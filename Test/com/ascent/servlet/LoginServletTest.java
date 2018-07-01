package com.ascent.servlet;

import com.meterware.httpunit.GetMethodWebRequest;

import com.meterware.httpunit.PostMethodWebRequest;
import com.meterware.httpunit.WebRequest;
import com.meterware.httpunit.WebResponse;
import com.meterware.servletunit.InvocationContext;
import com.meterware.servletunit.ServletRunner;
import com.meterware.servletunit.ServletUnitClient;

import junit.framework.Assert;
import junit.framework.TestCase;

public class LoginServletTest extends TestCase {

	public void testUserlogin() {
		try {
			ServletRunner sr = new ServletRunner();

			   // 向环境中注册Servlet

			   sr.registerServlet("LoginServlet", LoginServlet.class.getName());
			 
			   // 创建访问Servlet的客户端

			   ServletUnitClient sc = sr.newClient();

			   // 发送请求
		
//			   WebRequest request = new GetMethodWebRequest("http://localhost/Ascent/login");
			   WebRequest request = new PostMethodWebRequest("http://localhost:8080/Ascent/login");
			   request.setParameter("a", "login");
			   request.setParameter("username", "admin");
			   request.setParameter("password", "123456");
//			   sc.getResponse(request)
//			   InvocationContext ic = sc.newInvocation(request);

//			   LoginServlet is = (LoginServlet) ic.getServlet();
			 
			   // 测试servlet的某个方法

//			   Assert.assertTrue(is.authenticate());

			   // 获得模拟服务器的信息

			   WebResponse response = sc.getResponse(request);

			   // 断言
			   System.out.println(response.getText());
			   Assert.assertTrue(response.getText().equals("loginservl"));
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	
	}

//	public void testLoginout() {
//		fail("Not yet implemented");
//	}

}
