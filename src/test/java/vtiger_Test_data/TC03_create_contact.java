package vtiger_Test_data;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
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

public class TC03_create_contact {

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
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		Select sel=new Select(driver.findElement(By.xpath("//select[@name='salutationtype']")));
		sel.selectByValue("Mr.");


		FileInputStream fis1=new FileInputStream(IAutoconstants.excelpath);

		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sheet = wb.getSheet("sheet1");
		Row row = sheet.getRow(2);

		String fname=row.getCell(0).getStringCellValue();

		Thread.sleep(2000);

		String lname=row.getCell(1).getStringCellValue();
		Thread.sleep(2000);

		WebElement firstname = driver.findElement(By.name("firstname"));
		WebElement lastname = driver.findElement(By.name("lastname"));

		firstname.sendKeys(fname);
		lastname.sendKeys(lname);

		//		click on + icon for add organization name
		driver.findElement(By.xpath("//input[@name='account_name']/../img")).click();
		Set<String> wins = driver.getWindowHandles();

		Iterator<String> it=wins.iterator();
		String parent= it.next();
		String child= it.next();

		//		Handling child window
		driver.switchTo().window(child);


		driver.findElement(By.id("search_txt")).sendKeys("Renuka");
		driver.findElement(By.xpath("//input[@name='search']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@id='1']")).click();

		driver.switchTo().window(parent);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(lname);
		WebElement insel = driver.findElement(By.xpath("//select[@id='bas_searchfield']"));

		Select sel1=new Select(insel);
		sel1.selectByValue("lastname");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		Thread.sleep(2000);
		String ln = driver.findElement(By.xpath("(//a[@title=\"Contacts\"])[2]")).getText();

		if(ln.equalsIgnoreCase(lname))	
		{
			System.out.println("TC PASS");
		}
		else
		{
			System.out.println("TC FAIL");
		}

		//		Signout from application
		WebElement signoutimg = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions ac=new Actions(driver);
		ac.moveToElement(signoutimg).build().perform();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		//			driver.close();

	}

}
