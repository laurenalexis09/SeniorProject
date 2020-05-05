package excel;

import java.io.File;  
import java.io.FileInputStream;  
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  

public class ExcelImportTest{  

	public static void main(String[] args){  

		try{  
			File chrSht = new File("C:\\Users\\laure\\OneDrive\\Desktop\\DND\\Excel Character Sheet.xlsx");   //Locates file and imports it  
			FileInputStream stream = new FileInputStream(chrSht);   //obtaining bytes from the file   

			String value = null;
			int vRow = 3;
			int vColumn = 1;
			Cell cell = null;
			Row row = null;
			XSSFWorkbook wb = null;

			wb = new XSSFWorkbook(stream); //reference to the workbook   
			XSSFSheet sheet = wb.getSheetAt(0);     //Reference to the first sheet

			for(int i = 0; i <= 13; i++){//Loop to display all of the strings
				row= sheet.getRow(vRow); //returns row  
				cell= row.getCell(vColumn); //returns cell based on the row and column  
				value = (String)cell.getStringCellValue();//getting cell value  
				System.out.println(value);
				vRow+= 1;
			}

			System.out.println("");
			System.out.println("");
			System.out.println("");

			vColumn = 1;
			vRow = 17;
			for(int i = 17; i <= 20; i++){//Loop to display numeric attributes
				row = sheet.getRow(vRow); //returns row
				cell = row.getCell(vColumn); //returns cell based on the row and column 
				int value2 = (int)cell.getNumericCellValue();//getting cell value  
				System.out.println(value2);
				vRow+= 1;
			}

			System.out.println("");

			vColumn = 5;
			vRow = 3;
			for(int i = 3; i <= 8; i++){//Loop to display stats
				row = sheet.getRow(vRow); //returns row
				cell = row.getCell(vColumn); //getting the cell representing the given column  
				int value3 = (int)cell.getNumericCellValue();    //getting cell value  
				System.out.println(value3);
				vRow+= 1;
			}
		}  

		catch(Exception e){  
			e.printStackTrace();  
		}  
	}  
}  