package com.myelth.tests;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Payers {
	public static WebDriver driver;
	
			
		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			//JavascriptExecutor js  = (JavascriptExecutor) driver;
			PageObjects objects = new PageObjects(driver);
			driver.get("https://myelth.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
			//Payers text test
			String payersText = objects.payer().getText();
			System.out.println(payersText);
			Assert.assertEquals(payersText,"Payers", "PayersText not found");
			
			//Payers test
			objects.payer().click();
			String payerTitle = driver.getTitle();
			System.out.println(payerTitle);
			Assert.assertEquals(payerTitle, "Payers | myelth");
						
			//Contact Us - button display test
			boolean isContactUsDisplayed = driver.findElement(By.xpath("//a[@href='/contact-us/']")).isDisplayed();
			Assert.assertTrue(isContactUsDisplayed, "Contact Us button not displayed");
			
			//Contact Us - button test
			
			WebElement contactUs_Element = driver.findElement(By.xpath("//a[@href='/contact-us/']"));
			//WebElement element = driver.findElement(By.xpath("//a[.='contact us']"));
			Thread.sleep(2000);
			contactUs_Element.click();
			String contact_us_title = driver.getTitle();
			System.out.println( contact_us_title);
			//Assert.assertEquals( contact_us_title, "Contact Us | myelth");
	
			driver.navigate().back();
			driver.close();
			

	}

}
