package com.example.fw;


import java.io.IOException;
import java.util.Properties;

public class ApplicationManager {

public static ApplicationManager singleton ;

	private Properties properties; 
	private ContactHelper contactHelper;

	private ProcessHelper processHelper;

	private AutoItHelper autoItHelper;
	
	public static ApplicationManager getInstance(Properties properties) throws IOException {
		if (singleton == null){
			singleton = new ApplicationManager ();
			singleton.setProperties(properties);
			singleton.start();
		}
		return singleton;
		
		}
	public void start() throws IOException {
		getProcessHelper().startAppUnderTest();
	  } 
		public void stop(){
			getProcessHelper().stopAppUnderTest();
  } 
		public void setProperties (Properties props){
			this.properties = props;
	}
public ProcessHelper getProcessHelper() {
	if (processHelper == null){
		processHelper = new ProcessHelper(this);

	}
	return processHelper;
}
public ContactHelper getContactHelper() {
	if (contactHelper == null){
		contactHelper = new ContactHelper(this);

	}
	return contactHelper;
}

public String getProperty(String string) {
	
	return null;
}
public AutoItHelper getAutoItHelper() {
	if (autoItHelper == null){
		autoItHelper = new AutoItHelper(this);

	}
	return autoItHelper;
}
}