package com.tgq.TGQPageObjects;

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

import wrapper.classes.methods.MyWebElement;

public class TGQ_Application_Questions_Page extends TGQAllPages {

	private static final Logger log = LogManager.getLogger(TGQ_Application_Questions_Page.class.getName());

	// Page Factory

	@FindBy(how = How.NAME, using = "quoteBean.appQuestions[0].writableValue")
	public WebElement appQuestions_1;
	@FindBy(how = How.NAME, using = "quoteBean.appQuestions[1].writableValue")
	public WebElement appQuestions_2;
	@FindBy(how = How.NAME, using = "quoteBean.appQuestions[2].writableValue")
	public WebElement appQuestions_3;
	@FindBy(how = How.NAME, using = "quoteBean.appQuestions[3].writableValue")
	public WebElement appQuestions_4;
	@FindBy(how = How.NAME, using = "quoteBean.appQuestions[4].writableValue")
	public WebElement appQuestions_5;
	@FindBy(how = How.NAME, using = "quoteBean.appQuestions[5].writableValue")
	public WebElement appQuestions_6;
	@FindBy(how = How.NAME, using = "quoteBean.appQuestions[6].writableValue")
	public WebElement appQuestions_7;
	@FindBy(how = How.NAME, using = "quoteBean.appQuestions[7].writableValue")
	public WebElement appQuestions_8;
	@FindBy(how = How.NAME, using = "quoteBean.appQuestions[8].writableValue")
	public WebElement appQuestions_9;
	@FindBy(how = How.NAME, using = "quoteBean.appQuestions[9].writableValue")
	public WebElement appQuestions_10;
	@FindBy(how = How.NAME, using = "quoteBean.businessUseQuestions[0].writableValue")
	public WebElement businessQuestions_1;
	@FindBy(how = How.NAME, using = "quoteBean.businessUseQuestions[1].writableValue")
	public WebElement businessQuestions_2;
	@FindBy(how = How.NAME, using = "quoteBean.businessUseQuestions[2].writableValue")
	public WebElement businessQuestions_3;
	@FindBy(how = How.NAME, using = "quoteBean.businessUseQuestions[3].writableValue")
	public WebElement businessQuestions_4;
	@FindBy(how = How.NAME, using = "quoteBean.businessUseQuestions[4].writableValue")
	public WebElement businessQuestions_5;
	@FindBy(how = How.NAME, using = "quoteBean.businessUseQuestions[5].writableValue")
	public WebElement businessQuestions_6;
	@FindBy(how = How.NAME, using = "quoteBean.businessUseQuestions[6].writableValue")
	public WebElement businessQuestions_7;
	@FindBy(how = How.LINK_TEXT, using = "Next")
	public WebElement next_button;

	WebDriver ldriver;

	public TGQ_Application_Questions_Page(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void applicationquestions() throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {
			if (!(currentHash.get("QuoteState").equals("CO"))&&!(currentHash.get("QuoteState").equals("FL")) ) {
				Select appQue_1 = new Select(appQuestions_1);
				appQue_1.selectByVisibleText("No");
				if (!currentHash.get("PolicyType").equals("Bond - No Credit")) {
					if (MyWebElement.isElementExistwithid("quoteBean.appQuestions[1].writableValue")) {
						Select appQue_2 = new Select(appQuestions_2);
						appQue_2.selectByVisibleText("No");
					}
				} else {
					if (MyWebElement.isElementExistwithid("quoteBean.appQuestions[2].writableValue")) {

						Select appQue_2 = new Select(appQuestions_2);
						appQue_2.selectByVisibleText("Yes");
					}

				}
				if (currentHash.get("BusUse").equals("Yes")) {
					Select appQue_3 = new Select(appQuestions_3);
					appQue_3.selectByVisibleText("Yes");
				} else if (!currentHash.get("QuoteState").equals("NC")) {
					Select appQue_3 = new Select(appQuestions_3);
					appQue_3.selectByVisibleText("No");
				} else {
					Select appQue_3 = new Select(appQuestions_3);
					appQue_3.selectByVisibleText("Yes");
				}
				if (currentHash.get("QuoteState").equals("NC")) {
					Select appQue_4 = new Select(appQuestions_4);
					appQue_4.selectByVisibleText("Yes");
				}

				if (!currentHash.get("PolicyType").equals("Bond - No Credit")
						&& (!currentHash.get("QuoteState").equals("NC"))) {
					Select appQue_4 = new Select(appQuestions_4);
					appQue_4.selectByVisibleText("No");
					Select appQue_5 = new Select(appQuestions_5);
					appQue_5.selectByVisibleText("Yes");
					Select appQue_6 = new Select(appQuestions_6);
					appQue_6.selectByVisibleText("Yes");
				}
				if (MyWebElement.isElementExistwithid("quoteBean.appQuestions[6].writableValue")) {
					Select appQue_7 = new Select(appQuestions_7);
					appQue_7.selectByVisibleText("No");
				}
				if (MyWebElement.isElementExistwithid("quoteBean.appQuestions[7].writableValue")) {
					Select appQue_8 = new Select(appQuestions_8);
					appQue_8.selectByVisibleText("No");
				}
				if (currentHash.get("BusUse").equals("Yes")) {
					Select busQue_1 = new Select(businessQuestions_1);
					busQue_1.selectByVisibleText("No");
					Select busQue_2 = new Select(businessQuestions_2);
					busQue_2.selectByVisibleText("No");
					Select busQue_3 = new Select(businessQuestions_3);
					busQue_3.selectByVisibleText("No");
					Select busQue_4 = new Select(businessQuestions_4);
					busQue_4.selectByVisibleText("No");
					Select busQue_5 = new Select(businessQuestions_5);
					busQue_5.selectByVisibleText("No");
					Select busQue_6 = new Select(businessQuestions_6);
					busQue_6.selectByVisibleText("No");
					Select busQue_7 = new Select(businessQuestions_7);
					busQue_7.selectByVisibleText("No");
				}
			}
			if ((currentHash.get("QuoteState").equals("FL"))) {
				Select busQue_1 = new Select(appQuestions_1);
				busQue_1.selectByVisibleText("Yes");
				Select busQue_2 = new Select(appQuestions_2);
				busQue_2.selectByVisibleText("Yes");
				Select busQue_3 = new Select(appQuestions_3);
				busQue_3.selectByVisibleText("Yes");
				Select busQue_4 = new Select(appQuestions_4);
				busQue_4.selectByVisibleText("Yes");
				Select busQue_5 = new Select(appQuestions_5);
				busQue_5.selectByVisibleText("Yes");
				Select busQue_6 = new Select(appQuestions_6);
				busQue_6.selectByVisibleText("No");
				Select busQue_7 = new Select(appQuestions_7);
				busQue_7.selectByVisibleText("No");
				Select busQue_8 = new Select(appQuestions_8);
				busQue_8.selectByVisibleText("No");
				Select busQue_9 = new Select(appQuestions_9);
				busQue_9.selectByVisibleText("No");
				Select busQue_10 = new Select(appQuestions_10);
				busQue_10.selectByVisibleText("No");
			}
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Application questions Tab.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","Opened Application questions Tab",System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/"	+ "Application questions Tab.png");
			next_button.click();
			Thread.sleep(4000);
		} catch (Exception exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in Opening Application questions Tab.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error while Opening Application questions Tab: </b></font><br />" + exp.getMessage() + "<br />",
							System.getProperty("user.dir")+"\\Results\\Screenshots_"+ testRunTimeStamp + "/"
							+ "Error in Opening Application questions Tab.png");
			throwException("Unable To open the Application questions Tab \n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
