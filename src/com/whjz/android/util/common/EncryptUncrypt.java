package com.whjz.android.util.common;

import java.io.UnsupportedEncodingException;
import android.util.Base64;

/**
 * �����б�дʹ�����������мӽ��ܵķ���
 * @author Zhang Yuhao
 * @2013-10-8 ����05:29:59
 */
public class EncryptUncrypt {
	/**
	 * ����
	 * @param value
	 * @param secret
	 * @return
	 */
	public static String encryptAndUncrypt(String value, char secret) {
		// ��value���ܣ�secret�����ַ�
		byte[] bt = value.getBytes();
		// ����Ҫ���ܵ�����ת��Ϊ�ֽ�����
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (bt[i] ^ (int) secret); // ͨ�����������м���
		}
		/*תΪbase�ֽ���*/
		byte[] bts=Base64.encode(bt, Base64.DEFAULT);
		return new String(bts, 0, bts.length);// ���ؼ��ܺ���ַ���
	}
	/**
	 * ����
	 * @param value
	 * @param secret
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	public static String encryptAndcrypt(String value, char secret) throws UnsupportedEncodingException  {
		/*תΪbase�ֽ���*/
		byte[] bt=Base64.decode(value.getBytes(), Base64.DEFAULT);
		// ��value���ܣ�secret�����ַ�
		// ����Ҫ���ܵ�����ת��Ϊ�ֽ�����
		for (int i = 0; i < bt.length; i++) {
			bt[i] = (byte) (bt[i] ^ (int) secret); // ͨ�����������м���
		}
		return new String(bt, "utf-8");// ���ؼ��ܺ���ַ���
	}
	
}