package org.iit.selenium.mmpspark;

import org.iit.spark.mmp.helper.BaseClass;
import org.iit.spark.mmp.helper.HelperClass;
import org.iit.spark.mmp.pages.HomePage;
import org.iit.spark.mmp.pages.Login;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
public class PatientSanityTests extends BaseClass
{
	 
	HomePage home;
	Login login;
	HelperClass helper ;
	String username;
	 

	@Test(priority=1)
	public void validateLogin(){
		HelperClass helper = new HelperClass(driver);
		String actualPName= helper.fetchText(username);
		Assert.assertEquals(actualPName,username);

	}
	@Parameters({"username","password"})
	@Test(priority=2)
	public void performSanityTest(String username,String password)
	{


		SoftAssert sa = new SoftAssert();

		String moduleName ="Profile";
		home.navigatetoAModule(moduleName);
		String expected = "Personal Details";
		String actual= helper.fetchText(expected);
		sa.assertEquals(actual, expected,"Profile module is not loaded Successfully");


		moduleName ="Schedule Appointment";
		home.navigatetoAModule(moduleName);
		expected="Current Appointments";
		actual= helper.fetchText(expected);
		sa.assertEquals(actual, expected,"Schedule Appointment module is not loaded Successfully");

		moduleName ="Information";
		home.navigatetoAModule(moduleName);
		expected="Information";
		actual= helper.fetchText(expected);
		sa.assertEquals(actual, expected,"Information module is not loaded Successfully");

		moduleName ="Fees";
		home.navigatetoAModule(moduleName);
		expected="Fees";
		actual= helper.fetchText(expected);
		sa.assertEquals(actual, expected,expected+" module is not loaded Successfully");

		moduleName ="Search Symptoms";
		home.navigatetoAModule(moduleName);
		expected="Search Symptoms";
		actual= helper.fetchText(expected);
		sa.assertEquals(actual, expected,expected+" module is not loaded Successfully");

		moduleName ="Messages";
		home.navigatetoAModule(moduleName);
		expected="Messages";
		actual= helper.fetchText(expected);
		sa.assertEquals(actual, expected,expected+" module is not loaded Successfully");




		sa.assertAll();
	}
	@AfterClass
	public void validateLogout()
	{
		String moduleName ="Logout";
		home.navigatetoAModule(moduleName);
		String expectedTitle="NAMTG";
		String actualTitle = home.fetchTitle();
		Assert.assertEquals(expectedTitle, actualTitle,moduleName+" module is not  Successfull");
	}
}




