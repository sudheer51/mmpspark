package org.iit.spark.mmp.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperClass {
	

	WebDriver driver;             //null
	
	public HelperClass(WebDriver driver1)
	{
		driver=driver1;
	}
	public String fetchText(String expected)
	{
		String actualPName = driver.findElement
				(By.xpath("(//h3[normalize-space()='"+expected+"'])[1]")).getText();
		return actualPName;
	}

}
