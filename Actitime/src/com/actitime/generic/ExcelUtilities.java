package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilities {
	/**
	 * @author PRASHANT
	 * created on 11/2/17
	 * reviewed by prashant
	 */
	
	static final String filePath ="C:/Users/PRASHANT/workspace/Actitime/testdata/testdata.xlsx";
	/*
	 * @description use to read data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @returnString
	 */
	
public static String readData (String sheetName, int rowNum, int cellNum ) {
{
	String value = null;
	
	try{
	 Workbook wb = WorkbookFactory.create(new FileInputStream(new File(filePath)));
	value =wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}
	catch(EncryptedDocumentException e){
		e.printStackTrace();
	}
    catch(InvalidFormatException e){
	e.printStackTrace();
	}
	catch(FileNotFoundException e){
	e.printStackTrace();	
	}
	catch(IOException e){
		e.printStackTrace();
	}
	return value;
}
}
}
