package com.cdms.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadConfig {
	Properties pro;

	public  ReadConfig(String age) {

		try {

			pro = new Properties();
			pro.load(new FileInputStream(
					"C:\\Users\\xmedia\\eclipse-workspace\\cdms\\configuration\\config.properties"));

			//String value = pro.getProperty("url");
			//System.out.println(value);

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	public String getApplicationURL() {
		String value = pro.getProperty("url");
		return value;
	}
	
	public String getusername() {
		String value = pro.getProperty("username");
		return value;
	}
	
	public String getpassword() {
		String value = pro.getProperty("password");
		return value;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
