package org.iit.spark.mmp.pages;

import java.util.Date;
import java.util.HashMap;

import org.iit.spark.mmp.util.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	

	WebDriver driver;             //null
	
	public HomePage(WebDriver driver1)
	{
		driver=driver1;
	}
	public void navigatetoAModule(String moduleName)
	{
		driver.findElement(By.xpath("//span[contains(.,'"+moduleName+" ')] ")).click();
	}
	public String fetchTitle()
	{
		 
		return driver.getTitle();
	}
	public HashMap<String, String> fetchPatientTableValues()
	{
		String date = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[1]")).getText();
		String actualDate =AppLibrary.convertDateFormat(new Date(date),"dd/MMMM/yyyy");
		String actualTime = driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[2]")).getText();
		String actualSym= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[3]")).getText();
		String actualDoctor= driver.findElement(By.xpath("//table[@class='table']/tbody/tr[1]/td[4]")).getText();
		HashMap<String,String> actualData = new HashMap<String,String>();
		actualData.put("date", actualDate );
		actualData.put("time", actualTime);
		actualData.put("sym", actualSym);
		actualData.put("doctor", actualDoctor);
		return actualData;
	}
}
