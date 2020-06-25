package com.tgr.PageObjects;

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

public class VehicleDetailsPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(VehicleDetailsPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public VehicleDetailsPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================
	@FindBy(how = How.ID, using = "lhSearch0")
	public WebElement fin_style;
	@FindBy(how = How.ID, using = "lhSearch1")
	public WebElement fin2_style;
	@FindBy(how = How.NAME, using = "vehicles[0].vin.value")
	public WebElement vin;
	@FindBy(how = How.NAME, using = "vehicles[1].vin.value")
	public WebElement vin2;
	@FindBy(how = How.NAME, using = "vehicles[0].registrationState")
	public WebElement registrationState;
	@FindBy(how = How.NAME, using = "vehicles[1].registrationState")
	public WebElement registrationState2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicleDet1\"]/div[6]/div/div/div/label[2]")
	public WebElement existingDamage;
	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicleDet2\"]/div[6]/div/div/div/label[2]")
	public WebElement existingDamage2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"licensePlate0\"]")
	public WebElement licensePlate;
	@FindBy(how = How.XPATH, using = "//*[@id=\"licensePlate1\"]")
	public WebElement licensePlate2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicleDet1\"]/div[7]/div/div/div/label[2]")
	public WebElement existingDamageforNy;
	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicleDet1\"]/div[9]/div[1]/select")
	public WebElement owner;

	@FindBy(how = How.NAME, using = "org.apache.struts.taglib.html.BEAN[0].vehicles[0].lienHolder.lienholderId")
	public WebElement finc_leas_comp;
	@FindBy(how = How.NAME, using = "org.apache.struts.taglib.html.BEAN[1].vehicles[1].lienHolder.lienholderId")
	public WebElement finc_leas_comp2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[2]/div[3]/ul/li/b")
	public WebElement errorMessage;

	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicleDet1\"]/div[10]/div[1]/select")
	public WebElement coOwner;
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void vehicledetailsPage() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			// MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			MyWebElement.enterText(vin, currentHash.get("vin1"));
			Select liscstatus = new Select(registrationState);
			liscstatus.selectByVisibleText(currentHash.get("registrationState"));
			if (MyWebElement.isButtonExist("//*[@id=\"licensePlate0\"]"))
				MyWebElement.enterText(licensePlate, "456775");
			if (MyWebElement.isButtonExist("//*[@id=\"vehicleDet1\"]/div[6]/div/div/div/label[2]"))
				existingDamage.click();
			if (MyWebElement
					.isDropdownExist("org.apache.struts.taglib.html.BEAN[0].vehicles[0].lienHolder.lienholderId")
					&& !(fin_style.getAttribute("style").equals("display: none;"))) {
				Select comp = new Select(finc_leas_comp);
				comp.selectByIndex(1);
			}

			if (MyWebElement.isButtonExist("//*[@id=\"vehicleDet1\"]/div[7]/div/div/div/label[2]"))
				existingDamageforNy.click();
			if (MyWebElement.isButtonExist("//*[@id=\"vehicleDet1\"]/div[9]/div[1]/select")) {
				Select Owner = new Select(owner);
				Owner.selectByIndex(1);
				;
			}
			if (MyWebElement.isButtonExist("//*[@id=\"vehicleDet1\"]/div[10]/div[1]/select")) {
				Select cowner = new Select(coOwner);
				cowner.selectByIndex(0);
				;
			}
			if (currentHash.get("AdditionalVehicle").equals("Yes")) {
				MyWebElement.enterText(vin2, currentHash.get("vin2"));
				Select liscstatus2 = new Select(registrationState2);
				liscstatus2.selectByVisibleText(currentHash.get("registrationState"));
				if (MyWebElement.isButtonExist("//*[@id=\"licensePlate1\"]"))
					MyWebElement.enterText(licensePlate2, "456775");
				if (MyWebElement.isButtonExist("//*[@id=\"vehicleDet2\"]/div[6]/div/div/div/label[2]"))
					existingDamage2.click();
				if (MyWebElement
						.isDropdownExist("org.apache.struts.taglib.html.BEAN[1].vehicles[1].lienHolder.lienholderId")
						&& !(fin2_style.getAttribute("style").equals("display: none;"))) {
					Select comp = new Select(finc_leas_comp2);
					comp.selectByIndex(1);
				}
			}
			continueLink.click();
			if (MyWebElement.isButtonExist("//*[@id=\"content_table\"]/div[2]/div[3]/ul/li/b")) {
				if (errorMessage.getText().contains("We are unable to verify the VIN entered for vehicle")) {

					continueLink.click();
					continueLink.click();
				}
			}
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
