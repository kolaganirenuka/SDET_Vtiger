package vtiger_Test_data;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com_vtger_framework.IAutoconstants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc001_create_org {

	public static void main(String[] args) throws Throwable {
		
		
		
		FileInputStream fis=new FileInputStream(IAutoconstants.propfilepath);
		Properties pro=new Properties();
		pro.load(fis);
		String browser=pro.getProperty("Browser");
		WebDriverManager.chromedriver().setup();

		WebDriver driver;
		
		
		if(browser.equalsIgnoreCase("chrome")) {
			

			driver =new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("firefox")){
			
			driver =new FirefoxDriver();
		}
		else {
			driver= new EdgeDriver();
			
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(pro.getProperty("Url"));
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(pro.getProperty("UN"));
		driver.findElement(By.name("user_password")).sendKeys(pro.getProperty("PW"));
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		Thread.sleep(3000);
		FileInputStream fis1=new FileInputStream(IAutoconstants.excelpath);
		String orgname=WorkbookFactory.create(fis1).getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();

		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		Thread.sleep(3000);


		driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);

		Select sel=new Select(driver.findElement(By.id("bas_searchfield")));
		sel.selectByValue("accountname");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
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
		WebElement signoutimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(signoutimg).build().perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	
		
		

	}

}
