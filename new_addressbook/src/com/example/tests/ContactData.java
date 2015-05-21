package com.example.tests;



public class ContactData implements Comparable <ContactData>{
	private String firstname;
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

	

	@Override
	public String toString() {
		return "ContactData [firstname=" + firstname + ", lastname=" + lastname
				+ ", address=" + address + ", home=" + home + ", mobile="
				+ mobile + ", work=" + work + ", email=" + email + ", email2="
				+ email2 + ", date=" + date + ", month=" + month + ", year="
				+ year + ", groupname=" + groupname + ", address2=" + address2
				+ ", phone2=" + phone2 + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		// result = prime * result	+ ((firstname == null) ? 0 : firstname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		
		return this.firstname.toLowerCase().compareTo(other.firstname.toLowerCase());
	}
	
	public ContactData setFirstname(String text) {
		
		return this;
	}

	public Object withFirstname(String firstname) {
		this.firstname = firstname;
		return this;
	}


	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getAddress() {
		return address;
	}

	public String getHome() {
		return home;
	}

	public String getMobile() {
		return mobile;
	}

	public String getWork() {
		return work;
	}

	public String getEmail() {
		return email;
	}

	public String getEmail2() {
		return email2;
	}

	public String getDate() {
		return date;
	}

	public String getMonth() {
		return month;
	}

	public String getYear() {
		return year;
	}

	public String getGroupname() {
		return groupname;
	}

	public String getAddress2() {
		return address2;
	}

	public String getPhone2() {
		return phone2;
	}

	}

	


	
	
