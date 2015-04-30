package com.example.tests;

public class ContactData {
	public String firstname;
	public String lastname;
	public String address;
	public String home;
	public String mobile;
	public String work;
	public String email;
	public String email2;
	public String date;
	public String month;
	public String year;
	public String groupname;
	public String address2;
	public String phone2;

	public ContactData() {
	}
	
	public ContactData(String firstname, String lastname, String address,
			String home, String mobile, String work, String email,
			String email2, String date, String month, String year,
			String groupname, String address2, String home2) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.home = home;
		this.mobile = mobile;
		this.work = work;
		this.email = email;
		this.email2 = email2;
		this.date = date;
		this.month = month;
		this.year = year;
		this.groupname = groupname;
		this.address2 = address2;
		this.phone2 = home2;
	}
}