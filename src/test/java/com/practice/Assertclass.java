package com.practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertclass {
	@Test
	public void A() {
		System.out.println("launch browser");
		System.out.println("get url");
		System.out.println("login");
		SoftAssert sf=new SoftAssert();
		sf.assertEquals("HYD", "TYSS");
		//Assert.assertEquals("TYSS","TYSS");

		System.out.println("TEST step 1");
		System.out.println("TEST step 2");
		System.out.println("TEST step 3");
		System.out.println("TEST step 4");
		sf.assertAll();
	}

}
