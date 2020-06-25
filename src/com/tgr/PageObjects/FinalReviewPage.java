package com.tgr.PageObjects;

import java.time.LocalDate;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWebElement;

public class FinalReviewPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(FinalReviewPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public FinalReviewPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.XPATH, using = "//*[@id=\"verify-info-label\"]/div[1]")
	public WebElement chechbox;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_area\"]/div[3]/div/div[1]/div[6]/div/input[2]")
	public WebElement date;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_area\"]/div[3]/div/div[1]/div[6]/div/input[1]")
	public WebElement month;
	@FindBy(how = How.LINK_TEXT, using = "Agree")
	public WebElement agreeLink;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void finalreviewPage() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			// MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			if(currentHash.get("state").equals("IL")) {
				agreeLink.click();
			}
			LocalDate ldate = java.time.LocalDate.now();
			int day = ldate.getDayOfMonth();
			int lmonth = ldate.getMonthValue();
			if (day > 30 || day > 31) {
				day = day++;
				lmonth++;
			} else {
				day++;
			}
			date.clear();
			MyWebElement.enterText(date, String.valueOf(day));
			month.clear();
			MyWebElement.enterText(month, String.valueOf(lmonth));
			chechbox.click();
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "finalreviewPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "finalreviewPage",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "finalreviewPage.png");
			continueLink.click();
		} catch (Exception e) {
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "Error in finalreviewPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error in finalreviewPage: </b></font><br />" + e.getMessage() + "<br />",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "Error in finalreviewPage.png");
			log.error(e.getMessage());

			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + e.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}
}
