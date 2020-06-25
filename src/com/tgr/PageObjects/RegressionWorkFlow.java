package com.tgr.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tgq.TGQPageObjects.MarsApplicationLoginPage;
import com.tgq.TGQPageObjects.TGQAllPages;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

public class RegressionWorkFlow extends Base {

	private static final Logger log = LogManager.getLogger(RegressionWorkFlow.class.getName());
	public void openMyPolicy() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			myPolicytrackerspages.loginPage().initiateBrowser();
			driver.navigate().to(configProps.getProperty("TGRURL"));
			myPolicytrackerspages.loginPage().loginMypolicy();
			myPolicytrackerspages.generalInfoPage().generalInfoMypolicy();
			myPolicytrackerspages.addDriverPage().addDriverMypolicy();
			myPolicytrackerspages.driversPage().driversInfoMypolicy();
			myPolicytrackerspages.vehcilesPage().vehiclePageMypolicy();
			trackerspages.quotePage().quoteInfo();
			trackerspages.applicationQuestionsPage().applicationQuestions();
			myPolicytrackerspages.driverDetailsPage().driverdetailMypolicy();
			trackerspages.finalReviewPage().finalreviewPage();
			trackerspages.orderReportCreditsPage().orderreportCreditsPage();
			trackerspages.orderReportsMVRPage().orderReportsMVR();
			trackerspages.orderReportsMVRProcessPage().orderReportsMVRProcess();
			trackerspages.contactInformarionPage().contactinformarionPage();
			trackerspages.paymentSelectionpage().paymentselectionpage();
			trackerspages.creditDebitCardPaymentPage().creditdebitCardPaymentPage();
			trackerspages.grabpolicyNum().grabPolicyNum();
			trackerspages.eSign().esign();

		} catch (Exception exp) {
			log.error(exp.getMessage());

		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}
	public void openTGRgSign() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			trackerspages.mainPage().initiateBrowser();
			driver.navigate().to(configProps.getProperty("TGRURL"));
			trackerspages.mainPage().ClickOnstartQuote();
			trackerspages.generalInfoPage().generalInfo();
			trackerspages.driversPage().driversInfo();
			trackerspages.vehiclesPage().vehiclesInfo();
			trackerspages.quotePage().quoteInfo();
			trackerspages.ExcludedDriverpage().excludedDriverInfo();
			trackerspages.addressPagePage().addressInfo();
			trackerspages.applicationQuestionsPage().applicationQuestions();
			trackerspages.driverdetailsPage().driverDetailsPage();
			trackerspages.vehicleDetailsPage().vehicledetailsPage();
			trackerspages.finalReviewPage().finalreviewPage();
			trackerspages.orderReportCreditsPage().orderreportCreditsPage();
			trackerspages.orderReportsMVRPage().orderReportsMVR();
			trackerspages.orderReportsMVRProcessPage().orderReportsMVRProcess();
			trackerspages.contactInformarionPage().contactinformarionPage();
			trackerspages.paymentSelectionpage().paymentselectionpage();
			trackerspages.creditDebitCardPaymentPage().creditdebitCardPaymentPage();
			trackerspages.grabpolicyNum().grabPolicyNum();
			trackerspages.eSign().esign();

		} catch (Exception exp) {
			log.error(exp.getMessage());

		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}
	public void openTGReSign() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			trackerspages.mainPage().initiateBrowser();
			driver.navigate().to(configProps.getProperty("TGRURL"));
			TGQAllPages allPages = new TGQAllPages(driver);
			trackerspages.mainPage().ClickOnstartQuote();
			trackerspages.generalInfoPage().generalInfo();
			trackerspages.driversPage().driversInfo();
			trackerspages.vehiclesPage().vehiclesInfo();
			trackerspages.quotePage().quoteInfo();
			trackerspages.ExcludedDriverpage().excludedDriverInfo();
			trackerspages.addressPagePage().addressInfo();
			trackerspages.applicationQuestionsPage().applicationQuestions();
			trackerspages.driverdetailsPage().driverDetailsPage();
			trackerspages.vehicleDetailsPage().vehicledetailsPage();
			trackerspages.finalReviewPage().finalreviewPage();
			trackerspages.orderReportCreditsPage().orderreportCreditsPage();
			trackerspages.orderReportsMVRPage().orderReportsMVR();
			trackerspages.orderReportsMVRProcessPage().orderReportsMVRProcess();
			trackerspages.contactInformarionPage().contactinformarionPage();
			trackerspages.paymentSelectionpage().paymentselectionpage();
			trackerspages.creditDebitCardPaymentPage().creditdebitCardPaymentPage();
			trackerspages.grabpolicyNum().grabPolicyNum();
			allPages.esign().ESIgn();

		} catch (Exception exp) {
			log.error(exp.getMessage());

		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}

	public void openTGQeSign() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			tgQTrackerspages.loginPage().initiateTGQBrowser();
			driver.navigate().to(configProps.getProperty("TGQURL"));
			MarsApplicationLoginPage m = new MarsApplicationLoginPage(driver);
			TGQAllPages allPages = new TGQAllPages(driver);
			m.login();
			allPages.homePage().homepage();
			allPages.newquote().newQuote();
			allPages.ratinginfo().ratingInfo();
			allPages.quotedit().quotEdit();
			allPages.driversedit().driversEdit();
			allPages.vehiclesedit().vehiclesEdit();
			allPages.consumerquestions().consumerQuestions();
			allPages.applicationQuestions().applicationquestions();
			allPages.validatequote().validateQuote();
			allPages.paymentTab().paymenttab();
			allPages.policy_page().policyPage();
			allPages.esign().ESIgn();
		} catch (Exception exp) {
			log.error(exp.getMessage());

		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}
	public void openTGQvSign() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			tgQTrackerspages.loginPage().initiateTGQBrowser();
			driver.navigate().to(configProps.getProperty("TGQURL"));
			MarsApplicationLoginPage m = new MarsApplicationLoginPage(driver);
			TGQAllPages allPages = new TGQAllPages(driver);
			m.login();
			allPages.homePage().homepage();
			allPages.newquote().newQuote();
			allPages.ratinginfo().ratingInfo();
			allPages.quotedit().quotEdit();
			allPages.driversedit().driversEdit();
			allPages.vehiclesedit().vehiclesEdit();
			allPages.consumerquestions().consumerQuestions();
			allPages.applicationQuestions().applicationquestions();
			allPages.validatequote().validateQuote();
			allPages.paymentTab().paymenttab();
			allPages.policy_page().policyPage();
			allPages.vsign().VSIgn();
		} catch (Exception exp) {
			log.error(exp.getMessage());

		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}

	public void openAgentTGR() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			trackerspages.agentlogin().initiateBrowser();
			driver.navigate().to(configProps.getProperty("TGRAgentURL"));
			trackerspages.agentlogin().agentLogin();
			trackerspages.agenthome().agentHome();
			trackerspages.agentQuotesearch().agentQuoteSearch();
			trackerspages.agentnewquote().agentNewQuote();
			trackerspages.generalInfoPage().generalInfo();
			trackerspages.driversPage().driversInfo();
			trackerspages.vehiclesPage().vehiclesInfo();
			trackerspages.quotePage().quoteInfo();
			// trackerspages.policydetailPage().policydetail();
			trackerspages.addressPagePage().addressInfo();
			trackerspages.applicationQuestionsPage().applicationQuestions();
			trackerspages.driverdetailsPage().driverDetailsPage();
			trackerspages.vehicleDetailsPage().vehicledetailsPage();
			trackerspages.finalReviewPage().finalreviewPage();
			trackerspages.orderReportCreditsPage().orderreportCreditsPage();
			trackerspages.orderReportsMVRPage().orderReportsMVR();
			trackerspages.orderReportsMVRProcessPage().orderReportsMVRProcess();
			  trackerspages.contactInformarionPage().contactinformarionPage();
			  trackerspages.paymentSelectionpage().paymentselectionpage();
			  trackerspages.creditDebitCardPaymentPage().creditdebitCardPaymentPage();
			  trackerspages.grabpolicyNum().grabPolicyNum();
				TGQAllPages allPages = new TGQAllPages(driver);
				allPages.esign().ESIgn();

		} catch (Exception exp) {
			log.error(exp.getMessage());

		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}

	public void openTGRGeneralInfo() throws InterruptedException, MyOwnException {

		try {
			trackerspages.mainPage().initiateBrowser();
			driver.navigate().to(configProps.getProperty("TGRURL"));
			trackerspages.mainPage().ClickOnstartQuote();
			trackerspages.generalInfoPageforHomeOwners().generalInfo();

		} catch (Exception exp) {
			log.error(exp.getMessage());

		}
	}
}
