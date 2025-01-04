package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class getProfileRequestTest {

	@Test
	public void getProfileRequestTest()
	{
		AuthService authService=new AuthService();
		Response response = authService.login(new LoginRequest("neil", "learn2621"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		
		UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
		response=userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfile = response.as(UserProfileResponse.class);
		System.out.println(userProfile.getFirstName());
	}
}
