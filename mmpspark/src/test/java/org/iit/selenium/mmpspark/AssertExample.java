package org.iit.selenium.mmpspark;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertExample {
	
	@Test
	public void a()
	{
		 
		SoftAssert sa = new SoftAssert();

		sa.assertEquals(1,2);
		sa.assertEquals(2,2);
		sa.assertEquals(3,3);
		System.out.println("After checking all the validation");
		sa.assertAll();
		 
		
	}

	@Test
	public void a1()
	{
		 
		 
		Assert.assertEquals(1,2);
		Assert.assertEquals(2,2);
		Assert.assertEquals(3,3);
		System.out.println("After checking all the validation in Assert");
	 
		 
		
	}

}
