package com.tgr.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWait;
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

	@FindBy(how = How.NAME, using = "driver[0].firstName")
	public WebElement firstName;
	@FindBy(how = How.XPATH, using = "//*[@id=\"driver1\"]/div[3]/div/div/label[2]")
	public WebElement gender;
	@FindBy(how = How.XPATH, using = "//*[@id=\"maritalStatus\"]")
	public WebElement gender_or;
	@FindBy(how = How.NAME, using = "driver[0].birthDate.mo")
	public WebElement month;
	@FindBy(how = How.NAME, using = "driver[0].birthDate.dy")
	public WebElement date;
	@FindBy(how = How.NAME, using = "driver[0].birthDate.yr")
	public WebElement year;
	@FindBy(how = How.NAME, using = "driver[0].maritalStatus")
	public WebElement maritalStatus;
	@FindBy(how = How.XPATH, using = "//*[@id=\"sr221\"]/div/div/label[2]")
	public WebElement sr22_no;
	@FindBy(how = How.XPATH, using = "//*[@id=\"sr221\"]/div/div/label[1]")
	public WebElement sr22_yes;
	@FindBy(how = How.XPATH, using = "//*[@id=\"sr222\"]/div/div/label[2]")
	public WebElement sr22_driver2_no;

	@FindBy(how = How.XPATH, using = "//*[@id=\"takenDriverCourse0\"]/div[1]/div/label[2]")
	public WebElement takenDriverCourse;
	@FindBy(how = How.NAME, using = "driver[0].firstLicensedDate.mo")
	public WebElement firstLicensedDateMo;
	@FindBy(how = How.NAME, using = "driver[0].firstLicensedDate.yr")
	public WebElement firstLicensedDateYr;
	@FindBy(how = How.LINK_TEXT, using = "Add another driver")
	public WebElement extraDriver;
	@FindBy(how = How.NAME, using = "driver[0].ageFirstLicensed")
	public WebElement ageFirstLicensed;
	@FindBy(how = How.XPATH, using = "//*[@id=\"daccCntN0lbl\"]")
	public WebElement previousAcidents;
	@FindBy(how = How.XPATH, using = "//*[@id=\"driver2\"]/div[2]/div/input[1]")
	public WebElement monthDr2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"driver2\"]/div[2]/div/input[2]")
	public WebElement dateDr2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"driver2\"]/div[2]/div/input[3]")
	public WebElement yearDr2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"driver2\"]/div[3]/div/div/label[2]")
	public WebElement genderDr2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"driver2\"]/div[4]/div/select")
	public WebElement maritalStatusDr2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"driver2\"]/div[5]/div/div/input[1]")
	public WebElement monthliscDr2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"driver2\"]/div[5]/div/div/input[2]")
	public WebElement yearliscDr2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"takenDriverCourse1\"]/div[1]/div/label[2]")
	public WebElement takenDriverCourse2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"daccCntDiv1\"]/div/label[2]")
	public WebElement pastViol2;

	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void driversInfo() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			// MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			if (currentHash.get("state").equals("NC")) {
				MyWebElement.enterText(firstName, "Test" + randomNameString(3));
				MyWebElement.enterText(month, "10");
				MyWebElement.enterText(date, "10");
				MyWebElement.enterText(year, "1990");
				Select marriedStatus = new Select(maritalStatus);
				marriedStatus.selectByVisibleText("Single");
				Select ageFirstlicensed = new Select(ageFirstLicensed);
				ageFirstlicensed.selectByVisibleText("17");
				previousAcidents.click();
			} else {
				MyWebElement.enterText(month, "02");
				MyWebElement.enterText(date, "14");
				MyWebElement.enterText(year, "1987");
				if (currentHash.get("state").equals("OR")) {
					Select gender = new Select(gender_or);
					gender.selectByVisibleText("Female");
				} else
					gender.click();
				Select marriedStatus = new Select(maritalStatus);
				marriedStatus.selectByVisibleText("Single");
				if (MyWebElement.isButtonExist("//*[@id=\"sr221\"]/div/div/label[2]")
						&& currentHash.get("SR22").equals("Nil"))
					sr22_no.click();
				if (MyWebElement.isButtonExist("//*[@id=\"sr221\"]/div/div/label[1]")
						&& currentHash.get("SR22").equals("Yes"))
					sr22_yes.click();
				if (MyWebElement.isButtonExist("//*[@id=\"driver1\"]/div[5]/div/div/input[1]")
						&& (currentHash.get("state").equals("NY")))
					MyWebElement.enterText(firstLicensedDateMo, "10");
				if (MyWebElement.isButtonExist("//*[@id=\"driver1\"]/div[5]/div/div/input[2]")
						&& (currentHash.get("state").equals("NY")))
					MyWebElement.enterText(firstLicensedDateYr, "2011");
				takenDriverCourse.click();
				previousAcidents.click();
			}
			if (currentHash.get("AdditionalDriver").equals("Yes")) {
				MyWebElement.clickOn(extraDriver);
				MyWebElement.enterText(monthDr2, "10");
				MyWebElement.enterText(dateDr2, "10");
				MyWebElement.enterText(yearDr2, "1994");
				genderDr2.click();
				Select marriedStatus = new Select(maritalStatusDr2);
				marriedStatus.selectByVisibleText("Single");
				if (MyWebElement.isButtonExist("//*[@id=\"sr222\"]/div/div/label[2]"))
					sr22_driver2_no.click();
				if (MyWebElement.isButtonExist("//*[@id=\"driver2\"]/div[5]/div/div/input[1]")
						&& (currentHash.get("state").equals("NY")))
					MyWebElement.enterText(monthliscDr2, "10");
				if (MyWebElement.isButtonExist("//*[@id=\"driver2\"]/div[5]/div/div/input[2]")
						&& (currentHash.get("state").equals("NY")))
					MyWebElement.enterText(yearliscDr2, "2010");
				takenDriverCourse2.click();
				pastViol2.click();
			}
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "DriversPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Driver'sPage",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "DriversPage.png");
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
