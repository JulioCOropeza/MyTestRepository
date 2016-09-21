package FirstTestNGPackage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class FirstTestNGFile {
	// WebDriver driver = new FirefoxDriver();
	
	public String baseUrl = "http://newtours.demoaut.com";
	//public String baseUrl = "https://web.bancadigitalbod.com" + "/nblee6/f/ext/Login/index.xhtml";
	
	public WebDriver driver;

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:/uti/DevVarios/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}

	@Test (priority = 1)
	public void basicTest() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
		

	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
}
