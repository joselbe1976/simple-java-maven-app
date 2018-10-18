/*
 * Equilibrha 2017. Send mail
 * Jose Luis Bustos
 * In config.properties of the backend are the settings of mail configuracion.
 */
package com.common.tools.mail;

import java.util.Properties;



import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.common.config.ParamsApp;
import com.common.tools.interfaces.iDisposable;

//Send Mail
public class SendMail implements iDisposable {
	
	private static String className = "";
	
	private static String Server;
	private static String port;
	private static String user;
	private static String pass;
	private static String auth;
	private static String tls;
	
	//Constructor
	public SendMail() {
		new ParamsApp();
		className = this.getClass().getSimpleName(); //Class name for logs
		
		// Get Data from Backend Configuration. Is static = only load one time
		if ( Server == null ){
			Server = ParamsApp.MAIL_SERVER;
			port   = ParamsApp.MAIL_PORT;
			user   = ParamsApp.MAIL_USER;
			pass   = ParamsApp.MAIL_PASS;
			auth   = ParamsApp.MAIL_AUTH;
			tls    = ParamsApp.MAIL_TLS;
		}
		
	}
	
	public void Dispose() {
		
	}
	
	//send a Simple Mail

	public void sendMail(String ToMail, String subject , String text) {
		Properties props;
		Session session;
		Message message;
		Transport transport;
		
		try {
			addLog("\n ********[ Inicio Envio mail] ******",ParamsApp.LOG_TYPE_INFO);
			addLog("     To     : "+ ToMail, ParamsApp.LOG_TYPE_INFO);
			addLog("     subject: "+ subject, ParamsApp.LOG_TYPE_INFO);
			addLog("     text   : "+ text, ParamsApp.LOG_TYPE_INFO);

			// Create the properties of configuration Backend
			props = getConfigMail();
			session = Session.getDefaultInstance(props);
			
			// Create the message

			message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO,new InternetAddress(ToMail));
			message.setSubject(subject);
			message.setContent(text, "text/html; charset=utf-8"); //HTML Format

			// Transport and send the email
			transport = session.getTransport("smtp");
			transport.connect(Server,user,pass);
			transport.sendMessage(message, message.getAllRecipients());
			transport.close();
			
			addLog("\n ********[ Fin envio OK ] ******", ParamsApp.LOG_TYPE_INFO);
			
			
		} catch (MessagingException e) {
			addLog(e.getMessage(),ParamsApp.LOG_TYPE_ERROR);
			throw new RuntimeException(e);
		}
		finally {
			props = null;
			session = null;
			message = null;
			transport = null;
		}
		

	}
	
	
	//Configure the properties Mail
	private  Properties getConfigMail() {
		Properties props = new Properties();
		//optional security configuration
		if (auth.equals("Y")) {props.put("mail.smtp.auth", "true");}
		if (tls.equals("Y")) {props.put("mail.smtp.starttls.enable", "true");}

		props.put("mail.smtp.host", Server); //Server
		props.put("mail.smtp.port", port);   //Server port
		
		return props;
	}
	
	
	// Debug class
	protected void addLog(String info, int logType)
	{
			new ParamsApp().systemDebug(ParamsApp.LOG_LEVEL_SESSION, "("+className+") "+info, logType);
	}
	
	
}
