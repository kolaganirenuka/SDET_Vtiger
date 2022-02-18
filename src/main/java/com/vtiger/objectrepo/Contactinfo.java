package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactinfo {
	WebDriver driver;
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createcontimg;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement contsearchlntxt;
@FindBy(xpath="//select[@id='bas_searchfield']")
private WebElement contsearchlndd;
@FindBy(xpath="//input[@name='submit']")
private WebElement contsearchbtn;


	public WebElement getContsearchlntxt() {
	return contsearchlntxt;
}
public WebElement getContsearchlndd() {
	return contsearchlndd;
}
public WebElement getContsearchbtn() {
	return contsearchbtn;
}
	public WebElement getCreatecontimg() {
		return createcontimg;
	}
	public Contactinfo(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
