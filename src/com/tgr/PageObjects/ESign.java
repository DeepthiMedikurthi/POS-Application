package com.tgr.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class ESign extends CommonPage {

	private static final Logger log = LogManager.getLogger(ESign.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;
	Alert a;

	public ESign(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/form/div[3]/div/div[1]/div[2]/div/div/div/div/div/strong")
	public WebElement policyNum;

	@FindBy(how = How.LINK_TEXT, using = "Agree")
	public WebElement agreeButton;
	public int eSignStepCount=1;

	// ===================== PAGE METHODS ======================

	public void esign() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, agreeButton);
			MyWebElement element=new MyWebElement();
			while (element.isElementExist("Agree")) {
				Base.screenShot(System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "eSignStep"+eSignStepCount+".png");
				reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","ESignPage"+eSignStepCount,System.getProperty("user.dir") +"\\Results\\Screenshots_"+ testRunTimeStamp + "/"	+ "eSignStep"+eSignStepCount+".png");
				agreeButton.click();
				Thread.sleep(2000);
				a = ldriver.switchTo().alert();
				Thread.sleep(2000);
				a.accept();
				eSignStepCount++;
			}
			Base.screenShot(System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "eSignStep"+eSignStepCount+".png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","ESignPage"+eSignStepCount,System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/"	+ "eSignStep"+eSignStepCount+".png");
			System.out.println("GSign Completed Successfully");
		} catch (UnhandledAlertException exp) {
			MyWebElement.clickOn(agreeButton);
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "eSignStep"+eSignStepCount+".png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error in ESignPage: </b></font><br />" + exp.getMessage() + "<br />",
					System.getProperty("user.dir") +"\\Results\\Screenshots_"+ testRunTimeStamp + "/"
									+ "eSignStep"+eSignStepCount+".png");
			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
