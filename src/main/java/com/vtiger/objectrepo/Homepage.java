package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver  driver;
	@FindBy(xpath="//a[.='Organizations']")
	private WebElement orglink;
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contactlink;
	public WebElement getOrglink() {
		return orglink;
	}
	public WebElement getContactlink() {
		return contactlink;
	}
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);
	}
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement signoutimg;
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutlink;
	public WebElement getSignoutimg() {
		return signoutimg;
	}
	public WebElement getSignoutlink() {
		return signoutlink;
	}
	
}
