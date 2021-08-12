package org.testngsample;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class TestNGSample extends BaseClass {
	@org.testng.annotations.Test(dataProvider="adactin")
	public void test(String username,String password) {
		getChromeDriver();
		loadUrl("http://adactinhotelapp.com/");
		maximizeBrowser();
		WebElement txtUser =driver.findElement(By.id("username"));
		typeInput(txtUser, username);
		WebElement txtPass = driver.findElement(By.id("password"));
		typeInput(txtPass, password);
		driver.findElement(By.id("login")).click();
				
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