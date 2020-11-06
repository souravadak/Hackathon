package FindingHospital;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class searchForDiagnostic extends SearchHospitals{
	Row row;
	Cell cell;
	
	static FileInputStream file;
	static XSSFWorkbook wb;
	static XSSFSheet sheet;
	@Test(priority=1)
	public void searchForTopCities() throws Exception
	{
		driver1.navigate().to("https://www.practo.com/tests");
		File src = new File("C:\\Users\\MANU SHARMA\\Desktop\\Hackathon\\Hackathon.xlsx");//object of FileInputStream class to open excel
 		file=new FileInputStream(src); //object of FileInputStream class to read excel
 		wb = new XSSFWorkbook(file);
 		sheet=wb.getSheetAt(2);
		List<WebElement> cities= driver1.findElements(By.xpath("/html/body/div[3]/div/div/div/div/div/div/div/div[3]/ul"));
		for(int i=0;i<cities.size();i++)
        {
        	String text=cities.get(i).getText();
        	System.out.println("The major cities are:"+text);
        	for(int j=0;j<i+1;j++) {
        	row = sheet.createRow(j);
    		cell=row.createCell(j);
    		cell.setCellValue(text);
    		FileOutputStream fos = new FileOutputStream("C:\\Users\\MANU SHARMA\\Desktop\\Hackathon\\Hackathon.xlsx");
    		wb.write(fos);
    		fos.flush();
        	}
        }
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver1.navigate().back();
		
	}
}
