package regression_Suite;

import org.testng.annotations.Test;

import base.Base_Test_Suite;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_TestClass2 extends Base_Test_Suite {
	
	@BeforeClass
	public void setUp() {
		System.out.println("\nTestNG_TestClass2 -> This runs first in class.");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\nTestNG_TestClass2 -> This runs before every method.");
	}
	
	@Test
	public void TestMethod1() {
		System.out.println("\nTestNG_TestClass2 -> Running test -> TestNG_TestClass2 -> TestMethod1...");
	}
	
	@Test
	public void TestMethod2() {
		System.out.println("\nTestNG_TestClass2 -> Running test -> TestNG_TestClass2 -> TestMethod2...");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("\nTestNG_TestClass2 -> This runs after every method.");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_TestClass2 -> This runs after class.\n");
	}

}