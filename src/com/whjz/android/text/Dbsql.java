package com.whjz.android.text;

/**
 * 程序中用到的sql语句
 * @author ChengJian
 *
 */
public class Dbsql {
	// 用户注册信息
	String userinfo_aql = "create table "
			+ CommonText.USERINFO
			+ "(_id integer primary key autoincrement,username TEXT, userpassword TEXT,deviceId TEXT,patform TEXT,createtime TEXT,lastlogintime TEXT)";
	// 用户基本信息
	String baseinfo_aql = "create table "
			+ CommonText.BASEINFO
			+ "(_id integer primary key autoincrement,userId TEXT, realname TEXT, gender TEXT,"
			+ "brithday TEXT, joinworktime TEXT,phone TEXT, hometown TEXT, areacity TEXT,areaemail TEXT,"
			+ " ismarry TEXT,nationality TEXT,license TEXT,workingabroad TEXT,politicalstatus TEXT,avator TEXT)";
	// 工作经历数据
	String work_experience_aql = "create table "
			+ CommonText.WORKEXPERIENCE
			+ "(_id integer primary key autoincrement,userId TEXT, companyname TEXT, industryclassification TEXT,"
			+ "jobtitle TEXT, worktimeStart TEXT,worktimeEnd TEXT, expectedsalary TEXT, workdesc TEXT,createtime TEXT)";
	
	// 教育培顺经历
	String evaluation_aql = "create table "
			+ CommonText.EVALUATION
			+ "(_id integer primary key autoincrement,userId TEXT, selfevaluation TEXT, careergoal TEXT,createtime TEXT)";
	
	// 求职意向数据
	String job_intension_aql = "create table "
			+ CommonText.JOBINTENSION
			+ "(_id integer primary key autoincrement,userId TEXT, expectedworkingproperty TEXT, expectedworkplace TEXT,"
			+ " expectedworkindustry TEXT,expectedworkcareer TEXT,expectedmonthlysalary TEXT,workingstate TEXT)";
	
	String otherinfo_aql = "create table "
			+ CommonText.OTHERINFO
			+ "(_id integer primary key autoincrement,userId TEXT, expectedworkingproperty TEXT, expectedworkplace TEXT,"
			+ " expectedworkindustry TEXT)";
	
	String otherinfo1_aql = "create table "
			+ CommonText.OTHERINFO1
			+ "(_id integer primary key autoincrement,userId TEXT, expectedworkingproperty TEXT, expectedworkplace TEXT,"
			+ " expectedworkindustry TEXT)";
	
	String otherinfo2_aql = "create table "
			+ CommonText.OTHERINFO2
			+ "(_id integer primary key autoincrement,userId TEXT, expectedworkingproperty TEXT, expectedworkplace TEXT,"
			+ " expectedworkindustry TEXT)";
	
	/* 创建数据库表的语句 */
	public String createTableSql[] = {userinfo_aql,baseinfo_aql,work_experience_aql,evaluation_aql,job_intension_aql};

}
