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

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class CreditDebitCardPaymentPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(CreditDebitCardPaymentPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public CreditDebitCardPaymentPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.XPATH, using = "//*[@id=\"navigationButtons\"]/a[2]")
	public WebElement processPayment;
	@FindBy(how = How.ID, using = "ccNumber")
	public WebElement ccNumber;
	@FindBy(how = How.NAME, using = "expirationMonth")
	public WebElement expirationMonth;
	@FindBy(how = How.NAME, using = "expirationYear")
	public WebElement expirationYear;
	@FindBy(how = How.LINK_TEXT, using = "Use Garaging Address")
	public WebElement useGaragingLink;
	

	// ===================== PAGE METHODS ======================

	public void creditdebitCardPaymentPage() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
		//	MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, processPayment);
			MyWebElement.enterText(ccNumber, currentHash.get("ccNumber"));
			MyWebElement.enterText(expirationMonth, currentHash.get("expirationMonth"));
			//MyWebElement.enterText(expirationYear, );
			expirationYear.sendKeys(currentHash.get("expirationYear"));
			MyWait.implicitlyFor(ldriver, 10, "SECONDS");
			useGaragingLink.click();
			processPayment.click();
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
