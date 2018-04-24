package google_GET_Response;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Get_Request {
	
	// Given -> I have this information
	// When -> I perform this action
	// Then -> This should be the output
	
	@BeforeClass
	public  void setUp() {
		RestAssured.baseURI = "https://maps.googleapis.com";
		RestAssured.basePath = "/maps/api";
	}

	@Test
	public void get_Xml_Response() {
		Response response = given()
			   .queryParam("units", "imperial")
			   .queryParam("origins", "Washington,DC")
			   .queryParam("destinations", "New+York+City")
			   .queryParam("key", "AIzaSyApk0x97FECwfGRJ50ADnsrCCoFromUJZM ")
		.when()
			   .get("/distancematrix/xml")
		.then()
			   .statusCode(200).extract().response();
		String responseString = response.asString();
		System.out.println(responseString);
		
		String value = response.path("distancematrixresponse.row.element.duration.value");
		System.out.println("The duration value is: " + value);
		
		XmlPath xmlPath = new XmlPath(responseString);
		String text = xmlPath.get("distancematrixresponse.row.element.duration.text");
		System.out.println("The duration text using XMLPath is: " + text);
	}
	
}