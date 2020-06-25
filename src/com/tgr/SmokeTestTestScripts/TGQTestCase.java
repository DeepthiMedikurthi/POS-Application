package com.tgr.SmokeTestTestScripts;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.tgr.PageObjects.SmoketestWorkFlow;
import com.tgr.Utilities.MyOwnException;

public class TGQTestCase extends SmoketestWorkFlow {

	private static final Logger log = LogManager.getLogger(TGQTestCase.class.getName());

	@Test 
	public void TC1() throws InterruptedException, MyOwnException {

		log.info("METHOD(TC1) EXECUTION STARTED SUCCESSFULLY");
		try {

			openTGQ();

		} catch (Exception exp) {
			log.error(exp.getMessage());
			throwException("Login SUCCESSFUL\n" + exp.getMessage());
		}
		log.info("METHOD(IU_TC1) EXECUTED SUCCESSFULLY");
	}

}
