package com.TestCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Utilitiy.ReadConfig;

public class Base {
	
	ReadConfig readconfig =new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL() ;
	public String username=readconfig.getUsername();
	public String password=readconfig.getPassword() ;
	public static WebDriver driver ;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		logger=Logger.getLogger("Banking Project");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
		
		System.setProperty("webdriver.chrome.driver",readconfig.getChrome());
		driver=new ChromeDriver();
		}
		
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefox());
			driver=new FirefoxDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get(baseURL);
		//BasicConfigurator.configure();
		
		
	}
	
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

	
	
	public void captureScreen(WebDriver driver,String tname) throws IOException
	{
		TakesScreenshot ts= (TakesScreenshot)driver;
		File source= ts.getScreenshotAs(OutputType.FILE);
		File Dest= new File(System.getProperty("user.dir")+"/screenshots/"+tname+ ".png");
		FileUtils.copyFile(source, Dest);
		System.out.println("Screenshots taken");
		
		
	}
	
	
	public String randomstring()
	{
		String gen=RandomStringUtils.randomAlphabetic(5);
		return (gen);
	}
	
	public static String randomnum()
	{
		String gen1=RandomStringUtils.randomNumeric(4);
		return (gen1);
	}
}
