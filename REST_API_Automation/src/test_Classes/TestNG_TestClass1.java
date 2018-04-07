package test_Classes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_TestClass1 {
	
	@BeforeClass
	public void setUp() {
		System.out.println("\nTestNG_TestClass1 ->This runs first in class.");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_TestClass1 -> This runs before every method.");
	}
	
	@Test
	public void TestMethod1() {
		System.out.println("\nTestNG_TestClass1 -> Running test -> TestNG_TestClass1 -> TestMethod1...");
	}
	
	@Test
	public void TestMethod2() {
		System.out.println("\nTestNG_TestClass1 -> Running test -> TestNG_TestClass1 -> TestMethod2...");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("\nTestNG_TestClass1 -> This runs after every method.");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_TestClass1 -> This runs after class.\n");
	}

}
