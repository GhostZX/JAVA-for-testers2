package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}

	public void gotoContactCreation() {
		click(By.linkText("add new"));
	}

	public void fillContactCreation(ContactData contact) {
		type(By.name("firstname"),contact.firstname);
		
	    type(By.name("lastname"),contact.lastname);
        
	    type(By.name("address"),contact.address);
	    
	    type(By.name("home"),contact.home);
	    
	    type(By.name("mobile"),contact.mobile);
	    
	    type(By.name("work"),contact.work);
	    
	    type(By.name("email"),contact.email);
	    
	    type(By.name("email2"),contact.email2);
	    
	    
	    selectByText(By.name("bday"), contact.date);
	    selectByText(By.name("bmonth"), contact.month);
	    
	    type(By.name("byear"),contact.year);
	    
	  //  selectByText(By.name("new_group"), contact.groupname);
	    
	    type(By.name("address2"),contact.address2);
	    
	    type(By.name("phone2"),contact.phone2);
	    
	}

	
	public void submitContactCreation() {
		click(By.name("submit"));
	}

}
