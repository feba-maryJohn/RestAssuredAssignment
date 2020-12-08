package annotationStepDef;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ParameterProvider {
	
		String uri = "https://api.ratesapi.io";
		Response response;
		
		
		@DataProvider(name="Date")
		public Object[][] data_provider(){
			Object[][] data = new Object[4][3];
			
			data[0][0] = "2002";
			data[0][1] = "08";
			data[0][2] = "10";
			
			data[1][0] = "2010";
			data[1][1] = "11";
			data[1][2] = "01";
			
			data[2][0] = "2024";
			data[2][1] = "04";
			data[2][2] = "06";
			
			data[3][0] = "2020";
			data[3][1] = "09";
			data[3][2] = "24";
			
			return data;
		}
		
		@Test
		@Given("API for foreign exchange")
		public void test_given_api() {
			RestAssured.baseURI = uri;
		}
		
		@Test(dataProvider="Date")
		@When("posted with parameterized values")
		public void test_when_posted(String year,String month,String day) {
			response = RestAssured.get("/api/"+year+"-"+month+"-"+day);
			
		}
		
		@Test(dataProvider="Date")
		@Then("validate multiple records")
		public void test_then_validate(String year,String month,String day) {
			
			response = RestAssured.given().get("/api/"+year+"-"+month+"-"+day);
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
			System.out.println("Passing new value ::");
			System.out.println("New status code: "+statusCode);
			
			String text = response.getStatusLine();
			Assert.assertTrue(text.contains("OK"));
			System.out.println(text);
					   
		}

}
