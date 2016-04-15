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
			+ "brithday TEXT, joinworktime TEXT,phone TEXT, hometown TEXT, city TEXT,email TEXT,"
			+ " ismarry TEXT,nationality TEXT,license TEXT,workingabroad TEXT,politicalstatus TEXT,avator TEXT)";
	// 工作经历数据
	String work_experience_aql = "create table "
			+ CommonText.WORKEXPERIENCE
			+ "(_id integer primary key autoincrement,userId TEXT, companyname TEXT, industryclassification TEXT,"
			+ "jobtitle TEXT, worktimeStart TEXT,worktimeEnd TEXT, expectedsalary TEXT, workdesc TEXT,createtime TEXT)";
	
	// 自我评价
	String evaluation_aql = "create table "
			+ CommonText.EVALUATION
			+ "(_id integer primary key autoincrement,userId TEXT, selfevaluation TEXT, careergoal TEXT,createtime TEXT)";
	
	// 求职意向数据
	String job_intension_aql = "create table "
			+ CommonText.JOBINTENSION
			+ "(_id integer primary key autoincrement,userId TEXT, expworkingproperty TEXT, expdworkplace TEXT,"
			+ " expworkindustry TEXT,expworkcareer TEXT,expmonthlysalary TEXT,workingstate TEXT,createtime TEXT)";
	
	// 教育经历
	String education_aql = "create table "
			+ CommonText.EDUCATION
			+ "(_id integer primary key autoincrement,userId TEXT, time TEXT, school TEXT,"
			+ " examination TEXT,majorname TEXT,degree TEXT,createtime TEXT)";
	// 培顺经历
	String training_aql = "create table "
			+ CommonText.EDUCATION_TRAIN
			+ "(_id integer primary key autoincrement,userId TEXT, time TEXT, trainingorganization TEXT,"
			+ " trainingclass TEXT,certificate TEXT,description TEXT,createtime TEXT)";
	
	
	String otherinfo_aql = "create table "
			+ CommonText.OTHERINFO
			+ "(_id integer primary key autoincrement,userId TEXT, language TEXT, literacyskills TEXT,"
			+ " listeningspeaking TEXT,createtime TEXT)";
	
	String otherinfo1_aql = "create table "
			+ CommonText.OTHERINFO1
			+ "(_id integer primary key autoincrement,userId TEXT, certificate TEXT, certificatetime TEXT,"
			+ " createtime TEXT)";
	
	String otherinfo2_aql = "create table "
			+ CommonText.OTHERINFO2
			+ "(_id integer primary key autoincrement,userId TEXT, title TEXT, description TEXT,"
			+ " createtime TEXT)";
	
	/* 创建数据库表的语句 */
	public String createTableSql[] = {userinfo_aql,baseinfo_aql,work_experience_aql,evaluation_aql,
				education_aql,training_aql,job_intension_aql,otherinfo_aql,otherinfo1_aql,otherinfo2_aql};

}
