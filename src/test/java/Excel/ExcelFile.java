package Excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {
	static String path;
	
	static XSSFWorkbook workbook;
	
	static XSSFSheet sheet;
	
	public static void main(String[] args) throws IOException {
		
		String path=".\\excel folder\\excelDataProvider.xlsx";
		System.out.println(path);
		ExcelFile data=new ExcelFile(path);
		System.out.println("excel file is opened");
		int r=data.getRowCount("Sheet1");
		System.out.println(r);
		int c=data.getColumnCount("Sheet1", 1);
		System.out.println(c);
		for(int a=0;a<r;a++) {
			for(int b=0;b<c;b++) {
				String s=data.getCellData(a,b,"Sheet1");
				System.out.print("\t"+s+"\t");
			}
			System.out.println("\n");
		}
	}
	
	
	public ExcelFile(String path)  {
		
		try {
			workbook=new XSSFWorkbook(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				


			
			
			
		
			}
	public  int getRowCount(String sheetname) throws IOException {
		
		
		
		
		
		
		sheet=workbook.getSheet(sheetname);
		
	    int rowcount;
		
	    rowcount=sheet.getPhysicalNumberOfRows();
	    
	    return rowcount;
	    
	}
	public int getColumnCount(String sheetname,int i) throws IOException {
		
		
		
		
		sheet=workbook.getSheet(sheetname);
		
		int columncount;
		
		columncount=sheet.getRow(i).getPhysicalNumberOfCells();
		
		return columncount;
		
	}	
	
	
	public   String getCellData(int rowcount,int columncount,String sheetname) throws IOException {
		
		
		
		sheet=workbook.getSheet(sheetname);
		
		
		String value;
		
		XSSFCell hero=sheet.getRow(rowcount).getCell(columncount);
		
		value=hero.getStringCellValue();
		workbook.close();
		
		return value;
		
	}
	
}



		
		
		
			
		
		
		
	


	
