package com.whjz.android.util.interfa;

import java.util.Map;

import android.content.ContentValues;
import android.content.Context;

import com.whjz.android.util.common.DataSetList;

/**
 * @author ZhangYuHao
 * @date 2013-3-2����04:43:39
 * @category ���ݱ��ػ������ӿ� �����ϻ�����ݱ����ڱ������ݿ��У���ʵ�ִӱ������ݿ��ж�ȡ����
 */
public interface DbLocalUtil {
	
	/**
	 * 
	 * @param mContext	������
	 * @param mTableName ����
	 * @param value ֵ
	 */
	public abstract boolean insertData(Context mContext, String mTableName,
			ContentValues values);
	/**
	 * @param mContext
	 *            ������
	 * @param mTableName
	 *            ����
	 * @param dataSetList
	 *            ���ݽṹ
	 * @category ����õ�DataSetList����ڱ������ݿ���
	 * @eg DataSetList dataSetlist=baseCommon.selects(...);<br>
	 *     DbLocalUtil dbUtil=new DbUtilImplement();<br>
	 *     dbUtil.insertDataSetList(LogoActivity.this, "hour_one",dataSetlist);<br>
	 */
	public abstract void insertDataSetList(Context mContext, String mTableName,
			DataSetList dataSetList);
	
	/**
	 * @param mContext
	 *            ������
	 * @param tableName
	 *            ����
	 * @param where
	 *            ��ѯ����
	 * @return
	 * @category �ӱ������ݿ��ж�ȡ����,�������ݱ�����Map<String,
	 *           String[]>�У���ʽ��String=���ƣ�String[]={"����","����","����"};
	 * @eg DbLocalUtil dbUtil=new DbUtilImplement();<br>
	 *     dbUtil.queryData(LogoActivity.this, "hour_one","from hour_one ");<br>
	 */
	public abstract Map<String, String[]> queryData(Context mContext,
			String tableName, String where);

	/**
	 * @param mContext
	 *            ������
	 * @param where
	 *            ������sql���
	 * @return DataSetList
	 * @category �ӱ������ݿ��ж�ȡ����,�������ݱ�����Map<String,
	 *           String[]>�У���ʽ��String=���ƣ�String[]={"����","����","����"};
	 * @eg DbLocalUtil dbUtil=new DbUtilImplement();<br>
	 *     dbUtil.queryData(LogoActivity.this,
	 *     "select * from hour_one ");<br>
	 */
	public abstract Map<String, String[]> queryData(Context mContext,
			String where);

	/**
	 * @param mContext
	 *            ������
	 * @param where
	 *            ����sql���
	 * @category �ӱ������ݿ���ɾ������
	 * @eg DbLocalUtil dbUtil=new DbUtilImplement();
	 *     dbUtil.delectData(LogoActivity.this, "delete from hour_one ");
	 */
	public abstract void delectData(Context mContext, String where);
}
