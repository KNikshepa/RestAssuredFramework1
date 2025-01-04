package com.api.base;

import java.util.HashMap;

import com.api.models.requests.LoginRequest;
import com.api.models.requests.SignUpRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {

	private final static String BASE_PATH = "/api/auth/";

	public Response login(LoginRequest loginRequest) {
		return postRequest(loginRequest, BASE_PATH + "login");
	}

	public Response signup(SignUpRequest signUpRequest) {
		return postRequest(signUpRequest, BASE_PATH + "signup");
	}

	public Response forgotPassword(String emailAddress) {
		HashMap<String, String> payload = new HashMap<String, String>();
		payload.put("email", "disha88@yahoo.com");
		return postRequest(payload, BASE_PATH+"forgot-password");
	}
}
