package com.ascent.util;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.log4j.Logger;
  
public class SendMail {   
  
	private static final Logger logger = Logger.getLogger(SendMail.class);
	//private static final String SMTP_HOST="smtp.163.com";   
	//private static final String SENDER_NAME="北京亚思晟科技有限公司";   //显示的发件人别名信息
	private static final String SUBJECT="图书询价回复(亚思晟科技)";   //标题
	
	public SendMail(){
		
	}
	/**
	 * 发送邮件方法
	 * @param fromAddress 发件地址
	 * @param username 发件用户名
	 * @param password 发件密码
	 * @param toAddress 收邮件地址
	 * @param customerAddress 客户邮件地址
	 * @param mge 邮件内容
	 */
	public void sendMessage(String fromAddress,String username,String password,String toAddress,String customerAddress,String mge){
		
		Properties props=new Properties();   
		String mailType = this.cutFromAddress(fromAddress);
		String mailserver=null;
		//测试成功
		if (mailType.equals("163.com")||mailType.equals("sohu.com")||mailType.equals("126.com")){
	   		mailserver = "smtp."+mailType;
	   		System.out.println("mailserver====="+mailserver);
	   		props.setProperty("mail.smtp.host", mailserver);
   			props.setProperty("mail.smtp.auth", "true");
	   		}
	   
	   	if (mailType.indexOf("sina")!=-1) //验证已经成功
	   		{
	   			mailserver ="smtp.sina.com.cn";//"202.106.187.180";
	   			System.out.println("mailserver====="+mailserver);
	   			props.setProperty("mail.smtp.host", mailserver);
	   			props.setProperty("mail.smtp.auth", "true");
	   			
	   		}
	   		
	   	if (mailType.indexOf("gmail")!=-1){   //验证已经成功
	   			mailserver = "smtp.gmail.com";
	   			System.out.println("mailtype==============="+mailType);
	   			String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	   			props.setProperty("mail.smtp.host", mailserver);
	   			props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
	   			props.setProperty("mail.smtp.socketFactory.fallback", "false");
	   			props.setProperty("mail.smtp.port", "465");
	   			props.setProperty("mail.smtp.socketFactory.port", "465");
	   			props.setProperty("mail.smtp.auth", "true");
	   			props.setProperty("mail.smtp.ssl",  "true");
	       }
		props.put("mail.smtp.user",username);   //添加发件Email用户名
		props.put("mail.smtp.password",password);//添加发件Email密码
		jmyz auth =new jmyz();   
        auth.performCheck(fromAddress,password);  
		Session session=Session.getInstance(props);   
		session.setDebug(true);
		try{   
			if(mge.length() == 0)
				throw new Exception("邮件的内容不能为空，不然容易被识别为垃圾邮件");
			System.out.println("发送开始！"); 
			Message msg=new MimeMessage(session);   
			msg.setFrom(new InternetAddress(fromAddress,customerAddress));  // 设置发件Email和邮件别名
			msg.setRecipient(Message.RecipientType.TO,new InternetAddress(toAddress));   //设置收件人地址
			msg.setSubject(SUBJECT);   //设置邮件主题
			msg.setSentDate(new Date());   
			//msg.setText(mge);   //邮件内容
			BodyPart mdp = new MimeBodyPart();
			mdp.setContent(mge,"text/html;charset=gb2312");
			Multipart mp = new MimeMultipart();
			mp.addBodyPart(mdp);
			msg.setContent(mp);
			msg.saveChanges();
			
			Transport transport = session.getTransport("smtp"); 
			transport.connect(mailserver,props.getProperty("mail.smtp.user"),props.getProperty("mail.smtp.password"));//2   
			transport.sendMessage(msg,msg.getAllRecipients());   
			System.out.println("发送成功！");  
		}catch(Exception e){
			System.out.println(e);   
		}   
	}   
  
	//截取发送邮件的类型
	public String cutFromAddress(String fromAddress){
		String mailType = fromAddress.substring(fromAddress.indexOf("@")+1,fromAddress.length());
		System.out.println("======mailType======"+mailType);
		return mailType;
	}
	
	public static void main(String[] args){   
		SendMail sendMail=new SendMail();   
		sendMail.sendMessage("m15317097810@163.com", "15317097810", "fwh19970312", "1352785889@qq.com", "fangpo@sina.com", "哈哈1");
		String email="lixing051116@163.com";
		System.out.println(email.substring(0, email.indexOf("@")));
	
		//ServletActionContext.getRequest().setAttribute("result","adminsuccess");  
	}   
}   
