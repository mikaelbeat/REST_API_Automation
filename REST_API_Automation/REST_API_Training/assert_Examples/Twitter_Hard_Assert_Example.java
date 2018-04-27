package assert_Examples;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.lessThan;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Twitter_Hard_Assert_Example {
	
	// Given -> I have this information
	// When -> I perform this action
	// Then -> This should be the output
	
	String consumerKey = "fzDfnjmtGavB1LnB5bWvxMgvH";
	String consumerSecretKey = "LW8wKiFws6GunWMsuTmcM7Yqw9CNIKzCvybYLt010OJRolBYZT";
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
			.oauth(consumerKey, consumerSecretKey, accessToken, accessTokenSecret)
			.queryParam("user_id", "MikaelBeat")
		.when()
			.get("/user_timeline.json")
		.then()
			.statusCode(200)
			.body("user.name", hasItem("Petri Ryynänen"))
			.body("entities.hashtags[1].text", hasItem("Pullaa"))
			.body("entities.hashtags[0].size()", equalTo(2))
			.body("entities.hashtags[0].size()", lessThan(3));
	}

}