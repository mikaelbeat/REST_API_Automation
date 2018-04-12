package test_Classes;

import org.testng.annotations.DataProvider;

public class Test_Data {
	
	@DataProvider(name = "inputs")
	public Object[][] getData() {
		return new Object[][] {
			{"bmw","m3"},
			{"audi", "a6"},
			{"benz", "c300"}
		};
	}

}
