package com.MDAS.SeleniumFramework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchFeature {
	@Test
	public void SearchForText(WebDriver driver,String txt) throws InterruptedException{
		driver.findElement(By.cssSelector("input.wrapper__input")).sendKeys(txt);
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("i.icon.wrapper__icon")).click();
		Thread.sleep(5000);
  }
}
