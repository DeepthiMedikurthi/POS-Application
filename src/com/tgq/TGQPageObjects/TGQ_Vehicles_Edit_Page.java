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

public class TGQ_Vehicles_Edit_Page extends TGQAllPages {

	private static final Logger log = LogManager.getLogger(TGQ_Vehicles_Edit_Page.class.getName());

	// Page Factory

	@FindBy(how = How.ID, using = "vehicles[0].ownershipType.writableValue")
	public WebElement ownership_type;
	@FindBy(how = How.ID, using = "vehicles[0].priorDamage.writableValue")
	public WebElement prior_damage;
	@FindBy(how = How.ID, using = "vehicles[0].registrationState.writableValue")
	public WebElement veh_reg_state;
	@FindBy(how = How.ID, using = "vehicles[0].antiTheft.writableValue")
	public WebElement antiTheft;
	@FindBy(how = How.ID, using = "vehicles[0].owner.writableValue")
	public WebElement owner;

	@FindBy(how = How.LINK_TEXT, using = "Recalculate")
	public WebElement recalculate_button;
	@FindBy(how = How.LINK_TEXT, using = "Next")
	public WebElement next_button;
	WebDriver ldriver;

	public TGQ_Vehicles_Edit_Page(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void vehiclesEdit() throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {
			if (!(currentHash.get("PolicyType").equals("Bond - No Credit"))
					&& !(currentHash.get("QuoteState").equals("CO"))
					&& !(currentHash.get("Type").equals("Non-Owner"))) {
				Select ownership_type_veh = new Select(ownership_type);
				ownership_type_veh.selectByVisibleText("Owned");
				if (MyWebElement.isElementExistwithid("vehicles[0].priorDamage.writableValue")) {
					Select prior_damage_veh = new Select(prior_damage);
					prior_damage_veh.selectByVisibleText("No");
				}
			}
			if (MyWebElement.isElementExistwithid("vehicles[0].registrationState.writableValue")) {
				Select veh_reg_state_veh = new Select(veh_reg_state);
				veh_reg_state_veh.selectByVisibleText(currentHash.get("QuoteState"));
			}
			if (MyWebElement.isElementExistwithid("vehicles[0].antiTheft.writableValue")) {
				Select veh_reg_state_veh = new Select(antiTheft);
				veh_reg_state_veh.selectByVisibleText("No");
			}
			if (MyWebElement.isElementExistwithid("vehicles[0].owner.writableValue")) {
				Select owner_veh = new Select(owner);
				owner_veh.selectByIndex(0);
			}
			// recalculate_button.click();
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "VehiclesEdit Tab.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS", "VehiclesEdit",
					System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "VehiclesEdit Tab.png");
			next_button.click();
			Thread.sleep(4000);
		} catch (Exception exp) {
			log.error(exp.getMessage());

			Base.screenShot(
					System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in Opening VehiclesEdit Tab.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error while Opening VehiclesEdit: </b></font><br />" + exp.getMessage()
							+ "<br />",
					System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/" + "Error in Opening ValidateQuote Tab.png");
			throwException("Unable To open the ValidateQuote \n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
