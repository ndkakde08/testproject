package iNautix_Technologies_pune;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Test;

public class dummyclass {

	public static void main(String[]arg) throws EncryptedDocumentException, IOException {
		
		String path ="C:\\Users\\Navnath\\Desktop\\Software Testing\\AUTOMATIC TESTING\\Xpath finding\\Test.xlsx";
		String sheet = "password";
		String data = utility.ExcelData(path, sheet, 1, 1);
		System.out.println(data);
	}
}
