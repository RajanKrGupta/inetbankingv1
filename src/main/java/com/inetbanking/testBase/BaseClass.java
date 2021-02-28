package com.inetbanking.testBase;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL= readconfig.getApplicationURL();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setUP(String br) {

		if(br.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver =new ChromeDriver();
		}

		else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxPath());
			driver =new FirefoxDriver();
			
		}

		else if(br.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver =new InternetExplorerDriver();
		}
		
		driver.get(baseURL);


		logger=	Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");


	}

	@AfterClass
	public void tearDown() {
		driver.quit();


	}

}
