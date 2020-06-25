package com.tgr.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWebElement;

public class Quotepage extends CommonPage {

	private static final Logger log = LogManager.getLogger(Quotepage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public Quotepage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.CLASS_NAME, using = "jumpout")
	public WebElement quoteNumber;
	@FindBy(how = How.ID, using = "ad_unit_placeholder")
	public WebElement monetization;
	@FindBy(how = How.CLASS_NAME, using = "roadside-questions-wrap")
	public WebElement roadsideQuestions;
	@FindBy(how = How.XPATH, using = "//*[@id=\"umBiPdLimitsSelect\"]")
	public WebElement umpd;
	@FindBy(how = How.XPATH, using = "//*[@id=\"uimbiLimit\"]")
	public WebElement uimbi;
	@FindBy(how = How.NAME, using = "uimpdLimit")
	public WebElement uimpd;
	@FindBy(how = How.NAME, using = "pipLimit")
	public WebElement pip;
	@FindBy(how=How.XPATH, using="//*[@class=\"roadside-questions-wrap\"]/div[1]/label[1]/div[1]")
	public WebElement que1;
	@FindBy(how=How.XPATH, using="//*[@class=\"roadside-questions-wrap\"]/div[1]/label[2]/div[1]")
	public WebElement que2;
	@FindBy(how=How.XPATH, using="//*[@class=\"roadside-questions-wrap\"]/div[1]/label[3]/div[1]")
	public WebElement que3;
	@FindBy(how=How.XPATH, using="//*[@class=\"roadside-questions-wrap\"]/div[1]/label[4]/div[1]")
	public WebElement que4;
	@FindBy(how=How.XPATH, using="//*[@id=\"vehicle1\"]/div[9]/div/div/label[1]")
	public WebElement yes_antiTheft;
	@FindBy(how = How.LINK_TEXT, using = "Back")
	public WebElement backLink;
	@FindBy(how = How.ID, using = "ownOrLeaseOptions0")
	public WebElement ownOrLeaseOptions;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;
	@FindBy(how = How.LINK_TEXT, using = "Recalculate")
	public WebElement RecalculateLink;
	// ===================== PAGE METHODS ======================

	public void quoteInfo() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			//MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			System.out.println(quoteNumber.getAttribute("innerHTML"));
			Base.quoteNumber = quoteNumber.getAttribute("innerHTML");
			if(!(MyWebElement.isAlertPresent("roadside-questions-wrap")) &&!( currentHash.get("state").equals("NC")))
			Assert.assertEquals(true, MyWebElement.isElementExistwithid("ad_unit_placeholder"));
			System.out.println("Monetization is Present before navigating to vehicles Page?: "+MyWebElement.isElementExistwithid("ad_unit_placeholder"));;
			backLink.click();
			if(testDataFilename.equals("MyPolictTestData"))
				yes_antiTheft.click();
			else {
			Select ownOrLeaseOptionsOfVehicle = new Select(ownOrLeaseOptions);
			ownOrLeaseOptionsOfVehicle.selectByVisibleText("Leased");}
			continueLink.click();
			System.out.println("Monetization is Present after navigating from vehicles Page?: "+MyWebElement.isElementExistwithid("ad_unit_placeholder"));;
			if(MyWebElement.isAlertPresent("roadside-questions-wrap")) {
				MyWebElement.clickOn(que1);
				MyWebElement.clickOn(que2);
				MyWebElement.clickOn(que3);
				MyWebElement.clickOn(que4);
				
			}
			if(currentHash.get("state").equals("WA")) {
				Select umpdele= new Select(umpd);
				umpdele.selectByVisibleText("$50,000/$100,000/$50,000");
				Select uimbiele= new Select(uimbi);
				uimbiele.selectByVisibleText("$50,000/$100,000");
				Select uimpdele= new Select(uimpd);
				uimpdele.selectByVisibleText("$50,000");
				Select pipele= new Select(pip);
				pipele.selectByVisibleText("$10,000");
				RecalculateLink.click();
			}
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_"  + testRunTimeStamp + "/" + "QuotePage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","QuotePage",System.getProperty("user.dir")+"\\Results\\Screenshots_"  + testRunTimeStamp + "/"	+ "QuotePage.png");
			continueLink.click();

		} catch (Exception e) {
			log.error(e.getMessage());
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_"  + testRunTimeStamp + "/" + "Error in QuotePage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error in QuotePage: </b></font><br />" + e.getMessage() + "<br />",
							System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "Error in QuotePage.png");
			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + e.getMessage() + "\n");
		} 
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
