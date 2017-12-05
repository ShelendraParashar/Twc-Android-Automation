package com.weather.screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class LocationManagerScreen {
	
	AndroidDriver<AndroidElement> driver;
		
	public @FindBy  (id="com.weather.Weather:id/search_icon")
	WebElement searchIcon;
	
	public @FindBy (id="com.weather.Weather:id/txt_location_name")
	WebElement searchTextBox;
	
	public @FindBy (id="com.weather.Weather:id/search_text")
	WebElement searchTextBoxAfterClick;
	
	public LocationManagerScreen(AndroidDriver<AndroidElement> driv) {
		this.driver=driv;
		PageFactory.initElements(driv, this);
	}
	
	
}
