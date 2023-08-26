package com.cdms.testcase;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class CdmsListener implements ITestListener  {

	
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("on test fail with pass result %  : "+result.getName());
	}
	

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("on test fail with timeout result   : "+result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		
		
		System.out.println("on test failure result   : "+result.getName());
		//BaseClass baseClass = new BaseClass();
		BaseClass.takeScreenShot(result.getName());
		
		
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("on test skip result   : "+result.getName());
	}
	
	
	
	

}
