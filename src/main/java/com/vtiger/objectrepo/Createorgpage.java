package com.vtiger.objectrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Createorgpage {

	WebDriver driver;

	@FindBy(name="accountname")
	private WebElement orgname;

	@FindBy(xpath="//input[@class='crmbutton small save']")
	private WebElement orgsavebtn;
	@FindBy(name="industry")
	private WebElement orginddd;
	@FindBy(name="rating")
	private WebElement orgratdd;
	@FindBy(name="accounttype")
	private WebElement orgacdd;


	public WebElement getOrgname() {
		return orgname;
	}

	public WebElement getOrgsavebtn() {
		return orgsavebtn;
	}

	public WebElement getOrginddd() {
		return orginddd;
	}

	public WebElement getOrgratdd() {
		return orgratdd;
	}

	public WebElement getOrgacdd() {
		return orgacdd;
	}

	public Createorgpage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
}
