package generic;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.types.resources.selectors.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public abstract class Base_Page {
	
	public WebDriver driver;
	
	public Base_Page(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void verifyTitle(String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		try{
		wait.until(ExpectedConditions.titleContains(title));
		Reporter.log("title is matching",true);
		
		}
		catch(Exception e)
		{
			Reporter.log("title is not matching",true);
			Assert.fail();
		}
	}
	
	public void verifyElement(WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,10);
		
		try{
		wait.until(ExpectedConditions.visibilityOf(element));
		Reporter.log("element is present",true);
		}
		catch(Exception e)
		{
			Reporter.log("element is not present",true);
			Assert.fail();
		}
	}
	
	
	public void dropdown(WebElement element,String text) {
		
		Select s= new Select(element);
		try {
			s.selectByVisibleText(text);
			Reporter.log("option is present",true);
			
		}catch(Exception e) {
			
			Reporter.log("option is not present",false);
			Assert.fail();
		}
	
		
	}
	
	public void mouseover(WebDriver driver ,WebElement element) {
		
		Actions act= new Actions(driver);
		try {
			act.moveToElement(element).perform();
			Reporter.log("mouse hover action is performed ", true);
			
		}catch (Exception e) {
			
			Reporter.log("mouse hover action is not  performed ", false);
			Assert.fail();
		}
		
	}
	
	
	public void ScrollBarActions(WebDriver driver,int x , int y ) {
		
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Reporter.log("scroll bar action is performed ", true);
		
		try {
			js.executeScript("window.scrollby("+x+","+y+")");
		} catch (Exception e) {
			
			Reporter.log("scroll bar action is not performed ", false);
		}
		
		
	}
	
	
	public void clickaction(WebElement ele) {
		
		
		ele.click();	
	}
	
	
	public void PassData(WebElement tbox, String data) {
		
		tbox.sendKeys(data);
	}
	
	
	
	public static void ScreenShot(WebDriver driver, String path) {
		
		Date d = new Date();
		String s = d.toString();
		String date = s.replaceAll(":", "_");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src= ts.getScreenshotAs(OutputType.FILE);
		
		File dst = new File(path+date+".jpeg");
		
		try {
			FileUtils.copyFile(src, dst);
			
		} catch(Exception e){
			
			Reporter.log("cannot take screenshot",true);
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
