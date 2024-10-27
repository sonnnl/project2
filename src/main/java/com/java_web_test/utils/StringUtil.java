package com.java_web_test.utils;

public class StringUtil {
	public static boolean isEmptyString(String s) {
		if(s==null|| s.equals("")) {
			return true;
		}else {
			return false;
		}
	}
}
