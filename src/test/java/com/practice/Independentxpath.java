package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Independentxpath {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("poco mobiles",Keys.ENTER);
		driver.findElement(By.xpath("//div[.='POCO C31 (Royal Blue, 64 GB)']/ancestor::a[@class='_1fQZEK']//span[.='Add to Compare']")).click();
		
		driver.findElement(By.xpath("//input[@class='_3704LK']")).sendKeys("samsung mobiles",Keys.ENTER);

}
}
