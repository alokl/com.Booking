package com.Blazedemo.Pages;

import java.util.List;
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


public class BookingConfirmation extends TestBaseFlight {

	WebDriver driver;
	
	public BookingConfirmation(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
		
	String before_xpath = "//table/tbody/tr[";
	String after_xpath = "]/td[1]";


	 
	@FindBy(xpath = "//table/tbody/tr[") 
	WebElement beforexpath;

	@FindBy(xpath = "]/td[1]") 
	WebElement Afterxpath;
	
	@FindBy(xpath ="//table/tbody/tr/td[1]")
	public List<WebElement> rowsWithData;

	 

	public boolean Bookingdetails()
	{
		
		boolean flag=driver.getPageSource().contains("Thank you for your purchase today!");
		
        return flag;
		

	}
	
	public void BookingReference()
	{
		for(int i=1; i<=rowsWithData.size(); i++){
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			if(name.contains("Id"))
			{
				String Id = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText();
				System.out.println(Id);
				break;
			
		}
	
	}

}}