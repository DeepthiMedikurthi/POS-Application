package com.myPolicy.PageObjects;

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
import com.tgr.PageObjects.VehiclesPage;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWebElement;

public class DriversPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(DriversPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public DriversPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.XPATH, using = "//*[@id=\"sr221\"]/div/div/label[2]")
	public WebElement sr22;
	@FindBy(how = How.XPATH, using = "//*[@id=\"takenDriverCourse0\"]/div[1]/div/label[2]")
	public WebElement accCourse;
	@FindBy(how = How.XPATH, using = "//*[@id=\"daccCntN0lbl\"]")
	public WebElement previousAcc;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_area\"]/div[3]/div/div[1]/form/div[2]/div/label/div[1]")
	public WebElement addveh;

	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void driversInfoMypolicy() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			MyWebElement.clickOn(sr22);
			MyWebElement.clickOn(accCourse);
			MyWebElement.clickOn(previousAcc);
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "DriversPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Driver'sPage",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "DriversPage.png");
			continueLink.click();
			MyWebElement.clickOn(addveh);
			continueLink.click();


		} catch (Exception exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "Error in DriversPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error in Driver'sPage: </b></font><br />" + exp.getMessage() + "<br />",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "Error in DriversPage.png");
			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
