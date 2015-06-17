package com.example.tests;

import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;

import com.beust.jcommander.Parameters;
import com.example.fw.ApplicationManager;


public  class TestBase { 
	protected Logger log = Logger.getLogger("TEST");
	 protected ApplicationManager app;

	@BeforeClass
	@Parameters({"configFile"})
	public void setUp(@Optional String configFile) throws Exception {
		if ( configFile == null) {
		configFile = System.getProperty("configfile");
				}
		if ( configFile == null) {
			configFile = System.getenv("configfile");
					}
		if ( configFile == null) {
			configFile = "application.properties";
			}
		
		Properties properties = new Properties();
		properties.load(new FileReader("configfile"));
		log.info("setUp start");
		app = ApplicationManager.getInstance(properties);
		log.info("setUp end");
	}
	@AfterClass
	@AfterTest
	public void tearDown() throws Exception {
		log.info("tearDown start");
		ApplicationManager.getInstance(null).stop();
		log.info("tearDown end");
		
	}
	
  	
}
		  
