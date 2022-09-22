package com.myelth.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EmployerPageTest {

		public static WebDriver driver;
		
		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			JavascriptExecutor js  = (JavascriptExecutor) driver;
			PageObjects objects = new PageObjects(driver);
			driver.get("https://myelth.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
			//Employer text test
			String employerText = objects.employer().getText();
			System.out.println(employerText);
			Assert.assertEquals(employerText, "Employer", "EmployerText not found");
			
			//Employer test
			objects.employer().click();
			String employerTitle = driver.getTitle();
			System.out.println(employerTitle);
			Assert.assertEquals(employerTitle, "Employer | myelth");
			
			//Contact Us - button display test
			boolean isContactUsDisplayed = driver.findElement(By.xpath("//a[@href='/contact-us/']")).isDisplayed();
			Assert.assertTrue(isContactUsDisplayed, "Contact Us button not displayed");
			
			//Contact Us - button test
			
			WebElement contactUs_Element = driver.findElement(By.xpath("//a[@href='/contact-us/']"));
			
			Thread.sleep(2000);
			contactUs_Element.click();
			String contact_us_title = driver.getTitle();
			System.out.println( contact_us_title);
			Assert.assertEquals( contact_us_title, "Contact Us | myelth");
			Thread.sleep(2000);
			driver.navigate().back();

	}

}
