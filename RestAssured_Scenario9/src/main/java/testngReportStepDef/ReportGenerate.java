package testngReportStepDef;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ReportGenerate {
	
		String uri = "https://api.ratesapi.io";
		Response response;
		
		
		@DataProvider(name="Date")
		public Object[][] data_provider(){
			Object[][] data = new Object[3][3];
			
			data[0][0] = "2012";
			data[0][1] = "07";
			data[0][2] = "10";
			
			data[1][0] = "2010";
			data[1][1] = "11";
			data[1][2] = "1";
			
			data[2][0] = "2030";
			data[2][1] = "04";
			data[2][2] = "06";
			
			
			return data;
		}
		
		@Test
		@Given("API for foreign exchange")
		public void test_given() {
			RestAssured.baseURI = uri;
		}
		
		@Test(dataProvider="Date")
		@When("posted with parameterized values")
		public void test_when(String year,String month,String day) {
			response = RestAssured.get("/api/"+year+"-"+month+"-"+day);
			
		}
		
		@Test(dataProvider="Date")
		@Then("validate multiple records and display report")
		public void test_then(String year,String month,String day) {
			
			response = RestAssured.given().get("/api/"+year+"-"+month+"-"+day);
			String text = response.getStatusLine();
			Assert.assertTrue(text.contains("OK"));
			System.out.println(text);
					   
		}

}
