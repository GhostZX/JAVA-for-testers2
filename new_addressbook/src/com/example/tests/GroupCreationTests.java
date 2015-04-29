package com.example.tests;

import org.testng.annotations.Test;

	public class GroupCreationTests extends TestBase { 
	  
	  

	  @Test
	  public void testNonEmptyGropCreation() throws Exception {
	    openMainPage();
	    gotoGroupsPage();
	    initGroupCreation();
	    GroupData group = new GroupData();
	    group.groupname = "groupname 1";
	    group.header = "header 1";
	    group.footer = "footer 1";
	    
		fillGroupForm(group);
	    submitGroupForm();
	    returnToGroupsPage();
	  }
	  
	  @Test
	  public void testEmptyGropCreation() throws Exception {
	    openMainPage();
	    gotoGroupsPage();
	    initGroupCreation();
	    fillGroupForm(new GroupData("", "", ""));
	    submitGroupForm();
	    returnToGroupsPage();
	  }

		
	}

