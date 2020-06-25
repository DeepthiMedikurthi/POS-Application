package com.tgq.TGQPageObjects;

import java.util.LinkedList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tgr.accelerators.Base;
import com.tgr.Utilities.MyOwnException;
import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class TGQ_Validate_Quote_Page extends TGQAllPages {

	private static final Logger log = LogManager.getLogger(TGQ_Validate_Quote_Page.class.getName());

	// Page Factory

	@FindBy(how = How.LINK_TEXT, using = "Validate")
	public WebElement validate_button;
	@FindBy(how = How.ID, using = "quoteBean.paperless.writableValue")
	public WebElement signup_paperless;
	@FindBy(how = How.ID, using = "quoteBean.homePhone.area")
	public WebElement prim_num1;
	@FindBy(how = How.ID, using = "quoteBean.homePhone.exchange")
	public WebElement prim_num2;
	@FindBy(how = How.ID, using = "quoteBean.homePhone.station")
	public WebElement prim_num3;
	@FindBy(how = How.ID, using = "quoteBean.primaryAccountAlertsOptInPreference.writableValue")
	public WebElement account_alerts;
	@FindBy(how = How.ID, using = "quoteBean.workPhone.area")
	public WebElement alt_num1;
	@FindBy(how = How.ID, using = "quoteBean.workPhone.exchange")
	public WebElement alt_num2;
	@FindBy(how = How.ID, using = "quoteBean.workPhone.station")
	public WebElement alt_num3;
	@FindBy(how = How.ID, using = "quoteBean.alternateAccountAlertsOptInPreference.writableValue")
	public WebElement alt_account_alert;
	@FindBy(how = How.ID, using = "quoteBean.closingMethod.writableValue")
	public WebElement closing_method;
	@FindBy(how = How.ID, using = "quoteBean.accessEmail.value")
	public WebElement confirm_email;
	@FindBy(how = How.ID, using = "emailRow")
	public WebElement emailRow;
	
	@FindBy(how = How.LINK_TEXT, using = "Next")
	public WebElement tgq_next_btn;

	WebDriver ldriver;

	public TGQ_Validate_Quote_Page(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void validateQuote() throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {
			Select signup_paperless_val = new Select(signup_paperless);
			signup_paperless_val.selectByVisibleText("No");
			if (MyWebElement.isElementExistwithid("quoteBean.primaryAccountAlertsOptInPreference.writableValue")) {
				Select account_alerts_val = new Select(account_alerts);
				account_alerts_val.selectByVisibleText("Call");
			}

			Select closing_method_val = new Select(closing_method);
			closing_method_val.selectByVisibleText("eSign");
			if (MyWebElement.isElementExistwithid("quoteBean.accessEmail.value")&& !(emailRow.getAttribute("style").equals("display: none;"))) {
				MyWebElement.enterText(confirm_email, currentHash.get("Emailid"));
			}
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "ValidateQuote Tab.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "ValidateQuote",
					System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "ValidateQuote Tab.png");
			MyWebElement.clickOn(tgq_next_btn);
			Thread.sleep(4000);
		} catch (Exception exp) {
			log.error(exp.getMessage());

			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in Opening ValidateQuote Tab.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error while Opening ValidateQuote: </b></font><br />" + exp.getMessage()
							+ "<br />",
					System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in Opening ValidateQuote Tab.png");
			throwException("Unable To open the ValidateQuote \n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
