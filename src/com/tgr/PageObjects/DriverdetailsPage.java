package com.tgr.PageObjects;

import java.util.ArrayList;
import java.util.List;

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
import com.tgr.Utilities.MyOwnException;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class DriverdetailsPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(DriverdetailsPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public DriverdetailsPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.NAME, using = "drivers[0].firstName.value")
	public WebElement firstName;
	@FindBy(how = How.NAME, using = "drivers[0].lastName.value")
	public WebElement lastName;
	@FindBy(how = How.NAME, using = "drivers[0].suffix.value")
	public WebElement suffix;
	@FindBy(how = How.NAME, using = "drivers[0].middleInitial.value")
	public WebElement middleName;
	List<WebElement> options = new ArrayList();
	String option = null;
	@FindBy(how = How.NAME, using = "drivers[0].licenseStatus.realValue")
	public WebElement liscStatus;
	@FindBy(how = How.NAME, using = "drivers[0].licenseNumber.value")
	public WebElement licenseNumber;
	@FindBy(how = How.NAME, using = "ssnPart1")
	public WebElement ssnPart1;
	@FindBy(how = How.NAME, using = "ssnPart2")
	public WebElement ssnPart2;
	@FindBy(how = How.NAME, using = "ssnPart3")
	public WebElement ssnPart3;
	@FindBy(how = How.NAME, using = "drivers[1].firstName.value")
	public WebElement firstNameDr2;
	@FindBy(how = How.NAME, using = "drivers[1].lastName.value")
	public WebElement lastNameDr2;
	@FindBy(how = How.NAME, using = "drivers[1].suffix.value")
	public WebElement suffixDr2;
	@FindBy(how = How.NAME, using = "drivers[1].middleInitial.value")
	public WebElement middleNameDr2;
	@FindBy(how = How.NAME, using = "drivers[1].relation.realValue")
	public WebElement relation;
	@FindBy(how = How.NAME, using = "drivers[1].licenseStatus.realValue")
	public WebElement liscStatusDr2;
	@FindBy(how = How.NAME, using = "drivers[1].licenseNumber.value")
	public WebElement licenseNumberDr2;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void driverDetailsPage() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			
		//	MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			if (currentHash.get("state").equals("NC")) {
				MyWebElement.enterText(lastName, currentHash.get("LastName"));
				MyWebElement.enterText(licenseNumber, currentHash.get("licenseNumber"));
				MyWebElement.enterText(ssnPart1, "014");
				MyWebElement.enterText(ssnPart2, "45");
				MyWebElement.enterText(ssnPart3, "8885");
			}
			else {
			MyWebElement.enterText(firstName, currentHash.get("FirstName"));
			MyWebElement.enterText(lastName, currentHash.get("LastName"));
			Select liscstatus = new Select(liscStatus);
			liscstatus.selectByVisibleText("Active");
			MyWebElement.enterText(licenseNumber, currentHash.get("licenseNumber"));
			MyWebElement.enterText(ssnPart1, "012");
			MyWebElement.enterText(ssnPart2, "31");
			MyWebElement.enterText(ssnPart3, "3882");
			}
			if(currentHash.get("AdditionalDriver").equals("Yes")) {
				MyWebElement.enterText(firstNameDr2, "Test"+randomNameString(3));
				MyWebElement.enterText(lastNameDr2, randomNameString(7));
				Select liscstatus = new Select(liscStatusDr2);
				liscstatus.selectByVisibleText("Active");
				Select relationShip = new Select(relation);
				options = relationShip.getOptions();
				for (WebElement list : options) {
					if (list.getText().equals("Relative")) {
						option = "Relative";
						break;
					} else
						option = "Dependent";
				}
				relationShip.selectByVisibleText(option);
				MyWebElement.enterText(licenseNumberDr2, "4554455");
			}
			continueLink.click();
		} catch (AssertionError exp) {
			log.error(exp.getMessage());

			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		} catch (Exception exp) {
			log.error(exp.getMessage());

			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
