package org.testngsample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;

import junit.framework.Assert;

public class TestNGDataProvidre extends BaseClass {
	@org.testng.annotations.Test(dataProvider="adactin")
	public void test(String username,String password) throws InterruptedException {
		getChromeDriver();
		loadUrl("http://adactinhotelapp.com/");
		maximizeBrowser();
		WebElement txtUser =driver.findElement(By.id("username"));
		typeInput(txtUser, username);
		WebElement txtPass = driver.findElement(By.id("password"));
		typeInput(txtPass, password);
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(2000);
		WebElement dDnCountry = driver.findElement(By.id("location"));
		Select select = new Select(dDnCountry);
		select.selectByIndex(4);			
	}
	@DataProvider(name="adactin")
	public Object[][] testData() {
		return new Object[][] {
			{"Sripathi","Sripathi"},
			{"Pathisri","Sripathi"},
			{"Sripathi","Pathisri"},
			{"Pathisri","Pathisri"}
		
		};
		
		}
				
		}