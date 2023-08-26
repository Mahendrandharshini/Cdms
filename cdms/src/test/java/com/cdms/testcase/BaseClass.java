package com.cdms.testcase;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.cdms.pageobjects.LoginPageObject;
import com.cdms.utility.ReadConfig;
import com.github.dockerjava.api.model.Image;

import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class BaseClass {
	static WebDriver driver;
	String username;
	String password;
	ExtentReports extent;
	static ExtentTest test1;
	ExtentTest test2;
	ExtentTest test4; 
	ExtentTest test5;
	ExtentTest test6;
	ExtentTest test7;
	ExtentTest test8;
	ExtentTest test3;
	ExtentTest test9;
	ExtentTest test10;
	
	List<String> coreCafeteriaTopics;

	@BeforeClass
	public void setup() {
		
		try {
			Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		String Filepath = System.getProperty("user.dir") + "\\extentReports.html";

		ExtentSparkReporter reportfile = new ExtentSparkReporter(Filepath);

		extent = new ExtentReports();
		extent.attachReporter(reportfile);
		test1 = extent.createTest("Cdms Login Test with Use case");
		 
		 
		 
		ReadConfig read = new ReadConfig("mahi");
		String url = read.getApplicationURL();
		username = read.getusername();
		password = read.getpassword();
		driver.get(url);

		coreCafeteriaTopics = new ArrayList<String>();

		coreCafeteriaTopics.add("Group Discussion");
		coreCafeteriaTopics.add("Debates");
		coreCafeteriaTopics.add("General Video");
		coreCafeteriaTopics.add("Posters");
		coreCafeteriaTopics.add("Podcasts");
	}

	public static void takeScreenShot(String methodname) {
		try {
			Thread.sleep(3000);

		} catch (Exception e1) {
			System.out.println(e1);
		}
		TakesScreenshot sc = (TakesScreenshot) driver;
		File src = sc.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\xmedia\\eclipse-workspace\\cdms\\screenshots\\" + methodname + ".png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		try {

			BufferedImage image = new Robot()
					.createScreenCapture(new Rectangle(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize())));
			ImageIO.write(image, "png",
					new File("C:\\Users\\xmedia\\eclipse-workspace\\cdms\\screenshots\\imagebf.png"));

		} catch (HeadlessException | AWTException | IOException e) {
			System.out.println(e);
		}

	}
	
	public static void Loginbase() {
		
		LoginPageObject lp = new LoginPageObject(driver);
		lp.signIn();
		
		lp.setpassword("admin");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		lp.submitform();
		driver.switchTo().activeElement().sendKeys("admin@admin.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.submitform();
		test1.log(Status.INFO, "Login form submitted");
		String expect = "https://devcdms.mo.vc/home";
		if (driver.getCurrentUrl().equals(expect)) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}
		
	}
	

	@AfterClass
	public void teardown() {

		driver.quit();
		extent.flush();
	}

	
}
