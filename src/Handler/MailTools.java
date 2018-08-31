package Handler;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 文本邮件发送
 * 
 * @time 2017年4月19日23:59:29
 * @author taomi_000
 *
 */
public class MailTools {

	/**
	 * 发送邮件
	 * 
	 * @param email
	 * @param name
	 *            用户姓名
	 * @param post
	 *            用户职位
	 * @param adminMail
	 *            管理员邮箱
	 * @param adminPass
	 *            密码--授权码
	 * @param protocol
	 *            邮箱协议
	 * @throws Exception
	 */
	public static void sendRegisterMail(String email, String name, String post, String time, String adminMail,
			String adminPass, String protocol) throws Exception {
		// 设置参数
		Properties prop = new Properties();

		prop.setProperty("mail.host", protocol);

		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");

		if (protocol.equals("smtp.qq.com")) {
			prop.setProperty("mail.smtp.port", "465");
			prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			prop.setProperty("mail.smtp.socketFactory.fallback", "false");
			prop.setProperty("mail.smtp.socketFactory.port", "465");
		}

		
		// 使用JavaMail发送邮件的5个步骤
		// 1、创建session
		Session session = Session.getInstance(prop);
		// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		session.setDebug(true);
		// 2、通过session得到transport对象
		Transport ts;
		ts = session.getTransport();
		// 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，
		// 用户名和密码都通过验证之后才能够正常发送邮件给收件人。
		// 发件人必须开通对应的邮件服务
		// 如果有授权码，则密码位授权码

		ts.connect(protocol, adminMail, adminPass);

		// 4、创建邮件
		Message message = null;
		message = createMail(session, email, name, post, time, adminMail);

		// 5、发送邮件
		ts.sendMessage(message, message.getAllRecipients());
		ts.close();

	}

	/**
	 * 创建邮件
	 * 
	 * @param session
	 * @param email
	 *            发送地址
	 * @return
	 * @throws Exception
	 */
	public static MimeMessage createMail(Session session, String email, String name, String post, String time,
			String adminMail) throws Exception {
		// 创建邮件对象
		MimeMessage message = new MimeMessage(session);
		// 指明邮件的发件人
		message.setFrom(new InternetAddress(adminMail));
		// 指明邮件的收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress(email));
		// 邮件的标题
		message.setSubject("企业在线笔试系统");

		// 邮件的文本内容
		StringBuffer sbd = new StringBuffer();
		sbd.append("<font style:'font-family:YouYuan'>");
		sbd.append("<br>企业在线笔试系统通知邮件:<br><br>");
		sbd.append("您好," + name + ",您应聘的职位是:<font style='color:red'>" + post + "</font>.");
		sbd.append("<br>-------------------------------------------------------<br>");
		sbd.append("<br>恭喜您通过了本系统的笔试,请准备进行面试.<br>");
		sbd.append("<br>面试时间:" + time + ".<br>");
		sbd.append("<br>面试地点:XXX市XXX路XXX号.<br>");
		sbd.append("<br><br><br><br><font style='color:red'>tips:如果未收到手机短信信息，请回复此邮件</font><br>");
		sbd.append("</font>");
		message.setContent(sbd.toString(), "text/html;charset=UTF-8");
		// 返回创建好的邮件对象
		return message;
	}

}
