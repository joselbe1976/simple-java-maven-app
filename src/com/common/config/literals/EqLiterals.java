package com.common.config.literals;

import java.io.IOException;
import java.util.Properties;

public final class EqLiterals {

	private static Properties prop  = new Properties();
	private static boolean LOADED_PROPERTIES=false;

			
	//values
	public static  String  GENUSERSAUTO_COMMENT = "";
	public static  String  MAIL_NEWUSER_SUBJECT = "";
	public static  String  MAIL_NEWUSER_BODY_1 = "";
	public static  String  MAIL_NEWUSER_BODY_2 = "";
	public static  String  MAIL_CHG_PASSWORD_SUBJECT = "";
	public static  String  MAIL_CHG_PASSWORD_BODY_1 = "";
	public static  String  MAILS_SIGNATURE = "";

			
	
	//Constructor
	public EqLiterals() {
		controlLoadProperties();
	}
	

	private static final void controlLoadProperties()
	{
				//Load only one time
				if (LOADED_PROPERTIES == true) { return;}
				
				try {
					ClassLoader loader = Thread.currentThread().getContextClassLoader();
					prop.load(loader.getResourceAsStream("com/common/config/literals/literals.properties"));
					LOADED_PROPERTIES = true;
					
					//load data
					GENUSERSAUTO_COMMENT = prop.getProperty("GENUSERSAUTO_COMMENT","").trim();
					MAIL_NEWUSER_SUBJECT = prop.getProperty("MAIL_NEWUSER_SUBJECT","").trim();
					MAIL_NEWUSER_BODY_1 = prop.getProperty("MAIL_NEWUSER_BODY_1","").trim();
					MAIL_NEWUSER_BODY_2 = prop.getProperty("MAIL_NEWUSER_BODY_2","").trim();
					MAIL_CHG_PASSWORD_SUBJECT = prop.getProperty("MAIL_CHG_PASSWORD_SUBJECT","").trim();
					MAIL_CHG_PASSWORD_BODY_1 = prop.getProperty("MAIL_CHG_PASSWORD_BODY_1","").trim();
					MAILS_SIGNATURE = prop.getProperty("MAILS_SIGNATURE","").trim();
					
					
				}
				catch(Exception e)
				{
					System.out.print("\n(ERROR) Fichero  literals.properties.xml No encontrado");
				}
				finally
				{
					
				}
	
	}

	
	
}
