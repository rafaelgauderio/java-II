package com.rafaeldeluca;

import junit.framework.Assert;

public class StringUtil {
	
	
	public static boolean isEmpty(String s) {
		
		if(s == null) {
			return true;
		}
		
		//removendo os espaços em branco da String
		s = s.trim();		
		if (s.length()==0) {
			return true;
		}
		
		else {
			return false;
		}	
		
	}
	
	public static String reverse(String s) {
		
		if (s==null ) {
			return s;
		}
		
		
		StringBuilder string = new StringBuilder(s);
		
		string.reverse();
		
		
		return string.toString();
		
	}
	
	public static String uppercase(String s) {
		
		String upper = s.toUpperCase();
		
		return upper;
		
	}
	
	
	

}
