package com.example.tests;

	

import java.util.Collections;

import java.util.List;


import static org.testng.Assert.assertEquals;


import org.testng.annotations.Test;

	public class ContactCreationTests  extends TestBase {
		
		
	  @Test(dataProvider = "randomValidContactGenerator")
	  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	    app.getNavigationHelper().openMainPage();
	    // save old state
	    List<ContactData> oldlist = app.getContactHelper().getContacts();
	    
	    // action
	    app.getContactHelper().gotoContactCreation();
	    app.getContactHelper().fillContactCreation(contact);
	    app.contactHelper.submitContactCreation();
	    app.getNavigationHelper().returnToHomePage();
	    
	    // save new state
	   List<ContactData> newlist = app.getContactHelper().getContacts();
	    // compare states 
	    
	 
	   oldlist.add(contact);
	   Collections.sort(oldlist); 
	    assertEquals(newlist, oldlist);
	  }  
	  
	  
	  
	 
		  
	}



	