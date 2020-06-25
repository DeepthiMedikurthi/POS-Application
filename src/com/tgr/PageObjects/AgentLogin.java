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

public class AgentLogin extends CommonPage {
	private static final Logger log = LogManager.getLogger(AgentLogin.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public AgentLogin(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}
	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.ID, using = "username")
	public WebElement username;
	@FindBy(how = How.ID, using = "password")
	public WebElement password;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fm1\"]/section[3]/input[4]")
	public WebElement loginButton;

	// ===================== PAGE METHODS ======================

	public void agentLogin() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			MyWebElement.enterText(username, currentHash.get("username"));
			MyWebElement.enterText(password, currentHash.get("password"));
			loginButton.click();

		} catch (Exception exp) {
			log.error(exp.getMessage());

			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}
}
