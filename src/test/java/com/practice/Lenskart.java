package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Lenskart {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
driver.get("https://www.lenskart.com/");
driver.findElement(By.xpath("//input[@class='search_input-bar autoSuggest']")).click();
List<WebElement> name = driver.findElements(By.xpath("//div[@class='trending_block']//li"));
for (WebElement list : name) {
	String s=list.getText();
	System.out.println(s);
	
}
	}

}
