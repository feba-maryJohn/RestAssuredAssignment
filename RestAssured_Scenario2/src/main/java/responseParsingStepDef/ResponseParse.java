package responseParsingStepDef;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseParse {
	
		String uri = "https://api.ratesapi.io";
		Response response;
		
		@Test
		@Given("API for foreign exchange ")
		public void test_given_api() {
			RestAssured.baseURI = uri;
		}
		
		@Test
		@When("posted with correct Information")
		public void test_when_posted() {
			response = RestAssured.get("/api/latest");       //store response into response object
		}
		
		@Test
		@Then("validate response and log it on console")
		public void test_then_log() {
			
			//store response into response object
			response = RestAssured.given()
					   .headers("Content-type","application/json")
					   .log().all()
					   .get("/api/latest")
					   .then()
					   .assertThat()
					   .statusCode(200)
					   .log().all()                        //logging console
					   .extract().response();
		}

}
