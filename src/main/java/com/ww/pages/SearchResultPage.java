package com.ww.pages;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ww.base.TestBase;

public class SearchResultPage extends TestBase{
	
	@FindBy(id="location-search")
	WebElement searchBox;
	
	@FindBy(className="rightArrow-daPRP")
	WebElement searchBoxEnter;
	
	@FindBy(className="linkUnderline-1_h4g")
	WebElement firstSearchResult;
	
	@FindBy(className="distance-OhP63")
	WebElement distance;
	
	@FindBy(className="locationName-1jro_")
	WebElement matchFirstSearchText;
	
	@FindBy(className="hoursIcon-II-H2")
	WebElement weeklist;
	
	@FindBy(className="dayName-CTNC6")
	List<WebElement> days;
	
	@FindBy(className="times-fms3v")
	List<WebElement> hours;
	
	@FindBy(className="scheduleContainerMobile-1RfmF")
	List<WebElement> schedule;
	
	@FindBy(className="day-NhBOb")
	List<WebElement> weekday;
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	public void searchWorkshop(){
		searchBox.clear();
		searchBox.sendKeys("10011");
		searchBoxEnter.click();
	}
	
	public String printFirstSearchResult() {
		System.out.println("First search result="+ firstSearchResult.getText());
		return firstSearchResult.getText();
	}
	
	public void printFirstSearchResultDistance() {
		System.out.println("Distance="+ distance.getText());
	}
	
	public void clickFirstSearchResult() {
		firstSearchResult.click();
	}
	
	public String getSearchResult() {
		return matchFirstSearchText.getText();
	}
	
	public void printHoursOfOperation() {
		String dayOfWeek = LocalDate.now().getDayOfWeek().name();
		System.out.println("Today is="+dayOfWeek);
		weeklist.click();
		for(int i=0; i<days.size(); i++) {
			if(days.get(i).getText().equalsIgnoreCase(dayOfWeek)) {
				System.out.println("Hours of operation="+hours.get(i).getText());
			}
		}
	}
	
	public void printNoOfMeetingsPerPerson() {
		WebElement scheduleTable = schedule.get(1);
		List<WebElement> weekdays =  scheduleTable.findElements(By.className("day-NhBOb"));
		//for(int j=0;j< weekdays.size();j++){ //for loop is written if user wants print for all days of a week
			String resultStr = weekdays.get(1).getText().replaceAll("\n", ",");
			String[] convertedArray = resultStr.split(",");
			List<String> convertedList = new ArrayList<String>();
			for (int i=2; i<convertedArray.length; i+=2) {
			    convertedList.add(convertedArray[i]);
			}
			System.out.println("Weekday is-->"+scheduleTable.findElements(By.className("dayName-1UpF5")).get(1).getText());
			Set<String> unique = new HashSet<String>(convertedList);
			for (String key : unique) {
			    System.out.println(key + "-->" + Collections.frequency(convertedList, key));
			}
		}		
	//}
	
}