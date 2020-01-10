package basicTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelTest {

	
//	@Test(dataProvider="data")
//	public void test1(Map<String, String> map)
//	{
//		System.out.println("User name is: " + map.get("UserName"));
//		System.out.println("Password is: " + map.get("Password"));
//	}
	
	
	
	//@DataProvider(name="data")
	//public static Object[][] excel() throws Exception
	public static void main(String[] args) throws Exception
	{
		
		//String keys = "";
		//String values="";
		String path="C:\\Users\\C049977\\Desktop\\TestExcel.xlsx";
		File file=new File(path);
		FileInputStream stream=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(stream);
		XSSFSheet sheet=wb.getSheetAt(0);
		wb.close();
		
		int total_rows=sheet.getLastRowNum();
		int total_col=sheet.getRow(0).getLastCellNum();
		//Object[][] obj=new Object[total_rows][1];
		
		
		for(int row=0; row<total_rows; row++)
		{
			
			Map<String, String> map=new HashMap<String, String>();
			
			for(int col=0; col<total_col; col++)
			{
				
				 XSSFCell key_cell=sheet.getRow(0).getCell(col);
				 XSSFCell value_cell=sheet.getRow(row+1).getCell(col);
				 //String values=sheet.getRow(row+1).getCell(col).getStringCellValue();
				 String value=null;
				 if(value_cell.getCellType() == CellType.NUMERIC)
				 {
					   value=String.valueOf(value_cell.getNumericCellValue());
					   String keys=key_cell.getStringCellValue();
					   map.put(keys, value);					 
				 }
				 
				 String keys=key_cell.getStringCellValue();
				 value=value_cell.getStringCellValue();
				 map.put(keys, value);
				 
			}
		
			System.out.println("User name is: " + map.get("UserName"));
			System.out.println("Password is: " + map.get("Password"));
			
			
			//obj[row][0]=map;
		}
		
		//return obj;
		
	}

}
