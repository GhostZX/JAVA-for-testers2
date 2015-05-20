package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTests extends TestBase{
	@Test(dataProvider = "randomValidContactGenerator")
	
	public void deleteSomeContact (){
		app.navigateTo().mainPage();
		 // save old state
	    List<ContactData> oldlist = app.getContactHelper().getContacts();
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldlist.size()-1); 
	    // action
		app.getContactHelper().deleteContact(index);
		app.navigateTo().returnToHomePage();
		 // save new state
		   List<ContactData> newlist = app.getContactHelper().getContacts();
		    // compare states 
		    
		   
		   oldlist.remove(index);
		   Collections.sort(oldlist); 
		    assertEquals(newlist, oldlist);
		  }  
		  
		  
}
	
	
	
