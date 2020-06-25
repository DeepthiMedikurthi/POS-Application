package com.tgr.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.tgr.accelerators.Base;

public class Excel extends Base {

	private static final Logger log = LogManager.getLogger(Excel.class.getName());

	private static Workbook wb;
	private static Sheet sh;
	private static Row row;

	public static boolean writeToExcelSheet(String policyNumber, String quoteNUmber) throws Exception {
		String fileName = System.getProperty("user.dir") + "\\TestData\\" + configProps.getProperty("TestCaseFileName")
				+ ".xlsx";
		String sheetName = configProps.getProperty("PolicyDetails");
		FileInputStream file = new FileInputStream(fileName);
		wb = WorkbookFactory.create(file);
		sh = wb.getSheet(sheetName);


		int rowCount = sh.getLastRowNum() + 1;
		if (testDataFilename.equals("TGRTestData")) {
			row = sh.createRow(rowCount);
			Pattern p = Pattern.compile("[:]");
			String[] s = p.split(policyNumber);
			Cell c1 = row.createCell(0);
			c1.setCellValue(s[1]);
			Cell c5 = row.createCell(5);
			c5.setCellValue("TGR");
		} else {
			row = sh.createRow(rowCount);
			Cell c1 = row.createCell(0);
			c1.setCellValue(policyNumber);
			Cell c5 = row.createCell(5);
			c5.setCellValue("TGQ");
		}
		Cell c2 = row.createCell(1);
		c2.setCellValue(quoteNUmber);
		Cell c3 = row.createCell(2);
		c3.setCellValue(currentHash.get("Testcaseid"));
		Cell c4 = row.createCell(3);
		c4.setCellValue(testRunTimeStamp);
		
		file.close();

		FileOutputStream outFile = new FileOutputStream(fileName);
		wb.write(outFile);
		outFile.close();
		return true;

	}

}