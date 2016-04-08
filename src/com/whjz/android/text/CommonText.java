package com.whjz.android.text;

public class CommonText {
	
	public static final boolean DEBUG = true;//日志输出开关,true:打印输出，false:关闭打印输出
	public static final String LOGTAG = "CJLog";
	public static final boolean UNSECRET=false;//是否加密，false不加密；true加密
	public static final char secret='z';//加密密钥
	
	public static String endPoint=  "http://221.232.152.201:4044"; 
	
	// 数据库名称常量
	public static final String DATABASE_NAME = "myResume.db";
	// 数据库版本常量
	public static final int DATEBASE_VERSION = 1;
	
	// 数据库表名称常量
	public static final String WORKEXPERIENCE="work_experience";// 工作经历
	public static final String EVALUATION="evaluation";// 自我评价
	public static final String JOBINTENSION="job_intension";// 求职意向
	
	public static final String EDUCATION="education";// 教育背景
	public static final String EDUCATION_TRAIN="education_train";// 培顺经历
	
	public static final String OTHERINFO="otherinfo";// 其他信息 （语言能力）
	public static final String OTHERINFO1="otherinfo1";// 其他信息 （证书）
	public static final String OTHERINFO2="otherinfo2";// 其他信息  （其他信息）
	
}
