package Selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadXmlDay9 {

	public static void main(String[] args) throws IOException {

		//1.Get the path of file
		String filePath = "C:\\Training\\Read.xlsx";
		
		//2.Add the file to the file input stream object 
		FileInputStream excelfile= new FileInputStream(filePath);
		
		//3.Assign the file input stream to workBook XSSFWorkbook
		XSSFWorkbook excelworkbook=new XSSFWorkbook(excelfile);
		
		//4.Get the sheet from the book
		XSSFSheet excelsheet = excelworkbook.getSheet("Login");
		
		//Print the cell data
		//System.out.println(excelsheet.getRow(1).getCell(0));
		
		int totalrows=3;
		int totalcols=2;
		
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<=totalcols;j++) {
				System.out.print(excelsheet.getRow(i).getCell(j));
				System.out.print("\t");
			}System.out.print("\n");
		}
		
		excelworkbook.close();
	}

}
