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

public class NewsPageTest {

			//div[@class='notfound']
	public static WebDriver driver;
		
		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			JavascriptExecutor js  = (JavascriptExecutor) driver;
			PageObjects objects = new PageObjects(driver);
			driver.get("https://myelth.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
			//News text test
			String newsText = objects.news().getText();
			System.out.println(newsText);
			Assert.assertEquals(newsText, "News", "NewsText not found");
			
			//News test
			objects.news().click();
			String newsTitle = driver.getTitle();
			System.out.println(newsTitle);
			Assert.assertEquals(newsTitle, "News | myelth");
			
			//Healthcare Tech Outlook
			WebElement healthCareElement=driver.findElement(By.xpath("//a[@href='https://communications.healthcaretechoutlook.com/vendors/top-healthcare-communication-solution-companies.html']"));
            String healthCareElementTitle=healthCareElement.getText();
            System.out.println(healthCareElementTitle);
            Assert.assertEquals(healthCareElementTitle,"Healthcare Tech Outlook");
            healthCareElement.click();
           System.out.println(driver.getTitle());
           driver.navigate().back();
           //here
          WebElement hereElement=driver.findElement(By.xpath("//a[@href='https://communications.healthcaretechoutlook.com/vendor/myelth-delivering-complete-control-to-the-consumer-cid-1818-mid-163.html'][.='here']")); 
          String hereElementTitle=hereElement.getText();
          System.out.println(hereElementTitle);
          //Website is not currently available in your region or country
           hereElement.click();
         System.out.println(driver.getTitle());
         driver.navigate().back();
         //image
      WebElement img=driver.findElement(By.xpath("//img[@src='https://secureservercdn.net/198.71.189.51/bnw.5eb.myftpupload.com/wp-content/uploads/2022/06/myElth-HC_Tech-Award_PNG.webp']"));
         img.click();
         String imgTitle=driver.getTitle();
         System.out.println(imgTitle);//Website is not currently available in your region or country
         driver.navigate().back();
         
       //Contact Us - button display test
		//	boolean isContactUsDisplayed = driver.findElement(By.xpath("//a[.='contact us']")).isDisplayed();
			//Assert.assertTrue(isContactUsDisplayed, "Contact Us button not displayed");
			
			//Contact Us - button test
			
		/*	WebElement element = driver.findElement(By.xpath("//a[.='contact us']"));
			Thread.sleep(2000);
			element.click();
			String contact_us_title = driver.getTitle();
			System.out.println( contact_us_title);
			Assert.assertEquals( contact_us_title, "Contact Us | myelth");
			Thread.sleep(2000);
			driver.navigate().back();
			driver.navigate().back();*/
         }

}
