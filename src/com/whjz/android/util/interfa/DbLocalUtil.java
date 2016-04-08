package com.whjz.android.util.interfa;

import java.util.Map;

import android.content.ContentValues;
import android.content.Context;

import com.whjz.android.util.common.DataSetList;

/**
 * @author ZhangYuHao
 * @date 2013-3-2下午04:43:39
 * @category 数据本地化操作接口 将网上获得数据保存在本地数据库中，并实现从本地数据库中读取数据
 */
public interface DbLocalUtil {
	
	/**
	 * 
	 * @param mContext	上下文
	 * @param mTableName 表名
	 * @param value 值
	 */
	public abstract boolean insertData(Context mContext, String mTableName,
			ContentValues values);
	/**
	 * @param mContext
	 *            上下文
	 * @param mTableName
	 *            表名
	 * @param dataSetList
	 *            数据结构
	 * @category 将获得的DataSetList存放在本地数据库中
	 * @eg DataSetList dataSetlist=baseCommon.selects(...);<br>
	 *     DbLocalUtil dbUtil=new DbUtilImplement();<br>
	 *     dbUtil.insertDataSetList(LogoActivity.this, "hour_one",dataSetlist);<br>
	 */
	public abstract void insertDataSetList(Context mContext, String mTableName,
			DataSetList dataSetList);
	
	/**
	 * @param mContext
	 *            上下文
	 * @param tableName
	 *            表名
	 * @param where
	 *            查询条件
	 * @return
	 * @category 从本地数据库中读取数据,并将数据保存在Map<String,
	 *           String[]>中，格式：String=名称；String[]={"张三","李四","王五"};
	 * @eg DbLocalUtil dbUtil=new DbUtilImplement();<br>
	 *     dbUtil.queryData(LogoActivity.this, "hour_one","from hour_one ");<br>
	 */
	public abstract Map<String, String[]> queryData(Context mContext,
			String tableName, String where);

	/**
	 * @param mContext
	 *            上下文
	 * @param where
	 *            完整的sql语句
	 * @return DataSetList
	 * @category 从本地数据库中读取数据,并将数据保存在Map<String,
	 *           String[]>中，格式：String=名称；String[]={"张三","李四","王五"};
	 * @eg DbLocalUtil dbUtil=new DbUtilImplement();<br>
	 *     dbUtil.queryData(LogoActivity.this,
	 *     "select * from hour_one ");<br>
	 */
	public abstract Map<String, String[]> queryData(Context mContext,
			String where);

	/**
	 * @param mContext
	 *            上下文
	 * @param where
	 *            完整sql语句
	 * @category 从本地数据库中删除数据
	 * @eg DbLocalUtil dbUtil=new DbUtilImplement();
	 *     dbUtil.delectData(LogoActivity.this, "delete from hour_one ");
	 */
	public abstract void delectData(Context mContext, String where);
}
