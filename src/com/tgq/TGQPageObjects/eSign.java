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

public class eSign extends TGQAllPages {
	private static final Logger log = LogManager.getLogger(eSign.class.getName());

	// Page Factory

	@FindBy(how = How.LINK_TEXT, using = "Confirm & Continue")
	public WebElement confirm;

	@FindBy(how = How.LINK_TEXT, using = "Agree")
	public WebElement agreeButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"esignAgreeModal\"]/div/div/div[2]/button[1]")
	public WebElement okButton;
	WebDriver ldriver;
	public int eSignStepCount=1;
	public eSign(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void ESIgn() throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {
			ldriver.navigate().to(configProps.getProperty("eSignURL")+quoteNumber);
			MyWait.until(ldriver, "ELEMENT_VISIBLE", 50, confirm);
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_"  + testRunTimeStamp + "/" + "eSignStartStep"+".png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","ESignStartPage",System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/"+ "eSignStartStep"+".png");
			MyWebElement.clickOn(confirm);
			MyWebElement element = new MyWebElement();
			while (element.isElementExist("Agree")) {
				Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_"  + testRunTimeStamp + "/" + "eSignStep"+eSignStepCount+".png");
				reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","ESignPage"+eSignStepCount,System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/"+ "eSignStep"+eSignStepCount+".png");
				agreeButton.click();
				Thread.sleep(2000);
				okButton.click();
				Thread.sleep(2000);
				eSignStepCount++;

			}
			Base.screenShot(System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "ESignEndPage"+".png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","ESignEndPage",System.getProperty("user.dir") +"\\Results\\Screenshots_" + testRunTimeStamp + "/"	+ "ESignEndPage"+".png");
			System.out.println("ESign Completed Successfully");
		} catch (Exception exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "eSignStep"+eSignStepCount+".png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error in ESignPage: </b></font><br />"+eSignStepCount + exp.getMessage() + "<br />",
					System.getProperty("user.dir")+"\\Results\\Screenshots_"+ testRunTimeStamp + "/"
									+ "eSignStep"+eSignStepCount+".png");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}
}
