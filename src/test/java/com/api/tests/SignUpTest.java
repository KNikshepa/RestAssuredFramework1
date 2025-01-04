package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;

import io.restassured.response.Response;

public class SignUpTest {

	@Test
	public void SignUpTestAccountCreationTest() {
		SignUpRequest signUpRequest = new SignUpRequest.Builder().username("Disha6489ratata").email("disha8989@yahoo.com")
				.firstName("Disha").password("disha123").lastName("Bhatt").mobileNumber("8292929292").build();

		AuthService authService = new AuthService();
		Response response = authService.signup(signUpRequest);
		System.out.println(response.asPrettyString());
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
	}
}
