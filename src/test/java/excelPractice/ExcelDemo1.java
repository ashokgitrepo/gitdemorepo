package excelPractice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo1 {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("C:\\Users\\ASHOK KUMAR\\eclipse-workspace\\org.seleniumframework\\excel folder\\excelworkbook.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum();
		//System.out.println(rowCount);
		int colCount=sheet.getRow(0).getLastCellNum();
		for(int i=1;i<rowCount;i++)
		{
			XSSFRow row=sheet.getRow(i);
			for(int j=0;j<colCount;j++)
			{
				String values=row.getCell(j).toString();
				System.out.print("       "+values);
			}
			System.out.println("\n");
			
		}
		// TODO Auto-generated method stub

	}//https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F

}
