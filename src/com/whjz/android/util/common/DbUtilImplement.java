package com.whjz.android.util.common;

import java.util.HashMap;
import java.util.Map;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.whjz.android.util.interfa.DbLocalUtil;

/**
 * @author ZhangYuHao
 * @date 2013-3-2下午04:50:42
 * @category 数据库本地化操作实现类
 */
public class DbUtilImplement implements DbLocalUtil {

	@Override
	public boolean insertData(Context mContext, String mTableName,
			ContentValues values) {
		// TODO Auto-generated method stub
		DbHelper db=DbHelper.getInstance(mContext);
		return db.InsertData(values, mTableName);
	}
	
	public void insertDataSetList(Context mContext, String mTableName,
			DataSetList dataSetList) {
		// TODO Auto-generated method stub
		DbHelper db=DbHelper.getInstance(mContext);
		if (dataSetList != null) {
			db.InsertData(dataSetList, mTableName);
		}
	}

	public Map<String, String[]> queryData(Context mContext, String tableName,
			String where) {
		// TODO Auto-generated method stub
//		DbHelper db = new DbHelper(mContext);
		DbHelper db=DbHelper.getInstance(mContext);
		Map<String, String[]> map = new HashMap<String, String[]>();
		Cursor cur = db.query(where, tableName);
		if (cur.getCount() > 0) {
			if (cur.moveToFirst()) {
				String names[] = cur.getColumnNames();
				int namesize = names.length;
				int rows = cur.getCount();
				String list[][] = new String[namesize][rows];
				int k = 0;
				do {
					for (int i = 0; i < namesize; i++) {
						list[i][k] = (cur.getString(i)==null)?"":cur.getString(i).toString();
					}
					k++;
				} while (cur.moveToNext());

				for (int j = 0; j < namesize; j++) {
					map.put(names[j], list[j]);
				}
			}
		} else {
			map = null;
		}
		cur.close();
		return map;
	}

	
	public Map<String, String[]> queryData(Context mContext, String where) {
		// TODO Auto-generated method stub
//		DbHelper db = new DbHelper(mContext);
		DbHelper db=DbHelper.getInstance(mContext);
		Map<String, String[]> map = new HashMap<String, String[]>();
		Cursor cur = db.query(where);
		if (cur.getCount() > 0) {
			if (cur.moveToFirst()) {
				String names[] = cur.getColumnNames();
				int namesize = names.length;
				int rows = cur.getCount();
				String list[][] = new String[namesize][rows];
				int k = 0;
				do {
					for (int i = 0; i < namesize; i++) {
						list[i][k] = (cur.getString(i)==null)?"":cur.getString(i).toString();
					}
					k++;
				} while (cur.moveToNext());

				for (int j = 0; j < namesize; j++) {
					map.put(names[j], list[j]);
				}
			}
		} else {
			map = null;
		}
		cur.close();
		return map;
	}

	
	public void delectData(Context mContext, String where) {
		// TODO Auto-generated method stub

		DbHelper db=DbHelper.getInstance(mContext);
		try {
			db.delete(where);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	

}
