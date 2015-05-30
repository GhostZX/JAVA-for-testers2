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

import static com.example.tests.GroupDataGenerator.generateRandomGroups;
import static com.example.tests.ContactDataGenerator.generateRandomContacts;
public  class TestBase { 
	
	 protected ApplicationManager app;

	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception {
		String configfile = System.getProperty("configfile", "application.properties");
		Properties properties = new Properties();
		properties.load(new FileReader(new File ("configfile")));
		app = new ApplicationManager(properties);
	}
	@AfterMethod
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	}
	@DataProvider
	
	  public Iterator<Object[]> randomValidGroupGenerator() {
		  return wrapGroupDataforDataProvider (generateRandomGroups(5)).iterator();
	  }	
  	public static List<Object[]> wrapGroupDataforDataProvider(List<GroupData> groups) {
			  List<Object[]> list = new ArrayList<Object[]>();
			  for (GroupData group : groups){
				 list.add(new Object[]{groups});
			  }
		return list;
	}
  	
	  @DataProvider
	  public Iterator<Object[]> randomValidContactGenerator() { 
	  return wrapContactDataforDataProvider (generateRandomContacts(6)).iterator();
}	
      public static List<Object[]> wrapContactDataforDataProvider(List<ContactData> contacts) {
		  List<Object[]> list = new ArrayList<Object[]>();
		  for (ContactData contact : contacts){
			 list.add(new Object[]{contacts});
		  }
	return list;
      }	
		}
		  
