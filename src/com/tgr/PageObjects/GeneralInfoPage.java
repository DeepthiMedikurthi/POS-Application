package com.tgr.PageObjects;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

public class GeneralInfoPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(GeneralInfoPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;
	@SuppressWarnings("rawtypes")
	List<WebElement> options = new ArrayList();
	String option = null;

	public GeneralInfoPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.ID, using = "piLapseDays")
	public WebElement previousInsurance;
	@FindBy(how = How.NAME, using = "insuredPrevious6Months")
	public WebElement insuredPrevious6Months;
	@FindBy(how = How.ID, using = "piTenureDaysSelect")
	public WebElement piTenureDaysSelect;
	@FindBy(how = How.ID, using = "piBiLimitSelect")
	public WebElement piBiLimitSelect;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_area\"]/div[3]/div/div[1]/form/div[6]/div[1]/div/label[2]")
	public WebElement noExclude;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_area\"]/div[3]/div/div[1]/form/div[6]/div[1]/div/label[1]")
	public WebElement yesExclude;
	
	@FindBy(how = How.ID, using = "ownsHomeFlag")
	public WebElement ownsHomeflag;
	@FindBy(how = How.ID, using = "emailAddress")
	public WebElement emailId;

	@FindBy(how = How.NAME, using = "userRatedCredit")
	public WebElement credit;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_area\"]/div[2]/div/ul/li")
	public WebElement errorMessage;

	// ===================== PAGE METHODS ======================

	public void generalInfo() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			
			// MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			if (currentHash.get("state").equals("NC")) {
				Select ownsHome = new Select(insuredPrevious6Months);
				ownsHome.selectByVisibleText("No");
				Select creditInfo = new Select(credit);
				creditInfo.selectByVisibleText("Good");
				MyWebElement.enterText(emailId, currentHash.get("Emailid"));

			} else {
				if (MyWebElement
						.isButtonExist("//*[@id=\"content_area\"]/div[3]/div/div[1]/form/div[6]/div[1]/div/label[2]")
						&& !(currentHash.get("excludedDriver").equalsIgnoreCase("Yes")))
					noExclude.click();
				else {
					if (MyWebElement
							.isButtonExist("//*[@id=\"content_area\"]/div[3]/div/div[1]/form/div[6]/div[1]/div/label[1]"))
					yesExclude.click();
				}
				if (MyWebElement.isDropdownExist("insuredPrevious6Months")) {
					Select previousInsured = new Select(insuredPrevious6Months);

					options = previousInsured.getOptions();
					for (WebElement list : options) {
						if (list.getText().equals("No: Other")) {
							option = "No: Other";
							break;
						} else
							option = "No";
					}
					previousInsured.selectByVisibleText("No");
				}

				if (MyWebElement.isElementExistwithid("piLapseDays")) {
					if (currentHash.get("priorInsurance").equals("Yes")) {
						Select excludeDriver = new Select(previousInsurance);
						options = excludeDriver.getOptions();
						for (WebElement list : options) {
							if (list.getText().equals("Yes: No lapse (0 days)")) {
								option = list.getText();
								break;
							}
						}
						excludeDriver.selectByVisibleText(option);
						Select piTenureDays = new Select(piTenureDaysSelect);
						piTenureDays.selectByIndex(1);
						Select piBiLimit = new Select(piBiLimitSelect);
						piBiLimit.selectByIndex(1);

					} else {
						Select excludeDriver = new Select(previousInsurance);
						options = excludeDriver.getOptions();
						for (WebElement list : options) {
							if (list.getText().equals("No: Other")) {
								option = "No: Other";
								break;
							} else
								option = "No";
						}
						excludeDriver.selectByVisibleText(option);
					}

				}

				Select ownsHome = new Select(ownsHomeflag);

				ownsHome.selectByVisibleText(currentHash.get("residenceType"));
				Select creditInfo = new Select(credit);
				creditInfo.selectByVisibleText("Good");
				MyWebElement.enterText(emailId, currentHash.get("Emailid"));
			}
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "GeneralInfoPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "GeneralInfoPage",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "GeneralInfoPage.png");
			continueLink.click();
			if (MyWebElement.isCloseButtonExist("//*[@id=\"content_area\"]/div[2]/div/ul/li")) {
				if (errorMessage.getText()
						.equals("Please indicate whether you have had auto insurance coverage in the last 5 years."))
					continueLink.click();
				// System.out.println("Error Message: " + errorMessage.getText());
			}
		} catch (AssertionError exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
					+ "Error in GeneralInfoPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error in GeneralInfoPage: </b></font><br />" + exp.getMessage() + "<br />",
					System.getProperty("user.dir") + "\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "Error in GeneralInfoPage.png");
			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
