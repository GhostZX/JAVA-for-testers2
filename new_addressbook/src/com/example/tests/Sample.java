package com.example.tests;

public class Sample {

	public static void main (String[] args){
		String b = "+3 (752) 456-87-99 ";
	    b =	b.trim();
		b = b.replaceAll("[ ()\\-]", "");
		System.out.println(b);
		System.out.println(b.matches("\\+\\d+\\s*\\(\\d+\\)\\s*[\\d\\-])+"));
		
		
		
	}
	
}   
