package com.cdms.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminDashboardObject  {
	WebDriver ldriver;
	
	public AdminDashboardObject(WebDriver rdriver) {
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(xpath = "//*[@id=\"navbarSupportedContent\"]/ul/div[2]/li[2]")
	WebElement userRole;
	
	@FindBy(partialLinkText = "Apps")
	WebElement appsText;
	
	@FindBy(partialLinkText = "Cafeteria")
	WebElement cafeteriaText;
	
	
		
	
	public String getRole() {
		
		String role=userRole.getText();
		return role;
	}
	
	public void clickApps() {
		appsText.click();
	}
	
	public void clickCafeteria() {
		cafeteriaText.click();
	}
	
	public List<WebElement> checkCafeteriaTopics() {
		
		 List<WebElement> cafList= ldriver.findElements(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div[2]/div/div/div/nav/a"));
		 return cafList;
	}
	
}


