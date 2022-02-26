package vtiger_Test_data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.vtiger.objectrepo.Contactinfo;
import com.vtiger.objectrepo.Createcontactpage;
import com.vtiger.objectrepo.Homepage;
import com.vtiger.objectrepo.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_crm.Base_Class;
import vtiger_crm.FileUtils;
import vtiger_crm.JavaUtil;
import vtiger_crm.WebDriverUtilities;

public class TC03_create_contact extends Base_Class {
	@Test
	public void create_cont() throws Throwable {
		Homepage homepage=new Homepage(driver);
		homepage.getContactlink().click();
		Contactinfo contactinfo=new Contactinfo(driver);
		contactinfo.getCreatecontimg().click();


		Createcontactpage createcontactpage=new Createcontactpage(driver);
		WebElement elem = createcontactpage.getCreatecontsalutdd();
		webutil.selectfromdd(elem, "Mrs.");

		String fname = jv.fakefirstName();
		String lname = jv.fakelastName();
		createcontactpage.getCreatecontfntxb().sendKeys(fname);
		createcontactpage.getCreatecontlntxb().sendKeys(lname);

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
		System.out.println(ln);
		if(ln.equalsIgnoreCase(orgname))	
		{
			System.out.println("TC PASS");
		}
		else
		{
			System.out.println("TC FAIL");
		}

	}

}
