package com.example.tests;


import java.util.Collections;

import java.util.List;


import static org.testng.Assert.assertEquals; 


import org.testng.annotations.Test;

	public class GroupCreationTests extends TestBase { 

	  @Test(dataProvider = "randomValidGroupGenerator")
	  public void testGropCreationWithValidData(GroupData group) throws Exception {
	    app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().gotoGroupsPage();
	    // save old state
	    List<GroupData> oldlist = app.getGroupHelper().getGroups();
	    //action		
	    app.getGroupHelper().initGroupCreation();
	    app.getGroupHelper().fillGroupForm(group);
	    app.getGroupHelper().submitGroupForm();
	    app.getGroupHelper().returnToGroupsPage();
	 // save new state
	    List<GroupData> newlist = app.getGroupHelper().getGroups();
	    // compare status 	  
	  oldlist.add(group); 
	  Collections.sort(oldlist);
	  assertEquals(newlist, oldlist);
	  
	  }
	  
	}

