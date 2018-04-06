package test_Classes;

import org.testng.annotations.Test;
import application_Code.Some_Class_To_Test;

public class Test_Annotation {

	@Test
	public void testMethod1() {
		Some_Class_To_Test obj = new Some_Class_To_Test();
		int result = obj.sumNumbers(1, 2);
		System.out.println("Running test -> testMethod1");
	}
	
	@Test
	public void testMethod2() {
		System.out.println("Running test -> testMethod2");
	}
	
	@Test
	public void testMethod3() {
		System.out.println("Running test -> testMethod3");
	}

}
