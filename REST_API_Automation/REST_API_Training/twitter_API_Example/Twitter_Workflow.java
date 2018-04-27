package twitter_API_Example;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Twitter_Workflow {
	
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
	public void get_Response() {
		Response response = given()
			.auth()
			.oauth(consumerKey, consumerSecretKey, accessToken, accessTokenSecret)
			.queryParam("status", "My first tweet.")
		.when()
			.post("/update.json")
		.then()
			.statusCode(200)
			.extract().response();
		
		String id = response.path("id_str");
		System.out.println("The response.path: " + id);
		
		String responseString = response.asString();
		System.out.println(responseString);
		
		JsonPath jsPath = new JsonPath(responseString);
		String name = jsPath.get("user.name");
		System.out.println("The username is: " + name);
	}

}