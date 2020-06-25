package com.tgq.TGQPageObjects;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.tgr.Utilities.MyOwnException;

public class TGQCommonPage extends TGQAllPages {

	private static final Logger log = LogManager.getLogger(TGQCommonPage.class.getName());

	WebDriver ldriver;
	

	public TGQCommonPage(WebDriver driver) {
		super(driver);
		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ========================= PAGE OBJECTS ============================

	// ========================= PAGE METHODS ============================

	public void initiateTGQBrowser() throws MyOwnException {

		log.info("METHOD(initiateBrowser) EXECUTION STARTED SUCCESSFULLY");
		try {
			if (sBrowserType.equalsIgnoreCase("") || sBrowserType == null) {
				sBrowser = configProps.getProperty("TGQbrowserType");
			} else {
				sBrowser = sBrowserType;
				// System.out.println(sBrowser);
			}
			System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
			if (sBrowser.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");
				FirefoxProfile profile = new FirefoxProfile();
				profile.setPreference("network.proxy.type", 1);
				profile.setPreference("network.proxy.http", configProps.getProperty("ipAddress"));
				profile.setPreference("network.proxy.http_port", 8080);
				profile.setPreference("network.proxy.ftp", 8080);
				profile.setPreference("network.proxy.ftp_port", 8080);
				profile.setPreference("network.proxy.ssl", configProps.getProperty("ipAddress"));
				profile.setPreference("network.proxy.ssl_port", 8080);
				// webDriver = new FirefoxDriver(profile);
				log.info("Initiated Mozilla session");
				webDriver.manage().window().maximize();
			} else if (sBrowser.equalsIgnoreCase("ie")) {
				File file = new File("Drivers\\IEDriverServer.exe");
				System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
				webDriver = new InternetExplorerDriver();
				log.info("Initiated IE session");
				webDriver.manage().window().maximize();
			} else if (sBrowser.equalsIgnoreCase("chrome")) {
				System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
				options.addArguments("--test-type");
				webDriver = new ChromeDriver(options);
				log.info("Initiated Chrome session");
				webDriver.manage().window().maximize();
			}

			driver = new EventFiringWebDriver(webDriver);
			driver.manage().deleteAllCookies();
			int implicitWaitTime = 10;
			if ("ie".equalsIgnoreCase(configProps.getProperty("browserType"))) {
				driver.manage().timeouts().implicitlyWait(implicitWaitTime * 2, TimeUnit.SECONDS);
			} else {
				driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
			}
			// driver.navigate().to("http://10.221.240.145/listing-div/login");

			tgQTrackerspages = new TGQAllPages(ldriver);
			
			// Report.logTestCaseStatus(childTestCase1, "INFO", "Browser Is Initiated
			// Successfully");
		} catch (Exception exp) {
			log.error(exp.getMessage());
			// Report.logTestCaseStatus(childTestCase1, "FAIL",
			// "<font color=red><b>Browser Is Not Initiated Successfully</b></font><br />" +
			// exp.getMessage()
			// + "<br />");
			// throwException(
			// "UNABLE TO INITIATE THE BROWSER FROM THE METHOD initiateBrowser\n" +
			// exp.getMessage() + "\n");
		}
		log.info("METHOD(initiateBrowser) EXECUTED SUCCESSFULLY");
	}
	

}
