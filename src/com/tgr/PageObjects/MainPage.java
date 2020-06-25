package com.tgr.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.tgr.Utilities.MyOwnException;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class MainPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(MainPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public MainPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.ID, using = "free-quote-zip")
	public WebElement zipCode;

	@FindBy(how = How.XPATH, using = "//*[@id=\"free-quote\"]/button")
	public WebElement startQuote;

	// ===================== PAGE METHODS ======================

	@SuppressWarnings("unlikely-arg-type")
	public void ClickOnstartQuote() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			//MyWait.until(ldriver, "ELEMENT_VISIBLE", 190, startQuote);
			zipCode.sendKeys(currentHash.get("zipCode"));
			startQuote.click();

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
