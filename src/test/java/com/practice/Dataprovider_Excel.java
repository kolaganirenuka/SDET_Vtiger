package com.practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import vtiger_crm.IAutoconstants;

public class Dataprovider_Excel {
	@Test(dataProvider="read")
	public void readExceldata(Object UN,Object PW,Object opt) {
		System.out.println(UN+" "+PW+" "+opt);
	}
	@DataProvider
	public Object[][] read() throws Throwable {
		FileInputStream fis=new FileInputStream(IAutoconstants.excelpath);
		Workbook wb = WorkbookFactory.create(fis);
		int lastrow = wb.getSheet("Sheet1").getLastRowNum();
//		short lastcell = wb.getSheet("Sheet1").getRow(1).getLastCellNum();
//		System.out.println(lastcell);
		Object arr[][]=new Object[lastrow][3];
		for(int i=0;i<lastrow;i++) {
			arr[i][0]=wb.getSheet("Sheet1").getRow(i).getCell(0).getStringCellValue();
			arr[i][1]=wb.getSheet("Sheet1").getRow(i).getCell(1).getStringCellValue();
			arr[i][2]=wb.getSheet("Sheet1").getRow(i).getCell(2).getNumericCellValue();
		}
		return arr;
	}
}
