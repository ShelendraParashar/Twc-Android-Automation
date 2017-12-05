package com.weather.test;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.weather.BaseTest;
import com.weather.screens.LocationManagerScreen;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LocationManagerTest {
	
	AndroidDriver<AndroidElement> driver;
	LocationManagerScreen  LocationManagerPageObj;
	
	
	@Test(priority=0)
	public void testSearchIocnIsVisible() {  
		driver = BaseTest.setUp();
		LocationManagerPageObj = new LocationManagerScreen(driver);
		BaseTest.waitForElementToVisible( LocationManagerPageObj.searchIcon);
		Assert.assertTrue(LocationManagerPageObj.searchIcon.isDisplayed());
		
	}

	
/*	@Test(priority=1)
	public void testSearchLocationTextBoxTextHint() {
		Assert.assertEquals("Search locations", LocationManagerPageObj.searchTextBox.getText());
	}
	
	@Test(priority=2)
	public void testSearchAndSaveLocation() {
		BaseTest.clickOnElement(LocationManagerPageObj.searchIcon);
		BaseTest.typeTextInElement(LocationManagerPageObj.searchTextBoxAfterClick, "Miami");
	}*/
}
