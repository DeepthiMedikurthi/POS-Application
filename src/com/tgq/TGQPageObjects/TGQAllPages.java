package com.tgq.TGQPageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.support.PageFactory;

import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

public class TGQAllPages extends Base {

	static WebDriver ldriver;

	public TGQAllPages(WebDriver dr) {

		ldriver = dr;

		PageFactory.initElements(dr, this);
	}

	public static Timeouts getImplicitWait() {
		return ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public eSign esign() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "eSign_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "eSign_Page");
		return new eSign(ldriver);
	}

	public vSign vsign() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "vSign_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "vSign_Page");
		return new vSign(ldriver);
	}

	public TGQ_RatingInfo_Page ratinginfo() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "TGQ_RatingInfo_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "TGQ_RatingInfo_Page");
		return new TGQ_RatingInfo_Page(ldriver);
	}

	public MarsApplicationLoginPage loginPage() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "MarsApplicationLoginPage");
		reportVar.assignCategoryToTestCase(parentTestCase, "MarsApplicationLoginPage");
		return new MarsApplicationLoginPage(ldriver);
	}

	public MarsHomePage homePage() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "MarsHomePage");
		reportVar.assignCategoryToTestCase(parentTestCase, "MarsHomePage");
		return new MarsHomePage(ldriver);
	}

	public TGQ_New_Quote_Page newquote() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "TGQ_New_Quote_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "TGQ_New_Quote_Page");
		return new TGQ_New_Quote_Page(ldriver);
	}

	public TGQ_Quote_Edit_Page quotedit() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "TGQ_Quote_Edit_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "TGQ_Quote_Edit_Page");
		return new TGQ_Quote_Edit_Page(ldriver);
	}

	public TGQ_Drivers_Edit_Page driversedit() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "TGQ_Drivers_Edit_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "TGQ_Drivers_Edit_Page");
		return new TGQ_Drivers_Edit_Page(ldriver);
	}

	public TGQ_Vehicles_Edit_Page vehiclesedit() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "TGQ_Vehicles_Edit_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "TGQ_Vehicles_Edit_Page");
		return new TGQ_Vehicles_Edit_Page(ldriver);
	}

	public TGQ_Consumer_Questions_Page consumerquestions() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "TGQ_Consumer_Questions_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "TGQ_Consumer_Questions_Page");
		return new TGQ_Consumer_Questions_Page(ldriver);
	}

	public TGQ_Application_Questions_Page applicationQuestions() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "TGQ_Application_Questions_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "TGQ_Application_Questions_Page");
		return new TGQ_Application_Questions_Page(ldriver);
	}

	public TGQ_Validate_Quote_Page validatequote() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "TGQ_Validate_Quote_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "TGQ_Validate_Quote_Page");
		return new TGQ_Validate_Quote_Page(ldriver);
	}

	public TGQ_Payment_Page paymentTab() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "TGQ_Payment_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "TGQ_Payment_Page");
		return new TGQ_Payment_Page(ldriver);
	}

	public TGQ_Final_Policy_Page policy_page() throws MyOwnException {
		parentTestCase = reportVar.makeTestCaseEntry(report, "TGQ_Final_Policy_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "TGQ_Final_Policy_Page");
		return new TGQ_Final_Policy_Page(ldriver);
	}
}