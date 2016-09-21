package FirstTestNGPackage;

import java.util.concurrent.TimeUnit;

//import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.support.ui.Select;

/*
 public class TCNBLLogin2 {
 private WebDriver driver;
 private String baseUrl;
 private boolean acceptNextAlert = true;
 private StringBuffer verificationErrors = new StringBuffer();

 @BeforeClass(alwaysRun = true)
 public void setUp() throws Exception {
 driver = new FirefoxDriver();
 baseUrl = "http://web.bancadigitalbod.com/";
 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
 }
 */
public class TC_NBL_Login_1_TNG {
	// WebDriver driver = new FirefoxDriver();

	// public String baseUrl = "http://newtours.demoaut.com";
	public String baseUrl = "https://web.bancadigitalbod.com";
	// + "/nblee6/f/ext/Login/index.xhtml";
	public WebDriver driver;

	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	@BeforeTest
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"D:/uti/DevVarios/chromedriver.exe");
		driver = new ChromeDriver();
		//driver = new FirefoxDriver();
		
		/*
		String marionetteDriverLocation = "D:/uti/DevVarios/wires.exe";
		System.setProperty("webdriver.gecko.driver", marionetteDriverLocation);
		driver = new MarionetteDriver();*/
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

		driver.get(baseUrl);
	}

	@Test(priority = 1)
	public void basicTest() {
		/*
		 * String expectedTitle = "Welcome: Mercury Tours"; String actualTitle =
		 * driver.getTitle(); Assert.assertEquals(actualTitle, expectedTitle);
		 */
		try {
			testNBLLogin1();
			// testTCNBLLogin2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @Test (priority = 2)
	public void testNBLLogin1() throws Exception {
		driver.get(baseUrl + "/nblee6/f/ext/Login/index.xhtml");
		new Select(driver.findElement(By.id("form:selectNumIdCli")))
				.selectByVisibleText("V");
		driver.findElement(By.id("form:txtNumIdCli")).sendKeys("13833336");
		driver.findElement(By.id("form:validarLogin")).click();
		// ERROR: Caught exception [ERROR: Unsupported command [selectWindow |
		// null | ]]
		driver.findElement(By.id("form:nombre")).clear();
		driver.findElement(By.id("form:nombre")).sendKeys("v13833336");
		driver.findElement(By.id("form:siguiente")).click();

		if (!driver.getPageSource().contains("Iniciar sesión")) { //if doesn't appear this message, you must to verify if you're using a frequent device

			testTCNBLLogin2_ValidarEquipoFrecuente();
			// while
			// (driver.getPageSource().contains("Verificación de usuario")) //validar
			// preguntas secretas
			// {
			// testTCNBLLogin2_ValidarEquipoFrecuente();
			// }

			driver.findElement(
					By.xpath("//*[@id='j_idt23:form:j_idt26']/tbody/tr[2]/td[2]/label"))
					.click(); // equipo no frecuente

			driver.findElement(
					By.xpath("//*[@id='j_idt23:form']/div/div[3]/a[2]"))
					.click(); // siguiente
		}
		
		WebDriverWait myWait = new WebDriverWait(driver, 10);
		myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='form:img']")));
				
		driver.findElement(
				By.xpath("//*[@id='form:img']")).getText().compareToIgnoreCase("gerundio");
		
	}

	// @Test (priority = 4)
	public void testTCNBLLogin2_ValidarEquipoFrecuente() throws Exception {

		String sQuestion = driver.findElement(
				By.xpath("//*[@id='j_idt25:form-recu']/div[1]/p[1]")).getText();
		// driver.findElement(By.xpath(//*[@id="j_idt25:form-recu"]/div[1]/p[1]);
		switch (sQuestion) {
		case "¿Cuál es la marca de tu primer vehículo?":
			driver.findElement(
					By.id("j_idt25:form-recu:j_idt30:0:respuestaPregunta"))
					.sendKeys("daewoo");
			break;
		case "nombre del chivo":
			driver.findElement(
					By.id("j_idt25:form-recu:j_idt30:0:respuestaPregunta"))
					.sendKeys("gerundio");
			break;
		case "¿Cuál es el nombre de tu mejor amigo/a de la infancia?":
			driver.findElement(
					By.id("j_idt25:form-recu:j_idt30:0:respuestaPregunta"))
					.sendKeys("domingo");
			break;
		case "¿Cuál es el nombre de la universidad a la que solicitaste ingresar?":
			driver.findElement(
					By.id("j_idt25:form-recu:j_idt30:0:respuestaPregunta"))
					.sendKeys("simon bolivar");
			break;
		}

		String sQuestion2 = driver.findElement(
				By.xpath("//*[@id='j_idt25:form-recu']/div[2]/p[1]")).getText();

		switch (sQuestion2) {
		case "¿Cuál es la marca de tu primer vehículo?":
			driver.findElement(
					By.id("j_idt25:form-recu:j_idt30:1:respuestaPregunta"))
					.sendKeys("daewoo");
			break;
		case "nombre del chivo":
			driver.findElement(
					By.id("j_idt25:form-recu:j_idt30:1:respuestaPregunta"))
					.sendKeys("gerundio");
			break;
		case "¿Cuál es el nombre de tu mejor amigo/a de la infancia?":
			driver.findElement(
					By.id("j_idt25:form-recu:j_idt30:1:respuestaPregunta"))
					.sendKeys("domingo");
			break;
		case "¿Cuál es el nombre de la universidad a la que solicitaste ingresar?":
			driver.findElement(
					By.id("j_idt25:form-recu:j_idt30:1:respuestaPregunta"))
					.sendKeys("simon bolivar");
			break;
		}

		driver.findElement(By.id("j_idt25:form-recu:siguiente")).click();
	}

	// @Test (priority = 3)
	public void testTCNBLLogin2() throws Exception {
		driver.findElement(By.id("form:contrasena")).sendKeys("Roller.135");
		driver.findElement(By.id("form:siguiente")).click();
	}

	private boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	private boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	private String closeAlertAndGetItsText() {
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			if (acceptNextAlert) {
				alert.accept();
			} else {
				alert.dismiss();
			}
			return alertText;
		} finally {
			acceptNextAlert = true;
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() throws Exception {
		// driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			fail(verificationErrorString);
		}
	}
	/*
	 * @AfterTest public void closeBrowser() { driver.quit(); }
	 */
}
