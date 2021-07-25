package com.linkedin.utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	 private Properties properties;
	 private final String propertyFilePath= "src/main/resources/linkedin.properties";
	 
	 
	 public ConfigReader(){
		 //read properties data
	 BufferedReader reader;
		 try {
		 reader = new BufferedReader(new FileReader(propertyFilePath));
		 properties = new Properties();
		 try {
		 properties.load(reader);
		 reader.close();
		 } catch (IOException e) {
		 e.printStackTrace();
		 }
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 throw new RuntimeException("Configuration properties not found at " + propertyFilePath);
		 } 
	 }
	 //get web driver from properties file 
	 public String getWebDriver() {
		 String webDriver = properties.getProperty("WebDriver");
		 if(webDriver != null) return webDriver;
		 else throw new RuntimeException("webDriver not specified in the app.properties file.");
	 }
	 // get chrome driver path from properties file
	 public String getChromeDriver() {
		 String chromeDriver = properties.getProperty("chromeDriver");
		 if(chromeDriver != null) return chromeDriver;
		 else throw new RuntimeException("chromeDriver not specified in the app.properties file.");
	 }
	// get linkedin url from properties file
	 public String getUrl() {
		 String url = properties.getProperty("url");
		 if(url != null) return url;
		 else throw new RuntimeException("url not specified in the Configuration.properties file.");
		 }
}
