package com.APItests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class UpdateContact extends BaseTest {
  @Test
  public void UpdateContact_putreq() {
	 test = extent.createTest("Update Contact API Test");
	  String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODA3YTA1OWY1MzU5OTAwMTU0MTU3MWYiLCJpYXQiOjE3NDUzOTEzODd9.xbjzN7FLjHJlQjs_ixnNEd_govV-1xoA0e1tPTeYn2U";
		 
	  Response res = given()
			 .header("Content-Type","application/json")
			  .header("Authorization", "Bearer " + token)
			  .body("{\n"
			  		+ "\"firstName\": \"Amy\",\n"
			  		+ "\"lastName\": \"Miller\",\n"
			  		+ "\"birthdate\": \"1992-02-02\",\n"
			  		+ "\"email\": \"amiller@fake.com\",\n"
			  		+ "\"phone\": \"8005554242\",\n"
			  		+ "\"street1\": \"13 School St.\",\n"
			  		+ "\"street2\": \"Apt. 5\",\n"
			  		+ "\"city\": \"Washington\",\n"
			  		+ "\"stateProvince\": \"QC\",\n"
			  		+ "\"postalCode\": \"A1A1A1\",\n"
			  		+ "\"country\": \"Canada\"\n"
			  		+ "}")
			  .when()
			  .put("https://thinking-tester-contact-list.herokuapp.com/contacts/6807a30cf53599001541572d");
	  
	  Assert.assertEquals(res.getStatusCode(), 200, "Status code is 200");

  }
}
