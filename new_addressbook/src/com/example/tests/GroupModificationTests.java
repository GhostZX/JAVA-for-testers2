package com.example.tests;
import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase{
	

		@Test (dataProvider = "randomValidGroupGenerator")
		public void modifySomeGroup(GroupData group){
			app.getNavigationHelper().openMainPage();
		    app.getNavigationHelper().gotoGroupsPage();
		    
		 // save old state
		    List<GroupData> oldlist = app.getGroupHelper().getGroups();
		    

		    Random rnd = new Random();
		    int index = rnd.nextInt(oldlist.size()-1);
		    //action
		    
		    app.getGroupHelper().initGroupModification(index);
		    app.getGroupHelper().fillGroupForm(group);
		    app.getGroupHelper().submitGroupModification();
		    app.getGroupHelper().returnToGroupsPage();
		
		    // save new state
		    
		    List<GroupData> newlist = app.getGroupHelper().getGroups();
		   
		    
		    // compare status 	  
		  oldlist.remove(index); 
		  oldlist.add(group);  
		  Collections.sort(oldlist);
		  assertEquals(newlist, oldlist);
		
		}
	}

