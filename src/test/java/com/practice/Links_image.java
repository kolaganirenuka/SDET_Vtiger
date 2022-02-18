package com.practice;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Links_image {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
	//	WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	//	search.sendKeys("samsung tv");
	//	System.out.println(search.getAttribute("value"));
		List<WebElement> names = driver.findElements(By.tagName("a"));
		System.out.println(names.size());
		for(int i=0;i<names.size();i++) {
			String link = names.get(i).getAttribute("href");
			System.out.println(link);
			verifyLnkActive(link);
		}
	}
	public static void verifyLnkActive(String linkurl)  {


		try {
			URL url=new URL(linkurl);
			HttpURLConnection urlconnection=(HttpURLConnection) url.openConnection();
			urlconnection.setConnectTimeout(3000);
			urlconnection.connect();
			if(urlconnection.getResponseCode()==200) {
				System.out.println(urlconnection.getResponseMessage());
			}
			else if(urlconnection.getResponseCode()==urlconnection.HTTP_NOT_FOUND) {
				System.out.println(urlconnection.getResponseMessage());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 

}



