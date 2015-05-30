package com.example.tests;

import static com.example.tests.ContactsDataGenerator.loadContactsFromCsvFile;
import static com.example.tests.ContactsDataGenerator.loadContactsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
import static com.example.fw.ContactHelper.CREATION;


	public class ContactCreationTests  extends TestBase {
		
		@DataProvider
		
		  public Iterator<Object[]> ContactsFromFile()throws IOException {
			  return wrapContactDataforDataProvider (loadContactsFromXmlFile(new File("contacts.xml"))).iterator();
		  }
	
		  @Test(dataProvider = "contactsfromfile")
	  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	   // app.navigateTo().mainPage();
	    // save old state
	  SortedListOf<ContactData> oldlist = app.getContactHelper().getContacts();
	    // action
		app.getContactHelper().createContact(contact);
		app.navigateTo().returnToHomePage();
	    // save new state
		SortedListOf<ContactData> newlist = app.getContactHelper().getContacts();
	    // compare states 
		 assertThat(newlist, equalTo(oldlist.withAdded(contact))); 
	  }  
	}

	
	
	
	  

	