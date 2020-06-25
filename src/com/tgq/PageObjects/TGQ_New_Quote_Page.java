package com.tgq.PageObjects;

import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tgr.accelerators.Base;
import com.tgr.Utilities.MyOwnException;
import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class TGQ_New_Quote_Page extends AllPages {

	private static final Logger log = LogManager.getLogger(TGQ_New_Quote_Page.class.getName());

	// Page Factory
	@FindBy(xpath = "//*[@name='newQuoteBean.allowableStates.realValue']")
	public WebElement tgq_state;
	@FindBy(how = How.ID, using = "newQuoteBean.policyTypeHelper.value")
	public WebElement tgq_policy_type;
	@FindBy(how = How.ID, using = "referralLocationCodeInputField")
	public WebElement tgq_zip_code;
	@FindBy(how = How.LINK_TEXT, using = "Next")
	public WebElement tgq_next;
	@FindBy(how = How.NAME, using = "newQuoteBean.effectiveDate.mo")
	public WebElement tgq_eff_mnth;
	@FindBy(how = How.NAME, using = "newQuoteBean.effectiveDate.dy")
	public WebElement tgq_eff_date;
	@FindBy(how = How.NAME, using = "newQuoteBean.effectiveDate.yr")
	public WebElement tgq_eff_year;

	WebDriver ldriver;

	public TGQ_New_Quote_Page(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void newquote(String applicationType) throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {
			for (String handle1 : ldriver.getWindowHandles()) {				
				ldriver.switchTo().window(handle1);
				ldriver.getTitle();
				ldriver.manage().window().maximize();
			}
			Thread.sleep(3000);			
			Select state = new Select(tgq_state);
			state.selectByVisibleText(currentHash.get("QuoteState"));
			// MyWebElement.enterText(tgq_state, prop.getProperty("tgq_state"));
			Select policy_type = new Select(tgq_policy_type);
			policy_type.selectByVisibleText(currentHash.get("PolicyType"));
			// MyWebElement.enterText(tgq_policy_type, prop.getProperty("tgq_policy_type"));

			MyWebElement.enterText(tgq_zip_code, currentHash.get("ZipCode"));
			// MyWebElement.enterText(tgq_eff_mnth, prop.getProperty("tgq_eff_mnth"));
			// MyWebElement.enterText(tgq_eff_date, prop.getProperty("TGQUserName"));
			// MyWebElement.enterText(tgq_eff_year, prop.getProperty("TGQPassword"));
			
			MyWait.until(driver, "ELEMENT_CLICKABLE", 30, tgq_next);
			MyWebElement.clickOn(tgq_next);

		} catch (Exception exp) {
			log.error(exp.getMessage());
			
			throwException(
					"Unable To Create New Quote " + applicationType + "application \n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
