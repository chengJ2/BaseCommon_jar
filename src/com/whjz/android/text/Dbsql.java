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
			+ "(id integer primary key autoincrement,username TEXT, userpassword TEXT,deviceId TEXT,patform TEXT,temp TEXT,temp2 TEXT,createtime TEXT,lastlogintime TEXT)";
	// 用户基本信息
	String baseinfo_aql = "create table "
			+ CommonText.BASEINFO
			+ "(id integer primary key autoincrement,userId TEXT, realname TEXT, gender TEXT,"
			+ "brithday TEXT, joinworktime TEXT,phone TEXT, hometown TEXT, city TEXT,email TEXT,"
			+ " ismarry TEXT,nationality TEXT,license TEXT,workingabroad TEXT,politicalstatus TEXT,avator TEXT, bgcolor TEXT,temp TEXT)";
	// 工作经历数据
	String work_experience_aql = "create table "
			+ CommonText.WORKEXPERIENCE
			+ "(id integer primary key autoincrement,userId TEXT, companyname TEXT,companynature TEXT,companyscale TEXT, industryclassification TEXT,"
			+ "jobtitle TEXT, worktimestart TEXT,worktimeend TEXT, expectedsalary TEXT, workdesc TEXT,bgcolor TEXT,temp TEXT,createtime TEXT)";
	
	// 自我评价
	String evaluation_aql = "create table "
			+ CommonText.EVALUATION
			+ "(id integer primary key autoincrement,userId TEXT, selfevaluation TEXT, careergoal TEXT,bgcolor TEXT,temp TEXT,createtime TEXT)";
	
	// 求职意向数据
	String job_intension_aql = "create table "
			+ CommonText.JOBINTENSION
			+ "(id integer primary key autoincrement,userId TEXT, expworkingproperty TEXT, expdworkplace TEXT,"
			+ " expworkindustry TEXT,expworkcareer TEXT,expmonthlysalary TEXT,workingstate TEXT,bgcolor TEXT,temp TEXT,createtime TEXT)";
	
	// 教育经历
	String education_aql = "create table "
			+ CommonText.EDUCATION
			+ "(id integer primary key autoincrement,userId TEXT, educationtimestart TEXT,educationtimeend TEXT, school TEXT,"
			+ " examination TEXT,majorname TEXT,degree TEXT,bgcolor TEXT,temp TEXT,createtime TEXT)";
	// 培顺经历
	String training_aql = "create table "
			+ CommonText.EDUCATION_TRAIN
			+ "(id integer primary key autoincrement,userId TEXT, trainingtimestart TEXT,trainingtimeend TEXT, trainingorganization TEXT,"
			+ " trainingclass TEXT,certificate TEXT,description TEXT,bgcolor TEXT,temp TEXT,createtime TEXT)";
	
	
	String otherinfo_aql = "create table "
			+ CommonText.OTHERINFO
			+ "(id integer primary key autoincrement,userId TEXT, language TEXT, literacyskills TEXT,"
			+ " listeningspeaking TEXT,bgcolor TEXT,temp TEXT,createtime TEXT)";
	
	String otherinfo1_aql = "create table "
			+ CommonText.OTHERINFO1
			+ "(id integer primary key autoincrement,userId TEXT, certificate TEXT, certificatetime TEXT,temp TEXT,"
			+ " createtime TEXT)";
	
	String otherinfo2_aql = "create table "
			+ CommonText.OTHERINFO2
			+ "(id integer primary key autoincrement,userId TEXT, title TEXT, description TEXT,temp TEXT,"
			+ " createtime TEXT)";
	
	// 项目经验
	String project_experience_aql = "create table "
			+ CommonText.PROJECT_EXPERIENCE
			+ "(id integer primary key autoincrement,userId TEXT, projectname TEXT, worktimestart TEXT,worktimeend TEXT,"
			+ " duties TEXT, prokectdesc TEXT,bgcolor TEXT,temp TEXT,createtime TEXT)";
	
	String professional_skill_aql = "create table "
			+ CommonText.PROFESSIONAL_SKILL
			+ "(id integer primary key autoincrement,userId TEXT, skillname TEXT, usetime TEXT,skillful TEXT,"
			+ "temp TEXT,createtime TEXT)";
	
	String learning_inschool_aql = "create table "
			+ CommonText.LEARNING_INSCHOOL
			+ "(id integer primary key autoincrement,userId TEXT, awardedlevel TEXT, activity_duties_desc TEXT,awards TEXT,"
			+ " award_level TEXT, getime TEXT,desc TEXT,temp TEXT,createtime TEXT)";
	
	String practicalexperience_inschool_aql = "create table "
			+ CommonText.PRACTICALEXPERIENCE_INSCHOOL
			+ "(id integer primary key autoincrement,userId TEXT, practicalname TEXT, practicaltimestart TEXT,practicaltimeend TEXT,"
			+ " practicaldesc TEXT, temp TEXT,createtime TEXT)";
	
	String mycollection_sql = "create table "
			+ CommonText.MYCOLLECTION
			+ "(id integer primary key autoincrement,userId TEXT,title TEXT,content TEXT,"
			+ "sharename TEXT,sharenamecity TEXT,sharedatime TEXT,type TEXT)";
	
	
	/* 创建数据库表的语句 */
	public String createTableSql[] = {userinfo_aql,baseinfo_aql,
				work_experience_aql,evaluation_aql,education_aql,training_aql,job_intension_aql,
				otherinfo_aql,otherinfo1_aql,otherinfo2_aql,
				project_experience_aql,professional_skill_aql,learning_inschool_aql,practicalexperience_inschool_aql,
				mycollection_sql};

}
