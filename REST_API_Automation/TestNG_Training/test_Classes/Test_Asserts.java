package test_Classes;

import org.testng.Assert;
import org.testng.annotations.Test;
import application_Code.Some_Class_To_Test;

public class Test_Asserts {

	@Test
	public void testSum() {
		System.out.println("Running test -> testSum");
		Some_Class_To_Test obj = new Some_Class_To_Test();
		int result = obj.sumNumbers(1, 2);
		Assert.assertEquals(result, 3);
	}
	
	@Test
	public void testStrings() {
		System.out.println("Running test -> testStrings");
		String expectedString = "Hello World";
		Some_Class_To_Test obj = new Some_Class_To_Test();
		String result = obj.addStrings("Hello", "World");
		Assert.assertEquals(result, expectedString);
	}
	
	@Test
	public void testArrays() {
		System.out.println("Running test -> testArrays");
		int[] expectedArray = {1, 2, 3};
		Some_Class_To_Test obj = new Some_Class_To_Test();
		int[] result = obj.getArray();
		Assert.assertEquals(result, expectedArray);
	}

}