package com.basics;

public class Abc {

	public static void main(String[] args) {

		String s1 = "abc";
		String s2 = new String("abc");
		String s3 = "abc";
			
		if(s1.equals(s2)) {
			System.out.println("One");
		}else {
			System.out.println("Two");
		}
		
		
		if(s1 == s2) {
			System.out.println("1");
		}else {
			System.out.println("2");
		}
		
		
	}

}
