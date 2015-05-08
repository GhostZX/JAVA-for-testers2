package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{


	
	@Test (dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		app.getNavigationHelper().openMainPage();
		
		 // save old state
	    List<ContactData> oldlist = app.getContactHelper().getContacts();
	    
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldlist.size()-1); 
	    
	    // action
	    app.getContactHelper().editContact(index);
	    app.getContactHelper().fillContactCreation(contact);
	    app.getContactHelper().submitContactModification();
	    
	    app.getNavigationHelper().returnToHomePage();
	    // save new state
		   List<ContactData> newlist = app.getContactHelper().getContacts();
		    // compare states 
		   
		   
		   oldlist.remove(index);
		   oldlist.add(contact);
		   Collections.sort(oldlist); 
		    assertEquals(newlist, oldlist);
		  }  
	}


