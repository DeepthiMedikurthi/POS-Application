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

public class AgentHome extends CommonPage {
	private static final Logger log = LogManager.getLogger(AgentHome.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public AgentHome(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.ID, using = "agentLogin")
	public WebElement agentLogin;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueButton;
	

	// ===================== PAGE METHODS ======================

	public void agentHome() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			MyWebElement.enterText(agentLogin, currentHash.get("agentNumber"));
			continueButton.click();

		} catch (Exception exp) {
			log.error(exp.getMessage());

			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}
}
