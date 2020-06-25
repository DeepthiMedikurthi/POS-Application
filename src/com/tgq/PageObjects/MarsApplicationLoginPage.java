package com.tgq.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tgr.Utilities.MyOwnException;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class MarsApplicationLoginPage extends TGQCommonPage {

	private static final Logger log = LogManager.getLogger(MarsApplicationLoginPage.class.getName());

	// Page Factory

	@FindBy(how = How.CLASS_NAME, using = "OrangeGradientButton")
	public WebElement signin_button;

	@FindBy(how = How.NAME, using = "agencyid")
	public WebElement mars_agencyid;

	@FindBy(how = How.NAME, using = "pwd")
	public WebElement mars_password;

	WebDriver ldriver;

	public MarsApplicationLoginPage(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void login() throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		/*
		 * try { //MyWait.until(driver, "ELEMENT_VISIBLE", 90, signin_button);
		 * //System.out.println(currentHash.get("Username"));
		 * mars_agencyid.sendKeys("NTVNDM31"); MyWebElement.enterText(mars_agencyid,
		 * currentHash.get("Username")); MyWebElement.enterText(mars_password,
		 * currentHash.get("Password")); MyWait.until(driver, "ELEMENT_CLICKABLE", 30,
		 * signin_button); MyWebElement.clickOn(signin_button);
		 * 
		 * } catch (Exception exp) { log.error(exp.getMessage());
		 * 
		 * throwException("Unable To login to the TGQ application \n" + exp.getMessage()
		 * + "\n"); }
		 */
		MyWebElement.enterText(mars_agencyid, currentHash.get("Username"));
		MyWebElement.enterText(mars_password, currentHash.get("Password"));
		MyWait.until(driver, "ELEMENT_CLICKABLE", 30, signin_button);
		MyWebElement.clickOn(signin_button);
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
