package com.tgr.RegressionTestScripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.tgr.PageObjects.RegressionWorkFlow;
import com.tgr.Utilities.MyOwnException;

public class HomeOwners extends RegressionWorkFlow  {

	private static final Logger log = LogManager.getLogger(HomeOwners.class.getName());

	@Test 
	public void TC1() throws InterruptedException, MyOwnException {

		log.info("METHOD(TC1) EXECUTION STARTED SUCCESSFULLY");
		try {

		openTGRGeneralInfo();

		} catch (Exception exp) {
			log.error(exp.getMessage());
			throwException("Login SUCCESSFUL\n" + exp.getMessage());
		}
		log.info("METHOD(IU_TC1) EXECUTED SUCCESSFULLY");
	}
}

