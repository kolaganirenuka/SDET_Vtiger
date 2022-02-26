package vtiger_crm;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.vtiger.objectrepo.Homepage;
import com.vtiger.objectrepo.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	public WebDriver driver;
	public FileUtils fileutil = new FileUtils();
	public WebDriverUtilities webutil = new WebDriverUtilities();
	public JavaUtil jv = new JavaUtil();

	@BeforeSuite
	public void makeConnections() {
		System.out.println("Before Siute");
		System.out.println("data base connection");
	}
	@BeforeTest
	public void beforeTest() 
	{
		System.out.println("==Before Test==");
	}

	@BeforeClass
	public void launchbrowser_driver_Initilize() throws Throwable {
		WebDriverManager.chromedriver().setup();
		String BROWSER=fileutil.readdataprop("Browser");
		if(BROWSER.equalsIgnoreCase("Chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();	
		}
		else if(BROWSER.equalsIgnoreCase("Edge")) {
			driver= new EdgeDriver();
		}
		else {
			driver= new FirefoxDriver();
		}

		driver.get(fileutil.readdataprop("Url"));

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@BeforeMethod
	public void logintoApp() throws Throwable {
		Loginpage loginpage = new Loginpage(driver);
		
		loginpage.getUsertxtbox().sendKeys(fileutil.readdataprop("UN"));

		loginpage.getPwdtxtbox().sendKeys(fileutil.readdataprop("PW"));

		loginpage.getLoginbtn().click();
	}

	@AfterMethod
	public void logoutFromApp()
	{
		
		Homepage homepage = new Homepage(driver);
		WebElement signoutimg1 = homepage.getSignoutimg();
		webutil.actionelement(driver, signoutimg1);

		homepage.getSignoutlink().click();
		System.out.println("Logout form App");
	}
	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(10000);
		driver.close();
	}


	@AfterTest
	public void aftertest() {
		System.out.println("after test");
	}
	@AfterSuite
	public void aftersuite() {
		System.out.println("after suite");
	}




}

