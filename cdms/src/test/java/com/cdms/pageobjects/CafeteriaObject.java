package com.cdms.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class CafeteriaObject {
	WebDriver ldriver;
	
	public CafeteriaObject(WebDriver rdriver) {
		
		this.ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(partialLinkText = "Add Cafeteria")
	WebElement addCafBtu;
	
	@FindBy(id = "cafetria_master_id")
	WebElement cafeteriadropdown;
	
	
	
	public void clickAddCafe() {
		addCafBtu.click();
	}
	public List<WebElement> cafedropdownlist() {
		Select caflistselect= new Select(cafeteriadropdown);
		List<WebElement> CafList=caflistselect.getOptions();
		return CafList;
	}
	
	public void selectGD() {
		Select gdcaf= new Select(cafeteriadropdown);
		gdcaf.selectByVisibleText("Group Discussion");
		
	}
	
	public void selectDebates() {
		Select gdcaf= new Select(cafeteriadropdown);
		gdcaf.selectByVisibleText("Debates");
		
	}

	public void selectGV() {
		Select gdcaf= new Select(cafeteriadropdown);
		gdcaf.selectByVisibleText("General Video");
	}
	
	public void selectPoster() {
		Select gdcaf= new Select(cafeteriadropdown);
		gdcaf.selectByVisibleText("Posters");
	}
	
	public void selectPodcasts() {
		Select gdcaf= new Select(cafeteriadropdown);
		gdcaf.selectByVisibleText("Podcasts");
	}
	
}
