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

public class ExcludedDriverPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(DriversPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public ExcludedDriverPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.NAME, using = "driver[0].firstName.value")
	public WebElement firstName;
	@FindBy(how = How.NAME, using = "driver[0].lastName.value")
	public WebElement lastName;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[2]/div/div[6]/div/div/label[1]")
	public WebElement gender;
	@FindBy(how = How.NAME, using = "driver[0].dateOfBirth.mo")
	public WebElement month;
	@FindBy(how = How.NAME, using = "driver[0].dateOfBirth.dy")
	public WebElement date;
	@FindBy(how = How.NAME, using = "driver[0].dateOfBirth.yr")
	public WebElement year;
	@FindBy(how = How.NAME, using = "driver[0].maritalStatus.realValue")
	public WebElement maritalStatus;
	@FindBy(how = How.ID, using = "relationship1")
	public WebElement relationship;
	@FindBy(how = How.LINK_TEXT, using = "Back")
	public WebElement backLink;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void excludedDriverInfo() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			backLink.click();
			System.out.println("Monetization is Present after navigating?: "+MyWebElement.isElementExistwithid("ad_unit_placeholder"));;
			continueLink.click();
			// MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			if (currentHash.get("excludedDriver").equals("Yes")) {
				MyWebElement.enterText(firstName, "First" + randomNameString(3));
				MyWebElement.enterText(lastName, "Last" + randomNameString(3));
				MyWebElement.enterText(month, "10");
				MyWebElement.enterText(date, "10");
				MyWebElement.enterText(year, "1960");
				gender.click();
				Select marriedStatus = new Select(maritalStatus);
				marriedStatus.selectByVisibleText("Single");
				Select ageFirstlicensed = new Select(relationship);
				ageFirstlicensed.selectByVisibleText("Parent");
				Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
						+ "DriversPage.png");
				reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Driver'sPage",
						System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
								+ "DriversPage.png");
				continueLink.click();
			}

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
