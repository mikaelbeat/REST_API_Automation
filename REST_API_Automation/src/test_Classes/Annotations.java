package test_Classes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Annotations {
	
	@BeforeClass
	public void setUp() {
		System.out.println("This runs once before class.");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("This runs before every method.");
	}
	
	@Test
	public void testMethod1() {
		System.out.println("Running test -> TestMethod1...");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("Running test -> TestMethod2...");
	}


	@AfterMethod
	public void afterMethod() {
		System.out.println("This runs after every method.");
	}
	
	@AfterClass
	public void cleanUp() {
		System.out.println("This runs after class.");
	}

}