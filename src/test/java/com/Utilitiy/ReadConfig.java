package com.Utilitiy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig() 
	
	{
		File src = new File("./configuration/config.properties");
		
		try {
			
		
		
		FileInputStream fis = new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		
		} catch (Exception e ) {
			
			System.out.println("Exception is "+e.getMessage());
		}
		
		
	}
	
	public String getApplicationURL()
	{
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	public String getUsername()
	{
		String username=pro.getProperty("username");
		return username;
	}
	
	
	public String getPassword()
	{
		String password=pro.getProperty("password");
		return password;
	}
	
	public String getChrome()
	{
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getFirefox()
	{
		String firefoxpath=pro.getProperty("firefoxpath");
		return firefoxpath;
	}
	
	
	
	
	

}
