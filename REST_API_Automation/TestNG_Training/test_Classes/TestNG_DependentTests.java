package test_Classes;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import application_Code.Some_Class_To_Test;

public class TestNG_DependentTests {
	
	Some_Class_To_Test obj;	
	
	@BeforeClass
	public void setUp() {
		obj = new Some_Class_To_Test();
		System.out.println("Test setup.");
	}

	@AfterClass
	public void cleanUp() {
		System.out.println("Test cleanUp.");
	}

	@Test(dependsOnMethods = {"testMethod2"},alwaysRun = true)
	public void testMethod1() {
		System.out.println("testMethod1");

	}

	@Test
	public void testMethod2() {
		System.out.println("testMethod2");
		int result = obj.sumNumbers(1, 2);
		Assert.assertEquals(result, 2);
	}

	@Test(dependsOnMethods = {"testMethod1"})
	public void testMethod3() {
		System.out.println("testMethod3");
	}

	@Test(dependsOnMethods = {"testMethod3"})
	public void testMethod4() {
		System.out.println("testMethod4");
	}

}