package com.whjz.android.util.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhangYuHao
 * @date 2013-3-1����04:47:53
 * @category �������ȡ���ݺ�洢�����ݽṹ
 */
public class DataSetList implements Serializable{
	public Map<String, List<String>> map=new HashMap<String, List<String>>();
	public String type;
	public List<String> nameList=new ArrayList<String>();

	public List<String> valueList=new ArrayList<String>();
	public List<String> Documentid = new ArrayList<String>();
	public List<String> CONTENTID=new ArrayList<String>();
	public String ERROR="";
	public String SUCCESS="";
	
	public static String autoTextData[];//������ҵ������Դ
	public static String groupsValue[];//���ڵ�ֵ����
	public static String childrenValue[][];//�ӽڵ�ֵ����
	public static String childrenId[][];//��ҵ���
//	û���ӽڵ�ĵ��ô˷���
	public Map<String, List<String>> getMap(){
		int num=nameList.size();
		for(int i=0;i<num;i++){
			List<String> list=new ArrayList<String>();
			for(int j=i+1;j<=valueList.size();j=j+num){
				list.add(valueList.get(j-1));
			}
			map.put(nameList.get(i), list);
		}
		return map;
	}
//	���ӽڵ�ĵ��ô˷���


}
