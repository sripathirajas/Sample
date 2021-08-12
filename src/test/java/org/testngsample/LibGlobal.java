package org.testngsample;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.google.common.collect.Table.Cell;

import io.github.bonigarcia.wdm.WebDriverManager;





public class LibGlobal {
	
	public  static WebDriver driver;
	
	public static WebDriver getChromeDriver() {
	WebDriverManager.chromedriver().setup();
		return driver;
		
	}
	

	
	
	
	public void loadUrl(String data) {
		driver.get(data);
	}
	
	
	
	public void maximizeBrowser() {
		driver.manage().window().maximize();
	}
	
	
	public String  getData(int rowNo, int cellNo) throws IOException {
		String data = null;
		File file = new File("C:\\Users\\srira\\eclipse-workspace\\SriRam\\Raja\\SriPathi\\Adactin\\Test Data\\Adacti.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("Bookings");
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		int type = cell.getCellType();
		if (type==1) {
			data = cell.getStringCellValue();
		}
		 
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date date = cell.getDateCellValue();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			data = format.format(date);
			}
		else
		{
			double d = cell.getNumericCellValue();
			long l = (long)d;
			data = String.valueOf(l);
		}
		return data;
		
	}
	
	
	public void typeInput(WebElement element,String data) {
		element.sendKeys(data);
	}
	
	
	public String geTAttribute(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}

	
	public void saveExcel() throws IOException {
		File file = new File("C:\\\\Users\\\\srira\\\\eclipse-workspace\\\\SriRam\\\\Raja\\\\SriPathi\\\\Adactin\\\\Test Data\\\\Adacti.xlsx");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		Workbook workbook = new  XSSFWorkbook();
		workbook.write(fileOutputStream);
	}
	
	public void insertDataIntoExcel(WebElement element, int rowNo, int CellNo) throws IOException {
		File file = new File("C:\\Users\\srira\\eclipse-workspace\\SriRam\\Raja\\SriPathi\\Adactin\\Test Data\\Adacti.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workbook.getSheet("Bookings");
		Row createRow = sheet.getRow(rowNo);
		Cell createCell = createRow.createCell(CellNo);
		
		String attribute = element.getAttribute("value");
		createCell.setCellValue(attribute);
		
		FileOutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		System.out.println("done");
	}
	
	
}