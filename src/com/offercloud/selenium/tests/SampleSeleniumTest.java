package com.offercloud.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SampleSeleniumTest {
	private WebDriver driver;
	private String testPageUrl;

	@Parameters({ "testUrl", "user", "password" })
	@BeforeClass
	public void setUp(String testUrl, String user, String password) {
		// Later read the url from
		testPageUrl = "http://" + user + ":" + password + "@" + testUrl;
		driver = new FirefoxDriver();

	}

	@Test(description = "Check the login functionality")
	public void SampleSeleniumTest_1() throws InterruptedException {

		// Visit the test page
		driver.get(testPageUrl);
		// Wait for the page to load
		(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver drv) {
				return drv.getTitle().startsWith("OfferCloud");
			}
		});
		Assert.assertTrue(driver.findElement(By.cssSelector("div.logo"))
				.isDisplayed());
		Reporter.log("Login Success!!!");

	}

	@AfterClass
	public void tearDown() {
		driver.close();
		driver.quit();
	}
}
