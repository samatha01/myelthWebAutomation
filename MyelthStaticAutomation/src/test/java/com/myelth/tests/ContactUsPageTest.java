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

public class ContactUsPageTest {

	
      public static WebDriver driver;
		
		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			JavascriptExecutor js  = (JavascriptExecutor) driver;
			PageObjects objects = new PageObjects(driver);
			driver.get("https://myelth.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
			
			//Contact us text test
			String contactUsText = objects.contactUs().getText();
			System.out.println(contactUsText);
			Assert.assertEquals(contactUsText, "CONTACT US", "Contact Us Text not found");
			
			//Contact us test
			objects.contactUs().click();
			String contactUsTitle = driver.getTitle();
			System.out.println(contactUsTitle);
			Assert.assertEquals(contactUsTitle, "Contact Us | myelth");
			Thread.sleep(2000);
			driver.navigate().back();
			driver.findElement(By.xpath("//input[@type='text' and @id='et_pb_contact_first_0']")).sendKeys("Peter");
			driver.findElement(By.xpath("//input[@type='text' and @id='et_pb_contact_email_0']")).sendKeys("abc@gmail.com");
			driver.findElement(By.xpath("//input[@type='text' and @id='et_pb_contact_last_0']")).sendKeys("Hudson");
			driver.findElement(By.xpath("//input[@type='text' and @id='et_pb_contact_phone_0']")).sendKeys("9999899993");
			driver.findElement(By.xpath("//textarea[@name='et_pb_contact_message_0']")).sendKeys("MyElth info");
			
			
			//captcha
			WebElement element=driver.findElement(By.xpath("//span[@class='et_pb_contact_captcha_question']"));
			String str=element.getText();
			String s1=str.substring(0, 2);
			String s2=str.substring(5, 6);
			Integer i1=Integer.valueOf(s1);
			Integer i2=Integer.valueOf(s2);
			System.out.println("No:1 " + i1 + "  No:2 " +i2);
			Integer i=i1+i2;
			String ans=String.valueOf(i);
			element=driver.findElement(By.xpath("//input[@class='input et_pb_contact_captcha']"));
			element.sendKeys(ans);
			//driver.findElement(By.xpath("//button[@type='submit']")).click();
			
	}

}
