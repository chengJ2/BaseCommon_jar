package com.whjz.android.util.common;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;

import com.whjz.android.text.CommonText;
import com.whjz.android.util.interfa.BaseCommonUtil;

public class CommonUtil implements BaseCommonUtil {

	String nameSpace = "http://huanbaoyun.com/";// uploadFile
	String methodName = "getDataFromProc";
	String getuploadFile = "getFileFromProc";
	
	public DataSetList datasetlistUpdata(String username, String pwd,
			String functionname, int style, List<String> params,
			List<String> paramvalue, byte[] data) {

		DataSetList dataSetlist = new DataSetList();
		String sqlxml;
		sqlxml = XmlPackage.getXmlRequest(username, pwd, functionname, style,
				params, paramvalue,true);
//		System.out.println("Request Xml==========" + sqlxml);
		dataSetlist = RequestForData.getResultData(nameSpace, getuploadFile,
				CommonText.endPoint+"/MyService.asmx?wsdl", sqlxml, data,true);
		return dataSetlist;
	}

	public DataSetList selects(String username, String pwd,
			String functionname, int style, List<String> params,
			List<String> paramvalue) {

		// TODO Auto-generated method stub
		DataSetList dataSetlist = new DataSetList();
		String sqlxml;
		sqlxml = XmlPackage.getXmlRequest(username, pwd, functionname, style,
				params, paramvalue,false);
//		MyLog.d("System.out","Request Xml====����======" + sqlxml);
		dataSetlist = RequestForData.getResultData(nameSpace, methodName,
				CommonText.endPoint+"/MyService.asmx?wsdl", sqlxml, null,false);
		return dataSetlist;
	}

}