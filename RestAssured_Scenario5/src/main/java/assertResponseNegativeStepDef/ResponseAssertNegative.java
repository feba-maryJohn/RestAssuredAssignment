package assertResponseNegativeStepDef;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseAssertNegative {
	
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
			response = RestAssured.given().get("/api");      //store response into response object
			
		}
		
		@Test
		@Then("validate response status code received")
		public void test_then_assert() {
			
			response = RestAssured.given().get("/api");     //negative scenario
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 400);           //asserting negative scenario
			
			String text = response.getStatusLine();
			Assert.assertTrue(text.contains("Bad Request"));   //asserting status for negative scenario
		}

}
