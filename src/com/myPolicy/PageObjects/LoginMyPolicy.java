package com.myPolicy.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.tgr.PageObjects.CommonPage;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class LoginMyPolicy extends CommonPage {

	private static final Logger log = LogManager.getLogger(LoginMyPolicy.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public LoginMyPolicy(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.LINK_TEXT, using = "Manage MyPolicy")
	public WebElement myPolicy;
	@FindBy(how = How.ID, using = "emailPolicy")
	public WebElement email;
	@FindBy(how = How.ID, using = "signinPassword")
	public WebElement password;
	@FindBy(how = How.ID, using = "Login")
	public WebElement login;
	@FindBy(how = How.LINK_TEXT, using = "Get Quick Quote")
	public WebElement getQuickQuote;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement Continue;
	

	// ===================== PAGE METHODS ======================

	public void loginMypolicy() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			MyWebElement.clickOn(myPolicy);
			MyWebElement.enterText(email, currentHash.get("PolicyNumber"));
			MyWebElement.enterText(password, currentHash.get("password"));
			MyWebElement.clickOn(login);
			MyWebElement.clickOn(getQuickQuote);
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "RefillPolicy.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "RefillPolicy",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "RefillPolicy.png");
			MyWebElement.clickOn(Continue);
	
		} catch (AssertionError exp) {
			log.error(exp.getMessage());

			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		} catch (Exception exp) {
			log.error(exp.getMessage());

			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
