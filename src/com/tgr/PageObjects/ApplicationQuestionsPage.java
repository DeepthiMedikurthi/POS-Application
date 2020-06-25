package com.tgr.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.aventstack.extentreports.ExtentTest;
import com.tgr.Utilities.MyOwnException;

import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class ApplicationQuestionsPage extends CommonPage {

	private static final Logger log = LogManager.getLogger(ApplicationQuestionsPage.class.getName());

	WebDriver ldriver;
	ExtentTest testCase;

	public ApplicationQuestionsPage(WebDriver driver) {
		super(driver);

		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	// ===================== PAGE OBJECTS ======================

	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[2]/div[1]/div/label[2]")
	public WebElement appQue1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[3]/div[1]/div/label[2]")
	public WebElement appQue2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[4]/div[1]/div/label[2]")
	public WebElement appQue3;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[5]/div[1]/div/label[2]")
	public WebElement appQue4;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[6]/div[1]/div/label[1]")
	public WebElement appQue5;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[7]/div[1]/div/label[1]")
	public WebElement appQue6;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[8]/div[1]/div/label[2]")
	public WebElement appQue7;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[4]/div[1]/div/label[1]")
	public WebElement appQueForNC3;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[5]/div[1]/div/label[1]")
	public WebElement appQueForNC4;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[2]/div[1]/div/label[1]")
	public WebElement appQueForFL1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[11]/div[1]/div/label[2]")
	public WebElement appQueForFL10;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[3]/div[1]/div/label[1]")
	public WebElement appQueForFL2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[4]/div[1]/div/label[1]")
	public WebElement appQueForFL3;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[5]/div[1]/div/label[1]")
	public WebElement appQueForFL4;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[6]/div[1]/div/label[1]")
	public WebElement appQueForFL5;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[7]/div[1]/div/label[2]")
	public WebElement appQueForFL6;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[8]/div[1]/div/label[2]")
	public WebElement appQueForFL7;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[9]/div[1]/div/label[2]")
	public WebElement appQueForFL8;
	@FindBy(how = How.XPATH, using = "//*[@id=\"content_table\"]/div[3]/div/div[1]/div[10]/div[1]/div/label[2]")
	public WebElement appQueForFL9;
	

	@FindBy(how = How.LINK_TEXT, using = "Continue")
	public WebElement continueLink;

	// ===================== PAGE METHODS ======================

	public void applicationQuestions() throws InterruptedException, MyOwnException {

		log.info("METHOD(login) EXECUTION STARTED SUCCESSFULLY");
		try {
			//MyWait.until(ldriver, "ELEMENT_VISIBLE", 90, continueLink);
			if (currentHash.get("state").equals("NC")) {
				appQue1.click();
				appQue2.click();
				appQueForNC3.click();
				appQueForNC4.click();

			} else if(!currentHash.get("state").equals("NC")&&!currentHash.get("state").equals("FL") ) {
				appQue1.click();
				appQue2.click();
				appQue3.click();
				appQue4.click();
				appQue5.click();
				appQue6.click();
				if(MyWebElement.isButtonExist("//*[@id=\"content_table\"]/div[3]/div/div[1]/div[8]/div[1]/div/label[2]")) {
					appQue7.click();
				}
			}
			else {
				appQueForFL1.click();
				appQueForFL2.click();
				appQueForFL3.click();
				appQueForFL4.click();
				appQueForFL5.click();
				appQueForFL6.click();
				appQueForFL7.click();
				appQueForFL8.click();
				appQueForFL9.click();
				appQueForFL10.click();
				
			
			}
			continueLink.click();
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
