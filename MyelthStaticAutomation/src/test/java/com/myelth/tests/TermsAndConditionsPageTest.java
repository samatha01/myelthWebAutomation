package com.myelth.tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TermsAndConditionsPageTest {

	
		 public static WebDriver driver;
			
			public static void main(String[] args) throws Exception {
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver();
				//JavascriptExecutor js  = (JavascriptExecutor) driver;
				PageObjects objects = new PageObjects(driver);
				driver.get("https://myelth.com/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

				//Terms and conditions text test
				String termsAndConditionsText = objects.termsAndConditions().getText();
				System.out.println(termsAndConditionsText);
				Assert.assertEquals(termsAndConditionsText, "TERMS & CONDITIONS", "Terms And Conditions Text not found");
				
				//Terms and conditions test
				objects.termsAndConditions().click();
				String termsAndConditionsTitle = driver.getTitle();
				System.out.println(termsAndConditionsTitle);
				Assert.assertEquals(termsAndConditionsTitle, "Terms & Conditions | myelth");
				driver.close();
	}

}
