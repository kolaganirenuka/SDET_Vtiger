package vtiger_Test_data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.objectrepo.Createorgpage;
import com.vtiger.objectrepo.Homepage;
import com.vtiger.objectrepo.Loginpage;
import com.vtiger.objectrepo.Orginfopage;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_crm.FileUtils;
import vtiger_crm.JavaUtil;
import vtiger_crm.WebDriverUtilities;

public class Tc001_create_org {
	public static void main(String[] args) throws Throwable {
		FileUtils futil=new FileUtils();
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		String browser = futil.readdataprop("Browser");
		if(browser.equalsIgnoreCase("chrome")) {
			driver =new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")){

			driver =new FirefoxDriver();
		}
		else {
			driver= new EdgeDriver();

		}
		WebDriverUtilities webutil=new WebDriverUtilities();
		webutil.pageloadtimeouts(driver);
		driver.get(futil.readdataprop("Url"));
		Loginpage loginpage=new Loginpage(driver);
		loginpage.getUsertxtbox().sendKeys(futil.readdataprop("UN"));
		loginpage.getPwdtxtbox().sendKeys(futil.readdataprop("PW"));
		loginpage.getLoginbtn().click();
		Homepage homepage=new Homepage(driver);
		homepage.getOrglink().click();
		Orginfopage orginfopage=new Orginfopage(driver);
		orginfopage.getCreateorgimg().click();
		Thread.sleep(3000);
		JavaUtil jv=new JavaUtil();
		String orgname = jv.fakecompanyName();
		Createorgpage createorgpage=new Createorgpage(driver);
		createorgpage.getOrgname().sendKeys(orgname);
		createorgpage.getOrgsavebtn().click();
		Thread.sleep(3000);
		homepage.getOrglink().click();
		Thread.sleep(3000);
		orginfopage.getSearchtxtbox().sendKeys(orgname);
		WebElement ele = orginfopage.getOrgtypesdd();
		webutil.selectfromdd("Organization Name",  ele);
		orginfopage.getSearchorgbtn().click();
		Thread.sleep(3000);
		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		System.out.println(value);
		if(value.equals(orgname))
		{
			System.out.println("TC PASS");
		}
		else
		{
			System.out.println("TC FAIL");
		}
		WebElement signoutimg = homepage.getSignoutimg();
		webutil.actionelement(driver, signoutimg);
		homepage.getSignoutlink().click();
	}

}
