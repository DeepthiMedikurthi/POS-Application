package com.tgr.RegressionTestScripts;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.tgr.Utilities.MyOwnException;
import com.tgr.PageObjects.RegressionWorkFlow;

public class TGRTestCaseGSign extends RegressionWorkFlow {

	private static final Logger log = LogManager.getLogger(TGRTestCaseGSign.class.getName());

	@Test // (dataProvider = "TestData", dataProviderClass = DataProviderRepository.class)
	public void TC1() throws InterruptedException, MyOwnException {

		log.info("METHOD(TC1) EXECUTION STARTED SUCCESSFULLY");
		try {

			openTGRgSign();

		} catch (Exception exp) {
			log.error(exp.getMessage());
			throwException("Login SUCCESSFUL\n" + exp.getMessage());
		}
		log.info("METHOD(IU_TC1) EXECUTED SUCCESSFULLY");
	}

}
