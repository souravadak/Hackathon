package FindingHospital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class corporateWellness extends searchForDiagnostic{
	static FileInputStream file;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	Row row;
	Cell cell;
	@Test(priority=2)
	public void searchForCorporateWellness() throws Exception 
	{
		driver1.navigate().to("https://www.practo.com/plus/corporate");
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    	File src = new File("C:\\Users\\MANU SHARMA\\Desktop\\Hackathon\\Hackathon.xlsx");//object of FileInputStream class to open excel
 		file=new FileInputStream(src); //object of FileInputStream class to read excel
 		wb = new XSSFWorkbook(file);
 		sheet=wb.getSheetAt(1);//To read sheet at index 0
 		Cell c1=sheet.getRow(0).getCell(0);
		driver1.findElement(By.id("name")).sendKeys(c1.getStringCellValue());
		Cell c2 =sheet.getRow(0).getCell(1);
		driver1.findElement(By.id("organization_name")).sendKeys(c2.getStringCellValue());
		Cell c3 =sheet.getRow(0).getCell(2);
		driver1.findElement(By.id("official_email_id")).sendKeys(c3.getStringCellValue());
		Cell c4 =sheet.getRow(0).getCell(3);
		String number=String.valueOf(c4.getNumericCellValue());
		driver1.findElement(By.id("official_phone_no")).sendKeys(number);
		driver1.findElement(By.id("button-style")).click();
		WebDriverWait wait = new WebDriverWait(driver1, 20);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert=driver1.switchTo().alert();
		String alertmessage=driver1.switchTo().alert().getText();
		System.out.println("The warning message captured from alert is:"+alertmessage);
		row = sheet.createRow(2);
		cell=row.createCell(0);
		cell.setCellValue(alertmessage);
		FileOutputStream fos = new FileOutputStream("C:\\Users\\MANU SHARMA\\Desktop\\Hackathon\\Hackathon.xlsx");
		wb.write(fos);
		fos.flush();
		alert.accept();
		driver1.navigate().back();
	}
}
