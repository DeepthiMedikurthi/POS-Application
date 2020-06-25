package com.tgr.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.tgr.accelerators.Base;
import com.tgr.Utilities.MyOwnException;

public class Report extends Base {
	private static final Logger log = LogManager.getLogger(Report.class.getName());

	public static ExtentReports extentReport;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest testCase;
	public static boolean result;

	public static String fileFormat = "";
	public static File file;
	public static FileInputStream fs;
	public static FileOutputStream os;
	public static Properties properties;
	public static Properties configProps;
	public static String documentPath;
	public static ExtentReports report;
	public static ExtentTest parentTestCase;

	public static ExtentHtmlReporter initializeHTML(String reportName, boolean status) throws MyOwnException {

		log.info("INTEND TO INITIALIZE AN HTML REPORT");
		try {
			if (notEmpty(reportName)) {
				if (formatGiven(reportName) == true) {
					fileFormat = getFileFormat(reportName);
					if (fileFormatIs(".html")) {
						createInstanceOfHTMLReport(reportName);
						appendToExistingReport(status);
						setHTMLReportName("Test Case Summary");
						setChartVisibility(true);
						setHTMLReportTheme(Theme.DARK);
					} else {
						log.error("REPORT FORMAT IS INCORRECT, IT SHOULD BE .HTML");
						throwException("REPORT FORMAT IS INCORRECT, IT SHOULD BE .HTML" + "\n");
					}
				} else {
					log.error("REPORT FORMAT IS MISSING");
					throwException("REPORT FORMAT IS MISSING" + "\n");
				}
			} else {
				log.error("REPORT NAME SEEMS TO BE EMPTY");
				throwException("REPORT NAME SEEMS TO BE EMPTY" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO INITIALIZE HTML REPORT(" + reportName + ")\n" + e.getMessage());
			throwException("UNABLE TO INITIALIZE HTML REPORT(" + reportName + ")\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY INITIALIZED AN HTML REPORT(" + reportName + ")");
		return htmlReporter;
	}

	private static void setHTMLReportName(String reportName) throws MyOwnException {

		log.info("INTEND TO SET A NAME FOR THE HTML REPORT ");
		try {
			htmlReporter.config().setReportName(reportName);
		} catch (Exception e) {
			log.error("UNABLE TO SET HTML REPORT NAME(" + reportName + ")");
			throwException("UNABLE TO SET HTML REPORT NAME(" + reportName + ")" + "\n");
		}
		log.info("HTML REPORT NAME(" + reportName + ") WAS SET SUCCESSFULLY");
	}

	private static void setChartVisibility(boolean chartVisibility) throws MyOwnException {

		log.info("INTEND TO SET A Chart Visibility FOR THE HTML REPORT ");
		try {
			htmlReporter.config().setChartVisibilityOnOpen(chartVisibility);
		} catch (Exception e) {
			log.error("UNABLE TO SET CHART VISIBILITY (" + chartVisibility + ")");
			throwException("UNABLE TO SET CHART VISIBILITY (" + chartVisibility + ")" + "\n");
		}
		log.info("HTML REPORT CHART VISIBILITY(" + chartVisibility + ") WAS SET SUCCESSFULLY");
	}

	private static void setHTMLReportTheme(Theme theme) throws MyOwnException {

		log.info("INTEND TO SET A THEME FOR THE HTML REPORT ");
		try {
			htmlReporter.config().setTheme(theme);
		} catch (Exception e) {
			log.error("UNABLE TO SET HTML REPORT THEME");
			throwException("UNABLE TO SET HTML REPORT THEME" + "\n");
		}
		log.info("HTML REPORT THEME WAS SET SUCCESSFULLY");
	}

	private static void appendToExistingReport(boolean status) throws MyOwnException {

		log.info("INTED TO ADD THE CONTENTS TO EXTENT REPORT BASED ON THE APPEND STATUS");
		try {
			htmlReporter.setAppendExisting(status);
		} catch (Exception e) {
			log.error("UNABLE TO ADD CONTENTS TO EXTENT REPORT BASED ON THE APPEND STATUS(" + status + ")");
			throwException("UNABLE TO ADD CONTENTS TO EXTENT REPORT BASED ON THE APPEND STATUS(" + status + ")" + "\n");
		}
		log.info("CONTENTS ARE ADDED TO EXTENT REPORT BASED ON THE APPEND STATUS(" + status + ")");
	}

	private static ExtentHtmlReporter createInstanceOfHTMLReport(String reportName) throws MyOwnException {

		log.info("INTEND TO CREATE AN INSTANCE OF HTML REPORT WITH NAME");
		try {
			htmlReporter = new ExtentHtmlReporter(reportName);
		} catch (Exception e) {
			log.error("UNABLE TO CREATE AN INSTANCE OF HTML REPORT WITH NAME(" + reportName + ")");
			throwException("UNABLE TO CREATE AN INSTANCE OF HTML REPORT WITH NAME(" + reportName + ")" + "\n");
		}
		log.info("SUCCESSFULLY CREATED AN INSTANCE OF HTML REPORT WITH NAME(" + reportName + ")");
		return htmlReporter;
	}

	private static ExtentReports createInstanceOfExtentReport() throws MyOwnException {

		log.info("INTEND TO CREATE AN INSTANCE OF EXTENT REPORT");
		try {
			extentReport = new ExtentReports();
		} catch (Exception e) {
			log.error("UNABLE TO CREATE AN INSTANCE OF EXTENT REPORT");
			throwException("UNABLE TO CREATE AN INSTANCE OF EXTENT REPORT" + "\n");
		}
		log.info("SUCCESSFULLY CREATED AN INSTANCE OF EXTENT REPORT");
		return extentReport;
	}

	private static void attachHTMLReport(ExtentHtmlReporter htmlReporter) throws MyOwnException {

		log.info("INTEND TO ATTACH HTML REPORT TO EXTENT REPORT");
		try {
			extentReport.attachReporter(htmlReporter);
		} catch (Exception e) {
			log.error("UNABLE TO ATTACH HTML REPORT TO EXTENT REPORT");
			throwException("UNABLE TO ATTACH HTML REPORT TO EXTENT REPORT" + "\n");
		}
		log.info("SUCCESSFULLY ATTACHED HTML REPORT TO EXTENT REPORT");
	}

	public static ExtentReports initialize(String reportName, boolean status) throws MyOwnException {

		log.info("INTEND TO CREATE AN INSTANCE OF EXTENT REPORT WITH NAME AND APPEND STATUS");
		htmlReporter = initializeHTML(reportName, status);
		extentReport = createInstanceOfExtentReport();
		try {
			if (htmlReporter != null) {
				attachHTMLReport(htmlReporter);
			} else {
				log.error("HTML REPORT INSTANCE SEEMS TO BE NULL");
				throwException("HTML REPORT INSTANCE SEEMS TO BE NULL" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO INITIALIZE TEST EXECUTION REPORT(" + reportName + ") WITH APPEND STATUS(" + status
					+ ")\n" + e.getMessage());
			throwException("UNABLE TO INITIALIZE TEST EXECUTION REPORT(" + reportName + ") WITH APPEND STATUS(" + status
					+ ")\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULLY CREATED AN INSTANCE OF EXTENT REPORT WITH NAME(" + reportName + ") AND APPEND STATUS("
				+ status + ")");
		return extentReport;
	}

	public static void recordSystemInfo(ExtentReports report, String key, String value) throws MyOwnException {

		log.info("INTEND TO ADD SYSTEM INFORMATION IN EXTENT REPORT");
		try {
			report.setSystemInfo(key, value);
		} catch (Exception e) {
			log.error("UNABLE TO ADD SYSTEM INFORMATION(" + key + " : " + value + ") IN EXTENT REPORT");
			throwException("UNABLE TO ADD SYSTEM INFORMATION(" + key + " : " + value + ") IN EXTENT REPORT" + "\n");
		}
		log.info("SUCCESSFULLY ADDED SYSTEM INFORMATION(" + key + " : " + value + ") IN EXTENT REPORT");
	}

	public static void writeContents(ExtentReports report, String quotenumber) throws MyOwnException {

		log.info("INTEND TO WRITE ALL THE CONENTS INTO EXTENT REPORT");
		try {
			File f1 = new File(System.getProperty("user.dir") + "\\" + extentReportFileName);
			//Appending Quote Number to report for easy identification
			Pattern p = Pattern.compile("[.]");
			String[] s = p.split(extentReportFileName);
			extentReportFileName = s[0] + "_" + quotenumber + "." + s[1];

			File f2 = new File(System.getProperty("user.dir") + "\\Reports\\"+ extentReportFileName);
			
			report.flush();
			boolean b = f1.renameTo(f2);
			System.out.println(b);
		} catch (Exception e) {
			log.error("UNABLE TO WRITE CONTENTS INTO EXTENT REPORT");
			throwException("UNABLE TO WRITE CONTENTS INTO EXTENT REPORT" + "\n");
		}
		log.info("SUCCESSFULY WROTE ALL THE CONENTS INTO EXTENT REPORT");
	}

	public ExtentTest makeTestCaseEntry(ExtentReports report, String testCaseName) throws MyOwnException {

		log.info("INTEND TO CREATE AN INSTANCE OF TEST CASE WITH NAME IN EXTENT REPORT");
		try {
			if (notEmpty(testCaseName)) {
				testCase = report.createTest(testCaseName);
			} else {
				log.error("TEST CASE NAME SEEMS TO BE EMPTY");
				throwException("TEST CASE NAME SEEMS TO BE EMPTY" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO CREATE AN INSTANCE OF TEST CASE WITH NAME(" + testCaseName + ") IN EXTENT REPORT\n"
					+ e.getMessage());
			throwException("UNABLE TO CREATE AN INSTANCE OF TEST CASE WITH NAME(" + testCaseName
					+ ") IN EXTENT REPORT\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULY CREATED AN INSTANCE OF TEST CASE WITH NAME(" + testCaseName + ") IN EXTENT REPORT");
		return testCase;
	}

	public void assignCategoryToTestCase(ExtentTest test, String categoryName) throws MyOwnException {

		log.info("INTEND TO ASSIGN CATAGORY TO A TEST CASE IN EXTENT REPORT");
		try {
			test.assignCategory(categoryName);
		} catch (Exception e) {
			log.error("UNABLE TO ASSIGN THE CATAGORY(" + categoryName + ") TO A TEST CASE IN EXTENT REPORT");
			throwException("UNABLE TO ASSIGN THE CATAGORY(" + categoryName + ") TO A TEST CASE IN EXTENT REPORT\n"
					+ e.getMessage() + "\n");
		}
		log.info("SUCCESSFULY ASSIGNED THE CATAGORY(" + categoryName + ") TO A TEST CASE IN EXTENT REPORT");
	}

	public static void logTestCaseStatus(ExtentTest test, String logStatus, String logStatusDesc)
			throws MyOwnException {

		log.info("INTEND TO LOG TEST CASE STATUS WITH DESCRIPTION IN EXTENT REPORT");
		try {
			if (notEmpty(logStatus)) {
				if (notEmpty(logStatusDesc)) {
					if (logStatus.equalsIgnoreCase("PASS")) {
						test.log(Status.PASS, logStatusDesc);
					} else if (logStatus.equalsIgnoreCase("FAIL")) {
						test.log(Status.FAIL, logStatusDesc);
					} else if (logStatus.equalsIgnoreCase("SKIP")) {
						test.log(Status.SKIP, logStatusDesc);
					} else if (logStatus.equalsIgnoreCase("INFO")) {
						test.log(Status.INFO, logStatusDesc);
					} else if (logStatus.equalsIgnoreCase("ERROR")) {
						test.log(Status.ERROR, logStatusDesc);
					} else if (logStatus.equalsIgnoreCase("WARNING")) {
						test.log(Status.WARNING, logStatusDesc);
					} else {
						log.error("LOG STATUS SEEMS TO BE INCORRECT");
						throwException("LOG STATUS SEEMS TO BE INCORRECT" + "\n");
					}
				} else {
					log.error("LOG STATUS DESCRIPTION SEEMS TO BE EMPTY");
					throwException("LOG STATUS DESCRIPTION SEEMS TO BE EMPTY" + "\n");
				}
			} else {
				log.error("LOG STATUS SEEMS TO BE EMPTY");
				throwException("LOG STATUS SEEMS TO BE EMPTY" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO LOG THE TEST CASE STATUS(" + logStatus + ") WITH DESCRIPTION(" + logStatusDesc
					+ ") IN EXTENT REPORT\n" + e.getMessage());
			throwException("UNABLE TO LOG THE TEST CASE STATUS(" + logStatus + ") WITH DESCRIPTION(" + logStatusDesc
					+ ") IN EXTENT REPORT\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULY LOGED THE STATUS(" + logStatus + ") WITH DESCRIPTION(" + logStatusDesc
				+ ") IN EXTENT REPORT");
	}

	public void logTestCaseStatusWithSnapShot(ExtentTest test, String logStatus, String logStatusDesc,
			String imageNameWithPath) throws MyOwnException {

		log.info("INTEND TO LOG TEST CASE STATUS WITH DESCRIPTION AND SNAPSHOT IN EXTENT REPORT");
		try {
			if (notEmpty(logStatus)) {
				if (notEmpty(logStatusDesc)) {
					if (prop.getProperty("PositiveScreenshot").equalsIgnoreCase("True")) {
						if (notEmpty(imageNameWithPath)) {
							if (filePresent(imageNameWithPath) == true) {
								if (logStatus.equalsIgnoreCase("PASS")) {
									test.log(Status.PASS, logStatusDesc).addScreenCaptureFromPath(imageNameWithPath);
								} else if (logStatus.equalsIgnoreCase("FAIL")) {
									test.log(Status.FAIL, logStatusDesc).addScreenCaptureFromPath(imageNameWithPath);
								} else if (logStatus.equalsIgnoreCase("SKIP")) {
									test.log(Status.SKIP, logStatusDesc).addScreenCaptureFromPath(imageNameWithPath);
								} else if (logStatus.equalsIgnoreCase("INFO")) {
									test.log(Status.INFO, logStatusDesc).addScreenCaptureFromPath(imageNameWithPath);
								} else if (logStatus.equalsIgnoreCase("ERROR")) {
									test.log(Status.ERROR, logStatusDesc).addScreenCaptureFromPath(imageNameWithPath);
								} else if (logStatus.equalsIgnoreCase("WARNING")) {
									test.log(Status.WARNING, logStatusDesc).addScreenCaptureFromPath(imageNameWithPath);
								} else {
									log.error("LOG STATUS SEEMS TO BE INCORRECT");
									throwException("LOG STATUS SEEMS TO BE INCORRECT" + "\n");
								}
							} else {
								log.error("IMAGE FILE DOES NOT EXIST");
								throwException("IMAGE FILE DOES NOT EXIST" + "\n");
							}
						} else {
							log.error("IMAGE PATH SEEMS TO BE EMPTY");
							throwException("IMAGE PATH SEEMS TO BE EMPTY" + "\n");
						}
					} else {
						if (logStatus.equalsIgnoreCase("PASS")) {
							test.log(Status.PASS, logStatusDesc);
						} else if (logStatus.equalsIgnoreCase("FAIL")) {
							test.log(Status.FAIL, logStatusDesc);
						} else if (logStatus.equalsIgnoreCase("SKIP")) {
							test.log(Status.SKIP, logStatusDesc);
						} else if (logStatus.equalsIgnoreCase("INFO")) {
							test.log(Status.INFO, logStatusDesc);
						} else if (logStatus.equalsIgnoreCase("ERROR")) {
							test.log(Status.ERROR, logStatusDesc);
						} else if (logStatus.equalsIgnoreCase("WARNING")) {
							test.log(Status.WARNING, logStatusDesc);
						} else {
							log.error("LOG STATUS SEEMS TO BE INCORRECT");
							throwException("LOG STATUS SEEMS TO BE INCORRECT" + "\n");
						}
					}

				} else {
					log.error("LOG STATUS DESCRIPTION SEEMS TO BE EMPTY");
					throwException("LOG STATUS DESCRIPTION SEEMS TO BE EMPTY" + "\n");
				}
			} else {
				log.error("LOG STATUS SEEMS TO BE EMPTY");
				throwException("LOG STATUS SEEMS TO BE EMPTY" + "\n");
			}
		} catch (Exception e) {
			log.error("UNABLE TO LOG THE TEST CASE STATUS(" + logStatus + ") WITH DESCRIPTION(" + logStatusDesc
					+ ") AND SNAPSHOT(" + imageNameWithPath + ") IN EXTENT REPORT\n" + e.getMessage());
			throwException("UNABLE TO LOG THE TEST CASE STATUS(" + logStatus + ") WITH DESCRIPTION(" + logStatusDesc
					+ ") AND SNAPSHOT(" + imageNameWithPath + ") IN EXTENT REPORT\n" + e.getMessage() + "\n");
		}
		log.info("SUCCESSFULY LOGED THE STATUS(" + logStatus + ") WITH DESCRIPTION(" + logStatusDesc + ") AND SNAPSHOT("
				+ imageNameWithPath + ") IN EXTENT REPORT");
	}

	public static boolean filePresent(String fileNameWithPath) {

		log.info("INTENDED TO CHECK IF THE SNAPSHOT FILE IS PRESENT");
		file = new File(fileNameWithPath);
		if (file.exists()) {
			log.info("FILE(" + fileNameWithPath + ") IS PRESENT");
			result = true;
		} else {
			log.error("FILE(" + fileNameWithPath + ") IS NOT PRESENT");
			result = false;
		}
		log.info("SUCCESSFULLY CHECKED IF THE SNAPSHOT FILE IS PRESENT");
		return result;
	}

	public static boolean notEmpty(String string) {

		log.info("INTENDED TO CHECK IF THE STRING IS EMPTY");
		if (string != "") {
			log.info("STRING IS NOT EMPTY");
			result = true;
		} else {
			log.error("STRING IS EMPTY");
			result = false;
		}
		log.info("SUCCESSFULLY CHECKED IF THE STRING IS EMPTY");
		return result;
	}

	public static boolean formatGiven(String fileName) {

		log.info("INTENDED TO CHECK IF THE FILE NAME HAS THE FILE EXTENSION");
		int position = fileName.indexOf(".");
		if (position >= 0) {
			log.info("FILE FORMAT IS PROVIDED WITH THE FILE NAME(" + fileName + ")");
			result = true;
		} else {
			log.error("FILE FORMAT IS NOT PROVIDED WITH THE FILE NAME(" + fileName + ")");
			result = false;
		}
		log.info("SUCCESSFULLY CHECKED IF THE FILE NAME HAS THE FILE EXTENSION");
		return result;
	}

	public static String getFileFormat(String fileName) throws MyOwnException {

		log.info("INTENDED TO RETRIEVE THE FORMAT OF THE FILE");
		try {
			fileFormat = fileName.substring(fileName.indexOf("."));
			log.info(
					"SUCCESSFULLY GOT THE FILE FORMAT(" + fileFormat + ") FROM THE FILE NAME(" + fileName + ")" + "\n");
		} catch (Exception e) {
			log.error("UNABLE TO GET THE FILE FORMAT(" + fileFormat + ") FROM THE FILE NAME(" + fileName + ")");
			throwException(
					"UNABLE TO GET THE FILE FORMAT(" + fileFormat + ") FROM THE FILE NAME(" + fileName + ")" + "\n");
		}
		log.info("SUCCESSFULLY RETRIEVED THE FORMAT OF THE FILE");
		return fileFormat;
	}

	public static boolean fileFormatIs(String expectedExtension) {

		log.info("INTENDED TO CHECK IF THE FILE BELONGS TO THE GIVEN FORMAT");
		if (fileFormat.equalsIgnoreCase(expectedExtension)) {
			log.info("EXPECTED AND ACTUAL FILE FORMATS ARE THE SAME");
			result = true;
		} else {
			log.error("EXPECTED AND ACTUAL FILE FORMATS ARE DIFFERENT");
			result = false;
		}
		log.info("SUCCESSFULLY CHECKED IF THE FILE BELONGS TO THE GIVEN FORMAT");
		return result;
	}

	public static File createFileInstance(String name) throws MyOwnException {

		log.info("INTENDED TO CREATE THE FILE INSTANCE");
		try {
			file = new File(name);
			log.info("FILE INSTANCE CREATED");
		} catch (Exception e) {
			log.error("UNABLE TO CREATE AN INSTANCE OF THE FILE(" + name + ")");
			throwException("UNABLE TO CREATE AN INSTANCE OF THE FILE(" + name + ")" + "\n");
		}
		log.info("SUCCESSFULLY CREATED THE FILE INSTANCE");
		return file;
	}

	public static FileInputStream readFile(File file) throws MyOwnException {

		log.info("INTENDED TO READ THE GIVEN FILE");
		try {
			fs = new FileInputStream(file);
			log.info("SUCCESSFULLY READ THE FILE(" + file + ") SPECIFIED");
		} catch (FileNotFoundException e) {
			log.error("UNABLE TO READ THE FILE(" + file + ") SPECIFIED, PLEASE CHECK NAME OR LOCATION OR EXTENSION");

		}
		log.info("READING THE FILE IS SUCCESSFUL");
		return fs;
	}

	public static FileOutputStream writeFile(File file) throws MyOwnException {

		log.info("INTENDED TO WRITE TO THE GIVEN FILE");
		try {
			os = new FileOutputStream(file);
			log.info("READY TO WRITE CONTENTS IN THE FILE(" + file + ") SPECIFIED");
		} catch (FileNotFoundException e) {
			log.error("UNABLE TO WRITE CONTENTS TO THE FILE(" + file
					+ ") SPECIFIED, PLEASE CHECK NAME OR LOCATION OR EXTENSION");

		}
		log.info("WRITE TO THE GIVEN FILE IS SUCCESSFUL");
		return os;
	}

}
