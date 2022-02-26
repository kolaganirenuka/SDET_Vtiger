package vtiger_Test_data;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.vtiger.objectrepo.Createorgpage;
import com.vtiger.objectrepo.Homepage;
import com.vtiger.objectrepo.Orginfopage;

import vtiger_crm.Base_Class;

public class Tc001_create_org extends Base_Class{
	@Test
	public void create_org() throws Throwable {
		Homepage homepage= new Homepage(driver);
		homepage.getOrglink().click();

		Orginfopage orginfopage = new Orginfopage(driver);
		orginfopage.getCreateorgimg().click();

		String orgname = jv.fakecompanyName();

		Createorgpage createorgpage= new Createorgpage(driver);
		createorgpage.getOrgname().sendKeys(orgname);

		createorgpage.getOrgsavebtn().click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		homepage.getOrglink().click();
		Thread.sleep(2000);
		orginfopage.getSearchtxtbox().sendKeys(orgname);
		WebElement orgd = orginfopage.getOrgtypesdd();
		webutil.selectfromdd(orgd,"accountname");
		orginfopage.getSearchorgbtn().click();
		Thread.sleep(2000);
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

	}

}
