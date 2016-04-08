package com.whjz.android.util.common;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.annotation.SuppressLint;
import android.os.StrictMode;

import com.whjz.android.text.CommonText;

/**
 * @author ZhangYuHao
 * @category �������������ݷ���DataSetList
 * 
 */
public class RequestForData {

	/**
	 * @param nameSpace
	 * @param methodName
	 * @param endPoint
	 * @param params
	 *            ���󴫵ݵĲ���
	 * @param b 
	 * @return �������������ݷ���DataSetList
	 */
	@SuppressLint("NewApi")
	public static DataSetList getResultData(String nameSpace,
			String methodName, String endPoint, String params, byte[] data, boolean b) {

		DataSetList parsedExampleDataSet = null;
		// android3.0������Ҫ�������漸�仰
		if (android.os.Build.VERSION.SDK_INT > 10) {
		StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
				.detectDiskReads().detectDiskWrites().detectNetwork()
				.penaltyLog().build());
		StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
				.detectLeakedSqlLiteObjects().detectLeakedSqlLiteObjects()
				.penaltyLog().penaltyDeath().build());
		}
		String soapAction = nameSpace + methodName;

		// ָ��WebService�������ռ�͵��õķ�����
		SoapObject rpc = new SoapObject(nameSpace, methodName);

		// ���������WebService�ӿ���Ҫ�������������mobileCode��userId
		rpc.addProperty("dataTableName", params);

		if (data != null) {
			rpc.addProperty("contentBytes", data);
		}

		// ��ȡ���صĽ��
		String result = null;
		
		// ���ɵ���WebService������SOAP������Ϣ,��ָ��SOAP�İ汾
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.bodyOut = rpc;
		// �����Ƿ���õ���dotNet������WebService
		envelope.dotNet = true;
		// �ȼ���envelope.bodyOut = rpc;
		envelope.setOutputSoapObject(rpc);
//		HttpTransportSE transport = new HttpTransportSE(endPoint);
		HttpTransportSE transport = new MyAndroidHttpTransport(endPoint,10*1000);
		try {
			// ����WebService
			transport.call(soapAction, envelope);
		} catch (Exception e) {
			result = "<?xml version=\"1.0\" encoding=\"utf-8\"?><root><child><key>msg</key><value>timeout</value></child></root>";
			e.printStackTrace();
		}
		// ��ȡ���ص�����
		SoapObject object;
		try {
			object = (SoapObject) envelope.bodyIn;

		} catch (Exception e1) {
			// TODO Auto-generated catch block
			object = null;
			e1.printStackTrace();
		}
		
		if (object != null) {
			try {
				result = object.getProperty(0).toString();
//				MyLog.d("System.out", "==Response=="+result);
					if(CommonText.UNSECRET){
						if(!b){
							result=EncryptUncrypt.encryptAndcrypt(result, CommonText.secret);
						}
					}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				result = null;
				e.printStackTrace();
			}
		}

		MyLog.d("==���ܺ�Response=="+result);
		if (result != null) {
//			result=
			try {
				SAXParserFactory saxParserFactory = SAXParserFactory
						.newInstance();
				XMLReader reader = saxParserFactory.newSAXParser()
						.getXMLReader();

				XMLContentHandlerForList myExampleHandler = new XMLContentHandlerForList();
				reader.setContentHandler(myExampleHandler);
				reader.parse(new InputSource(new StringReader(result)));
				parsedExampleDataSet = myExampleHandler.dataSet;
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				parsedExampleDataSet = null;
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				parsedExampleDataSet = null;
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				parsedExampleDataSet = null;
				e.printStackTrace();
			}
		}
		return parsedExampleDataSet;
	}

}
