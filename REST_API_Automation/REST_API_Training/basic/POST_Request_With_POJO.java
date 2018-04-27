package basic;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Places_Add_Model;

public class POST_Request_With_POJO {
	
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
		
		Map<String, Double> locationMap = new HashMap<String, Double>();
		locationMap.put("lat", -33.8669710);
		locationMap.put("lng", 151.1958750);
		
		List<String> types = new ArrayList<String>();
		types.add("shoe_store");
		
		Places_Add_Model places = new Places_Add_Model();
		places.setLocation(locationMap);
		places.setAccuracy(50);
		places.setName("Google Shoes!");
		places.setPhone_number("(02) 9374 4000");
		places.setAddress("48 Pirrama Road, Pyrmont, NSW 2009, Australia");
		places.setTypes(types);
		places.setWebsite("http://www.google.com.au");
		places.setLanquage("en-AU");
		
//		Response res = 
		given()
			   .queryParam("key", "AIzaSyBiLi7Twf08yLo1GzR-szoYvguotlIu1eQ")
			   .body(places)
		.when()
			   .post("/place/add/json")
//		System.out.println(res.asString());
		.then()
				.statusCode(200).and()
				.contentType(ContentType.JSON).and()
				.body("scope", equalTo("APP")).and()
				.body("status", equalTo("OK"));
	}

}