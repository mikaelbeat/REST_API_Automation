package useful_Tricks;

import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Twitter_Check_Response_Time {
	
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
//		It is also possible to define rootpath in before class		
//		RestAssured.rootPath = "entities.hashtags[1]";
	}

	@Test
	public void read_Tweets() {
		long responseTime = 
		 given()
			.auth()
			.oauth(consumerKey, consumerSecretKey, accessToken, accessTokenSecret)
			.queryParam("user_id", "MikaelBeat")
		.when()
			.get("/user_timeline.json")
//			Gives response time in milliseconds
//			.time();
			.timeIn(TimeUnit.SECONDS);
		System.out.println("Response time: " + responseTime);
// 		Only response time is measured so no assertions is needed		
//		.then()
//			.statusCode(200)
//			.log().body()
//			.rootPath("user")
//			.body("name", hasItem("Petri Ryynänen"))
//			.body("screen_name", hasItem("MikaelBeat"))
//			.rootPath("entities.hashtags[1]")
//			.body("text", hasItem("Pullaa"))
//			.body("size()", equalTo(1));
	}

}