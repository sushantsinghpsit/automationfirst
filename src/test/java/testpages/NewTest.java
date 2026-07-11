package testpages;

import org.testng.annotations.Test;

import base.DBConnection;
import base.setup;
import page.homepage;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class NewTest extends setup {
	
homepage hp;
//DBConnection db = new DBConnection();
 @BeforeClass
 public void start() {
	 initiate();
	 hp = new homepage();
	 
 }
	
	
	
	
  @Test
  public void searchallproducts() {
	 
	  // Fetch Products From Database
      List<String> allproducts =
              DBConnection.getProducts();

      // Loop Through Products
      for(String product : allproducts) {

          System.out.println(
                  "Testing Product: "
                  + product);

          // Search Product
          boolean result =
                  hp.search(product);

          // Validation
          assertEquals(result, true);
          try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
            
		        
	  
	
	  
  
  }
  @AfterClass
  public void closeBrowser() {

      driver.close();
      DBConnection.closeConnection();

  }
  

}
