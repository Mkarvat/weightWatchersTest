package com.ww.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ww.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(className="MenuItem_menu-item__icon-wrapper__3_QQx")
	WebElement workshop;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
		
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public String verifyWorkshopTitle(){
		workshop.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String result = js.executeScript("return document.readyState").toString();
		    if (!result.equals("complete")) {
		     try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		    } 
		String workshopPageTitle = driver.getTitle();
		return workshopPageTitle;
	}
	
}

