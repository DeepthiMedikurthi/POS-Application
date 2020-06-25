package com.tgq.PageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tgr.accelerators.Base;
import com.tgr.Utilities.MyOwnException;
import wrapper.classes.methods.MyWait;
import wrapper.classes.methods.MyWebElement;

public class TGQ_Payment_Page extends AllPages {

	private static final Logger log = LogManager.getLogger(TGQ_Payment_Page.class.getName());

	// Page Factory

	@FindBy(how = How.ID, using = "cashPayment.paymentAmount.value")
	public WebElement cash_value;
	@FindBy(how = How.ID, using = "checkPayment.paymentAmount.value")
	public WebElement check_value;
	@FindBy(how = How.ID, using = "checkPayment.checkNumber.value")
	public WebElement check_number;
	@FindBy(how = How.ID, using = "moneyOrderPayment.paymentAmount.value")
	public WebElement money_order_value;
	@FindBy(how = How.ID, using = "moneyOrderPayment.moneyOrderNumber.value")
	public WebElement moneyorder_number;
	@FindBy(how = How.ID, using = "bankDraftPayment.paymentAmount.value")
	public WebElement ins_bank_draft;
	@FindBy(how = How.ID, using = "bankDraftPayment.accountType.writableValue")
	public WebElement act_type;
	@FindBy(how = How.ID, using = "bankDraftPayment.routingNumber.value")
	public WebElement routing_number;
	@FindBy(how = How.ID, using = "bankDraftPayment.accountNumber.value")
	public WebElement account_number;
	@FindBy(how = How.ID, using = "creditCardPayment.paymentAmount.value")
	public WebElement ins_debit_credit;
	@FindBy(how = How.ID, using = "creditCardPayment.accountNumber.value")
	public WebElement card_number;
	@FindBy(how = How.ID, using = "creditCardPayment.cardholderName.value")
	public WebElement name_on_card;
	@FindBy(how = How.ID, using = "creditCardPayment.expirationMonth.writableValue")
	public WebElement card_expiry_month;
	@FindBy(how = How.ID, using = "creditCardPayment.expirationYear.writableValue")
	public WebElement card_expiry_year;
	@FindBy(how = How.XPATH, using = "//*[@id='quoteSummaryTable']/tbody/tr[3]/td[4]")
	public WebElement downpayment_value;
	@FindBy(how = How.XPATH, using = "//*[@id='body']/form/table[3]/tbody/tr[3]/td[2]")
	public WebElement policy_num;
	@FindBy(how = How.XPATH, using = "//*[@id='quoteSummaryTable']/tbody/tr[3]/td[2]")
	public WebElement quote_num;
	@FindBy(how = How.LINK_TEXT, using = "Process Payment")
	public WebElement process_payment_button;

	WebDriver ldriver;

	public TGQ_Payment_Page(WebDriver dr) {
		super(dr);
		this.ldriver = dr;
		PageFactory.initElements(dr, this);
	}

	public void paymentTab(String applicationType) throws MyOwnException, InterruptedException {
		log.info("METHOD(login) STARTED SUCCESSFULLY");
		try {
			if (MyWebElement.isCloseButtonExist("//*[@src='images/popup_close.gif']")) {
				driver.findElement(By.xpath("//*[@src='images/popup_close.gif']")).click();
			}
			MyWebElement.enterText(ins_debit_credit, downpayment_value.getText());
			MyWebElement.enterText(card_number, "4012000033330026");
			MyWebElement.enterText(name_on_card, "Abcd Efgh");
			Select card_expiry_month_val = new Select(card_expiry_month);
			card_expiry_month_val.selectByVisibleText("1");
			Select card_expiry_year_val = new Select(card_expiry_year);
			card_expiry_year_val.selectByVisibleText("2028");

			process_payment_button.click();
			Thread.sleep(4000);
		} catch (Exception exp) {
			log.error(exp.getMessage());

			throwException("Unable To do payment " + applicationType + "application \n" + exp.getMessage() + "\n");
		}
		log.info("METHOD(login) EXECUTED SUCCESSFULLY");

	}

}
