package com.api.filters;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class LoggingFilter implements Filter {

	private static final Logger logger = LogManager.getLogger(LoggingFilter.class);

	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {
		logRequest(requestSpec);
		Response response = ctx.next(requestSpec, responseSpec); // Request is going to be executed
		logResponse(response);
		return response;
	}

	public void logRequest(FilterableRequestSpecification requestSpec) {
		logger.info("BASE URI is :" + requestSpec.getBaseUri());
		logger.info("BASE Path is :" + requestSpec.getBasePath());
		logger.info("Request Header is :" + requestSpec.getHeaders());
		logger.info("Request Payload is:" + requestSpec.getBody());
	}

	public void logResponse(Response response) {
		logger.info("Status code is :" + response.getStatusCode());
		logger.info("Response Header is :" + response.getHeaders());
		logger.info("Response Body is :" + response.getBody().prettyPrint());
	}
}
