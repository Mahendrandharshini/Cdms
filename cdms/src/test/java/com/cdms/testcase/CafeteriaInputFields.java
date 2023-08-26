package com.cdms.testcase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.cdms.pageobjects.AdminDashboardObject;
import com.cdms.pageobjects.CafPodcastObjects;
import com.cdms.pageobjects.CafeteriaGVObjects;
import com.cdms.pageobjects.CafeteriaObject;
import com.cdms.pageobjects.CafeteriaPosterObjects;



public class CafeteriaInputFields extends BaseClass {
	AdminDashboardObject ad;
	CafeteriaObject cfg;
	List GeneralTopics;

	
	
	@Test(priority = 0)
	public void Login() {
		BaseClass.Loginbase();
		
		test4 = extent.createTest("Cafeteria list test");
		 test5 = extent.createTest("Group Discussion form required fields");
		 test6 = extent.createTest("Debate form required fields");
		 test7= extent.createTest("General Topic test");
		 test8= extent.createTest("General Videos Form test");
		 test3 = extent.createTest("Check the Cafeteria topics");
	}
	
	@Test(priority = 1)
	public void checkCafeteriaTopics() {
		 ad= new AdminDashboardObject(driver);
		 cfg = new CafeteriaObject(driver);
		
		
		
		ad.clickApps();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ad.clickCafeteria();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> actualListCaf = ad.checkCafeteriaTopics();
		test3.pass("List of elements fetched");
		for (int i = 0; i < actualListCaf.size(); i++) {
			String actualtopic = actualListCaf.get(i).getText();
			if (coreCafeteriaTopics.contains(actualtopic)) {
				continue;
			} else {
				test3.fail("failed to match the list of cafeteria  : " + actualtopic);
				// Assert.assertTrue(false);
			}
		}
	}

	@Test(priority = 2)
	public void cafeteriaListinForm() {
		
		cfg = new CafeteriaObject(driver);
		cfg.clickAddCafe();
		List<WebElement> CafList = cfg.cafedropdownlist();
		for (int i = 1; i < CafList.size(); i++) {
			test4.info("Running  :  " + CafList.get(i).getText());
			if (coreCafeteriaTopics.contains(CafList.get(i).getText())) {
				
			} else {
				System.out.println(CafList.get(i).getText());
				test4.fail("Cafeteria list failed to match in the create page");
				Assert.assertTrue(false);
			}
		}
		test4.pass("All the items are matched in the cafeteria form page");
	}

	@Test(priority = 3)
	public void groupDiscussionForm() {

		
		cfg.selectGD();
		test5.pass("Group discussion selected from the dropdown");

		// check free option
		try {
			if (driver
					.findElement(
							By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[6]/div/div/div[1]"))
					.isDisplayed()) {
				test5.info("Free option is displayed");
			}
		} catch (Exception e) {
			System.out.println(e);
			test5.fail("The free options is not displayed in the GD form");
			takeScreenShot("GDFreeOption");
		}
		// check payable option

		try {
			if (driver
					.findElement(
							By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[6]/div/div/div[2]"))
					.isDisplayed()) {
				test5.info("Payable option is displayed");
			}
		} catch (Exception e) {
			System.out.println(e);
			test5.fail("The Payable options is not displayed in the GD form");
			takeScreenShot("GDPayableOption");
		}

		try {
			if (driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[7]/label"))
					.isDisplayed()) {
				test5.info("Title input field option is displayed");
			}
		} catch (Exception e) {
			System.out.println(e);
			test5.fail("The Title input options is not displayed in the GD form");
			takeScreenShot("GDTitle");
		}

		try {
			if (driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[8]/label"))
					.isDisplayed()) {
				test5.info("Description input field option is displayed");
			}
		} catch (Exception e) {
			System.out.println(e);
			test5.fail("The Description input options is not displayed in the GD form");
			takeScreenShot("GDDescription");
		}

		try {
			if (driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[10]/label"))
					.isDisplayed()) {
				test5.info("Thumbnail input field option is displayed");
			}
		} catch (Exception e) {
			System.out.println(e);
			test5.fail("The Thumbnail input options is not displayed in the GD form");
			takeScreenShot("GDThumbnail");
		}

		try {
			if (driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[11]/label"))
					.isDisplayed()) {
				test5.info("File input field option is displayed");
			}
		} catch (Exception e) {
			System.out.println(e);
			test5.fail("The File input options is not displayed in the GD form");
			takeScreenShot("GDFile");
		}

		try {
			if (driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[2]/button"))
					.isDisplayed()) {
				test5.info("Create button is displayed");
			}
		} catch (Exception e) {
			System.out.println(e);
			test5.fail("The Create button is not displayed in the GD form");
			takeScreenShot("GDCreate");
		}
	}

	@Test(priority = 4)
	public void DebatesForm() {

		
		cfg.selectDebates();
		test6.pass("Debate is selected from the dropdown");

		try {
			if (driver
					.findElement(
							By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[2]/div/div/div[1]"))
					.isDisplayed()) {

				String name = driver
						.findElement(By.xpath(
								"//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[2]/div/div/div[1]"))
						.getText();
				if (name.equalsIgnoreCase("Audio")) {

					test6.info("Audio option is displayed");
				} else {
					test6.fail("Audio option text is not displayed");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			test6.fail("The Audio options is not displayed in the GD form");
			takeScreenShot("DebateAudio");
		}

		try {
			if (driver
					.findElement(
							By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[2]/div/div/div[2]"))
					.isDisplayed()) {

				String name = driver
						.findElement(By.xpath(
								"//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[2]/div/div/div[2]"))
						.getText();
				if (name.equals("Video")) {
					test6.info("Video option is displayed");
				} else {
					test6.fail("Video option text is not displayed");
				}
			}
		} catch (Exception e) {
			System.out.println(e);
			test6.fail("The Video options is not displayed in the GD form");
			takeScreenShot("DebateVideo");
		}
		
		try {
			if (driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[11]/label"))
					.isDisplayed()) {
				test6.info("File input field option is displayed");
			}
		} catch (Exception e) {
			System.out.println(e);
			test6.fail("The File input options is not displayed in the GD form");
			takeScreenShot("DebateFile");
		}
		
		try {
			if (driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[2]/button"))
					.isDisplayed()) {
				test6.info("Create button is displayed");
			}
		} catch (Exception e) {
			System.out.println(e);
			test6.fail("Create button is not displayed in the GD form");
			takeScreenShot("Debatecreatebtu");
		}
	}
	
	
	
	
	@Test (priority = 5)
	public void GVTopics() {
		GeneralTopics=new ArrayList();
		
		
		driver.findElement(By.partialLinkText("General Videos Topics")).click();
		 WebElement showent= driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div[1]/div[2]/div/div[1]/div/div[1]/label/select"));
		
		Select showselect= new Select(showent);
		showselect.selectByVisibleText("100");
		test7.info("Show entries are selected");
		try {
		int topiccount=   driver.findElements(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div[1]/div[2]/div/div[2]/table/tbody/tr/td[2]")).size();
		
		for (int i=1;i<=topiccount;i++) {
			
			String a="//*[@id=\"app\"]/div/div[2]/main/div[1]/div[2]/div/div[2]/table/tbody/";
			String b="tr"+"["+Integer.toString(i)+"]"+"/td[2]";
			
			String topicto=driver.findElement(By.xpath(a+b)).getText();
			GeneralTopics.add(topicto);
			
			test7.pass("All the topics are fetched and stored in list");
		}
		}catch (Exception e) {
			// TODO: handle exception
			test7.fail("Unable to get the general topics");
			Assert.assertTrue(false);
		}
	}

	@Test (priority = 6)
	public void GVForm() {
		
		driver.findElement(By.partialLinkText("Cafeteria")).click();
		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div[1]/div[2]/a")).click();
		
		cfg.selectGV();
		CafeteriaGVObjects gvobj= new CafeteriaGVObjects(driver);
		
		try{
			boolean tresult=gvobj.getTopiclabel();
			System.out.println(tresult);
			Assert.assertTrue(tresult);
			
			List actualTopics= gvobj.getactualTopics();
			test8.info("General topic text is present");
			
			Assert.assertEquals(GeneralTopics, actualTopics);
			
			/*
			for (Object zy:GeneralTopics) {
				System.out.println(zy);
			}
			for (Object xy:actualTopics) {
				System.out.println(xy);
			}
			*/
			
			test8.pass("Topics are matched");
			
		}catch (Exception e) {
			// TODO: handle exception
			test8.fail("The general topic text is not displayed");
			Assert.assertTrue(false);
		}
		
		try {
			boolean freetest= gvobj.checkFreeOption();
			Assert.assertTrue(freetest);
			
			boolean paidtest= gvobj.checkPaidOption();
			Assert.assertTrue(paidtest);
			
			test8.info("Payment Options are displayed");
			
		}catch (Exception e) {
			// TODO: handle exception
			test8.fail("Payment Options is not present ");
		}
		
		try {
			boolean tfreetest= gvobj.checktitle();
			Assert.assertTrue(tfreetest);
			
			test8.info("Title input field is displayed");
			
		}catch (Exception e) {
			// TODO: handle exception
			test8.fail("Title input field is not displayed ");
		}
		
		try {
			boolean dfreetest= gvobj.checkDescription();
			Assert.assertTrue(dfreetest);
			
			test8.info("Description input field is displayed");
			
		}catch (Exception e) {
			// TODO: handle exception
			test8.fail("Description input field is not displayed ");
		}
		
		try {
			boolean thfreetest= gvobj.checkThumbnail();
			Assert.assertTrue(thfreetest);
			
			test8.info("Thumbnail input field is displayed");
			
		}catch (Exception e) {
			// TODO: handle exception
			test8.fail("Thumbnail input field is not displayed ");
		}
		
		try {
			boolean ffreetest= gvobj.checkFileinput();
			Assert.assertTrue(ffreetest);
			
			test8.info("File input field is displayed");
			
		}catch (Exception e) {
			// TODO: handle exception
			test8.fail("File input field is not displayed ");
		}
		
		try {
			boolean cfreetest= gvobj.checkcreatebtu();
			Assert.assertTrue(cfreetest);
			
			test8.info("Create button is displayed");
			
		}catch (Exception e) {
			// TODO: handle exception
			test8.fail("create button is not displayed ");
		}
	}
	@Test (priority = 7)
	public void posterForm() {
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		test9= extent.createTest("Poster input form test");
		CafeteriaPosterObjects pos= new  CafeteriaPosterObjects(driver);
		cfg.selectPoster();
		Assert.assertTrue(pos.checkTitle());
		Assert.assertTrue(pos.checkDescription());
		Assert.assertTrue(pos.checkfileinput());
		Assert.assertTrue(pos.checkcreatebtu());
		
		
		test9.pass("All the inputs fields are present as expected");
	}
	
	@Test(priority = 8)
	public void PodcastForm() {
		test10= extent.createTest("Podcast Input field test");
		try {
			Thread.sleep(1000);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		cfg.selectPodcasts();
		CafPodcastObjects pod= new CafPodcastObjects(driver);
		Reporter.log("Podcast validation is started");
		Assert.assertTrue(pod.checkaudioOption());
		Reporter.log("Audio option found");
		Assert.assertTrue(pod.checkVideoOption());
		Reporter.log("Video option found option found");
		Assert.assertTrue(pod.checkTitle());
		Reporter.log("Title option found");
		Assert.assertTrue(pod.checkDescription());
		Reporter.log("Description option found");
		Assert.assertTrue(pod.checkThumbnail());
		Reporter.log("Thumbnail option found");
		Assert.assertTrue(pod.checkFileInput());
		Reporter.log("FileInput option found");
		Assert.assertTrue(pod.checkCreate());
		Reporter.log("Create btu option found");
		test10.pass("All input fields are present as expected in the Podcast form");
		
		
	}
}
