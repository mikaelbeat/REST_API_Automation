package twitter_API_Example;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Twitter_GET_Request {
	
	// Given -> I have this information
	// When -> I perform this action
	// Then -> This should be the output
	
	String consumerKey = "fzDfnjmtGavB1LnB5bWvxMgvH";
	String consumerSecretKey = "LW8wKiFws6GunWMsuTmcM7Yqw9CNIKzCvybYLt010OJRolBYZT";
	String accessToken = "988679202609291264-foMMhGRXlmuNsfHCaAl9RT5zQFeYpTk";
	String accessTokenSecret = "n2hgWDPQCF1jZAO1u31jXjRirdpwfN1Jteg6DIlIdWSGN";
	String tweetId = "";
	
	@BeforeClass
	public  void setUp() {
		RestAssured.baseURI = "https://api.twitter.com";
		RestAssured.basePath = "/1.1/statuses";
	}

	@Test
	public void post_Tweet() {
		Response response = given()
			.auth()
			.oauth(consumerKey, consumerSecretKey, accessToken, accessTokenSecret)
			.queryParam("status", "My first tweet. #Pullaa")
		.when()
			.post("/update.json")
		.then()
			.statusCode(200)
			.extract().response();
		
		tweetId = response.path("id_str");
		System.out.println("The response.path: " + tweetId);

	}
	
	@Test(dependsOnMethods = {"post_Tweet"})
	public void read_Tweet() {
		Response response = given()
			.auth()
			.oauth(consumerKey, consumerSecretKey, accessToken, accessTokenSecret)
			.queryParam("id", tweetId)
		.when()
			.get("/show.json")
		.then()
			.extract().response();
		
		String text = response.path("text");
		System.out.println("The tweet text is: " + text);
	}
	
	@Test(dependsOnMethods = {"read_Tweet"})
	public void delete_Tweet() {
		given()
			.auth()
			.oauth(consumerKey, consumerSecretKey, accessToken, accessTokenSecret)
			.pathParam("id", tweetId)
		.when()
			.post("/destroy/{id}.json")
		.then()
			.statusCode(200);
	}

}