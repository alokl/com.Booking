package com.Blazedemo.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
 
public class ReserveFlightPage 
{
 
WebDriver driver;
 
 
public ReserveFlightPage(WebDriver ldriver)
{
this.driver=ldriver;
}
 
String before_xpath = "//table/tbody/tr[";
String after_xpath = "]/td[2]";


 
@FindBy(xpath = "//table/tbody/tr[") 
WebElement beforexpath;

@FindBy(xpath = "]/td[2]") 
WebElement Afterxpath;

@FindBy(xpath = "//table/tbody/tr/td[1]")
public List<WebElement> rowsWithData;
 

public void BookFlight(String FlightNo)
{
	System.out.println(rowsWithData.size());
	for(int i=1; i<=rowsWithData.size(); i++){
		String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
		System.out.println(name);
		if(name.contains(FlightNo))
		{
			driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/input")).click();
			break;
		}
	}
}

public boolean VerifyFlightReser()
{
	
	boolean flag=driver.getPageSource().contains("Flights from Boston to London:");
	
    return flag;
	

}

}
 

 
