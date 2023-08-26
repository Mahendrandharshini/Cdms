package com.cdms.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CafPodcastObjects {
	WebDriver ldriver;
	
	public CafPodcastObjects(WebDriver rdriver) {
		
		this.ldriver= rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[2]/div/div/div[1]/input")
	WebElement AudioOption;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[2]/div/div/div[2]")
	WebElement VideoOption;
	
	@FindBy(id = "tittle")
	WebElement title;
	
	@FindBy(id = "description")
	WebElement Desciption;
	
	@FindBy (xpath = "//*[@id=\"image\"]")
	WebElement Thumbnail;
	
	@FindBy (xpath = "//*[@id=\"Cafetria_url\"]")
	WebElement Fileinput;
	
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[2]/button")
	WebElement createbtu;
	
	
	//WebDriverWait wait= new WebDriverWait(ldriver,Duration.ofSeconds(10));
	public boolean checkaudioOption() {
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[2]/div/div/div[1]/input")));
		boolean test= AudioOption.isDisplayed();
		return test;
	}
	
	public boolean checkVideoOption() {
		boolean test= VideoOption.isDisplayed();
		return test;
	}

	public boolean checkTitle() {
		boolean test= title.isDisplayed();
		return test;
	}
	public boolean checkDescription() {
		boolean test= Desciption.isDisplayed();
		return test;
	}
	
	public boolean checkThumbnail() {
		boolean test= Thumbnail.isDisplayed();
		return test;
	}
	public boolean checkFileInput() {
		boolean test= Fileinput.isDisplayed();
		return test;
	}
	
	public boolean checkCreate() {
		boolean test= createbtu.isDisplayed();
		return test;
	}
	
}
