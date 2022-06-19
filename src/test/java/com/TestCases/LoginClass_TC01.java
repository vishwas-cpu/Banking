package com.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.LoginPage;

public class LoginClass_TC01 extends Base {
	
	
	@Test
	public void loginTest() throws IOException
	{
		
		logger.info("launching the website ");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("writing user name ");
		lp.setPassword(password);
		logger.info("writing password ");
		lp.clickSubmit();
		logger.info("click on submit");
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("passed ");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("failed ");
		}
		
	}

}
