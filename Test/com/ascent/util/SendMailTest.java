package com.ascent.util;

import junit.framework.TestCase;

public class SendMailTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testSendMessage() {
		SendMail sendMail=new SendMail();
		sendMail.sendMessage("m15317097810@163.com", "15317097810", "fwh19970312", "137012120@qq.com", "fangpo@163.com", "");
	}
	

	public void testCutFromAddress() {
//		fail("Not yet implemented");
		SendMail sm = new SendMail();
		String result = sm.cutFromAddress("137012120@qq.com");
		assertEquals(result, "qq.com");
	}
	
	public void testCutFromAddress1() {
//		fail("Not yet implemented");
		SendMail sm = new SendMail();
		String result = sm.cutFromAddress("m15317097810@163.com");
		assertEquals(result, "163.com");
	}
	
	public void testCutFromAddress2() {
//		fail("Not yet implemented");
		SendMail sm = new SendMail();
		String result = sm.cutFromAddress("1352785889@qq.com");
		assertEquals(result, "qq.com");
	}
	
	
	public void testCutFromAddress3() {
//		fail("Not yet implemented");
		SendMail sm = new SendMail();
		String result = sm.cutFromAddress("1552662@tongji.edu.cn");
		assertEquals(result, "tongji.edu.cn");
	}
	
	public void testCutFromAddress4() {
//		fail("Not yet implemented");
		SendMail sm = new SendMail();
		String result = sm.cutFromAddress("fwh19970312@gmail.com");
		assertEquals(result, "gmail.com");
	}
	
	public void testCutFromAddress5() {
//		fail("Not yet implemented");
		SendMail sm = new SendMail();
		String result = sm.cutFromAddress("12345");
		assertEquals(result, "");
	}
	
	public void testCutFromAddress6() {
//		fail("Not yet implemented");
		SendMail sm = new SendMail();
		String result = sm.cutFromAddress("12345@12.com");
		assertEquals(result, "");
	}
	
	public void testCutFromAddress7() {
//		fail("Not yet implemented");
		SendMail sm = new SendMail();
		String result = sm.cutFromAddress("fangpo@sina.com");
		assertEquals(result, "sina.com");
	}

}
