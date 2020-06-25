package com.tgq.PageObjects;

import static org.testng.Assert.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;


public class GlobalCommonObjects extends Base {

	private static final Logger log = LogManager.getLogger(GlobalCommonObjects.class.getName());
	public static int count = 0;

	WebDriver ldriver;

	public GlobalCommonObjects(WebDriver dr) {

		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void verifyPageTitle(String screenName) throws MyOwnException, InterruptedException {

		try {

			
			BaseClass.screenShot("./Results/Screenshots_" + testRunTimeStamp + "/" + "Verify_Title_" + screenName + ".png");

			Report.logTestCaseStatusWithSnapShot(parentTestCase, "PASS",
					"User Successfully Redirected to '" + screenName + "' screen",
					"./Results/Screenshots_"+ testRunTimeStamp + "/"
							+ "Verify_Title_" + screenName + ".png");
		} catch (Exception exp) {

			BaseClass.screenShot("./Results/Screenshots_" + testRunTimeStamp + "/" + "Error_Verify_Title_" + screenName + ".png");

			Report.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL", "Error redirecting user to '" + screenName,
					"./Results/Screenshots_"+ testRunTimeStamp + "/"
							+ "Error_Verify_Title_" + screenName + ".png");

			throwException("UNABLE TO verify page title in " + screenName + " screen \n" + exp.getMessage() + "\n");
		}

	}
}
