package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Base_Page;

public class RunningShoesDetailPage extends Base_Page {

	public RunningShoesDetailPage(WebDriver driver) {
		super(driver);
		
	}
	
	
	@FindBy(xpath="//div[@class='product-size-click-btn']")
	private WebElement sizedroparrow;
	
	public void clickDropArrow(WebElement ele) {
		
		clickaction(sizedroparrow);
	}
	
	
	@FindBy(xpath="//span[@id='180~229']")
	private WebElement selectsize;
	
	public void selectsize() {
		
		clickaction(selectsize);
	}
	
	
	
	

}
