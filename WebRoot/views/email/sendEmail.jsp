<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  errorPage="" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import ="javax.mail.*" %>
<%@ page import="javax.mail.internet.*" %>
<%@ page import="javax.activation.*" %>
<%@ page import="java.io.*" %>
<%
try{
	request.setCharacterEncoding("UTF-8");
	String from=request.getParameter("from");
	String to=request.getParameter("to");
	String cc=request.getParameter("cc");	
	String subject=request.getParameter("subject");
	String messageText=request.getParameter("content");
    String password=request.getParameter("password");
    File file=new File(request.getParameter("file"));
	//生成SMTP的主机名称
	int n =from.indexOf('@');
	int m=from.length() ;
	String mailserver ="smtp."+from.substring(n+1,m);
    //建立邮件会话
	Properties pro=new Properties();
    pro.put("mail.smtp.host",mailserver);  //将邮件服务器信息写入属性对象pro中
    pro.put("mail.smtp.auth","true");   //设置认证为true
    Session sess=Session.getInstance(pro);   //创建邮件会话对象
    sess.setDebug(true);
    //新建一个消息对象
    MimeMessage message=new MimeMessage(sess);
    //设置发件人
    InternetAddress from_mail=new InternetAddress(from);
    message.setFrom(from_mail);
    if (cc != null) 
   //设置1个或者多个收件人
   { InternetAddress [] to_mail={new InternetAddress(to),new InternetAddress(cc)};
    message.addRecipients(Message.RecipientType.TO ,to_mail);}
    else {
    InternetAddress  to_mail=new InternetAddress(to);
    message.setRecipient(Message.RecipientType.TO ,to_mail);
     
         }

  // 也可以包含 CC 收件人，即群发 
 // if (cc != null) 
  // message.setRecipients(Message.RecipientType.CC,InternetAddress.parse(cc, false)); 
 
       
    //设置主题
    message.setSubject(subject);
   //设置文本中的内容
   MimeBodyPart mbp1 = new MimeBodyPart();
   mbp1.setText(messageText);
   //设置邮件里面的附件
   MimeBodyPart mbp2 = new MimeBodyPart();
   FileDataSource fds = new FileDataSource(file);
   mbp2.setDataHandler(new DataHandler(fds));
   mbp2.setFileName(fds.getName());
   out.println(fds.getName());

  // 把两部分的内容放进信息
  Multipart mp = new MimeMultipart();
  mp.addBodyPart(mbp1);
  mp.addBodyPart(mbp2);

// add the Multipart to the message
message.setContent(mp);
   
   //设置发送时间
   message.setSentDate(new Date());
   //发送邮件
   System.out.println("z 发送邮件");
   message.saveChanges();  //保证报头域同会话内容保持一致
   Transport transport =sess.getTransport("smtp");
    System.out.println("z 连接邮件");
   transport.connect(mailserver,from,password);  //连接邮件服务器
    System.out.println("z 连接hao邮件");
   transport.sendMessage(message,message.getAllRecipients());
  
   transport.close();
   out.println("<script language='javascript'>alert('邮件已发送！');window.location.href='mail.jsp';</script>");
}catch(Exception e){
	System.out.println("发送邮件产生的错误："+e.getMessage());
	out.println("<script language='javascript'>alert('邮件发送失败！');window.location.href='mail.jsp';</script>");
}
%>
