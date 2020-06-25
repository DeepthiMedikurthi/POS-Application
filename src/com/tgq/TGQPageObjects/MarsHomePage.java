package com.tgq.TGQPageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tgr.accelerators.Base;
import com.tgr.Utilities.MyOwnException;
import wrapper.classes.methods.MyWebElement;

public class MarsHomePage extends TGQAllPages {

	private static final Logger log = LogManager.getLogger(MarsHomePage.class.getName());

	// Page Factory

	@FindBy(how = How.XPATH, using = "//*[@id=\"maincontent\"]/table/tbody/tr[2]/td/table/tbody/tr/td[1]/div[1]/div/div/div/div/div/div/div/div/div/table/tbody/tr[3]/td/input")
	public WebElement new_Quote;
	@FindBy(how = How.LINK_TEXT, using = "Start New Quote")
	public WebElement start_new_Quote;
	@FindBy(how = How.XPATH, using = "//*[@id='maincontent']/table/tbody/tr[2]/td/table/tbody/tr/td[1]/div[1]/div/div/div/div/div/div/div/div/div/table/tbody/tr[5]/td/input")
	public WebElement quote_Search;
	WebDriver ldriver;

	public MarsHomePage(WebDriver driver) {
		super(driver);
		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	public void homepage() throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {
			if (MyWebElement.isElementExist("Start New Quote")) {
				Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "MARS Home Page.png");
				reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","Opened MARS Home Page",System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/"	+ "MARS Home Page.png");
				MyWebElement.clickOn(start_new_Quote);
			}
			else {
				Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "MARS Home Page.png");
				reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","Opened MARS Home Page",System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/"	+ "MARS Home Page.png");
				MyWebElement.clickOn(new_Quote);
			}
				
		} catch (Exception exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in Opening MARS Home Page.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error while Opening MARS Home Page: </b></font><br />" + exp.getMessage() + "<br />",
							System.getProperty("user.dir")+"\\Results\\Screenshots_"+ testRunTimeStamp + "/"
							+ "Error in Opening MARS Home Page.png");
			throwException("Unable To open the  MARS Home Page \n" + exp.getMessage() + "\n");

		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
