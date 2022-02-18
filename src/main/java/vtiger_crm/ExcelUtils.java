package vtiger_crm;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	public String readDataExcel(String sheetname, int rownumber, int cellno) throws Throwable {
FileInputStream fis=new FileInputStream(IAutoconstants.excelpath);
return WorkbookFactory.create(fis)
		.getSheet(sheetname)
		.getRow(rownumber)
		.getCell(cellno)
		.getStringCellValue();

	}
	public String readDataExcel(String path, String sheetname, int rownumber, int cellno) throws Throwable {
		FileInputStream fis=new FileInputStream(IAutoconstants.excelpath);
		return WorkbookFactory.create(fis)
				.getSheet(sheetname)
				.getRow(rownumber)
				.getCell(cellno)
				.getStringCellValue();

			}
	

}
