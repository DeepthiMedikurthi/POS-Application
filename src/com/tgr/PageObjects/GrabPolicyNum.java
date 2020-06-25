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
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.tgq.TGQPageObjects.TGQAllPages;
import com.tgr.Utilities.Excel;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class GrabPolicyNum extends CommonPage {

	private static final Logger log = LogManager.getLogger(GrabPolicyNum.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public GrabPolicyNum(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/form/div[3]/div/div[1]/div[2]/div/div/div/div/div/strong")
	public WebElement policyNum;

	@FindBy(how = How.LINK_TEXT, using = "eSign & Print Documents")
	public WebElement waitLink;

	// ===================== PAGE METHODS ======================

	public void grabPolicyNum() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			//MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, policyNum);
			Excel.writeToExcelSheet(policyNum.getText(), quoteNumber);
			// policyNum.getText().substring(beginIndex)
			System.out.println(policyNum.getText());
			/*
			 * Base.screenShot( System.getProperty("user.dir")+"\\Results\\Screenshots_" +
			 * trimPolicyNumber(policyNum.getText()) + "_FinalPolicyPage_ " + ".png");
			 */
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "PolicyPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","PolicyPage",System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/"	+ "PolicyPage.png");
			if (MyWebElement.isElementExist("eSign & Print Documents"))
				MyWebElement.clickOn(waitLink);
		}  catch (Exception exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in PolicyPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error in PolicyPage: </b></font><br />" + exp.getMessage() + "<br />",
							"./Results/Screenshots_"+ testRunTimeStamp + "/"
							+ "Error in PolicyPage.png");
			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
