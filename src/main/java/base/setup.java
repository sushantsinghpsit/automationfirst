package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class setup {
	
	public static  WebDriver driver;
	public static String url = "https://www.amazon.in/";
	
	public void initiate() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SUSHANT\\Downloads\\latestdriver\\chromedriver-win64\\chromedriver.exe");	
		driver = new  ChromeDriver();
		driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Open Amazon
        driver.get(url);
		
		
		
	}
	}

