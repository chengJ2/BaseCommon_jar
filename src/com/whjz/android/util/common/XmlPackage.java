package com.whjz.android.util.common;

import java.util.List;

import com.whjz.android.text.CommonText;

/**
 * @author
 * @category ��װ������json
 */
public class XmlPackage {

	/**
	 * 
	 * @param username
	 *            �û���
	 * @param pwd
	 *            �û�����
	 * @param functionname
	 *            �洢����
	 * @param style
	 *            "������ʽ1234���ֱ�����ѯ��ɾ�����޸ģ�����"
	 * @param params
	 *            �ֶ���
	 * @param paramvalue
	 *            �ֶ�ֵ
	 * @param b
	 * @return
	 * @eg ��װ�����¸�ʽ:<br>
	 *     {"username":"1111","pwd":"1111"},{"functionname":"getYDZF_COMPANY",
	 *     "style":"1"},{"WRY_BM":"2012112218460087481"}
	 */
	public static String getXmlRequest(String username, String pwd, String functionname, int style,
			List<String> params, List<String> paramvalue, boolean b) {
		StringBuffer XmlRequest = new StringBuffer();
		XmlRequest.append("{\"username\":\"" + username + "\",\"pwd\":\"" + pwd + "\"}," + "{\"functionname\":\""
				+ functionname + "\",\"style\":\"" + style + "\"}");
		if(params != null && paramvalue != null){
			if (paramvalue.size() == params.size()) {
				int size = params.size();
				String str = "";
				for (int i = 0; i < size; i++) {
					str = ",{\"" + params.get(i) + "\":\"" + paramvalue.get(i) + "\"}";
					XmlRequest.append(str);
				}
			}else if(paramvalue.size() != params.size()){
				MyLog.d("��������������ĸ�����һ��");
			}
		}
		MyLog.d("Request_Xml========" + XmlRequest.toString());// �������
		if (CommonText.UNSECRET) {
			if (b) {
				return XmlRequest.toString();
			} else {
				return EncryptUncrypt.encryptAndUncrypt(XmlRequest.toString(), CommonText.secret);
			}

		} else {
			return XmlRequest.toString();
		}

	}
}
