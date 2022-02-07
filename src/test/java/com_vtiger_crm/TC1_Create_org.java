package com_vtiger_crm;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC1_Create_org {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
WebDriver driver=new ChromeDriver();
driver.get("http://localhost:8888/");
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.manage().window().maximize();
driver.findElement(By.name("user_name")).sendKeys(("admin"));
driver.findElement(By.name("user_password")).sendKeys(("admin"));
driver.findElement(By.id("submitButton")).click();

driver.findElement(By.xpath("//a[.='Organizations']")).click();
driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		

	}

}
