package com.naveenautomation.Utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	// Fetch the file
	public static FileInputStream fileInputStream;
	// initialize the workbook
	public static XSSFWorkbook workbook;
	// get the last row
	public static XSSFSheet workSheet;
	public static XSSFRow rows;
	public static XSSFCell cell;

	public static int getRowCount(String xFile, String sheetName) throws IOException {
		int rowCount = 0;
		// Fetch the file
		fileInputStream = new FileInputStream(xFile);
		// initialise the workbook
		workbook = new XSSFWorkbook(fileInputStream);
		workSheet = workbook.getSheet(sheetName);
		// get the last row
		rowCount = workSheet.getLastRowNum();
		workbook.close();
		fileInputStream.close();

		return rowCount;
	}

	public static int getColumnCount(String xFile, String sheetName, int rowNum) throws IOException {
		int columnCount = 0;
		fileInputStream = new FileInputStream(xFile);
		workbook = new XSSFWorkbook(fileInputStream);
		workSheet = workbook.getSheet(sheetName);
		rows = workSheet.getRow(rowNum);
		columnCount = rows.getLastCellNum();
		workbook.close();
		fileInputStream.close();

		return columnCount;
	}

	public static String getCellValue(String xFile, String sheetName, int rowNum, int columnCount) throws IOException {
		String data = "";
		fileInputStream = new FileInputStream(xFile);
		workbook = new XSSFWorkbook(fileInputStream);
		workSheet = workbook.getSheet(sheetName);
		rows = workSheet.getRow(rowNum);
		cell = rows.getCell(columnCount);
		data = new DataFormatter().formatCellValue(cell);

		return data;
	}

}
