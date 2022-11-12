package org.iit.spark.mmp.pages;

import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

	WebDriver driver;   
	HomePage hPage;

	public ProfilePage(WebDriver driver)
	{
		this.driver=driver;
	}
	public void handleAlert()
	{
		Alert alrt = driver.switchTo().alert();
		String text = alrt.getText();
		System.out.println(text);
		alrt.accept();
	}
	public void clickEditButton()
	{
		driver.findElement(By.id("Ebtn")).click(); 
	}
	public void submitEditData() {
		driver.findElement(By.id("Sbtn")).click();
	}
	public void enterFirstName(String expectedFNAME)
	{
		driver.findElement(By.id("fname")).clear();
		driver.findElement(By.id("fname")).sendKeys(expectedFNAME);
	}
	public void enterLastName(String expectedLName)
	{
		driver.findElement(By.id("lname")).clear();
		driver.findElement(By.id("lname")).sendKeys(expectedLName);
	}
	public HashMap<String, String> fetchAllFieldsData()
	{
		HashMap<String,String> profileDataHMap = new HashMap<String,String>();
		String actualFName= driver.findElement(By.id("fname")).getAttribute("value");
		profileDataHMap.put("FName",actualFName);
		
		String actualLName= driver.findElement(By.id("lname")).getAttribute("value");
		profileDataHMap.put("LName",actualLName);
		
		return profileDataHMap;
	}
}
