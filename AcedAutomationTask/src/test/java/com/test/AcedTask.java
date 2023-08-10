package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcedTask {
	@Test
	   public void verifyMassege() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://in.bookmyshow.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement city = driver.findElement(By.xpath("//input[@placeholder='Search for your city']"));
		city.sendKeys("Bengaluru");
		Thread.sleep(1000);
		city.sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//div[text()='Sign in']")).click();
		driver.findElement(By.xpath("//div[text()='Continue with Email']")).click();
		driver.findElement(By.id("emailId")).sendKeys("selauto@yopmail.com");
		driver.findElement(By.xpath("//button[text()='Continue']")).click();
		
		
		driver.navigate().to("https://yopmail.com/");
		driver.findElement(By.id("login")).sendKeys("selauto@yopmail.com");
		driver.findElement(By.id("login")).sendKeys(Keys.ENTER);
		String otp= driver.findElement(By.xpath("//td[text()='']")).getText();
		System.out.print(otp);
		driver.navigate().back();
		driver.navigate().back();
//		
		String actmsg=  driver.findElement(By.xpath("//*[@id=\"super-container\"]/div[2]/header/div[1]/div/div/div/div[2]/div[2]/span")).getText();
		String expmsg= "Hi, Guest";
		Assert.assertEquals(actmsg,expmsg,"invalid user");

		Thread.sleep(3000);
		
		
	}

}
