package com.cdms.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CafeteriaGVObjects {
	WebDriver ldriver;

	public CafeteriaGVObjects(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[3]/div/label")
	WebElement GeneralTopic;

	@FindBy(id = "general_topic_id")
	WebElement GTopicDropdown;

	@FindBy(xpath =  "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[6]/div/div/div[1]")
	WebElement FreeOption;

	@FindBy(xpath =  "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[6]/div/div/div[2]")
	WebElement PayableOption;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[7]/label")
	WebElement Title;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[8]/label")
	WebElement Description;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[10]/label")
	WebElement Thumbnail;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[1]/div[11]/label")
	WebElement FileInput;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div[2]/main/div/div/div/form/div[2]/button")
	WebElement CreateButton;

	public List getactualTopics() {
		List actualTopic = new ArrayList();
		Select dr = new Select(GTopicDropdown);
		List<WebElement> listop = dr.getOptions();
		for (int i = 1; i < listop.size(); i++) {

			String acttopic = listop.get(i).getText();
			actualTopic.add(acttopic);
		}
		return actualTopic;
	}

	public boolean getTopiclabel() {
		boolean result = GeneralTopic.isDisplayed();
		return result;

	}

	public boolean checkFreeOption() {
		boolean result = FreeOption.isDisplayed();
		return result;

	}

	public boolean checkPaidOption() {
		boolean paid = PayableOption.isDisplayed();
		return paid;
	}

	public boolean checktitle() {
		boolean Filetest = Title.isDisplayed();
		return Filetest;
	}
	
	

	public boolean checkDescription() {
		boolean Desctest = Description.isDisplayed();
		return Desctest;
	}
	
	public boolean checkThumbnail() {
		boolean Thumbtest = Thumbnail.isDisplayed();
		return Thumbtest;
	}
	
	public boolean checkFileinput() {
		boolean Fileinput = FileInput.isDisplayed();
		return Fileinput;
	}
	
	public boolean checkcreatebtu() {
		boolean createbtu = CreateButton.isDisplayed();
		return createbtu;
	}
}
