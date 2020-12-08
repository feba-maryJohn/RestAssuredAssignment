package responseAssertionStepDef;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ResponseAssert {
	
		String uri ="https://api.ratesapi.io" ;
		Response response;
		
		@Test
		@Given("API for foreign exchange ")
		public void test_given_api() {
			RestAssured.baseURI = uri;
		}  
		
		@Test
		@When("passing values from get method")
		public void test_when_passing() {
			RequestSpecification httpRequest = RestAssured.given();
			response = httpRequest.request(Method.GET, "/api/latest?base=USD");   //store response into response object
		}
		
		@Test
		@Then("validate response received")
		public void test_then_validate() {
			response = RestAssured.given().get("/api/latest?base=USD");       //store response into response object
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode,200);           //asserting status code of response

			String header = response.getHeader("Content-type");
			Assert.assertTrue(header.contains("application/json"));  //asserting response in json format
			response.prettyPrint();
			
		}

}
