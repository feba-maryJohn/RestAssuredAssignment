package negativeAssertFutureStepDef;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class NegAssertFuture {
	
		String uri = "https://api.ratesapi.io";
		Response response;
		
		@Test
		@Given("API for foreign exchange ")
		public void test_given() {
			RestAssured.baseURI = uri;
		}
		
		@Test
		@When("posted with future date Information")
		public void test_when_posted() {
			response = RestAssured.get("/api/2021-24-10");   //store response into response object
			
		}
		
		@Test
		@Then("validate response status code received")
		public void test_then_validate() {
			
			response = RestAssured.get("/api/2021-24-10");    //future date scenario
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 400);           //asserting status code
			System.out.println("Status Code for response: "+statusCode);
			
			String text = response.getStatusLine();
			Assert.assertTrue(text.contains("Bad Request"));  //asserting response status 
			System.out.println(text);
		}

}
