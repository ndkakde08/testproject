package iNautix_Technologies_pune;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class utility {

	public static String ExcelData(String path, String shit, int rowd, int cel) throws EncryptedDocumentException, IOException {
		
		FileInputStream file  = new FileInputStream(path);
		Sheet sheet = WorkbookFactory.create(file).getSheet(shit);
	
		try
		{
			double value1 = sheet.getRow(rowd).getCell(cel).getNumericCellValue();
			String value =String.valueOf(value1);
			return value;
		}
		catch (IllegalStateException e)
		{
			String value = sheet.getRow(rowd).getCell(cel).getStringCellValue();
			return value;
		}		
		
	}
}
