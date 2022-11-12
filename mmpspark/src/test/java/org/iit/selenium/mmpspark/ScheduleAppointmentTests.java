package org.iit.selenium.mmpspark;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.iit.spark.mmp.helper.BaseClass;
import org.iit.spark.mmp.pages.HomePage;
import org.iit.spark.mmp.pages.ScheduleAppointmentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * 
Calendar.getTime();-> Today date and time [HH:mm:ss]

SimpleDateFormat : 21/10/2022 

String split function : year 
		            month
			        day 
 * @return 
 */
public class ScheduleAppointmentTests extends BaseClass{
	HomePage home ;
	@Test
	public void validateBookAppointment()
	{
		ScheduleAppointmentPage sPage = new ScheduleAppointmentPage(driver);
		HashMap<String,String> expectedHMap =sPage.bookAppointment(pro.getProperty("futureDate"));
		HomePage hPage = new HomePage(driver);
		HashMap<String,String> actualHMap =hPage.fetchPatientTableValues();
		Assert.assertEquals(actualHMap,expectedHMap);
	}
	 
	 

}






//2022!=2023
//inside the loop
//
//
//2022!=2022
// will not go inside the loop









