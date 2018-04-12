package test_Classes;

import org.testng.annotations.Test;

public class TestNG_TestParaller1 {
	
	@Test
	public void testMethod1() throws InterruptedException {
		System.out.println("TestNG_TestParaller1 -> testMethod1...");
		Thread.sleep(6000);
		System.out.println("TestNG_TestParaller1 -> testmetho1 -> More steps...");
	}
	
	@Test
	public void testMethod2() throws InterruptedException {
		System.out.println("TestNG_TestParaller1 -> testMethod2...");
		Thread.sleep(6000);
		System.out.println("TestNG_TestParaller1 -> testMethod2 -> More steps...");
	}
}
