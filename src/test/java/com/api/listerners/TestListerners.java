package com.api.listerners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListerners implements ITestListener {

	private static final Logger logger = LogManager.getLogger(TestListerners.class);

	@Override
	public void onTestStart(ITestResult result) {
		logger.info("Test case started " + result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("Test case Success " + result.getMethod().getMethodName());
		logger.info("Test case Description " + result.getMethod().getDescription());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.info("Test case Failure " + result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		logger.info("Test case Skipped " + result.getMethod().getMethodName());
	}
	
	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}
}
