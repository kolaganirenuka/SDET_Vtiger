package testng_practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_Annotations {
	@Test
	@BeforeSuite
	public void bs() {
		System.out.println("before suite");
	}
	@Test
	@AfterSuite
	public void as() {
		System.out.println("after suite");
	}
	@Test
	@BeforeClass
	public void bc() {
		System.out.println("before class");
	}
	@Test
	@AfterClass
	public void ac() {
		System.out.println("after class");
	}
	@Test
	@BeforeMethod
	public void bm() {
		System.out.println("before method");
	}
	@Test
	@AfterMethod
	public void am() {
		System.out.println("after method");
	}
	@Test
	@BeforeTest
	public void bt() {
		System.out.println("before test");
	}
	@Test
	@AfterTest
	public void at() {
		System.out.println("after test");
	}

}
