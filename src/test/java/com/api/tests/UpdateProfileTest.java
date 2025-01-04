package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileUpdateRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {

	@Test
	public void updateProfileTest()
	{
		AuthService authService=new AuthService();
		Response response = authService.login(new LoginRequest("neil", "learn2621"));
		LoginResponse loginResponse = response.as(LoginResponse.class);
		System.out.println(response.asPrettyString());
		
		System.out.println("==============================================================");
		
		UserProfileManagementService userProfileManagementService=new UserProfileManagementService();
		response=userProfileManagementService.getProfile(loginResponse.getToken());
		System.out.println(response.asPrettyString());
		UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
		Assert.assertEquals(userProfileResponse.getUsername(), "Neil");
		
		System.out.println("==============================================================");
		
		ProfileUpdateRequest profileRequest=new ProfileUpdateRequest.Builder()
				.firstName("neil1234")
				.lastName("Nauai234")
				.mobileNumber("8765544399")
				.email("learn2621@gmail.com")
				.build();
		response=userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
		System.out.println(response.asPrettyString());
	}
}
