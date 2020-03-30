package IES_TestBaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.Utilities.Utilities;
import com.qa.Utilities.WebEventListener;

public class BaseClass {
	public static WebDriver driver;
	public static FileInputStream fi;
	public static XSSFWorkbook wbo;
	public static XSSFSheet wso;
	public  static Row row;
	public  static Cell cell;
	public static JavascriptExecutor jse;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriverWait wait;

	public BaseClass() {
		try {
			fi = new FileInputStream("E:/IES Validation Data/IESProperties.xlsx");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			wbo = new XSSFWorkbook(fi);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		wso = wbo.getSheet("Environ_Selection");
		if (wso.getRow(1).getCell(0).getStringCellValue().trim().equalsIgnoreCase("Dev")) {
			wso = wbo.getSheet("IES_DevVariables");
		} else {
			wso = wbo.getSheet("IES_ProdVariables");
		}
	}

	public static void initialization() throws IOException {
		// Initializing the browser
		String BrowserName = wso.getRow(1).getCell(0).getStringCellValue().trim();
		// String BrowserName ="Chrome";
		if (BrowserName.equalsIgnoreCase("FireFox")) {
			FirefoxProfile newProfile = new FirefoxProfile();
			newProfile.setPreference("dom.webnotifications.enabled", false);
			DesiredCapabilities desCap = DesiredCapabilities.firefox();
			desCap.setCapability(FirefoxDriver.PROFILE, newProfile);
			FirefoxOptions opt = new FirefoxOptions();
			opt.merge(desCap);
			System.setProperty("webdriver.gecko.driver", "E:/FireFox0.26/geckodriver.exe");

			driver = new FirefoxDriver(opt);
			jse = (JavascriptExecutor) driver;
			wait = new WebDriverWait(driver, 30);

		} else if (BrowserName.equalsIgnoreCase("Chrome")) {
			ChromeOptions coptions = new ChromeOptions();
			coptions.setPageLoadStrategy(PageLoadStrategy.NONE);
			coptions.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "E:/ChromeDriver80/chromedriver.exe");

			driver = new ChromeDriver(coptions);
			jse = (JavascriptExecutor) driver;
			wait = new WebDriverWait(driver, 30);
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with
		// EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String AgentURL = wso.getRow(1).getCell(1).getStringCellValue().trim();
		// String AgentURL ="https://web-dev.ieswebservices.com/Default.aspx";
		driver.get(AgentURL);
		///////////// DEBUG [main] cache:45 - Couldn't find template in cache
		///////////// for///////////////
		System.setProperty("org.freemarker.loggerLibrary", "none");
		driver.manage().timeouts().pageLoadTimeout(Utilities.Page_Load, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utilities.Implicit_Time, TimeUnit.SECONDS);
	}
}
