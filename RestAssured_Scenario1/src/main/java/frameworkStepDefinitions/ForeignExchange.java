package frameworkStepDefinitions;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ForeignExchange {
	
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
			response = RestAssured.get("/api/latest");
		}
		
		@Test
		@Then("validate positive response code received")
		public void test_then_validate() {
			
			response=RestAssured.given().get("/api/latest");
			int statuscode = response.getStatusCode();
			Assert.assertEquals(statuscode,200);          //checking success response
			response.prettyPrint();
		}

}
