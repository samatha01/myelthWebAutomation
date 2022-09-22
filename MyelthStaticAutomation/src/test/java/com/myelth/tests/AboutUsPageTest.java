package com.myelth.tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AboutUsPageTest {

	
		  public static WebDriver driver;
			
			public static void main(String[] args) throws Exception {
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				//JavascriptExecutor js  = (JavascriptExecutor) driver;
				PageObjects objects = new PageObjects(driver);
				driver.get("https://myelth.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
				
				//About us text test
				String aboutUsText = objects.aboutUs().getText();
				System.out.println(aboutUsText);
				Assert.assertEquals(aboutUsText, "ABOUT US", "About Us Text not found");
				
				//About us test
				objects.aboutUs().click();
				String aboutUsTitle = driver.getTitle();
				System.out.println(aboutUsTitle);
				Assert.assertEquals(aboutUsTitle, "About Us | myelth");
				driver.close();
				//objects.home().click();

	}

}
