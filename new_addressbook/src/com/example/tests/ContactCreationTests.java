package com.example.tests;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.example.fw.ContactHelper;
import com.example.fw.NavigationHelper;

import static com.example.fw.ContactHelper.CREATION;


	public class ContactCreationTests  extends TestBase {
			
	  @Test(dataProvider = "randomValidContactGenerator")
	  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	   // app.navigateTo().mainPage();
	    // save old state
	   List<ContactData> oldlist = app.getContactHelper().getContacts();
	    
	    // action
		app.getContactHelper().createContact(contact);
		app.navigateTo().returnToHomePage();
	    
	    // save new state
		List<ContactData> newlist = app.getContactHelper().getContacts();
	    // compare states 
		 assertThat(newlist, equalTo(oldlist.withAdded(contact))); 
   
	  }  
		  
	}



	