package basic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POST_Request_Demo {
	
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
		given()
			   .queryParam("key", "AIzaSyBiLi7Twf08yLo1GzR-szoYvguotlIu1eQ")
			   .body("{\r\n" + 
			   		"  \"location\": {\r\n" + 
			   		"    \"lat\": -33.8669710,\r\n" + 
			   		"    \"lng\": 151.1958750\r\n" + 
			   		"  },\r\n" + 
			   		"  \"accuracy\": 50,\r\n" + 
			   		"  \"name\": \"Google Shoes!\",\r\n" + 
			   		"  \"phone_number\": \"(02) 9374 4000\",\r\n" + 
			   		"  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\r\n" + 
			   		"  \"types\": [\"shoe_store\"],\r\n" + 
			   		"  \"website\": \"http://www.google.com.au/\",\r\n" + 
			   		"  \"language\": \"en-AU\"\r\n" + 
			   		"}")
		.when()
			   .post("/place/add/json")
		.then()
				.statusCode(200).and()
				.contentType(ContentType.JSON).and()
				.body("scope", equalTo("APP")).and()
				.body("status", equalTo("OK"));
	}

}