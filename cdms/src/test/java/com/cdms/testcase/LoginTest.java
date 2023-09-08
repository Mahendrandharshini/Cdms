package com.cdms.testcase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.cdms.pageobjects.AdminDashboardObject;
import com.cdms.pageobjects.CafeteriaGVObjects;
import com.cdms.pageobjects.CafeteriaObject;
import com.cdms.pageobjects.LoginPageObject;

public class LoginTest extends BaseClass {
	AdminDashboardObject ad;
	CafeteriaObject cfg;
	List GeneralTopics;

	@Test(priority = 1)
	public void loginTest() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// wait.until(ExpectedConditions.visibilityOfElementLocated(null));

		LoginPageObject lp = new LoginPageObject(driver);
		lp.signIn();
		test1.info("Login button clicked");
		lp.setpassword(password);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		test1.info("Password entered");
		lp.submitform();
		driver.switchTo().activeElement().sendKeys(username);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		test1.info("User name entered");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.submitform();
		test1.log(Status.INFO, "Login form submitted");
		String expect = "https://devcdms.mo.vc/home";
		if (driver.getCurrentUrl().equals(expect)) {
			test1.pass("User Logged in successfully");
			Assert.assertTrue(true);
		} else {
			test1.fail("User is failed login ");
			Assert.assertTrue(false);
		}
	}

	@Test(priority = 2)
	public void roleTest() {
		ad = new AdminDashboardObject(driver);
		String userRole = ad.getRole();
		if (userRole.equalsIgnoreCase("admin")) {
			test1.createNode("Validate the user role").pass("user role is as intented");
		} else {
			test1.fail("User role is not intented");
		}
		Assert.assertEquals(userRole, "Admin");

		System.out.println("The login test is completed");
	}

	
}
