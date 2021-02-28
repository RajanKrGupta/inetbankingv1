package com.inetbanking.testCases;

import com.inetbanking.testBase.BaseClass;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest()
	{
		driver.get(baseURL);
		logger.info("Browser is Open");

		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);		
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickButtun();
		logger.info("Button Clicked");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Assert Pass");
		}
		else
		{
			Assert.assertTrue(false);
			logger.info("Assert Fail");
		}

	}



}
