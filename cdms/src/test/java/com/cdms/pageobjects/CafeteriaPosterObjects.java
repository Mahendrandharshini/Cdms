package com.cdms.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CafeteriaPosterObjects {

	WebDriver ldriver;
	public CafeteriaPosterObjects(WebDriver rdriver) {
		
		this.ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	@FindBy(id = "tittle")
	WebElement postertitleInput; 
	
	@FindBy(id = "description")
	WebElement posterDescription; 
	
	@FindBy(xpath = "//*[@id=\"Cafetria_url\"]")
	WebElement PosterInput;
	
	@FindBy (xpath = "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[2]/button")
	WebElement createbtu;
	
	public boolean checkTitle() {
		
		 boolean test=postertitleInput.isDisplayed();
		 return test;
		 
	}
	public boolean checkDescription() {
		
		 boolean test=posterDescription.isDisplayed();
		 return test ;
	}
	
	public boolean checkfileinput() {
		
		 boolean test=PosterInput.isDisplayed();
		 return test ;
	}
	
	public boolean checkcreatebtu() {
		
		 boolean test=createbtu.isDisplayed();
		 return test ;
	}
}
