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
import com.tgr.PageObjects.VehicleDetailsPage;
import com.tgr.PageObjects.VehiclesPage;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWebElement;

public class DriversDetailsPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(DriversDetailsPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public DriversDetailsPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	
	@FindBy(how = How.NAME, using = "drivers[0].licenseNumber.value")
	public WebElement liscNo;

	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void driverdetailMypolicy() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			MyWebElement.clearOut(liscNo);
			MyWebElement.enterText(liscNo, currentHash.get("licNo"));
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "DriversDetailsPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "Driver Details'sPage",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "DriversDetailsPage.png");
		
			continueLink.click();
			VehicleDetailsPage veh=new VehicleDetailsPage(ldriver);
			veh.existingDamage.click();
			continueLink.click();
		} catch (Exception exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "Error in DriverDetailsPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error in DriverDetails'sPage: </b></font><br />" + exp.getMessage() + "<br />",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "Error in DriverDetailsPage.png");
			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
