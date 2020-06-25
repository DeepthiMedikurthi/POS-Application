package com.tgq.TGQPageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;
import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class MarsApplicationLoginPage extends TGQCommonPage {

	private static final Logger log = LogManager.getLogger(MarsApplicationLoginPage.class.getName());

	// Page Factory

	@FindBy(how = How.CLASS_NAME, using = "OrangeGradientButton")
	public WebElement signin_button;

	@FindBy(how = How.NAME, using = "agencyid")
	public WebElement agencyId;

	@FindBy(how = How.NAME, using = "pwd")
	public WebElement mars_password;

	WebDriver ldriver;

	public MarsApplicationLoginPage(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void login() throws InterruptedException, MyOwnException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");

		try {
			MyWait.implicitlyFor(ldriver, 10, "SECONDS");
			System.out.println(driver.getTitle());
			MyWait.until(driver, "ELEMENT_VISIBLE", 90, signin_button);
			MyWebElement.enterText(agencyId, currentHash.get("Username"));
			MyWebElement.enterText(mars_password, currentHash.get("Password"));
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Opened MARS.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","Opened MARS Application",System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/"	+ "Opened MARS.png");

			MyWebElement.clickOn(signin_button);
			log.info("METHOD(login) EXECUTED SUCCESSFULLY");
		} catch (MyOwnException e) {
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_"+ testRunTimeStamp + "/" + "Error in Opening MARS Application.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error while Opening MARS application: </b></font><br />" + e.getMessage() + "<br />",
					System.getProperty("user.dir")+"\\Results\\Screenshots_"+ testRunTimeStamp + "/"
							+ "Error in Opening MARS Application.png");
			throwException("Unable To open the  MARS application \n" + e.getMessage() + "\n");
			e.printStackTrace();
		}

	}

}
