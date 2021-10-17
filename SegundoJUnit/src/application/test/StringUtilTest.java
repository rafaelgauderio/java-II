package application.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import application.StringUtil;

public class StringUtilTest {

	
	@Test
	public void testIsEmpty() {
		
		StringUtil string = new StringUtil();
		
		boolean boo;
		
		boo= string.isEmpty("rafael");		
		Assert.assertFalse(boo);
		
		boo = string.isEmpty(null);
		Assert.assertTrue(boo);
		
		boo = StringUtil.isEmpty("");
		Assert.assertTrue(boo);
	}
	
	@Test
	public void testReverse() {
		
		StringUtil string = new StringUtil();
		String reverse = string.reverse("deluca");
		Assert.assertEquals("aculed",reverse);
		

		reverse = string.reverse(null);		
		Assert.assertNull(reverse);
		
	}
	


}
