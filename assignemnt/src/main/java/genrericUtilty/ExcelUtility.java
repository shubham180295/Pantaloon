package genrericUtilty;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelUtility {
@Test
public String getExcelData(String sheetname, int row, int cell) throws
EncryptedDocumentException, IOException {
	

FileInputStream fis = new FileInputStream("./Data/PantaloonsSheet.xlsx");
Workbook wb = WorkbookFactory.create(fis);
String data =
wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
return data;

}
public String setExcelData(String sheetname,int row, int cell, String value)
throws EncryptedDocumentException, IOException {
FileInputStream fis = new FileInputStream("./Data/PantaloonsSheet.xlsx");
Workbook wb = WorkbookFactory.create(fis);
wb.getSheet(sheetname).getRow(row).getCell(cell).setCellValue(value);
FileOutputStream fos = new
FileOutputStream("./Data/PantaloonsSheet.xlsx");
wb.write(fos);
wb.close();
return value;
}
}