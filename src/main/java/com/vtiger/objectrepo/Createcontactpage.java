package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createcontactpage {
	WebDriver driver;
	@FindBy(xpath="//select[@name='salutationtype']")
	private WebElement createcontsalutdd;
	@FindBy(name="firstname")
	private WebElement createcontfntxb;
	@FindBy(name="lastname")
	private WebElement createcontlntxb;
	@FindBy(xpath="//input[@name='account_name']/../img")
	private WebElement createcontwinhandle;
	@FindBy(id="search_txt")
	private WebElement createcontsearchorgnametxt;
	@FindBy(name="search")
	private WebElement createcontsearchorgname;
	@FindBy(id="1")
	private WebElement createcontgetorgname;
	@FindBy(xpath="//input[@class='crmButton small save']")
	private WebElement createcontsavebtn;
	public WebElement getCreatecontsalutdd() {
		return createcontsalutdd;
	}
	public WebElement getCreatecontfntxb() {
		return createcontfntxb;
	}
	public WebElement getCreatecontlntxb() {
		return createcontlntxb;
	}
	public WebElement getCreatecontwinhandle() {
		return createcontwinhandle;
	}
	public WebElement getCreatecontsearchorgnametxt() {
		return createcontsearchorgnametxt;
	}
	public WebElement getCreatecontsearchorgname() {
		return createcontsearchorgname;
	}
	public WebElement getCreatecontgetorgname() {
		return createcontgetorgname;
	}
	public WebElement getCreatecontsavebtn() {
		return createcontsavebtn;
	}
	public Createcontactpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
}
