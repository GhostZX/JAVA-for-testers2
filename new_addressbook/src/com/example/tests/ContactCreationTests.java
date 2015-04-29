package com.example.tests;

	
import org.testng.annotations.Test;

	public class ContactCreationTests  extends TestBase {
	  @Test
	  public void testNonEmptyContactCreation() throws Exception {
	    openMainPage();
	    gotoContactCreation();
	    ContactData contact = new ContactData();
		contact.firstname = "first name";
		contact.lastname = "last name";
		contact.address =  "address";
		contact.home = "home";
		contact.mobile = "mobile";
		contact.work = "work";
		contact.email = "email";
		contact.email2 = "email2";
		contact.date ="9";
		contact.month ="August";
		contact.year ="1980";
		contact.groupname = "group 1";
		contact.address2 = "address2";
		contact.home2 = "home 2";
		
		
		
	    fillContactCreation(contact);
	    //selectBirthDate("9");
	   // selectBirthMonth("August");
	   // fillBirthYear("1980");
	   // selectGroupName("group 1");
	   // fillSecondContact("address2","home 2");
	    submitContactCreation();
	    returnToHomePage();
	  }
	  
	  @Test
	  public void testEmptyContactCreation() throws Exception {
	    openMainPage();
	    gotoContactCreation();
	    fillContactCreation(new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "[none]", "", ""));
	    //selectBirthDate("-");
	    //selectBirthMonth("-");
	    //fillBirthYear(" ");
	    //selectGroupName("[none]");
	    //fillSecondContact("","");
	    submitContactCreation();
	    returnToHomePage();
	  }

	//private void fillSecondContact(String home2, String address2) {
		
	//}

	//private void selectGroupName(String groupname) {
		// new Select(driver.findElement(By.name("new_group"))).selectByVisibleText(groupname);
	//}

//	private void fillBirthYear(String year) {
//		driver.findElement(By.name("byear")).clear();
//	    driver.findElement(By.name("byear")).sendKeys(year);
//	}

//	private void selectBirthMonth(String month) {
//		new Select(driver.findElement(By.name("bmonth"))).selectByVisibleText(month);
//	}
//
//	private void selectBirthDate(String date) {
//		new Select(driver.findElement(By.name("bday"))).selectByVisibleText(date);
//	}

	}


