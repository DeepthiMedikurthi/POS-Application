package com.myPolicy.PageObjects;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

import wrapper.classes.methods.MyWebElement;

public class GeneralInfoPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(GeneralInfoPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;
	@SuppressWarnings("rawtypes")
	List<WebElement> options = new ArrayList();
	String option = null;

	public GeneralInfoPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.NAME, using = "piLapseDays")
	public WebElement previousInsurance;
	@FindBy(how = How.XPATH, using = "//*[@id=\"quickQuoteHouseholdQuestions\"]/div[1]/div[1]/div/label[2]")
	public WebElement no_exclude;
	@FindBy(how = How.NAME, using = "ownsHomeFlag")
	public WebElement ownsHomeflag;
	@FindBy(how = How.ID, using = "emailAddress")
	public WebElement emailId;
	@FindBy(how = How.NAME, using = "userRatedCredit")
	public WebElement credit;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void generalInfoMypolicy() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			MyWebElement.clickOn(no_exclude);
			Select previousinsurance = new Select(previousInsurance);

			previousinsurance.selectByVisibleText("No");
			
				Select ownsHome = new Select(ownsHomeflag);

				ownsHome.selectByVisibleText("Rent");
				Select creditInfo = new Select(credit);
				creditInfo.selectByVisibleText("Good");
				MyWebElement.clearOut(emailId);
				MyWebElement.enterText(emailId, currentHash.get("Emailid"));
		
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "GeneralInfoPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "GeneralInfoPage",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "GeneralInfoPage.png");
			continueLink.click();
			
		} catch (AssertionError exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "Error in GeneralInfoPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error in GeneralInfoPage: </b></font><br />" + exp.getMessage() + "<br />",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "Error in GeneralInfoPage.png");
			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
