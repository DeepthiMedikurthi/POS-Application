package com.tgq.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tgr.accelerators.Base;
import com.tgr.Utilities.MyOwnException;
import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class TGQ_Quote_Edit_Page extends AllPages {

	private static final Logger log = LogManager.getLogger(TGQ_Quote_Edit_Page.class.getName());

	// Page Factory

	@FindBy(how = How.NAME, using = "quoteBean.vehicles[0].compDed.writableValue")
	public WebElement comp_ded;
	@FindBy(how = How.NAME, using = "quoteBean.vehicles[0].collDed.writableValue")
	public WebElement coll_ded;
	@FindBy(how = How.ID, using = "quoteBean.vehicles[0].towingLimit.writableValue")
	public WebElement towing;
	@FindBy(how = How.XPATH, using = "//*[@id='body']/form/div[6]/table/tbody/tr/td[3]/a")
	public WebElement recalculate_button;
	@FindBy(how = How.LINK_TEXT, using = "Next")
	public WebElement next_button;
	@FindBy(how = How.ID, using = "quoteBean.rentalLimit.writableValue")
	public WebElement rental_reim;
	WebDriver ldriver;

	public TGQ_Quote_Edit_Page(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void quotedit(String applicationType) throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		// System.out.println("EGFIKEDBGKBGDSBGJDGBDKGBSKGSDBGKDS");
		try {
			if (!currentHash.get("CompDed").equals("Nil")) {
				Select comp_ded_q = new Select(comp_ded);
				comp_ded_q.selectByVisibleText(currentHash.get("CompDed"));
			}
			if (!currentHash.get("CollDed").equals("Nil")) {
				Select coll_ded_q = new Select(coll_ded);
				coll_ded_q.selectByVisibleText(currentHash.get("CollDed"));
			}
			if (!currentHash.get("Towing&Labour").equals("Nil")) {
				Select towing_q = new Select(towing);
				towing_q.selectByVisibleText(currentHash.get("Towing&Labour"));
			}
			if (!currentHash.get("RentalReim").equals("Nil")) {
				Select rental_reim_cov = new Select(rental_reim);
				rental_reim_cov.selectByVisibleText(currentHash.get("RentalReim"));
			}
			if (!currentHash.get("Towing&Labour").equals("Nil")) {
				recalculate_button.click();
			}

			next_button.click();
			Thread.sleep(4000);
		} catch (Exception exp) {
			log.error(exp.getMessage());

			throwException("Unable To create  " + applicationType + "application \n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
