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

public class CustomerDetailsPage extends TestBaseFlight {
	//public static final Logger log = Logger.getLogger(HomePage.class.getName());
	WebDriver driver;
	
	public CustomerDetailsPage(WebDriver ldriver)
	{
	this.driver=ldriver;
	}
		
	@FindBy(xpath = "//*[@id='inputName']") 
	WebElement txtinputName;

	@FindBy(xpath = "//*[@id='address']") 
	WebElement txtaddress;
	
	@FindBy(xpath = "//*[@id='city']") 
	WebElement txtcity;

	@FindBy(xpath = "//*[@id='state']") 
	WebElement txtstate;
	
	@FindBy(xpath = "//*[@id='zipCode']") 
	WebElement txtzipCode;
	
	@FindBy(xpath = "//*[@id='cardType']") 
	WebElement txtcardType;

	@FindBy(xpath = "//*[@id='creditCardNumber']") 
	WebElement txtcreditCardNumber;
	
	@FindBy(xpath = "//*[@id='creditCardMonth']") 
	WebElement txtcreditCardMonth;
	
	@FindBy(xpath = "//*[@id='creditCardYear']") 
	WebElement txtcreditCardYear;

	@FindBy(xpath = "//*[@id='nameOnCard']") 
	WebElement txtnameOnCard;
	
	@FindBy(xpath = "//*[@value='Purchase Flight']") 
	WebElement btnpurchaseFlights;
	 

	public void CustDetails(String Name,String Address, String city,String state,String zipCode,String cardType, String creditCardNumber,String creditCardMonth,String creditCardYear, String nameOnCard)
	{
		
		txtinputName.sendKeys(Name);
		txtaddress.sendKeys(Address);
		txtcity.sendKeys(city);
		txtstate.sendKeys(state);
		txtzipCode.sendKeys(zipCode);
		txtcardType.sendKeys(cardType);
		txtcreditCardNumber.sendKeys(creditCardNumber);
		txtcreditCardMonth.sendKeys(creditCardMonth);
		txtcreditCardYear.sendKeys(creditCardYear);
		txtnameOnCard.sendKeys(nameOnCard);
		
		btnpurchaseFlights.click();
		

	}
	
	public boolean VerifyCustomerDetailsPage()
	{
		
		boolean flag=driver.getPageSource().contains("has been reserved.");
		
	    return flag;
		

	}

}