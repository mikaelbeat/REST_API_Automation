package specs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class Response_Specification_Demo2 {
	
	// Given -> I have this information
	// When -> I perform this action
	// Then -> This should be the output
	
	String consumerKey = "fzDfnjmtGavB1LnB5bWvxMgvH";
	String consumerSecretKey = "LW8wKiFws6GunWMsuTmcM7Yqw9CNIKzCvybYLt010OJRolBYZT";
	String accessToken = "988679202609291264-foMMhGRXlmuNsfHCaAl9RT5zQFeYpTk";
	String accessTokenSecret = "n2hgWDPQCF1jZAO1u31jXjRirdpwfN1Jteg6DIlIdWSGN";
	
	ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpec;
	
	@BeforeClass
	public  void setUp() {
		RestAssured.baseURI = "https://api.twitter.com";
		RestAssured.basePath = "/1.1/statuses";
		responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectBody("user.name", hasItem("Petri Ryynänen"));
		responseSpec = responseBuilder.build();
	}

	@Test
	public void read_Tweets() {
		 given()
			.auth()
			.oauth(consumerKey, consumerSecretKey, accessToken, accessTokenSecret)
			.queryParam("user_id", "MikaelBeat")
		.when()
			.get("/user_timeline.json")	
		.then()
//			All common response parameters have been defined in responseBuilder
//			.statusCode(200)
//			.log().body()
//			.body("user.name", hasItem("Petri Ryynänen"))
		.spec(responseSpec)
		.body("user.screen_name", hasItem("MikaelBeat"));
	}

}