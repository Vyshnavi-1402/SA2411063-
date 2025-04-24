package com.APItests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class UpdateUser extends BaseTest{
  @Test
  public void patch_req() {
	  test = extent.createTest("Update User API Test");
	  String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODA4OGU0MDY3YzA4NjAwMTU1NTgxNTYiLCJpYXQiOjE3NDUzOTExNjh9.BPGya_LiI9TlFt71Rikk29cFiCkvLmRRWbfTjT5MYcQ";
		 
	  Response res = given()
			  .header("Authorization", "Bearer " + token)
			  .when()
			  .get("https://thinking-tester-contact-list.herokuapp.com/users/me");
	  	
	  Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 200 OK", "Status line is not 200 OK");
	  System.out.println("Status message is 200 OK");
  }
}
