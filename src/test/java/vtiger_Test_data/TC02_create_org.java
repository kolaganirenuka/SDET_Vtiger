package vtiger_Test_data;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.vtiger.objectrepo.Createorgpage;
import com.vtiger.objectrepo.Homepage;
import com.vtiger.objectrepo.Orginfopage;

import vtiger_crm.Base_Class;
import vtiger_crm.IAutoconstants;

public class TC02_create_org extends Base_Class{
	@Test

	public void create_org_ddd() throws Throwable {
		Homepage homepage=new Homepage(driver);
		homepage.getOrglink().click();
		Orginfopage orginfopage=new Orginfopage(driver);
		orginfopage.getCreateorgimg().click();
		FileInputStream fisexcel = new FileInputStream(IAutoconstants.excelpath);
		int randomnumber = jv.generateRandomNumber();

		String orgnameexcel=WorkbookFactory.create(fisexcel).getSheet("Sheet1").getRow(2).getCell(0).getStringCellValue();
		String	orgname1=orgnameexcel+randomnumber;
		Createorgpage createorg=new Createorgpage(driver);
		createorg.getOrgname().sendKeys(orgname1);
		webutil.selectfromdd(createorg.getOrginddd(), "Banking");
		webutil.selectfromdd(createorg.getOrgratdd(), "Acquired");
		webutil.selectfromdd(createorg.getOrgacdd(), "Analyst");

		createorg.getOrgsavebtn().click();
		Thread.sleep(2000);
		homepage.getOrglink().click();
		orginfopage.getSearchtxtbox().sendKeys(orgname1);
		webutil.selectfromdd(orginfopage.getOrgtypesdd(), "accountname");
		orginfopage.getSearchorgbtn().click();
		Thread.sleep(3000);
		String value = driver.findElement(By.xpath("//a[@title='Organizations']")).getText();
		System.out.println(value);
		if(value.equals(orgname1))
		{
			System.out.println("TC PASS");
		}
		else
		{
			System.out.println("TC FAIL");
		}

	}

}
