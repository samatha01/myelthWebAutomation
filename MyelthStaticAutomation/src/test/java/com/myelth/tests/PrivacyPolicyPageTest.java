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

public class PrivacyPolicyPageTest {

	
		public static WebDriver driver;
		
		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			//JavascriptExecutor js  = (JavascriptExecutor) driver;
			PageObjects objects = new PageObjects(driver);
			driver.get("https://myelth.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
			//Privacy policy text test
			String privacyPolicyText = objects.privacyPolicy().getText();
			System.out.println(privacyPolicyText);
			Assert.assertEquals(privacyPolicyText, "PRIVACY POLICY", "Privacy Policy Text not found");
			
			//Privacy policy test
			objects.privacyPolicy().click();
			String privacyPolicyTitle = driver.getTitle();
			System.out.println(privacyPolicyTitle);
			Assert.assertEquals(privacyPolicyTitle, "Privacy Policy | myelth");
			
			//a[@class='auto-generated-link' and @href='https://myelth.com/terms-of-service.']
          WebElement e=
          driver.findElement(By.xpath("//a[@class='auto-generated-link' and @href='https://myelth.com/terms-of-service.']"));
           e.click();
           System.out.println(driver.getTitle());
	}

}
