package com.TestCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PageObjects.LoginPage;
import com.Utilitiy.XLUtils;

public class LoginDataDriver_TC02 extends Base {
	
	
	
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String uname,String pward) throws InterruptedException
	{
	
		LoginPage lp=new LoginPage(driver);
		
		lp.setUsername(uname);
		logger.info("user name added");
		lp.setPassword(pward);
		logger.info("password added");
		lp.clickSubmit();
		logger.info("submitted ");
		
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			Thread.sleep(500);
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.info("Failed");
		}
		
		else
		{
			Assert.assertTrue(true);
			lp.doLogout();
			Thread.sleep(500);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			//logger.info("passed");
		}
		
		
	}
	
	public boolean isAlertPresent()
	{
		
		try
		{
			driver.switchTo().alert();
			return true;
		}catch(NoAlertPresentException e )
		{
			return false;
		}
		
		
	}
	
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		//String path= System.getProperty("user.dir")+"//src//test//java//com//TestData//Test_Data.xlsx";
		String path="D://new workspace//Banking//src//test//java//com//TestData//Test_Data.xlsx";
	     int rownum= XLUtils.getRowCount(path,"Sheet1");
	     int colcount =XLUtils.getCellCount(path,"Sheet1",1);
         String loginData[][]=new String[rownum][colcount];
         
         for(int i=1;i<=rownum;i++)
         {
        	 for(int j=0;j<colcount;j++)
        		 
        	 {
        		 
        		 loginData[i-1][j]=XLUtils.getCellData(path,"String1", i, j);
        	 }
        	 
         }
         
         return loginData;
		
	}
	

}
