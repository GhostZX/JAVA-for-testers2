package com.example.tests;

import static org.testng.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

import static com.example.fw.ContactHelper.MODIFICATION;

public class ContactModificationTest extends TestBase{


	
	@Test (dataProvider = "randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		app.navigateTo().mainPage();
		
		 // save old state
		SortedListOf<ContactData> oldlist = app.getContactHelper().getContacts();
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldlist.size()-1); 
	    // action
	    app.getContactHelper().modifyContact(index, contact);
	    app.navigateTo().returnToHomePage();
	    // save new state
		   SortedListOf<ContactData> newlist = app.getContactHelper().getContacts();
		    // compare states 
			 assertThat(newlist, equalTo(oldlist.without(index).withAdded(contact)));

		  }  
	}


