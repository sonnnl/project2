package com.java_web_test.utils;

public class NumberUtil {
	 public static boolean isNumber(String s) {
	        if (s == null || s.isEmpty()) {
	            return false;
	        }
	        try {
	            Double.parseDouble(s);  // Use Double to handle decimal numbers as well
	            return true;
	        } catch (NumberFormatException e) {
	            return false;
	        }
	    }
}