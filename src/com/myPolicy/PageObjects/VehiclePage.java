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

public class VehiclePage extends CommonPage {

	private static final Logger log = LogManager.getLogger(VehiclePage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public VehiclePage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================
	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicle1\"]/div[8]/div[1]/div/label[2]")
	public WebElement vehUse;
	
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void vehiclePageMypolicy() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			VehiclesPage veh=new VehiclesPage(ldriver);
			Select ownOrLeaseOptionsOfVehicle = new Select(veh.ownOrLeaseOptions);
			ownOrLeaseOptionsOfVehicle.selectByVisibleText("Owned (not making payments)");
			MyWebElement.clickOn(vehUse);
			MyWebElement.clickOn(continueLink);

		} catch (Exception exp) {
			log.error(exp.getMessage());
			
			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
