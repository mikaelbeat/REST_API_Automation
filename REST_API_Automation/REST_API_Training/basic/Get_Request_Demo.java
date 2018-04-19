package basic;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Get_Request_Demo {
	
	// Given -> I have this information
	// When -> I perform this action
	// Then -> This should be the output
	
	@BeforeClass
	public  void setUp() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}

	@Test
	public void status_Code_Verification() {
		given().param("units", "imperial")
			   .param("origins", "Washington,DC")
			   .param("destinations", "New+York+City")
			   .param("key", "AIzaSyD9jDyAwytS-zudoP9PyNh-AyFXzwOTX-Q")
		.when().get("/distancematrix/json")
		.then().statusCode(200);
	}

}