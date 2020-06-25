package com.tgr.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

public class AllPages extends Base {

	static WebDriver ldriver;

	public AllPages(WebDriver driver) {
		ldriver = driver;
		PageFactory.initElements(driver, this);
	}


	// ========================= PAGE METHODS ============================

	public AgentLogin agentlogin() {
		//System.out.println("MainPage");
		return new AgentLogin(ldriver);
	}
	public AgentHome agenthome() {
		//System.out.println("MainPage");
		return new AgentHome(ldriver);
	}
	public AgentQuoteSearch agentQuotesearch() {
		//System.out.println("MainPage");
		return new AgentQuoteSearch(ldriver);
	}
	public AgentNewQuote agentnewquote() {
		//System.out.println("MainPage");
		return new AgentNewQuote(ldriver);
	}
	public MainPage mainPage() {
		//System.out.println("MainPage");
		return new MainPage(ldriver);
	}
	public ExcludedDriverPage ExcludedDriverpage() {
		//System.out.println("MainPage");
		return new ExcludedDriverPage(ldriver);
	}
	public com.tgq.homeOwners.GeneralInfoPage generalInfoPageforHomeOwners() {
		//System.out.println("MainPage");
		return new com.tgq.homeOwners.GeneralInfoPage(ldriver);
	}
	public GeneralInfoPage generalInfoPage() throws MyOwnException {
		//System.out.println("MainPage");
		parentTestCase = reportVar.makeTestCaseEntry(report, "GeneralInfoPage");
		reportVar.assignCategoryToTestCase(parentTestCase, "GeneralInfoPage");
		return new GeneralInfoPage(ldriver);
	}
	public DriversPage driversPage() throws MyOwnException {
		//System.out.println("MainPage");
		parentTestCase = reportVar.makeTestCaseEntry(report, "DriversPage");
		reportVar.assignCategoryToTestCase(parentTestCase, "DriversPage");
		return new DriversPage(ldriver);
	}
	public VehiclesPage vehiclesPage() throws MyOwnException {
		//System.out.println("MainPage");
		parentTestCase = reportVar.makeTestCaseEntry(report, "Vehicles_Page");
		reportVar.assignCategoryToTestCase(parentTestCase, "Vehicles_Page");
		return new VehiclesPage(ldriver);
	}
	public Quotepage quotePage() throws MyOwnException {
		//System.out.println("MainPage");
		parentTestCase = reportVar.makeTestCaseEntry(report, "Quotepage");
		reportVar.assignCategoryToTestCase(parentTestCase, "Quotepage");
		return new Quotepage(ldriver);
	}
	public Policydetail policydetailPage() {
		//System.out.println("MainPage");
		return new Policydetail(ldriver);
	}
	public AddressPage addressPagePage() {
		//System.out.println("MainPage");
		return new AddressPage(ldriver);
	}
	
	public ApplicationQuestionsPage applicationQuestionsPage() {
		//System.out.println("MainPage");
		return new ApplicationQuestionsPage(ldriver);
	}
	public DriverdetailsPage driverdetailsPage() {
		//System.out.println("MainPage");
		return new DriverdetailsPage(ldriver);
	}
	public VehicleDetailsPage vehicleDetailsPage() {
		//System.out.println("MainPage");
		return new VehicleDetailsPage(ldriver);
	}
	public FinalReviewPage finalReviewPage() throws MyOwnException {
		//System.out.println("MainPage");
		parentTestCase = reportVar.makeTestCaseEntry(report, "FinalReviewPage");
		reportVar.assignCategoryToTestCase(parentTestCase, "FinalReviewPage");
		return new FinalReviewPage(ldriver);
	}
	public OrderReportCreditsPage orderReportCreditsPage() {
		//System.out.println("MainPage");
		return new OrderReportCreditsPage(ldriver);
	}
	public OrderReportsMVRPage orderReportsMVRPage() {
		//System.out.println("MainPage");
		return new OrderReportsMVRPage(ldriver);
	}
	public OrderReportsMVRProcessPage orderReportsMVRProcessPage() {
		//System.out.println("MainPage");
		return new OrderReportsMVRProcessPage(ldriver);
	}
	public ContactinformarionPage contactInformarionPage() {
		//System.out.println("MainPage");
		return new ContactinformarionPage(ldriver);
	}
	public PaymentSelectionpage paymentSelectionpage() {
		//System.out.println("MainPage");
		return new PaymentSelectionpage(ldriver);
	}
	public CreditDebitCardPaymentPage creditDebitCardPaymentPage() {
		//System.out.println("MainPage");
		return new CreditDebitCardPaymentPage(ldriver);
	}
	public GrabPolicyNum grabpolicyNum() throws MyOwnException {
		//System.out.println("MainPage");
		parentTestCase = reportVar.makeTestCaseEntry(report, "GrabPolicyNum");
		reportVar.assignCategoryToTestCase(parentTestCase, "GrabPolicyNum");
		return new GrabPolicyNum(ldriver);
	}
	public ESign eSign() throws MyOwnException {
		//System.out.println("MainPage");
		parentTestCase = reportVar.makeTestCaseEntry(report, "ESign");
		reportVar.assignCategoryToTestCase(parentTestCase, "ESign");
		return new ESign(ldriver);
	}
	
}
