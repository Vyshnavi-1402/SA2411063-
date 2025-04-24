package com.APItests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class AddContact extends BaseTest {
  @Test
  public void AddContact_postreq() { 
	  test = extent.createTest("Add Contact API Test");
	  String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODA3YTA1OWY1MzU5OTAwMTU0MTU3MWYiLCJpYXQiOjE3NDUzOTEzODd9.xbjzN7FLjHJlQjs_ixnNEd_govV-1xoA0e1tPTeYn2U";
	 
	  Response res = given()
			 .header("Content-Type","application/json")
			  .header("Authorization", "Bearer " + token)
			  .body("{\n"
			  		+ "\"firstName\": \"John\",\n"
			  		+ "\"lastName\": \"Doe\",\n"
			  		+ "\"birthdate\": \"1970-01-01\",\n"
			  		+ "\"email\": \"jdoe@fake.com\",\n"
			  		+ "\"phone\": \"8005555555\",\n"
			  		+ "\"street1\": \"1 Main St.\",\n"
			  		+ "\"street2\": \"Apartment A\",\n"
			  		+ "\"city\": \"Anytown\",\n"
			  		+ "\"stateProvince\": \"KS\",\n"
			  		+ "\"postalCode\": \"12345\",\n"
			  		+ "\"country\": \"USA\"\n"
			  		+ "}")
			  .when()
			  .post("https://thinking-tester-contact-list.herokuapp.com/contacts");
	  
	  Assert.assertEquals(res.getStatusCode(), 201, "Status code is 201");

			  
  }
}
