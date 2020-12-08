package responseLogNegStepDef;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseLogNegative {
	
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
			response = RestAssured.given().get("/api/");    //store response into response object
			int statusCode = response.getStatusCode();
			Assert.assertTrue(statusCode != 200);
		}
		
		@Test
		@Then("validate positive response code received")
		public void test_then_log() {
			
			RestAssured.given().headers("content-Type","application/json")
					   .get("/api/")             //negative scenario
					   .then()
					   .assertThat()
					   .statusCode(400)         
					   .log().all();            //log into console
		}

}
