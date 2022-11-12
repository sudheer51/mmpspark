package org.iit.spark.mmp.helper;

import java.io.IOException;
import java.util.Properties;

import org.iit.spark.mmp.pages.Login;
import org.iit.spark.mmp.util.ProjectConfiguration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	protected  WebDriver driver;
	protected Properties pro;
	Login login;
	
 
	@Parameters({"username","password"})
	@BeforeClass
	public void instantiateDriver(String username,String password) throws IOException
	{
		ProjectConfiguration pConfig = new ProjectConfiguration();
		pro = pConfig.loadProperties();
		String browser = pro.getProperty("browserType");
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if(browser.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get("http://96.84.175.78/MMP-Release2-Integrated-Build.6.8.000/portal/login.php");
		login = new Login(driver);
		login.login(username,password);
	}
}
