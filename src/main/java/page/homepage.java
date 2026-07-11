package page;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.setup;


public class homepage extends setup {
	  public homepage() {

	       PageFactory.initElements(driver, this);
	    }
	
	@FindBy(xpath = "//input[@id = \"twotabsearchtextbox\"]")WebElement searchbox;
 @FindBy(xpath = "//input[@id = \"nav-search-submit-button\"]")WebElement searchicon;
	@FindBy(xpath = "//h2[@class = \"a-size-base a-spacing-small a-spacing-top-small a-text-normal\"]")WebElement result;
	
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
	
	
	
	public boolean search(String product) {
		wait.until(ExpectedConditions.elementToBeClickable(searchbox));
		searchbox.click();

        searchbox.sendKeys(Keys.CONTROL + "a");

        searchbox.sendKeys(Keys.DELETE);
		//searchbox.clear();
		searchbox.sendKeys(product);
		//wait.until(ExpectedConditions.visibilityOfElementLocated((By) searchicon));
		
		wait.until(ExpectedConditions.elementToBeClickable(searchicon));
		searchicon.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	String actualtext = result.getText();
	String 	expectedtext = product;
	if(actualtext.toLowerCase().contains(expectedtext))
		return true;
		
	else
		
		
		return false;
		
		
		
		
		
		
	}

}
