package com.vaibhav.scala.basics;

public class JavaFIClient {

	// Functional interface implementation using method reference
	public static boolean referenceMethod(int x) {
		return x > 3;
	}

	// Java method, passing functional interface as argument
	public static boolean sampleMethod(int x, MyFI fi) {
		return fi.isGreater(x);
	}

	public static void main(String[] args) {
		int i = 5;
		// Java, Calling method using lambda expression
		System.out.println(sampleMethod(i, (x) -> x > 5));

		// Java, Calling method using method reference
		System.out.println(sampleMethod(i, JavaFIClient::referenceMethod));

	}

}
