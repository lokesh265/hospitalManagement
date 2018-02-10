package com.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

	public static String DB_URL ;
	public static String USER_NAME ;
	public static String PASSWD ;

	public PropertyReader() {
		getPropertyValues();
	}
	
	private void getPropertyValues(){
		Properties properties = new Properties();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("database.properties");
		try {
			properties.load(inputStream);
			
			DB_URL = properties.getProperty("dbURL");
			USER_NAME = properties.getProperty("dbUserName");
			PASSWD = properties.getProperty("dbPassword");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
