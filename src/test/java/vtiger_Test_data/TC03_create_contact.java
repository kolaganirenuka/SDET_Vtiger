package vtiger_Test_data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.objectrepo.Contactinfo;
import com.vtiger.objectrepo.Createcontactpage;
import com.vtiger.objectrepo.Homepage;
import com.vtiger.objectrepo.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_crm.FileUtils;
import vtiger_crm.JavaUtil;
import vtiger_crm.WebDriverUtilities;

public class TC03_create_contact {
	public static void main(String[] args) throws Throwable {
		FileUtils futil=new FileUtils();
		WebDriverManager.chromedriver().setup();
		WebDriver driver;
		String browser=futil.readdataprop("Browser");
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
		homepage.getContactlink().click();
		Contactinfo contactinfo=new Contactinfo(driver);
		contactinfo.getCreatecontimg().click();
		Createcontactpage createcontactpage=new Createcontactpage(driver);
		WebElement elem = createcontactpage.getCreatecontsalutdd();
		webutil.selectfromdd(elem, "Mrs.");
		JavaUtil jv=new JavaUtil();
		String fname = jv.fakefirstName();
		String lname = jv.fakelastName();
		createcontactpage.getCreatecontfntxb().sendKeys(fname);
		createcontactpage.getCreatecontlntxb().sendKeys(lname);
		//		click on + icon for add organization name
		createcontactpage.getCreatecontwinhandle().click();
		webutil.windowhandles(driver, "Accounts");
		String orgname="Renuka";
		createcontactpage.getCreatecontsearchorgnametxt().sendKeys(orgname);
		createcontactpage.getCreatecontsearchorgname().click();
		Thread.sleep(3000);
		createcontactpage.getCreatecontgetorgname().click();
		webutil.windowhandles(driver, "Administrator");
		Thread.sleep(3000);
		createcontactpage.getCreatecontsavebtn().click();
		homepage.getContactlink().click();
		Thread.sleep(3000);
		contactinfo.getContsearchlntxt().sendKeys(lname);
		WebElement insel = contactinfo.getContsearchlndd();
		webutil.selectfromdd(insel,"lastname" );
		Thread.sleep(3000);
		contactinfo.getContsearchbtn().click();
		Thread.sleep(2000);
		String ln = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		if(ln.equalsIgnoreCase(orgname))	
		{
			System.out.println("TC PASS");
		}
		else
		{
			System.out.println("TC FAIL");
		}
		//		Signout from application
		WebElement signoutimg = homepage.getSignoutimg();
		webutil.actionelement(driver, signoutimg);
		homepage.getSignoutlink().click();
	}

}
