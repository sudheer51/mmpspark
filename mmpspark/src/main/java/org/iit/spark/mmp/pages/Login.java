package org.iit.spark.mmp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;             //null
	
	public Login(WebDriver driver1)
	{
		driver=driver1;
	}
	
	public void login(String uname,String pword)
	{
		 
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pword);
		driver.findElement(By.name("submit")).click();
		 
		
	}
	 
	
}
