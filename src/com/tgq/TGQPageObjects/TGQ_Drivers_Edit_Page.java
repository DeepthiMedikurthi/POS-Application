package com.tgq.TGQPageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tgr.accelerators.Base;
import com.tgr.Utilities.MyOwnException;
import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class TGQ_Drivers_Edit_Page extends TGQAllPages {

	private static final Logger log = LogManager.getLogger(TGQ_Drivers_Edit_Page.class.getName());

	// Page Factory

	@FindBy(how = How.ID, using = "drivers[0].stateLicensed.writableValue")
	public WebElement state_lic;
	@FindBy(how = How.ID, using = "drivers[0].socialSecurityNumber.value")
	public WebElement ssn;
	@FindBy(how = How.ID, using = "drivers[0].driverLicenseNumber.value")
	public WebElement dl;
	@FindBy(how = How.ID, using = "drivers[1].stateLicensed.writableValue")
	public WebElement state_lic1;
	@FindBy(how = How.ID, using = "drivers[1].socialSecurityNumber.value")
	public WebElement ssn1;
	@FindBy(how = How.ID, using = "drivers[1].driverLicenseNumber.value")
	public WebElement dl1;
	@FindBy(how = How.ID, using = "drivers[2].stateLicensed.writableValue")
	public WebElement state_lic2;
	@FindBy(how = How.ID, using = "drivers[2].socialSecurityNumber.value")
	public WebElement ssn2;
	@FindBy(how = How.ID, using = "drivers[2].driverLicenseNumber.value")
	public WebElement dl2;
	@FindBy(how = How.ID, using = "drivers[3].stateLicensed.writableValue")
	public WebElement state_lic3;
	@FindBy(how = How.ID, using = "drivers[3].socialSecurityNumber.value")
	public WebElement ssn3;
	@FindBy(how = How.ID, using = "drivers[3].driverLicenseNumber.value")
	public WebElement dl3;
	
	@FindBy(how = How.ID, using = "drivers[0].occupation.writableValue")
	public WebElement occupation;

	@FindBy(how = How.LINK_TEXT, using = "Recalculate")
	public WebElement recalculate_button;
	@FindBy(how = How.LINK_TEXT, using = "Next")
	public WebElement next_button;

	WebDriver ldriver;

	public TGQ_Drivers_Edit_Page(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void driversEdit() throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {

			Select state_lic_dr = new Select(state_lic);
			state_lic_dr.selectByVisibleText(currentHash.get("QuoteState"));
			//state_lic_dr.selectByVisibleText("NY");
			MyWebElement.enterText(ssn, currentHash.get("SSN"));
			MyWebElement.enterText(dl, currentHash.get("DL"));
			if (currentHash.get("AdditionalDriver").equals("Yes")) {
			Select state_lic_dr1 = new Select(state_lic1);
			state_lic_dr1.selectByVisibleText(currentHash.get("QuoteState"));
			//state_lic_dr.selectByVisibleText("NY");
			MyWebElement.enterText(ssn1, "014526889");
			MyWebElement.enterText(dl1, "478596845");
			Select state_lic_dr2 = new Select(state_lic2);
			state_lic_dr2.selectByVisibleText(currentHash.get("QuoteState"));
			//state_lic_dr.selectByVisibleText("NY");
			MyWebElement.enterText(ssn2, "014526887");
			MyWebElement.enterText(dl2, "471569546");
			Select state_lic_dr3 = new Select(state_lic3);
			state_lic_dr3.selectByVisibleText(currentHash.get("QuoteState"));
			//state_lic_dr.selectByVisibleText("NY");
			MyWebElement.enterText(ssn3,"014526886");
			MyWebElement.enterText(dl3, "479955112");
			}
		//	System.out.println(occupation.getAttribute("style")+"fdhfdhfdhfdhfdhfdh");
			if (MyWebElement.isElementExistwithid("drivers[0].occupation.writableValue")&& !(occupation.getAttribute("style").equals("display: none;"))) {
				Select Occupation = new Select(occupation);
				Occupation.selectByVisibleText("Accountant/Auditor");
				
			}

			recalculate_button.click();
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Drivers Edit Tab.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","Drivers Edit Tab",System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/"	+ "Drivers Edit Tab.png");
			next_button.click();
			Thread.sleep(4000);
		} catch (Exception exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in Opening Drivers Edit Tab.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error while Opening Drivers Edit Tab: </b></font><br />" + exp.getMessage() + "<br />",
							System.getProperty("user.dir")+"\\Results\\Screenshots_"+ testRunTimeStamp + "/"
							+ "Error in Opening Drivers Edit Tab.png");
			throwException("Unable To open the Drivers Edit Tab \n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
