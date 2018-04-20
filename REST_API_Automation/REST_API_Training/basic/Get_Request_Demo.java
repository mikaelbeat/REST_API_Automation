package basic;

import io.restassured.RestAssured;
import io.restassured.response.Response;

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
			   .param("key", "AIzaSyA49xhTOHmabT9vU8Li-Pu6qdc8HEtawi8")
		.when().get("/distancematrix/json")
		.then().statusCode(200);
	}
	
	@Test
	public void get_Response_Body() {
		Response res = 
		given()
			.param("units", "imperial")
			.param("origins", "Washington,DC")
			.param("destinations", "New+York+City,NY")
			.param("key", "AIzaSyA49xhTOHmabT9vU8Li-Pu6qdc8HEtawi8")
		.when()
			.get("/distancematrix/json");
		
//		System.out.println(res.body().asString());
		System.out.println(res.body().prettyPrint());
	}
	

}