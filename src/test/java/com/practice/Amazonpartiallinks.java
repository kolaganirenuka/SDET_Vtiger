package com.practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazonpartiallinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		List<WebElement> parlnks = driver.findElements(By.xpath("//div[.='Get to Know Us']/..//li"));
		System.out.println(parlnks.size());
		for (WebElement parlnk : parlnks) {
			String lnk = parlnk.getText();
			System.out.println(lnk);
		}
	}

}
