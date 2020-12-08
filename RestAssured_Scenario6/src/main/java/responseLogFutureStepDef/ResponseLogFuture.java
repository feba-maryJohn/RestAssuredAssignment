package responseLogFutureStepDef;

import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseLogFuture {
	
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
			response = RestAssured.given().get("/api/2021-24-10"); //passing future date -store response into response object
			
		}
		
		@Test
		@Then("validate positive response code received")
		public void test_then_validate() {
			
			response = RestAssured.given()              
					   .headers("Content-Type","application/json")
					   .log().all()
					   .get("/api/2021-24-10") //future date scenario
					   .then()
					   .assertThat()
					   .statusCode(400)
					   .log().all()         //log response into console
					   .extract().response();
			
		}

}
