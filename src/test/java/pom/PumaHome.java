package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class PumaHome extends Base_Page {

	public PumaHome(WebDriver driver) {
		super(driver);
	
	}
	
	
	@FindBy(xpath="(//a[@class='digimeg-nav-item'])[1]")
	private WebElement men;
	
	
	@FindBy(xpath="(//a[.='Running'])[6]")
	private WebElement runningshoes;
	
	
	
	public void mouseaction(WebDriver driver , WebElement ele) {
		
		                             mouseover(driver,ele);
			 }
	
	
	public void runningshoesclick(WebElement ele) {
		
		clickaction(runningshoes);
	}
	
	

}
