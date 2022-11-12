package org.iit.spark.mmp.pages;

import java.util.HashMap;

import org.iit.spark.mmp.util.AppLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ScheduleAppointmentPage {
	WebDriver driver;   
	HomePage hPage;

	public ScheduleAppointmentPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public HashMap<String, String> bookAppointment(String noofDays)
	{
		HashMap<String,String> expectedHMap = new HashMap<String,String>();
		hPage = new HomePage(driver);
		String moduleName ="Schedule Appointment";
		hPage.navigatetoAModule(moduleName);
		driver.findElement(By.cssSelector("input[value='Create new appointment']")).click();

		String doctorName = driver.findElement(By.xpath("//p[normalize-space()='Description:Orthopedic']/ancestor::ul/li/h4")).getText().replace("Dr.","");
		expectedHMap.put("doctor", doctorName);


		driver.findElement(By.xpath("//p[normalize-space()='Description:Orthopedic']/ancestor::ul/following-sibling::button")).click();
		driver.switchTo().frame("myframe");
		driver.findElement(By.id("datepicker")).click();

		String expectedDate = AppLibrary.generateFutureDate(Integer.parseInt(noofDays),"dd/MMMM/yyyy");
		expectedHMap.put("date", expectedDate);

		String dateArr[] = expectedDate.split("/");
		System.out.println(dateArr[0]);
		System.out.println(dateArr[1]);
		System.out.println(dateArr[2]);
		String expectedMonth = dateArr[1];
		String expectedYear = dateArr[2];
		String actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		while(!(actualYear.equals(expectedYear))){
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			actualYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		}
		String actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		while(!(actualMonth.equals(expectedMonth))){
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			actualMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		}
		driver.findElement(By.linkText(dateArr[0])).click();
		Select timeSelect = new Select(driver.findElement(By.id("time")));

		String timeValue = "10Am";
		expectedHMap.put("time", timeValue);

		timeSelect.selectByVisibleText(timeValue);
		driver.findElement(By.id("ChangeHeatName")).click();
		driver.switchTo().defaultContent();

		expectedHMap.put("sym", "Fever and Cold");
		driver.findElement(By.id("sym")).sendKeys("Fever and Cold");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();

		return expectedHMap;
	}
}
