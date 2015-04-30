package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase{


	
	@Test
	public void modifySomeContact(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().editContact(1);
	    ContactData contact = new ContactData();
		contact.firstname = "new name";
	    app.getContactHelper().fillContactCreation(contact);
	    app.getContactHelper().submitContactModification();
	    
	    app.getNavigationHelper().returnToHomePage();
	}

}
