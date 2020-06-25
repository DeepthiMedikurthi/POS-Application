package com.tgq.PageObjects;

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

public class TGQ_Final_Policy_Page extends AllPages {

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

	public void policy_page(String applicationType) throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {
			MyWait.until(ldriver, "ELEMENT_VISIBLE", 50, policy_num);
			System.out.println(quote_num.getText()+"quote_num");
			System.out.println(policy_num.getText()+"policy_num");
			Excel.writeToExcelSheet(policy_num.getText(), quote_num.getText());
			
			
		} catch (Exception exp) {
			log.error(exp.getMessage());
			
			throwException("Unable To get Policy Number " + applicationType + "application \n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
