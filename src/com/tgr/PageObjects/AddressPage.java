package com.tgr.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.tgr.Utilities.MyOwnException;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class AddressPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(AddressPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public AddressPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.ID, using = "addrForm0.address1")
	public WebElement address;
	@FindBy(how = How.ID, using = "addrForm0.city")
	public WebElement city;
	@FindBy(how = How.CLASS_NAME, using = "proweb_popup")
	public WebElement popup;
	@FindBy(how = How.XPATH, using = "//*[@id=\"proweb_wgt0_refine_btnKeep\"]/a")
	public WebElement keepAsEntered;
	@FindBy(how = How.ID, using = "ad_unit_placeholder")
	public WebElement monetization;
	@FindBy(how = How.XPATH, using = "//*[@id=\"proweb_wgt0_partial_btnsubmit\"]")
	public WebElement acceptAdress;
	@FindBy(how = How.LINK_TEXT, using = "Back")
	public WebElement backLink;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void addressInfo() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			if (!currentHash.get("excludedDriver").equals("Yes")) {
				backLink.click();
				System.out.println("Monetization is Present after navigating?: "
						+ MyWebElement.isElementExistwithid("ad_unit_placeholder"));
				;
				continueLink.click();
			}
			MyWebElement.enterText(address, currentHash.get("address"));
			MyWebElement.enterText(city, currentHash.get("city"));
			MyWebElement element = new MyWebElement();
			continueLink.click();
			// MyWait.implicitlyFor(ldriver, 10, "SECONDS");
			// ((JavascriptExecutor) ldriver).executeScript("arguments[0].click()",
			// acceptAdress);
			// ldriver.switchTo().frame(0);
			if (element.isButtonExist("//*[@id=\"proweb_wgt0_refine_btnKeep\"]/a")) {
				keepAsEntered.click();
			} else
				acceptAdress.click();
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
