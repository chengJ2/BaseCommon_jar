package com.whjz.android.util.common;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @author Administrator
 * @category �����������˷��ص�xml�ļ�
 */
public class XMLContentHandlerForList extends DefaultHandler {
	private String temp = "";
	private String tagName;
	public DataSetList dataSet = new DataSetList();
	private boolean flag = false;
	int nameCounter = 0;
	int valueCounter = 0;

	@Override
	public void startDocument() throws SAXException {
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		tagName = localName;
		flag = true;
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		flag = false;
//		if (tagName.equals("CONTENTTYPENAME")) {
//			dataSet.type = new String(ch, start, length);
//		}
//		if (tagName.equals("CONTENTID")) {
//			temp = temp + new String(ch, start, length);
//		}
//		if (tagName.equals("NODETYPENAME")) {
//			temp = temp + new String(ch, start, length);
//			nodeCount++;
//		}
		if (tagName.equals("key")) {
			temp = temp + new String(ch, start, length);
		}else if (tagName.equals("value")) {
			temp = temp + new String(ch, start, length);
		}
//		if (tagName.equals("DOCUMENTID"))
//		{// ������Դ
//			dataSet.Documentid.add(new String(ch, start, length));
//		}
//		if (tagName.equals("ERROR")) {
//			dataSet.valueList.add("������");
//		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		tagName = localName;
		if (flag == false && tagName.equals("key")) {
			if (!dataSet.nameList.contains(temp)) {
				dataSet.nameList.add(temp);
				temp = "";
				nameCounter++;
			} else {
				temp = "";
			}
		} else if (flag == true && tagName.equals("key")) {
			if (!dataSet.nameList.contains(temp)) {
				dataSet.nameList.add(temp);
				temp = "";
				nameCounter++;
			} else {
				temp = "";
			}
		} else if (flag == false && tagName.equals("value")) {
			dataSet.valueList.add(temp);
			temp = "";
			valueCounter++;
		} else if (flag == true && tagName.equals("value")) {
			dataSet.valueList.add(temp);
			temp = "";
			valueCounter++;
		} else {
			// valueCounter++;
		}
		
	}

	@Override
	public void endDocument() throws SAXException {
//		MyLog.v("System.out", "nameCounter" + nameCounter);
//		MyLog.v("System.out", "valueCounter" + valueCounter);
	}

}
