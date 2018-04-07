package base;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Base_Test_Suite {

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("\nBase_Test_Suite -> Before suite.");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("\nBase_Test_Suite -> Before class.");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("\nBase_Test_Suite -> After class.");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("\nBase_Test_Suite -> After suite.");
	}

}