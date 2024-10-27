package com.java_web_test.utils;

public class NumberUtil {
	public static boolean isNumber(String s) {
		try {
			Long l = Long.parseLong(s);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
