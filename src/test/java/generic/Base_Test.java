package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base_Test implements Auto_const{
	
	static
	{
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	
	public WebDriver driver;
	
	@BeforeMethod
	public void openAppln()
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		 driver=new ChromeDriver();
		driver.get("https://in.puma.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeAppln()
	{
		driver.quit();
	}

}
