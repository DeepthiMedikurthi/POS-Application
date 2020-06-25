package com.tgq.homeOwners;

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
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.tgr.PageObjects.CommonPage;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWait;
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

	@FindBy(how = How.ID, using = "piLapseDays")
	public WebElement previousInsurance;
	@FindBy(how = How.NAME, using = "insuredPrevious6Months")
	public WebElement insuredPrevious6Months;

	@FindBy(how = How.XPATH, using = "//*[@id=\"content_area\"]/div[3]/div/div[1]/form/div[6]/div[1]/div/label[2]")
	public WebElement exclude;
	@FindBy(how = How.ID, using = "ownsHomeFlag")
	public WebElement ownsHomeflag;
	@FindBy(how = How.XPATH, using = "//*[@id='showHouseMessage']")
	public WebElement message;

	@FindBy(how = How.ID, using = "emailAddress")
	public WebElement emailId;

	@FindBy(how = How.NAME, using = "userRatedCredit")
	public WebElement credit;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void generalInfo() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			// MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			if (currentHash.get("state").equals("NC")) {
				Select ownsHome = new Select(insuredPrevious6Months);
				ownsHome.selectByVisibleText("No");
				Select creditInfo = new Select(credit);
				creditInfo.selectByVisibleText("Good");
				// MyWebElement.enterText(emailId, currentHash.get("Emailid"));

			} else {
				if (MyWebElement
						.isButtonExist("//*[@id=\"content_area\"]/div[3]/div/div[1]/form/div[6]/div[1]/div/label[2]"))
					exclude.click();
				if (MyWebElement.isDropdownExist("insuredPrevious6Months")) {
					Select previousInsured = new Select(insuredPrevious6Months);

					options = previousInsured.getOptions();
					for (WebElement list : options) {
						if (list.getText().equals("No: Other")) {
							option = "No: Other";
							break;
						} else
							option = "No";
					}
					previousInsured.selectByVisibleText("Yes");
				}

				if (MyWebElement.isElementExistwithid("piLapseDays")) {
					Select excludeDriver = new Select(previousInsurance);
					options = excludeDriver.getOptions();
					for (WebElement list : options) {
						if (list.getText().equals("No: Other")) {
							option = "No: Other";
							break;
						} else
							option = "No";
					}
					excludeDriver.selectByVisibleText(option);
				}

				Select ownsHome = new Select(ownsHomeflag);
				ownsHome.selectByVisibleText(currentHash.get("homeOption"));
				Base.screenShot("./Results/Screenshots_" + testRunTimeStamp + "/" +currentHash.get("Testcaseid")+".png");
				Assert.assertEquals(message.getText(),
						"Residence ownership applies a discount to your quote. If we are not able to verify ownership, you will be required to submit proof after purchase to keep the discount (proof of ownership must have a policyholder's name, or a policyholder's spouse name).");
			}

		} catch (AssertionError exp) {
			log.error(exp.getMessage());

		}
	}

}
