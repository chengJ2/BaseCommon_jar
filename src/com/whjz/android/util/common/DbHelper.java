package com.whjz.android.util.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.whjz.android.text.CommonText;
import com.whjz.android.text.Dbsql;

/**
 * 
 * @ClassName: DatabaseHelper
 * @Description: 本地数据库帮助类
 * @author Comsys-WH1510032
 * @date 2016/1/5 下午1:25:55
 * 
 */
public class DbHelper extends SQLiteOpenHelper {
	// 单例，在多线程读写数据库时进行同步
	private static DbHelper mInstance;

	public DbHelper(Context context) {
		super(context, CommonText.DATABASE_NAME, null,
				CommonText.DATEBASE_VERSION);
	}

	public static DbHelper getInstance(Context context) {
		if (mInstance == null) {
			mInstance = new DbHelper(context);
		}
		return mInstance;
	}

	public static void destoryInstance() {
		if (mInstance != null) {
			mInstance.close();
		}
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		MyLog.d("=====创建表=======");
		Dbsql sqls = new Dbsql();
		int size = sqls.createTableSql.length;
		for (int i = 0; i < size; i++) {
			db.execSQL(sqls.createTableSql[i]);
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		MyLog.d("=====更新表=======");
	}
	
	/**
	 * 创建一个新的数据库
	 * 
	 * @param Sql
	 *            SQLITE 语句
	 * @param context
	 *            上下文对象
	 */
	public static void CreateNewSqlite(String Sql, Context context) {
		if (mInstance != null) {
			mInstance.getWritableDatabase().execSQL(Sql);
		} else {
			getInstance(context).getWritableDatabase().execSQL(Sql);

		}
	}

	/**
	 * @param values
	 * @param table
	 * @category 普通插入
	 */
	public boolean insertData(ContentValues values, String table) {
		SQLiteDatabase db = getWritableDatabase();
		long result = db.insert(table, null, values);
		if (result == -1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param values
	 * @param table
	 * @category 普通插入
	 */
	public int updateData(Context mContext, String mTableName,
			String[] fieldName, String[] value,int whereArgs){
		SQLiteDatabase db = getWritableDatabase();
		int result = -1;
		try {
			ContentValues values = new ContentValues();
			int columnSize = fieldName.length;
			for (int i = 1; i < columnSize; i++) {
				values.put(fieldName[i],value[i]);
			}
			if(whereArgs == 1){
				result = db.update(mTableName, values, fieldName[0], 
						new String[]{value[0]});
			}else{
				result = db.update(mTableName, values, "id=? and userId=?", 
						new String[]{fieldName[0], value[0]});
			}
			return result;
		} catch (Exception e) {
			MyLog.d(e.getMessage());
		}
		return -1;
	}
	
	/**
	 * @param dataSetList
	 * @param table
	 * @category 异步操作数据库，插入数据时采用事物提高效率
	 */
	public void insertData(DataSetList dataSetList, String table) {
		SQLiteDatabase db = getWritableDatabase();
		int namesize = dataSetList.nameList.size();
		int valuesize = dataSetList.valueList.size();
		if (namesize > 0 && valuesize > 0) {
			int count = valuesize / namesize;// 行数
			try {
				db.beginTransaction();
				for (int i = 0; i < count; i++) {

					ContentValues values = new ContentValues();

					for (int j = 0; j < namesize; j++) {
						values.put(dataSetList.nameList.get(j),
								dataSetList.valueList.get(i * namesize + j));
					}
					db.insert(table, null, values);
				}
				db.setTransactionSuccessful();
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				db.endTransaction();
			}
		}

	}

	/**
	 * 
	 * @Title:DbHelper
	 * @Description: 更新数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param table
	 * @param where
	 */
	public void delete(String table, String where) {
		SQLiteDatabase db = getWritableDatabase();
		db.delete(table, where, null);
	}

	/**
	 * 
	 * @Title:DbHelper
	 * @Description: 更新数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param where
	 */
	public void delete(String where) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(where);
	}
	
	/**
	 * 
	 * @Title:DbHelper
	 * @Description: 更新数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param where
	 */
	public boolean update(String where) {
		SQLiteDatabase db = getWritableDatabase();
		try {
			db.execSQL(where);
			return true;
		} catch (Exception e) {
			MyLog.d(e.getMessage());
		} finally {
			if (db != null) {
				db.close();
			}
		}
		return false;
	}

	/**
	 * 
	 * @Title:DbHelper
	 * @Description: 查询
	 * @author Comsys-WH1510032
	 * @param where
	 * @param table
	 * @return Cursor
	 */
	public Cursor query(String where, String table) {
		Cursor cursor = null;
		SQLiteDatabase db = this.getReadableDatabase();
		cursor = db.query(table, null, where, null, null, null, null);
		return cursor;
	}
	/**
	 * 
	 * @Title:DbHelper
	 * @Description: 查询
	 * @author Comsys-WH1510032
	 * @param where
	 * @param table
	 * @return Cursor
	 */
	public Cursor query(String where) {
		Cursor cursor = null;
		SQLiteDatabase db = this.getReadableDatabase();
		cursor = db.rawQuery(where, null);
		return cursor;
	}

	/**
	 * 
	 * @Title:DbHelper
	 * @Description: 依表字段删除数据
	 * @author Comsys-WH1510032
	 * @return 返回类型  
	 * @param tableName
	 * @param column
	 * @param value
	 * @return
	 */
	public boolean delete(String tableName, String field, String value) {
		SQLiteDatabase db = getWritableDatabase();
		try {
			db.delete(tableName, field + "=?", new String[] { value });
			return true;
		} catch (Exception e) {
			MyLog.d(e.getMessage());
		} finally {
			if (db != null) {
				db.close();
			}
		}
		return false;

	}
}
