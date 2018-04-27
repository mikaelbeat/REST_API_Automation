package specs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.lessThan;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Specification_With_Time {
	
	// Given -> I have this information
	// When -> I perform this action
	// Then -> This should be the output
	
	String consumerKey = "fzDfnjmtGavB1LnB5bWvxMgvH";
	String consumerSecretKey = "LW8wKiFws6GunWMsuTmcM7Yqw9CNIKzCvybYLt010OJRolBYZT";
	String accessToken = "988679202609291264-foMMhGRXlmuNsfHCaAl9RT5zQFeYpTk";
	String accessTokenSecret = "n2hgWDPQCF1jZAO1u31jXjRirdpwfN1Jteg6DIlIdWSGN";
	
	RequestSpecBuilder requestBuilder;
	static RequestSpecification requestSpec;
	
	ResponseSpecBuilder responseBuilder;
	static ResponseSpecification responseSpec;
	
	@BeforeClass
	public  void setUp() {
		AuthenticationScheme authScheme = 
				RestAssured.oauth(consumerKey, consumerSecretKey, accessToken, accessTokenSecret);
		requestBuilder = new RequestSpecBuilder();
		requestBuilder.setBaseUri("https://api.twitter.com");
		requestBuilder.setBasePath("/1.1/statuses");
		requestBuilder.addQueryParam("user_id", "MikaelBeat");
		requestBuilder.setAuth(authScheme);
		requestSpec = requestBuilder.build();
		
		responseBuilder = new ResponseSpecBuilder();
		responseBuilder.expectStatusCode(200);
		responseBuilder.expectResponseTime(lessThan(3L), TimeUnit.SECONDS);
		responseBuilder.expectBody("user.name", hasItem("Petri Ryynänen"));
		responseSpec = responseBuilder.build();
	}

	@Test
	public void read_Tweets() {
		 given()
		 	.spec(requestSpec)
		.when()
			.get("/user_timeline.json")	
		.then()
			.spec(responseSpec)
			.body("user.screen_name", hasItem("MikaelBeat"));
	}

}