package com.example.tests;
import static com.example.tests.GroupDataGenerator.loadGroupsFromCsvFile;
import static com.example.tests.GroupDataGenerator.loadGroupsFromXmlFile;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.example.utils.SortedListOf;

	public class GroupCreationTests extends TestBase { 
		
		@DataProvider
		
		  public Iterator<Object[]> groupsFromFile()throws IOException {
			  return wrapGroupDataforDataProvider (loadGroupsFromXmlFile(new File("groups.xml"))).iterator();
		  }
	@Test(dataProvider = "groupsfromfile")
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

