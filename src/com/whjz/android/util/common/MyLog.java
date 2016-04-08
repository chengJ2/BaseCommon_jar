package com.whjz.android.util.common;

import com.whjz.android.text.CommonText;

import android.util.Log;

public class MyLog {

	public static void d(String tag, String msg) {
		if (CommonText.DEBUG)
			Log.d(tag, msg);
	}
	
	public static void d(String msg) {
		if (CommonText.DEBUG)
			Log.d(CommonText.LOGTAG, msg);
	}

	public static void v(String tag, String msg) {
		if (CommonText.DEBUG)
			Log.v(tag, msg);
	}
}
