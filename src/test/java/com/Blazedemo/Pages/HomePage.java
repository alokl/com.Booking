package com.Blazedemo.Pages;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.test.automation.uiAutomation.testBase.TestBase.TestBaseFlight;
//import com.test.automation.uiAutomation.uiActions.HomePage;

public class HomePage extends TestBaseFlight {
	//public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	public HomePage(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
		
	@FindBy(name="fromPort") 
	WebElement drpfrmCountry;

	@FindBy(xpath = "//*[@value='Find Flights']") 
	WebElement btnfindFlights;
	
	@FindBy(name="toPort") 
	WebElement drptoCountry;
	 

	public void departfromcity(String fromPort)
	{
		
		Select dropdown = new Select(drpfrmCountry);  
		dropdown.selectByVisibleText(fromPort);

	}
	
	public void departtocity(String toPort)
	{
		
		Select dropdown = new Select(drptoCountry);  
		dropdown.selectByVisibleText(toPort);

	}

public void findflights()
{
	
	btnfindFlights.click();
}

public boolean VerifyHomePage()
{
	
	boolean flag=driver.getPageSource().contains("Welcome to the Simple Travel Agency!");
	
    return flag;
	

}

}