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
import com.tgr.Utilities.Excel;
import com.tgr.Utilities.MyOwnException;
import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class TGQ_Final_Policy_Page extends TGQAllPages {

	private static final Logger log = LogManager.getLogger(TGQ_Final_Policy_Page.class.getName());

	// Page Factory

	
	@FindBy(how = How.XPATH, using = "//*[@id='quoteSummaryTable']/tbody/tr[3]/td[2]")
	public WebElement quote_num;
	@FindBy(how = How.XPATH, using = "//*[@id='body']/form/table[3]/tbody/tr[3]/td[2]")
	public WebElement policy_num;
	WebDriver ldriver;

	public TGQ_Final_Policy_Page(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void policyPage() throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {
			
			MyWait.until(ldriver, "ELEMENT_VISIBLE", 50, policy_num);
			System.out.println(quote_num.getText()+"quote_num");
			quoteNumber=quote_num.getText();
			System.out.println(policy_num.getText()+"policy_num");
			System.out.println(quote_num.getText()+"/"+policy_num.getText());
			
			Excel.writeToExcelSheet(policy_num.getText(), quote_num.getText());
		
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Policy Tab.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","Final Policy Tab",System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/"	+ "Policy Tab.png");
			
		} catch (Exception exp) {
			log.error(exp.getMessage());
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in Opening Policy Tab.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error while Opening Policy Tab: </b></font><br />" + exp.getMessage() + "<br />",
							System.getProperty("user.dir")+"\\Results\\Screenshots_"+ testRunTimeStamp + "/"
							+ "Error in Opening Policy Tab.png");
			throwException("Unable To open the Policy Tab \n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
