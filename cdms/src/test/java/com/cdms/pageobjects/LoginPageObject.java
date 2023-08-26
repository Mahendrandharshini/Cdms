package com.cdms.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObject {
	WebDriver ldriver;
	
	
	public LoginPageObject(WebDriver rdriver){
		
		this.ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(partialLinkText = "Sign In")
	WebElement singInBtu;
	
	
	@FindBy(how = How.ID, using = "email")
	WebElement username;
	
	
	@FindBy(how = How.ID, using = "login_password")
	WebElement password;
	
	@FindBy(xpath = "//*[@id=\"app\"]/div/main/div[2]/div/div[2]/form/div[3]/div/div[1]/button")
	WebElement submitbtu;
	
	public void signIn() {
		singInBtu.click();
	}
	
	
	public void setusername(String name) {
		 username.sendKeys(name);
		
	}
	public void setpassword(String pwd) {
		password.sendKeys(pwd);
		System.out.println(pwd);
	}
	
	public void submitform() {
		submitbtu.click();
		
	}
	
	
	
	

}
