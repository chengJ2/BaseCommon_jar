package com.whjz.android.util.common;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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

		Dbsql sqls = new Dbsql();
		int size = sqls.createTableSql.length;
		for (int i = 0; i < size; i++) {
			db.execSQL(sqls.createTableSql[i]);
		}
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
	/**
	 * @param values
	 * @param table
	 * @category 普通插入
	 */
	public boolean InsertData(ContentValues values, String table) {
		SQLiteDatabase db = getWritableDatabase();
		long result = db.insert(table, null, values);
		if (result == -1) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * @param dataSetList
	 * @param table
	 * @category 异步操作数据库，插入数据时采用事物提高效率
	 */
	public void InsertData(DataSetList dataSetList, String table) {
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
	 * @param where
	 *            sql语句
	 * @param table
	 *            表名
	 */
	public void delete(String table, String where) {
		SQLiteDatabase db = getWritableDatabase();
		db.delete(table, where, null);
	}

	public void delete(String where) {
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(where);
	}

	public Cursor query(String where, String table) {

		Cursor cursor = null;
		SQLiteDatabase db = this.getReadableDatabase();
		cursor = db.query(table, null, where, null, null, null, null);
		return cursor;
	}

	/**
	 * @param where
	 * @return
	 */
	public Cursor query(String where) {

		Cursor cursor = null;
		SQLiteDatabase db = this.getReadableDatabase();
		cursor = db.rawQuery(where, null);
		return cursor;
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
}
