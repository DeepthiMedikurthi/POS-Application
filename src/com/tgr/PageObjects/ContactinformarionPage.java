package com.tgr.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.tgr.Utilities.MyOwnException;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class ContactinformarionPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(ContactinformarionPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public ContactinformarionPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;
	@FindBy(how = How.NAME, using = "primaryPhoneNumberPart1")
	public WebElement primaryPhoneNumberPart1;
	@FindBy(how = How.NAME, using = "primaryPhoneNumberPart2")
	public WebElement primaryPhoneNumberPart2;
	@FindBy(how = How.NAME, using = "primaryPhoneNumberPart3")
	public WebElement primaryPhoneNumberPart3;
	@FindBy(how = How.ID, using = "primaryAccountAlertsOptInPreference")
	public WebElement primaryAccountAlertsOptInPreference;
	@FindBy(how = How.ID, using = "emailAddress2")
	public WebElement confirmEmail;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[1]/div[2]/div[6]/div[1]/div/label[2]")
	public WebElement paperlessOption;

	// ===================== PAGE METHODS ======================

	public void contactinformarionPage() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
		//	MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			MyWebElement.enterText(primaryPhoneNumberPart1, "456");
			MyWebElement.enterText(primaryPhoneNumberPart2, "856");
			MyWebElement.enterText(primaryPhoneNumberPart3, "9456");
			Select accAlerts = new Select(primaryAccountAlertsOptInPreference);
			accAlerts.selectByVisibleText("Call");
			MyWebElement.enterText(confirmEmail, currentHash.get("Emailid"));
			MyWebElement.clickOn(paperlessOption);
			MyWebElement.clickOn(continueLink);
		} catch (Exception exp) {
			log.error(exp.getMessage());

			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
