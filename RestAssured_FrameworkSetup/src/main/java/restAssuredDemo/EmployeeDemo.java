package restAssuredDemo;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class EmployeeDemo {
		
	String uri = "http://dummy.restapiexample.com/api/v1/";
	Response response;
	
	@Test
	 public void getEmployee()
	 {   
	 // Specify the base URL to the RESTful web service
	 RestAssured.baseURI = uri ;
	 
	 // Get the RequestSpecification of the request to be sent to the server. 
	 //The server is specified by the BaseURI
	 RequestSpecification httpRequest = RestAssured.given();
	 
	 // Make a request to the server by specifying the method Type and the method URL.
	 // This will return the Response from the server. Store the response in a variable.
	 response = httpRequest.request(Method.GET, "employees");
	 
	 //print the body of the message to see what response
	 response.prettyPrint();
	 
	 //status code of response
	 int statusCode = response.getStatusCode();
	 System.out.println("Status code of response : "+statusCode);
	 
	 }
	
	@Test
	 public void getInvalidEmployee()
	 {   
			// Specify the base URL to the RESTful web service
			RestAssured.baseURI = uri; 
			response = RestAssured.given().get("employees/31");
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);
	 }

}
