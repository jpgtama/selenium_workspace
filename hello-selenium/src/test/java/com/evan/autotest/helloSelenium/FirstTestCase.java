package com.evan.autotest.helloSelenium;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FirstTestCase {

	/**
	 * driver
	 */
	private static WebDriver driver;

	/**
	 * setup
	 */
	@BeforeClass
	public static void setup() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();

		// Puts a Implicit wait, Will wait for 10 seconds before throwing
		// exception
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * teardown
	 */
	@AfterClass
	public static void teardown() {
		// Close the Browser.
		driver.close();
	}

	/**
	 * testLogin
	 */
	@Test
	public void testLogin() {
		// Launch website
		driver.navigate().to("http://localhost:8080/ichmer/#/login");

		// Maximize the browser
		driver.manage().window().maximize();

		// login
		driver.findElement(By.xpath("//*[@id='loginId']")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Philips1");
		driver.findElement(By.xpath("//span[@widgetid='login']")).click();

		// check Welcome page
		String welcomeStr = driver.findElement(By.xpath("//*[@class='welcomeTip']/label")).getText();
		Assert.assertEquals("»¶Ó­", welcomeStr);
	}
}
