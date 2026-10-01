package com.utitlity;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	
	private static Properties prob=new Properties();
	private static String path="config/QA.properties";
	private static InputStream inputStream ;
	private static String env;
	
	
	private PropertiesUtil() {
		
	}
	static {
		
		env = System.getProperty("env","qa");
		 switch(env.trim().toLowerCase()) {
		 case "qa" ->path="config/QA.properties";
		 case "dev" ->path="config/DEV.properties";
		 case "uat" ->path="config/UAT.properties";
		 default   ->path="config/QA.properties";
		 
		 }
		
		inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		if(inputStream==null) {
			throw new RuntimeException(" Cannot find the file at the path" +path);
		}
		try {
			prob.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getProplety(String key) {
		
		return prob.getProperty(key.toUpperCase());
		
	}
	
	

}
