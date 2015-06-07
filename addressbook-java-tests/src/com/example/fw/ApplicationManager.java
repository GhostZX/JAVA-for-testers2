package com.example.fw;


import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.WindowOperator;

public class ApplicationManager {
	
	private static ApplicationManager singleton;
	private FolderHelper folderHelper;
	private Properties props;
	private JFrameOperator mainFrame;
	private MenuHelper menuHelper;

	public static  ApplicationManager getInstance(){
		
	if (singleton == null){
		singleton = new ApplicationManager ();
			}
	return singleton;
	
	}
	public void stop() { 
		getApplication().requestClose();
  } 

	private WindowOperator getApplication() {
		
		return null;
	}
	public void setProperties (Properties props){
		this.props = props;
	}
	public FolderHelper getFolderHelper() {
		if (folderHelper == null){
			folderHelper = new FolderHelper(this);
		}
		return folderHelper;
	}
	public JFrameOperator getAplication() {
		if (mainFrame == null ) {	
		try {
			new ClassReference("addressbook.AddressBookFrame").startApplication();
	        mainFrame = new JFrameOperator("jAddressBook");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return mainFrame;
	}
	public Object getMenuHelper() {
		if (menuHelper == null){
			menuHelper = new MenuHelper(this);
		}
		return menuHelper;
	}
	
}
