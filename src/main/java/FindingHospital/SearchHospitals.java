package FindingHospital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SearchHospitals extends driver {

	// static String[] cities = new String[2];
	static FileInputStream file;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;

	Row row;
	Cell cell;

	Row row1;
	Cell cell1;

	@Test
	public void findHospitals() throws Exception {
		driver1.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		File src = new File("C:\\Users\\MANU SHARMA\\Desktop\\Hackathon\\Hackathon.xlsx");// object of FileInputStream
																							// class to open excel
		file = new FileInputStream(src); // object of FileInputStream class to read excel
		wb = new XSSFWorkbook(file);
		sheet = wb.getSheetAt(0);// To read sheet at index 0
		Cell c1 = sheet.getRow(0).getCell(0);// to get row[0] column[0] element
		driver1.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.clear();
		driver1.findElement(
				By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/input[1]"))
				.sendKeys(c1.getStringCellValue());// passing the value to website
		driver1.findElement(By.xpath("//div[contains(text(),'Bangalore')]")).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Cell c2 = sheet.getRow(0).getCell(1);// to get row[0] column[1] element
		driver1.findElement(
				By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"))
				.sendKeys(c2.getStringCellValue());
		Thread.sleep(1000);
		driver1.findElement(
				By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/input[1]"))
				.sendKeys(Keys.ENTER);

		driver1.findElement(By.xpath("//header/div[1]/div[1]/div[3]/label[1]/div[1]")).click();
		Thread.sleep(3000);
		driver1.findElement(By.xpath("//header/div[1]/div[1]/div[4]/i[1]")).click();
		driver1.findElement(By.xpath("//header/div[2]/div[1]/div[1]/div[1]/label[1]/div[1]")).click();

		/*
		 * List<WebElement> rating1=driver1.findElements(By.xpath("//*[@title='4']"));
		 * for(int i=0;i<rating1.size()-1;i++) { String ratingOne =
		 * rating1.get(i).getText(); System.out.println(ratingOne); } List<WebElement>
		 * rating2=driver1.findElements(By.xpath("//*[@title='4.5']")); for(int
		 * i=0;i<rating2.size()-1;i++) { String ratingTwo=rating2.get(i).getText();
		 * System.out.println(ratingTwo); }
		 * 
		 * List<WebElement> rating3=driver1.findElements(By.xpath("//*[@title='3.5']"));
		 * for(int i=0;i<rating3.size()-1;i++) { String ratingThree =
		 * rating3.get(i).getText(); System.out.println(ratingThree); }
		 */
		WebDriverWait wait = new WebDriverWait(driver1, 15);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("(//span[@class='common__star-rating__value'])[8]")));
		String[] names = new String[100];
		String[] rating = new String[100];

		names[1] = driver1.findElement(By.xpath("(//h2[@class='u-title-font u-c-pointer u-bold'])[1]")).getText();
		names[2] = driver1.findElement(By.xpath("(//h2[@class='u-title-font u-c-pointer u-bold'])[2]")).getText();
		names[3] = driver1.findElement(By.xpath("(//h2[@class='u-title-font u-c-pointer u-bold'])[3]")).getText();
		names[4] = driver1.findElement(By.xpath("(//h2[@class='u-title-font u-c-pointer u-bold'])[4]")).getText();
		names[5] = driver1.findElement(By.xpath("(//h2[@class='u-title-font u-c-pointer u-bold'])[5]")).getText();
		names[6] = driver1.findElement(By.xpath("(//h2[@class='u-title-font u-c-pointer u-bold'])[6]")).getText();
		names[7] = driver1.findElement(By.xpath("(//h2[@class='u-title-font u-c-pointer u-bold'])[7]")).getText();
		names[8] = driver1.findElement(By.xpath("(//h2[@class='u-title-font u-c-pointer u-bold'])[8]")).getText();
		
		rating[1] = driver1.findElement(By.xpath("(//span[@class='common__star-rating__value'])[1]")).getText();
		row = sheet.createRow(4);
		cell = row.createCell(0);
		cell1 = row.createCell(1);
		cell.setCellValue(names[1]);
		cell1.setCellValue(rating[1]);
		rating[2] = driver1.findElement(By.xpath("(//span[@class='common__star-rating__value'])[2]")).getText();
		row = sheet.createRow(5);
		cell = row.createCell(0);
		cell1 = row.createCell(1);
		cell.setCellValue(names[2]);
		cell1.setCellValue(rating[2]);
		rating[3] = driver1.findElement(By.xpath("(//span[@class='common__star-rating__value'])[3]")).getText();
		row = sheet.createRow(6);
		cell = row.createCell(0);
		cell1 = row.createCell(1);
		cell.setCellValue(names[3]);
		cell1.setCellValue(rating[3]);
		rating[4] = driver1.findElement(By.xpath("(//span[@class='common__star-rating__value'])[4]")).getText();
		row = sheet.createRow(7);
		cell = row.createCell(0);
		cell1 = row.createCell(1);
		cell.setCellValue(names[4]);
		cell1.setCellValue(rating[4]);
		rating[5] = driver1.findElement(By.xpath("(//span[@class='common__star-rating__value'])[5]")).getText();
		row = sheet.createRow(8);
		cell = row.createCell(0);
		cell1 = row.createCell(1);
		cell.setCellValue(names[5]);
		cell1.setCellValue(rating[5]);
		rating[6] = driver1.findElement(By.xpath("(//span[@class='common__star-rating__value'])[6]")).getText();
		row = sheet.createRow(9);
		cell = row.createCell(0);
		cell1 = row.createCell(1);
		cell.setCellValue(names[6]);
		cell1.setCellValue(rating[6]);
		rating[7] = driver1.findElement(By.xpath("(//span[@class='common__star-rating__value'])[7]")).getText();
		row = sheet.createRow(10);
		cell = row.createCell(0);
		cell1 = row.createCell(1);
		cell.setCellValue(names[7]);
		cell1.setCellValue(rating[7]);
		rating[8] = driver1.findElement(By.xpath("(//span[@class='common__star-rating__value'])[8]")).getText();
		row = sheet.createRow(11);
		cell = row.createCell(0);
		cell1 = row.createCell(1);
		cell.setCellValue(names[8]);
		cell1.setCellValue(rating[8]);
		FileOutputStream fos1 = new FileOutputStream("C:\\Users\\MANU SHARMA\\Desktop\\Hackathon\\Hackathon.xlsx");
		wb.write(fos1);
		fos1.flush();
		for (int i = 1; i < 9; i++) {
			System.out.println("name of the hospital: " + names[i] + " rating: " + rating[i]);
		}
	}

	@BeforeClass
	public void beforeClass() {
		driver1 = chrome();
	}

	@AfterClass
	public void afterClass() {
		driver1.quit();
	}

}
