package com.APItests;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class get_user_profile extends BaseTest{
  @Test
  public void get_req() {
	  test = extent.createTest("User profile API Test");
	  String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODA4OGU0MDY3YzA4NjAwMTU1NTgxNTYiLCJpYXQiOjE3NDUzOTExNjh9.BPGya_LiI9TlFt71Rikk29cFiCkvLmRRWbfTjT5MYcQ";
	  Response res = given()
		        .header("Authorization", "Bearer " + token) // Set the Authorization header
		        .when()
		        .get("https://thinking-tester-contact-list.herokuapp.com/users/me"); // Endpoint for getting the user profile

		    // Validate status code
		    Assert.assertEquals(res.getStatusCode(), 200, "Status code is not 200");

		    // Validate status line
		    Assert.assertEquals(res.getStatusLine(), "HTTP/1.1 200 OK", "Status line is not 200 OK");

  }
}
