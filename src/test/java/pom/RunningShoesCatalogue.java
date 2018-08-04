package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class RunningShoesCatalogue extends Base_Page {

	public RunningShoesCatalogue(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="(//ul[@class='products-grid products-grid--max-4-col first last odd']//li[4]//a)[2]")
	private WebElement thirdelement;
	
	public void clickonshoeproduct(WebElement ele) {
		
		clickaction(thirdelement);
	}
	
	
	
	

}
