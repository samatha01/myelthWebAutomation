package com.myelth.tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.myelth.PageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Footer_Home {

		public static WebDriver driver;
		
		public static void main(String[] args) throws Exception {
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			//JavascriptExecutor js  = (JavascriptExecutor) driver;
			PageObjects objects = new PageObjects(driver);
			driver.get("https://myelth.com/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

			//Footer home text test
			String footerHomeText = objects.footerHome().getText();
			System.out.println(footerHomeText);
			Assert.assertEquals(footerHomeText, "HOME", "Footer Home Text not found");
			
			//Footer home test
			objects.footerHome().click();
			String footerHomeTitle = driver.getTitle();
			System.out.println(footerHomeTitle);
			Assert.assertEquals(footerHomeTitle, "myelth | healthtech with a consumer focus");
			
			
			
			
	}

}
