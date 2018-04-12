package test_Classes;

import org.testng.annotations.Test;

public class TestNG_EnableTimeout {

	public void setUp() {
		System.out.println("Before class.");
	}

	public void cleanUp() {
		System.out.println("After class.");
	}

	@Test(enabled = false)
	public void testMethod1() {
		System.out.println("testMethod1");
	}

	@Test(timeOut = 100)
	public void testmethod2() throws InterruptedException {
		System.out.println("testMethod2");
		Thread.sleep(200);
	}

}