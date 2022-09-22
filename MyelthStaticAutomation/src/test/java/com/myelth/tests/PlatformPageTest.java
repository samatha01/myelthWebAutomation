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

public class PlatformPageTest {
	
		public static WebDriver driver;
				
		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			JavascriptExecutor js  = (JavascriptExecutor) driver;
			PageObjects objects = new PageObjects(driver);
			driver.get("https://myelth.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			//Platform text test
			String platformText = objects.platform().getText();
			System.out.println(platformText);
			Assert.assertEquals(platformText, "Platform", "PlatformText not found");
			
			//Platfom test
			objects.platform().click();
			String platformTitle = driver.getTitle();
			System.out.println(platformTitle);
			Assert.assertEquals(platformTitle, "Platform | myelth");
			
			
			//Video display test
		   boolean isVideoDisplayed = driver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_4']")).isDisplayed();
		   System.out.println(driver.findElement(By.xpath("//div[@class='et_pb_row et_pb_row_4']")).getText());
		   Assert.assertTrue(isVideoDisplayed, "Video is not loaded on the Platform page.");
																		
		   //video functionality test
			js.executeScript("document.getElementsByTagName('video')[0].play()");
			Thread.sleep(6000);
			js.executeScript("document.getElementsByTagName('video')[0].pause()");
											
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
			Assert.assertEquals( contact_us_title, "Contact Us | myelth");
			driver.close();
			
	}

}
