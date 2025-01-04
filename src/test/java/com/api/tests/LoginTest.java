package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;

@Listeners(com.api.listerners.TestListerners.class)
public class LoginTest {

	@Test(description = "To verify the login test")
	public void loginTest() {
		// Create a LoginRequest object with username and password
		LoginRequest loginRequest = new LoginRequest("neil", "learn2621");

		// Call AuthService for login
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);

		// Print the raw response body in a readable format
		System.out.println(response.asPrettyString());

		// Deserialize the response into a LoginResponse object
		LoginResponse loginResponse = response.as(LoginResponse.class);

		System.out.println("=========================================");

		// Print the token retrieved from the response
		System.out.println(loginResponse.getToken());

		// Assert that the token is not null
		Assert.assertNotNull(loginResponse.getToken(), "Token should not be null!");
	}
}
