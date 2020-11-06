package FindingHospital;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class driver {
	public static WebDriver driver1;
	public static WebDriver driver2;
	public static String url = "https://www.practo.com/";

	public static WebDriver chrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\MANU SHARMA\\Desktop\\Hackathon\\Drivers\\chromedriver.exe");
		WebDriver driver1 = new ChromeDriver();
		driver1.navigate().to(url);
		driver1.manage().window().maximize();
		return driver1;
	}

	public static WebDriver firefox() {
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\MANU SHARMA\\Desktop\\Hackathon\\Drivers\\geckodriver.exe");
		WebDriver driver2 = new FirefoxDriver();
		driver2.navigate().to(url);
		driver2.manage().window().maximize();
		return driver2;
	}
	

	public static Object switchTo() {
		// TODO Auto-generated method stub
		return null;
	}

}
