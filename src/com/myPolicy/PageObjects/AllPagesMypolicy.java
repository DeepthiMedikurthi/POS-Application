package com.myPolicy.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

public class AllPagesMypolicy extends Base {

	static WebDriver ldriver;

	public AllPagesMypolicy(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}


	// ========================= PAGE METHODS ============================

	
	public LoginMyPolicy loginPage() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "RefillPolicy");
		reportVar.assignCategoryToTestCase(parentTestCase, "RefillPolicy");
		return new LoginMyPolicy(ldriver);
	}
	public GeneralInfoPage generalInfoPage() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "GeneralInfoPage");
		reportVar.assignCategoryToTestCase(parentTestCase, "GeneralInfoPage");
		return new GeneralInfoPage(ldriver);
	}
	public AdditionalDriverpage addDriverPage() {
		return new AdditionalDriverpage(ldriver);
	}
	public DriversPage driversPage() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "DriversPage");
		reportVar.assignCategoryToTestCase(parentTestCase, "DriversPage");
		return new DriversPage(ldriver);
	}
	public VehiclePage vehcilesPage() {
		return new VehiclePage(ldriver);
	}
	public DriversDetailsPage driverDetailsPage() {
		return new DriversDetailsPage(ldriver);
	}
	
}
