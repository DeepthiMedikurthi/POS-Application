package com.tgq.TGQPageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tgr.Utilities.Excel;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class vSign extends TGQAllPages {
	private static final Logger log = LogManager.getLogger(vSign.class.getName());

	// Page Factory

	

	@FindBy(how = How.LINK_TEXT, using = "Start")
	public WebElement agreeButton;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueButton;
	WebDriver ldriver;
	public int vSignStepCount=1;
	public vSign(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void VSIgn() throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {
			ldriver.navigate().to(configProps.getProperty("vSignURL")+quoteNumber);
			MyWait.until(ldriver, "ELEMENT_VISIBLE", 50, agreeButton);
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_"  + testRunTimeStamp + "/" + "vSignStartStep"+".png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","VSignStartPage",System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/"+ "vSignStartStep"+".png");
			MyWebElement.clickOn(agreeButton);
			MyWebElement element = new MyWebElement();
			while (element.isElementExist("Continue")) {
				Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_"+ testRunTimeStamp + "/" + "vSignStep"+vSignStepCount+".png");
				reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","VSignPage"+vSignStepCount,System.getProperty("user.dir")+"\\Results\\Screenshots_"+ testRunTimeStamp + "/"	+ "vSignStep"+vSignStepCount+".png");
				Thread.sleep(2000);
				continueButton.click();
				Thread.sleep(2000);
				vSignStepCount++;

			}
			Base.screenShot(System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "VSignEndPage"+".png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","VSignEndPage",System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/"	+ "VSignEndPage"+".png");
			System.out.println("VSign Completed Successfully");

		} catch (Exception exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "eSignStep"+vSignStepCount+".png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error in ESignPage: </b></font><br />" + exp.getMessage() + "<br />",
					System.getProperty("user.dir")+"\\Results\\Screenshots_"+ testRunTimeStamp + "/"
									+ "eSignStep"+vSignStepCount+".png");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}
}
