package assert_Examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Twitter_Assert_Example {
	
	// Given -> I have this information
	// When -> I perform this action
	// Then -> This should be the output
	
	String consumerKey = "fzDfnjmtGavB1LnB5bWvxMgvH";
	String cunsumerSecretKey = "LW8wKiFws6GunWMsuTmcM7Yqw9CNIKzCvybYLt010OJRolBYZT";
	String accessToken = "988679202609291264-foMMhGRXlmuNsfHCaAl9RT5zQFeYpTk";
	String accessTokenSecret = "n2hgWDPQCF1jZAO1u31jXjRirdpwfN1Jteg6DIlIdWSGN";
	
	@BeforeClass
	public  void setUp() {
		RestAssured.baseURI = "https://api.twitter.com";
		RestAssured.basePath = "/1.1/statuses";
	}

	@Test
	public void read_Tweets() {
		 given()
			.auth()
			.oauth(consumerKey, cunsumerSecretKey, accessToken, accessTokenSecret)
			.queryParam("user_id", "MikaelBeat")
		.when()
			.get("/user_timeline.json")
		.then()
			.log()
			.body()
			.statusCode(200);
	}

}