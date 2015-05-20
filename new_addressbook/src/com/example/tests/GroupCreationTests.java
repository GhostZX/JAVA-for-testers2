package com.example.tests;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import com.example.fw.GroupHelper;
import com.example.utils.SortedListOf;

	public class GroupCreationTests extends TestBase { 
		
	  @Test(dataProvider = "randomValidGroupGenerator")
	  public void testGropCreationWithValidData(GroupData group) throws Exception {
	    // save old state
		  SortedListOf<GroupData> oldlist = app.getGroupHelper().getGroups();
	    //action		
	    app.getGroupHelper().createGroup(group);
		
	 // save new state
	    SortedListOf<GroupData> newlist = app.getGroupHelper().getGroups();
	    // compare status 
	  assertThat(newlist, equalTo(oldlist.withAdded(group))); 
	  
	  }
	}

