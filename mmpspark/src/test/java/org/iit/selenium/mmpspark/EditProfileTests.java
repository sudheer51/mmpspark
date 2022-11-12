package org.iit.selenium.mmpspark;

import java.util.HashMap;
import java.util.Random;

import org.iit.spark.mmp.helper.BaseClass;
import org.iit.spark.mmp.pages.HomePage;
import org.iit.spark.mmp.pages.ProfilePage;
import org.iit.spark.mmp.util.AppLibrary;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
/*
 * String expectedFNAME="Ria FNAME";
click on edit 
clear the textbox 
sendKeys(expectedFName);
click on save
fetchthe textbox attribute "value": actualFName
compare actualFName against expectedFName 
 */
public class EditProfileTests extends BaseClass{
	
	
	HomePage hPage;
	Random rand;
	ProfilePage profilePage;
	@BeforeClass
	public void navigateToProfile()
	{
		hPage = new HomePage(driver);
		String moduleName ="Profile";
		hPage.navigatetoAModule(moduleName);
		profilePage = new ProfilePage(driver);
		 
	}
	
	@Test
	public void validateEditFirtNameField()
	{
		String expectedFNAME= AppLibrary.randomStringValue("RiaFNAME");
		profilePage.clickEditButton();
		profilePage.enterFirstName(expectedFNAME);
		profilePage.submitEditData();
		profilePage.handleAlert();
		HashMap<String,String> profileHMap = profilePage.fetchAllFieldsData();
		Assert.assertEquals(expectedFNAME, profileHMap.get("FName"));
		
	}
	 
	@Test 
	public void validateEditLastNameField()
	{
		String expectedLNAME=AppLibrary.randomStringValue("RiaLNAME");
		profilePage.clickEditButton();
		profilePage.enterLastName(expectedLNAME);
		profilePage.submitEditData();
		profilePage.handleAlert();
		HashMap<String,String> profileHMap = profilePage.fetchAllFieldsData();
		Assert.assertEquals(expectedLNAME, profileHMap.get("LName"));
	}
	@Test
	public void editAllFields()
	{
		String expectedFNAME= AppLibrary.randomStringValue("RiaFNAME");
		String expectedLNAME=AppLibrary.randomStringValue("RiaLNAME");
		profilePage.clickEditButton();
		profilePage.enterFirstName(expectedFNAME);
		profilePage.enterLastName(expectedLNAME);
		profilePage.submitEditData();
		profilePage.handleAlert();
		SoftAssert sa = new SoftAssert();
		HashMap<String,String> profileHMap = profilePage.fetchAllFieldsData();
		sa.assertEquals(expectedFNAME, profileHMap.get("FName"),"Edit Functionality is not working for First Name");
		sa.assertEquals(expectedLNAME, profileHMap.get("LName"),"Edit functionality is not working for Last Name");
		sa.assertAll();
		 
	}
	 
	 

}
