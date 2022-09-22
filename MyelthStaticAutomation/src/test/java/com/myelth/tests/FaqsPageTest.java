package com.myelth.tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaqsPageTest {

	
     public static WebDriver driver;
		
		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			JavascriptExecutor js  = (JavascriptExecutor) driver;
			PageObjects objects = new PageObjects(driver);
			driver.get("https://myelth.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
			//FAQs text test
			String faqsText = objects.faqs().getText();
			System.out.println(faqsText);
			Assert.assertEquals(faqsText, "FAQS", "Faqs Text not found");
			
			//FAQs test
			objects.faqs().click();
			String faqsTitle = driver.getTitle();
			System.out.println(faqsTitle);
			Assert.assertEquals(faqsTitle, "FAQs | myelth");
			
	}

}
