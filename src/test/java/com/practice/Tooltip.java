package com.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.vtiger.objectrepo.Loginpage;

import io.github.bonigarcia.wdm.WebDriverManager;
import vtiger_crm.FileUtils;
import vtiger_crm.WebDriverUtilities;

public class Tooltip {

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
		 String tit = driver.findElement(By.xpath("//img[@title='Change layout']")).getAttribute("title");
		
		System.out.println(tit);
	}

}
