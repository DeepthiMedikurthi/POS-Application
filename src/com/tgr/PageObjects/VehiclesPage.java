package com.tgr.PageObjects;

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

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class VehiclesPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(VehiclesPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public VehiclesPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.ID, using = "yearOptions0")
	public WebElement year;
	@FindBy(how = How.ID, using = "makeOptions0")
	public WebElement make;
	@FindBy(how = How.ID, using = "modelOptions0")
	public WebElement model;
	@FindBy(how = How.ID, using = "typeOptions0")
	public WebElement type;
	@FindBy(how = How.ID, using = "calculatedMileage0")
	public WebElement annualMilage;
	@FindBy(how = How.ID, using = "ownOrLeaseOptions0")
	public WebElement ownOrLeaseOptions;
	@FindBy(how = How.ID, using = "yearOptions1")
	public WebElement year2;
	@FindBy(how = How.ID, using = "makeOptions1")
	public WebElement make2;
	@FindBy(how = How.ID, using = "modelOptions1")
	public WebElement model2;
	@FindBy(how = How.ID, using = "typeOptions1")
	public WebElement type2;
	@FindBy(how = How.ID, using = "ownOrLeaseOptions1")
	public WebElement ownOrLeaseOptions2;
	@FindBy(how = How.NAME, using = "vehicles[0].originalPriceDisplay")
	public WebElement originalVehCost;
	@FindBy(how = How.ID, using = "primaryVehicleUse0")
	public WebElement primaryVehicleUse;
	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicle1\"]/div[12]/div[1]/div/label[2]")
	public WebElement vehicleUse;
	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicle1\"]/div[13]/div/div/label[2]")
	public WebElement antiTheft;
	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicle2\"]/div[12]/div[1]/div/label[2]")
	public WebElement vehicleUse2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicle2\"]/div[13]/div/div/label[2]")
	public WebElement antiTheft2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"vehicle1\"]/div[14]/div/div/label[2]")
	public WebElement vinetch;
	@FindBy(how = How.LINK_TEXT, using = "here")
	public WebElement hereLink;
	@FindBy(how = How.LINK_TEXT, using = "Add another vehicle")
	public WebElement addVehicle;
	
	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void vehiclesInfo() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			// MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			if (currentHash.get("costNew").equals("No")) {
				Select yearOfVehicle = new Select(year);
				yearOfVehicle.selectByVisibleText("2008");
				Select makeOfVehicle = new Select(make);
				makeOfVehicle.selectByVisibleText("AUDI");
				Select modelOfVehicle = new Select(model);
				modelOfVehicle.selectByVisibleText("A3 3.2 QUATTRO S-LINE");
				Select typeOfVehicle = new Select(type);
				typeOfVehicle.selectByVisibleText("Wagon 4Dr 3.2-liter 6-Cyl");
				Select ownOrLeaseOptionsOfVehicle = new Select(ownOrLeaseOptions);
				ownOrLeaseOptionsOfVehicle.selectByVisibleText("Financed (making loan payments)");
			}
			else {
				
				Select yearOfVehicle = new Select(year);
				yearOfVehicle.selectByVisibleText(currentHash.get("veh_year"));
				hereLink.click();
				Select makeOfVehicle = new Select(make);
				makeOfVehicle.selectByVisibleText(currentHash.get("veh_make"));
				Thread.sleep(2000);
				Select modelOfVehicle = new Select(model);
				modelOfVehicle.selectByVisibleText(currentHash.get("veh_model"));
				Thread.sleep(2000);
				Select typeOfVehicle = new Select(type);
				typeOfVehicle.selectByVisibleText(currentHash.get("veh_type"));
				Thread.sleep(2000);
				Select ownOrLeaseOptionsOfVehicle = new Select(ownOrLeaseOptions);
				ownOrLeaseOptionsOfVehicle.selectByVisibleText("Financed (making loan payments)");
				MyWebElement.enterText(originalVehCost, currentHash.get("original_veh_cost"));
			}
			if (currentHash.get("state").equals("NC")) {
				Select primaryvehicleUse = new Select(primaryVehicleUse);
				primaryvehicleUse.selectByVisibleText("Pleasure");
			} else {
				vehicleUse.click();
			}
			if (MyWebElement.isButtonExist("//*[@id=\"vehicle1\"]/div[13]/div/div/label[2]")) {
				antiTheft.click();
			}
			if (MyWebElement.isButtonExist("//*[@id=\"vehicle1\"]/div[14]/div/div/label[2]")) {
				vinetch.click();
			}
		
			if (MyWebElement.isElementExistwithid("calculatedMileage0")) {
				Select annualmilage = new Select(annualMilage);
				annualmilage.selectByVisibleText("0 - 3,999");
			}
			if(currentHash.get("AdditionalVehicle").equals("Yes")) {
				addVehicle.click();
				Select yearOfVehicle = new Select(year2);
				yearOfVehicle.selectByVisibleText("2017");
				Select makeOfVehicle = new Select(make2);
				makeOfVehicle.selectByVisibleText("ACURA");
				Select modelOfVehicle = new Select(model2);
				modelOfVehicle.selectByVisibleText("ILX");
				Select typeOfVehicle = new Select(type2);
				typeOfVehicle.selectByVisibleText("Sedan 4Dr 2.4-liter 4-Cyl");
				Select ownOrLeaseOptionsOfVehicle = new Select(ownOrLeaseOptions2);
				ownOrLeaseOptionsOfVehicle.selectByVisibleText("Financed (making loan payments)");
				vehicleUse2.click();
				if (MyWebElement.isButtonExist("//*[@id=\"vehicle2\"]/div[13]/div/div/label[2]")) 
				antiTheft2.click();
			}
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_"  + testRunTimeStamp + "/" + "VehiclesPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "PASS","Cost-New",System.getProperty("user.dir")+"\\Results\\Screenshots_"  + testRunTimeStamp + "/"+ "VehiclesPage.png");
			continueLink.click();

		} catch (Exception e) {
			log.error(e.getMessage());
			Base.screenShot(System.getProperty("user.dir")+"\\Results\\Screenshots_"  + testRunTimeStamp + "/" + "Error in VehiclesPage.png");
			reportVar.logTestCaseStatusWithSnapShot(parentTestCase, "FAIL",
					"<font color=red><b>Error while verifying Cost-New: </b></font><br />" + e.getMessage() + "<br />",
							System.getProperty("user.dir")+"\\Results\\Screenshots_" + testRunTimeStamp + "/"
							+ "Error in VehiclesPage.png");
			throwException("UNABLE TO open INTO THE TGR APPLICATION FROM THE METHOD login\n" + e.getMessage() + "\n");
		} 
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");
	}

}
