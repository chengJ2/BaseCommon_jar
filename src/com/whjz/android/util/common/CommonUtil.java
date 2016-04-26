package com.whjz.android.util.common;

import java.util.List;

import com.whjz.android.text.CommonText;
import com.whjz.android.util.interfa.BaseCommonUtil;

public class CommonUtil implements BaseCommonUtil {

	String nameSpace = "http://huanbaoyun.com/";// uploadFile
	String methodName = "getDataFromProcs";
	String getuploadFile = "getFileFromProc";
	
	public DataSetList datasetlistUpdata(String username, String pwd,
			String functionname, int style, List<String> params,
			List<String> paramvalue, byte[] data) {

		DataSetList dataSetlist = new DataSetList();
		String sqlxml;
		sqlxml = XmlPackage.getXmlRequest(username, pwd, functionname, style,
				params, paramvalue);
//		System.out.println("Request Xml==========" + sqlxml);
		dataSetlist = RequestForData.getResultData(nameSpace, getuploadFile,
				CommonText.endPoint+"/MyService.asmx?wsdl", sqlxml, data,CommonText.UNSECRET);
		return dataSetlist;
	}

	public DataSetList selects(String username, String pwd,
			String functionname, int style, List<String> params,
			List<String> paramvalue) {

		DataSetList dataSetlist = new DataSetList();
		String sqlxml;
		sqlxml = XmlPackage.getXmlRequest(username, pwd, functionname, style,
				params, paramvalue);
//		MyLog.d("Request Xml====加密======>>" + sqlxml);
		dataSetlist = RequestForData.getResultData(nameSpace, methodName,
				CommonText.endPoint+"/MyService.asmx?wsdl", sqlxml, null,CommonText.UNSECRET);
		return dataSetlist;
	}

}