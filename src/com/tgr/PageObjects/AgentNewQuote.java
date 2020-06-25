package com.tgr.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.tgr.Utilities.MyOwnException;

import wrapper.classes.methods.MyWebElement;

public class AgentNewQuote extends CommonPage {
	private static final Logger log = LogManager.getLogger(AgentNewQuote.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public AgentNewQuote(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	// ===================== PAGE OBJECTS ======================
	@FindBy(how = How.NAME, using = "zipCode")
	public WebElement zipCode;
	@FindBy(how = How.LINK_TEXT, using = "New Quote")
	public WebElement newQuote;

	// ===================== PAGE METHODS ======================

	public void agentNewQuote() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
	
		try {
			MyWebElement.enterText(zipCode, currentHash.get("zipCode"));
			newQuote.click();

		} catch (Exception exp) {
			log.error(exp.getMessage());

			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}
}
