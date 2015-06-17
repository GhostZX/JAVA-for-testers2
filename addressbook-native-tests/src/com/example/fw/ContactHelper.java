package com.example.fw;

public class ContactHelper extends HelperBase  {

	public ContactHelper(ApplicationManager applicationManager) {
		super(applicationManager);
		
	}

	public void createContact(Contact  contact) {
		initContactCreation();
	fillContactForm(contact);
	confirmContactCreation();
	}

	private void confirmContactCreation() {
		manager.getAutoItHelper()
		.click("Save")
		.winWaitAndActivate("AddressBook Portable", "", 5000);
	}

	private void fillContactForm(Contact contact) {
		manager.getAutoItHelper()
		.send("TDBEdit12", contact.firstname)
		.send("TDBEdit11",contact.lastname);
	}

	private void initContactCreation() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("Add").winWaitAndActivate("Add contact", "",5000);
	}

	public Contact getFirstContact() {
		manager.getAutoItHelper()
		.winWaitAndActivate("AddressBook Portable", "", 5000)
		.click("TListView1")
		.send("{DOWN}{SPACE}")
		.click("Edit")
		.winWaitAndActivate("Update Contact", "", 5000);
		Contact contact = new Contact()
		.setFirstname(manager.getAutoItHelper().getText("TDBEdit12"))
		.setLastName(manager.getAutoItHelper().getText("TDBEdit11"));
		manager.getAutoItHelper()
		.click("Cancel")
		.winWaitAndActivate("AddressBook Portable", "", 5000);
         return contact;
	}

}
 