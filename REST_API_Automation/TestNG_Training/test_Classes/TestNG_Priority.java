package test_Classes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNG_Priority {
	
	@BeforeClass
	public void setUp() {
		System.out.println("\nTestNG_TestClass1 ->This runs first in class.");
	}
	
	@Test(priority=2)
	public void TestMethod1() {
		System.out.println("\nTestNG_Priority -> TestMethod1...");
	}
	
	@Test(priority=1)
	public void TestMethod2() {
		System.out.println("\nnTestNG_Priority -> TestMethod2...");
	}
	
	@Test(priority=0)
	public void TestMethod3() {
		System.out.println("\nTestNG_Priority -> TestMethod3");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("\nTestNG_TestClass1 -> This runs after class.\n");
	}

}