package com.tgq.TGQPageObjects;

import java.util.List;
import java.util.ListIterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class TGQ_New_Quote_Page extends TGQAllPages {

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
	@FindBy(how = How.XPATH, using = "//*[@id=\"zipInGarage\"]")
	public WebElement zipInGarage;
	@FindBy(how = How.ID, using = "enhancedContinueInsured")
	public WebElement enhancedContinue;
	@FindBy(how = How.ID, using = "enhancedTransfer")
	public WebElement enhancedTransfer;
	@FindBy(how = How.ID, using = "continueInsured")
	public WebElement continueInsured;
	@FindBy(how = How.ID, using = "homeownerDiscount")
	public WebElement homeownerDisc;
	@FindBy(how = How.ID, using = "roadside")
	public WebElement roadsideAsst;
	String option = "";

	WebDriver ldriver;

	public TGQ_New_Quote_Page(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void newQuote() throws MyOwnException, InterruptedException {
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
			Select policy_type = new Select(tgq_policy_type);
			policy_type.selectByVisibleText(currentHash.get("PolicyType"));
			if (MyWebElement.isElementExistwithid("referralLocationCodeInputField"))
				MyWebElement.enterText(tgq_zip_code, currentHash.get("ZipCode"));
			else if (MyWebElement.isElementExistwithid("enhancedContinueInsured")
					&& !(enhancedTransfer.getAttribute("style").equals("display: none;"))) {
				MyWebElement.enterText(zipInGarage, currentHash.get("ZipCode"));
				Select enhance = new Select(enhancedContinue);
				List<WebElement> options = enhance.getOptions();

				for (int l = 0; l < options.size(); l++) {
					if (options.get(l).getText().equals("No: Other"))
						option = options.get(l).getText();
				}

				if (option.equals(""))
					option = "No";
				enhance.selectByVisibleText(option);
				Select homeownerDiscount = new Select(homeownerDisc);
				homeownerDiscount.selectByVisibleText(currentHash.get("HomeOwnerDisc"));
				Select roadsideAst = new Select(roadsideAsst);
				roadsideAst.selectByVisibleText("No");
			} else {
				MyWebElement.enterText(zipInGarage, currentHash.get("ZipCode"));
				Select enhance = new Select(continueInsured);
				List<WebElement> options = enhance.getOptions();
				System.out.println(options.toString());

				for (int l = 0; l < options.size(); l++) {
					if (options.get(l).getText().equals("No: Other"))
						option = options.get(l).getText();
				}

				if (option.equals(""))
					option = "No";
				enhance.selectByVisibleText(option);
				Select homeownerDiscount = new Select(homeownerDisc);
				homeownerDiscount.selectByVisibleText(currentHash.get("HomeOwnerDisc"));
				Select roadsideAst = new Select(roadsideAsst);
				roadsideAst.selectByVisibleText("No");
			}

			MyWait.until(driver, "ELEMENT_CLICKABLE", 30, tgq_next);
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "New Quote Page.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "New Quote Page",
					System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "New Quote Page.png");
			MyWebElement.clickOn(tgq_next);

		} catch (Exception exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in Opening New Quote Page.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error while Opening New Quote Page: </b></font><br />" + exp.getMessage()
							+ "<br />",
					System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in Opening New Quote Page.png");
			throwException("Unable To open the New Quote Page \n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
