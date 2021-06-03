package com.test.practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Practice1 {
	
	//@Test
	//public void executSessionOne()
    public static void main( String[] args )
    {
    	System.setProperty("webdriver.chrome.driver", "D:\\Java_proj\\chromedriver_win32\\chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		//driver.get("http://www.demo.guru99.com");
		driver.get("https://blazedemo.com/reserve.php");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
/*		Select drpfrmCountry = new Select(driver.findElement(By.name("fromPort")));
		drpfrmCountry.selectByVisibleText("Boston");
		Select drptoCountry = new Select(driver.findElement(By.name("toPort")));
		drptoCountry.selectByVisibleText("London");*/
		
	      //Store the table size
        //WebElement webtable = driver.findElement(By.xpath("//*[contains(@class,'table')]"));
		//Get rows which has data
        List<WebElement> rowsWithData = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
        System.out.println(rowsWithData.size());
       // /html/body/div[2]/table/tbody/tr[1]/td[1]
        String before_xpath = "//table/tbody/tr[";
        String after_xpath = "]/td[2]";     
        //Print the whole web table
        //System.out.println("Table Data is: ");
        //for(int rowIndex =0; rowIndex<rowsWithData.size(); rowIndex++) {
		for(int i=1; i<=rowsWithData.size(); i++)
		{
			String name = driver.findElement(By.xpath(before_xpath + i + after_xpath)).getText();
			System.out.println(name);
			
		}

	
    }

}