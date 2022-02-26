package com.practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Makemytrip {
	@Test
	public void selectcity() throws Throwable {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");
		driver.findElement(By.xpath("//li[@class='makeFlex hrtlCenter font10 makeRelative lhUser userLoggedOut']")).click();
		driver.findElement(By.xpath("//span[@class='lbl_input latoBold  appendBottom5']")).click();
		driver.findElement(By.xpath("//input[@class='react-autosuggest__input react-autosuggest__input--open']")).sendKeys("HYD");
		Thread.sleep(10);
		driver.findElement(By.xpath("//li[@class='react-autosuggest__suggestion react-autosuggest__suggestion--first']")).click();
		Thread.sleep(10);
		driver.findElement(By.id("tocity")).sendKeys("MUB");
	}

}
