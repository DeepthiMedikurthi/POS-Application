package com.tgr.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.tgq.TGQPageObjects.MarsApplicationLoginPage;
import com.tgq.TGQPageObjects.TGQAllPages;
import com.tgr.Utilities.MyOwnException;
import com.tgr.accelerators.Base;

public class SmoketestWorkFlow extends Base {

	private static final Logger log = LogManager.getLogger(SmoketestWorkFlow.class.getName());

	public void openTGR() throws InterruptedException, MyOwnException {

		log.info("WORKFLOW(newTrackerListingProcess) EXECUTION STARTED SUCCESSFULLY");
		try {
			trackerspages.mainPage().initiateBrowser();
			driver.navigate().to(configProps.getProperty("TGRURL"));
			trackerspages.mainPage().ClickOnstartQuote();
			trackerspages.generalInfoPage().generalInfo();
			trackerspages.driversPage().driversInfo();
			trackerspages.vehiclesPage().vehiclesInfo();
			trackerspages.quotePage().quoteInfo();

		} catch (Exception exp) {
			log.error(exp.getMessage());

		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}

	public void openTGQ() throws InterruptedException, MyOwnException {

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
			//allPages.quotedit().quotEdit();

		} catch (Exception exp) {
			log.error(exp.getMessage());

		}
		log.info("WORKFLOW(newTrackerListingProcess) EXECUTED SUCCESSFULLY");
	}
}
