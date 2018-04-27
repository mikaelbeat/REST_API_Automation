package specs;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class Request_Specification_Demo {
	
	// Given -> I have this information
	// When -> I perform this action
	// Then -> This should be the output
	
	String consumerKey = "fzDfnjmtGavB1LnB5bWvxMgvH";
	String consumerSecretKey = "LW8wKiFws6GunWMsuTmcM7Yqw9CNIKzCvybYLt010OJRolBYZT";
	String accessToken = "988679202609291264-foMMhGRXlmuNsfHCaAl9RT5zQFeYpTk";
	String accessTokenSecret = "n2hgWDPQCF1jZAO1u31jXjRirdpwfN1Jteg6DIlIdWSGN";
	
	RequestSpecBuilder requestBuilder;
	static RequestSpecification requestSpec;
	
	@BeforeClass
	public  void setUp() {
//		RestAssured.baseURI = "https://api.twitter.com";
//		RestAssured.basePath = "/1.1/statuses";
		AuthenticationScheme authScheme = 
				RestAssured.oauth(consumerKey, consumerSecretKey, accessTokenSecret, accessTokenSecret);
		requestBuilder = new RequestSpecBuilder();
		requestBuilder.setBaseUri("https://api.twitter.com");
		requestBuilder.setBasePath("/1.1/statuses");
		requestBuilder.addQueryParam("user_id", "MikaelBeat");
		requestBuilder.setAuth(authScheme);
		requestSpec = requestBuilder.build();
	}

	@Test
	public void read_Tweets() {
		 given()
		 	.spec(requestSpec)
//			Parameters have been defined in requestBuilder
//			.auth()
//			.oauth(consumerKey, consumerSecretKey, accessToken, accessTokenSecret)
//			.queryParam("user_id", "MikaelBeat")
		.when()
			.get("/user_timeline.json")	
		.then()
			.statusCode(200);
	}

}