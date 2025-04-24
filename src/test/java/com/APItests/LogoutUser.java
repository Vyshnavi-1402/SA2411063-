package com.APItests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class LogoutUser extends BaseTest{
  @Test
  public void LogOutUser_postreq() {
	  test = extent.createTest("Logout User API Test");
	  String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODA3YTA1OWY1MzU5OTAwMTU0MTU3MWYiLCJpYXQiOjE3NDUzOTEzODd9.xbjzN7FLjHJlQjs_ixnNEd_govV-1xoA0e1tPTeYn2U";
		
	  
	  Response res = given()
				 .header("Content-Type","application/json")
				  .header("Authorization", "Bearer " + token)
				  .when()
				  .post("https://thinking-tester-contact-list.herokuapp.com/users/logout");
		  
		  Assert.assertEquals(res.getStatusCode(), 200, "Status code is 200");

  }
}
