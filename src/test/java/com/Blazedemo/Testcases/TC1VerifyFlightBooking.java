package com.Blazedemo.Testcases;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Blazedemo.Pages.BookingConfirmation;
import com.Blazedemo.Pages.CustomerDetailsPage;
import com.Blazedemo.Pages.HomePage;
import com.Blazedemo.Pages.ReserveFlightPage;
//import com.test.automation.uiAutomation.homepage.TC002_VerifyRegistration;
//import com.crm.qa.pages.LoginPage;
import com.test.automation.uiAutomation.testBase.TestBase.TestBaseFlight;
/**
 * @author alokl
 * Testcases for end  to end flight booking
 *
 */


public class TC1VerifyFlightBooking extends TestBaseFlight
{
	
	String frmcity;
	String tocity;
	String flightno;
	String inputName;
	String address;
	String city;
	String state;
	String zipCode;
	String cardType;
	String creditCardNumber;
	String creditCardMonth;
	String creditCardYear;
	String nameOnCard;
	
	@BeforeClass
	public void setUp() throws IOException
	{
		initialize();
	}
	
@DataProvider(name="loginData")
	public String[][] getTestData(){
		String[][] testRecords = getData("TestData.xlsx", "LoginTestData");
		return testRecords;
	}

@Test(dataProvider="loginData")
public void verifyRecords(String departfromcity, String departtocity,String txtflightno,String txtName, String txtaddress,String txtcity, String txtstate,String txtzipCode, String txtcardType,String txtcreditCardNumber,String txtcreditCardMonth, String txtcreditCardYear,String txtnameOnCard)
{
	frmcity=departfromcity;
    tocity= departtocity;
    flightno=txtflightno;
    inputName =txtName;
	address = txtaddress;
	city=txtcity;
	state=txtstate;
	zipCode=txtzipCode;
	cardType=txtcardType;
	creditCardNumber=txtcreditCardNumber;
	creditCardMonth=txtcreditCardMonth;
	creditCardYear=txtcreditCardYear;
	nameOnCard=txtnameOnCard;

}


@Test(priority=1)
public void checkValidUser()
{
	
	//homePage = new  HomePage(driver);
	HomePage homepage= new  HomePage(driver);
	PageFactory.initElements(driver, homepage);
	Assert.assertTrue(homepage.VerifyHomePage());
	homepage.departfromcity(frmcity);
	homepage.departtocity(tocity);
	homepage.findflights();
}	

@Test(priority=2)
public void checkFlightselect()
{
	ReserveFlightPage Reserve_page= new  ReserveFlightPage(driver);
	PageFactory.initElements(driver, Reserve_page);
	Assert.assertTrue(Reserve_page.VerifyFlightReser());
	Reserve_page.BookFlight(flightno);
	
}

@Test(priority=3)
public void checkCustomerDetails()
{
	CustomerDetailsPage custdetailspage= new  CustomerDetailsPage(driver);
	PageFactory.initElements(driver, custdetailspage);
	Assert.assertTrue(custdetailspage.VerifyCustomerDetailsPage());
	custdetailspage.CustDetails(inputName,address,city,state,zipCode,cardType,creditCardNumber,creditCardMonth,creditCardYear,nameOnCard);
}

@Test(priority=4)
public void checkbookingconfirm()
{
	BookingConfirmation bookinconfirmpage= new  BookingConfirmation(driver);
	PageFactory.initElements(driver, bookinconfirmpage);
	bookinconfirmpage.BookingReference();
   Assert.assertTrue(bookinconfirmpage.Bookingdetails());

}

}