package basic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Validate_Response {
	
	// Given -> I have this information
	// When -> I perform this action
	// Then -> This should be the output
	
	@BeforeClass
	public  void setUp() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}

	@Test
	public void validate_Response() {
		given().param("units", "imperial")
			   .param("origins", "Washington,DC")
			   .param("destinations", "New+York+City")
			   .param("key", "AIzaSyA49xhTOHmabT9vU8Li-Pu6qdc8HEtawi8")
		.when().get("/distancematrix/json")
		.then().statusCode(200)
		.and()
		.body("rows[0].elements[0].distance.text", equalTo("225 mi"))
		.contentType(ContentType.JSON);
	}

}