package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonprice {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("mobiles under 20000");
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();	
		Thread.sleep(10);
		driver.findElement(By.xpath("//span[.='Oppo']")).click();
		List<WebElement> prices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		for(int i=0;i<=prices.size();i++) {
			String price = prices.get(i).getText();
			String[] pri = price.split(",");
			String pr = pri[0]+pri[1];
			int p = Integer.parseInt(pr);
			Thread.sleep(10);
			if(p<20000) {
				System.out.println("mobile price is :"+p);
				System.out.println("Test case pass");
			}
			else {
				System.out.println("Test case fail");
			}
		}
	}

}
