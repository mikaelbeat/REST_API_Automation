package test_Classes;

import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import application_Code.Some_Class_To_Test;

public class Soft_Assertions {
	
	@Test
	public void testSum() {
		SoftAssert sa = new SoftAssert();
		System.out.println("Running test - testSum...");
		Some_Class_To_Test obj = new Some_Class_To_Test();
		int result = obj.sumNumbers(1, 2);
		sa.assertEquals(result, 2);
		System.out.println("Line after assert 1.");
		sa.assertEquals(result, 3);
		System.out.println("This is a line after assert 2.");
		sa.assertAll();
	}

}