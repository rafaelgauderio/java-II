package com.rafaeldeluca.test;



import org.junit.Assert;
import org.junit.Test;

import com.rafaeldeluca.StringUtil;

public class StringUtilTest {	
	
	//failure é relativo ao teste
	//error é problema de código na classe de teste mesmo
	
	@Test
	public void testIsEmpty() {
		
		boolean boo;
		boo = StringUtil.isEmpty("");		
		Assert.assertTrue(boo);		
		
	}
	
	@Test
	public void testIsEmptyBlank() {
		
		boolean boo;
		boo = StringUtil.isEmpty("                        ");		
		Assert.assertTrue(boo);		
	}
	
	@Test
	public void testIsEmptyNull() {
		
		boolean boo;
		boo = StringUtil.isEmpty(null);		
		Assert.assertTrue(boo);		
	}	
	
	
	@Test
	public void testIsNotEmpty() {
		boolean boo;
		boo = StringUtil.isEmpty("rafael");
		Assert.assertFalse(boo);
		
	}
	
	@Test
	public void testStringReverse() {
		
		String input = "rafael";
		String output = "leafar";
		String result = StringUtil.reverse(input);
		Assert.assertEquals(output,result);		
		
	}	
	
	@Test
	public void testStringtoUpperCase() {
		
		String lowcase= "jaque";
		String uppercase="JAQUE";
		String result = StringUtil.uppercase(lowcase);
		Assert.assertEquals(uppercase, result);	
		
		
	}
	
	

}
