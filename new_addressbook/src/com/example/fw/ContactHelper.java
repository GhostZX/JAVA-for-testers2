package com.example.fw;

import static com.example.fw.ContactHelper.MODIFICATION;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.utils.SortedListOf;
public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = true;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
		
	}
	public ContactHelper gotoContactCreation() {
		click(By.linkText("add new"));
		return this; 
	}
	 private SortedListOf<ContactData> cachedContacts;
	
//!!!!!!
public SortedListOf<ContactData> getContacts() {
	if ( cachedContacts == null){
		rebuildCache();
	}
 return cachedContacts;
}
	private void rebuildCache() {
		SortedListOf<ContactData> cachedContacts = new SortedListOf<ContactData> ();
		manager.navigateTo().mainPage();
		List<WebElement> rows = getContactRows();
		for (WebElement row :rows){
		ContactData contact =   new ContactData ()
		.setFirstname(row.findElement(By.xpath(".//td[2]")).getText());
		//.setLastname(row.findElement(By.xpath(".//td[3]")).getText());	
		cachedContacts.add(contact);
		}
	}
	public ContactHelper createContact(ContactData contact) {
    	manager.navigateTo().mainPage();
    	gotoContactCreation();
        submitContactCreation();
        rebuildCache();
        return this;
}
	public ContactHelper fillContactCreation(ContactData contact, boolean formType) {
		type(By.name("firstname"),contact.getFirstname());
	    type(By.name("lastname"),contact.getLastname());
	    type(By.name("address"),contact.getAddress());
	    type(By.name("home"),contact.getHome());
	    type(By.name("mobile"),contact.getMobile());
	    type(By.name("work"),contact.getWork());
	    type(By.name("email"),contact.getEmail());
	    type(By.name("email2"),contact.getEmail2());
	    selectByText(By.name("bday"), contact.date);
	    selectByText(By.name("bmonth"), contact.month);
	    type(By.name("byear"),contact.year);
	    if (formType == CREATION){
	  //  selectByText(By.name("new_group"), contact.groupname);
	    }
	    else{
	    	//if (driver.findElement(By.name("new_group")).size() !=0) {
	    	//	throw new Error ("Group selector exist in contact modification form");
	    	//}
	    }
	    type(By.name("address2"),contact.address2);
	    type(By.name("phone2"),contact.phone2);
	    return this; 
	}
    	
		public ContactHelper modifyContact(int index, ContactData contact) {
			editContact(index);
		    fillContactCreation(contact, MODIFICATION);
		    submitContactModification();
		    rebuildCache();
			return this; 
		}
		
		public ContactHelper deleteContact(int index) {
		    click(By.xpath("(//img[@alt='Edit'])[" + (index+1) + "]"));
		    click(By.xpath("(//input[@name='update'])[2]"));
		    rebuildCache();
		    return this; 
		}
		public void submitContactModification() {
	       click(By.xpath("(//input[@name='update'])[1]"));
	       cachedContacts = null;
	
}
		public ContactHelper editContact(int index) {
			click(By.xpath("(//img[@alt='Edit'])[" + (index +1)+ "]"));
			return this; 
			
	} 
		public ContactHelper submitContactCreation() {
			click(By.name("submit"));
			cachedContacts = null;
			return this; 
		}
private ContactData setFirstname(String text) {
	
	return null;
}

// !!!!
public List<WebElement> getContactRows() {
	return driver.findElements((By.xpath(".//*[@id='maintable']/tbody/tr/td[3]")));
}
 }
  