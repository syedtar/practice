package com.rest.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeClass;
public class APIBaseClass {
	protected static Properties pro;
	@BeforeClass
	public void setUp() throws IOException
	{
		System.out.println("in BeforeClass");
		/**
		 * Load the Property File
		 */
		  // Create  FileInputStream object 
		  FileInputStream fis=new FileInputStream(new File("./src/main/java/com/rest/properties/configuration.properties"));

		  // Create Properties class object to read properties file
		   pro=new Properties();

		  // Load file so we can use into our script 
		  pro.load(fis);


		
	}
	 
}