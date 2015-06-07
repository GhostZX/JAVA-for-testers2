package com.example.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;


public  class TestBase { 
	
	 protected ApplicationManager app;

	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception {
		String configfile = System.getProperty("configfile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File ("configfile")));
		//app = new ApplicationManager(properties);
	}
	@AfterMethod
	@AfterTest
	public void tearDown() throws Exception {
		app.stop(); 
	}
	
  	
}
		  
