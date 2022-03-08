package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Properties_Fetch 
{
	public String note(String key) throws Exception
	{
		
		FileInputStream fs=new FileInputStream("C:\\Srinivas\\Orangehrm.PROPERTIES");
		Properties obj=new Properties();
		obj.load(fs);
		return obj.getProperty(key);
	}
	
	public String getExcel(String sheet,int row,int cell) throws Exception
	{
		FileInputStream fs1=new FileInputStream("C:\\Srinivas\\OrangeHrm.xlsx");
		Workbook book=WorkbookFactory.create(fs1);
		Sheet sh=book.getSheet(sheet);
		DataFormatter format=new DataFormatter();
		return format.formatCellValue(sh.getRow(row).getCell(cell));
	}
}
