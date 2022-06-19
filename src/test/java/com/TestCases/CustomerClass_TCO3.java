package com.TestCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.PageObjects.CustomerPage;
import com.PageObjects.LoginPage;



public class CustomerClass_TCO3 extends Base {
	
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	
	{
		
logger.info("launching the website ");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("writing user name ");
		lp.setPassword(password);
		logger.info("writing password ");
		lp.clickSubmit();
		logger.info("click on submit");
		Thread.sleep(3000);
		
		CustomerPage cust=new CustomerPage(driver);
		
cust.clickAddNewCustomer();
		
		logger.info("providing customer details....");
		
		
		cust.custName("Pavan");
		cust.custgender("male");
		cust.custdob("10","15","1985");
		Thread.sleep(5000);
		cust.custaddress("INDIA");
		cust.custcity("HYD");
		cust.custstate("AP");
		cust.custpinno("5000074");
		cust.custtelephoneno("987890091");
		
		String email= randomstring()  +"@gmail.com";
		cust.custemailid(email);
		cust.custpassword("abcdef");
		cust.custsubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation started....");
		
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");
			
		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
		
		
		
		
	}
	
	

}
