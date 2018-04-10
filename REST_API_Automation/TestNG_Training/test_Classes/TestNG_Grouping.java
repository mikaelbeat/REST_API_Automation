package test_Classes;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNG_Grouping {
	
  @BeforeClass(alwaysRun = true)
  public void beforeClass() {
	  System.out.println("Before class.");
  }
  
  @Test(groups = {"cars", "suv"})
  public  void testBMW6() {
	  System.out.println("Running test -> BMW X6");
  }
  
  @Test(groups = {"cars", "sedan"})
  public  void testAudiA6() {
	  System.out.println("Running test -> Audi A6");
  }
  
  @Test(groups = {"bikes"})
  public void testNinja() {
	  System.out.println("Running test -> Kawasaki Ninja");
  }
  
  @Test(groups = {"bikes"})
  public void testHondaCBR() {
	  System.out.println("Running test -> Honda CBR");
  }
  
  @AfterClass(alwaysRun = true)
  public void afterClass() {
	  System.out.println("After class.");
  }
   
}