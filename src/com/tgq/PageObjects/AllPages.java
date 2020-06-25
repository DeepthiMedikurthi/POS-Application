package com.tgq.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tgr.accelerators.Base;

public class AllPages extends Base {

	static WebDriver ldriver;

	public AllPages(WebDriver dr) {

		ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	
	public TGQ_RatingInfo_Page ratinginfo() {
		return new TGQ_RatingInfo_Page(ldriver);
	}

	public MarsApplicationLoginPage loginPage() {
		return new MarsApplicationLoginPage(ldriver);
	}
	public TGQ_New_Quote_Page newquote() {
		return new TGQ_New_Quote_Page(ldriver);
	}
	public TGQ_Quote_Edit_Page quotedit() {
		return new TGQ_Quote_Edit_Page(ldriver);
	}
	public TGQ_Drivers_Edit_Page driversedit() {
		return new TGQ_Drivers_Edit_Page(ldriver);
	}
	public TGQ_Vehicles_Edit_Page vehiclesedit() {
		return new TGQ_Vehicles_Edit_Page(ldriver);
	}
	public TGQ_Consumer_Questions_Page consumerquestions() {
		return new TGQ_Consumer_Questions_Page(ldriver);
	}
	public TGQ_Application_Questions_Page applicationQuestions() {
		return new TGQ_Application_Questions_Page(ldriver);
	}
	public TGQ_Validate_Quote_Page validatequote() {
		return new TGQ_Validate_Quote_Page(ldriver);
	}
	public TGQ_Payment_Page paymentTab() {
		return new TGQ_Payment_Page(ldriver);
	}
	public TGQ_Final_Policy_Page policy_page() {
		return new TGQ_Final_Policy_Page(ldriver);
	}
}