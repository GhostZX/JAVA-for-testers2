package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Random;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;


public class GroupModificationTests extends TestBase{
	

		@Test (dataProvider = "randomValidGroupGenerator")
		public void modifySomeGroup(GroupData group){		    
		 // save old state
			SortedListOf<GroupData> oldlist = app.getGroupHelper().getGroups();
		    
		    Random rnd = new Random();
		    int index = rnd.nextInt(oldlist.size()-1);
		    //action
		    app.getGroupHelper().modifyGroup(index, group);
		   
		    // save new state
		    SortedListOf<GroupData> newlist = app.getGroupHelper().getGroups();
		    // compare status 	
		    assertThat(newlist, equalTo(oldlist.without(index).withAdded(group))); 
			  
		}
	}

