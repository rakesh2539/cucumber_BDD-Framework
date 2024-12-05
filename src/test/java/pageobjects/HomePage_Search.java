package pageobjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage_Search {
	
	WebDriver driver;
	
	public HomePage_Search(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='Wikipedia1_wikipedia-search-input']")
	private WebElement searchbox;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement search_btn;
	
	@FindBy(xpath="//div[@id='Wikipedia1_wikipedia-search-results']//div//a")
	private List<WebElement> Autosuggested_elements;

	public WebElement getSearchbox() {
		return searchbox;
	}

	public void setText_Searchbox(String txt) {
		searchbox.sendKeys(txt);
		
	}

	public WebElement getSearch_btn() {
		return search_btn;
	}

	public void click_Search_btn() {
		search_btn.click();
	}

	public void GetAutoSuggistions() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElements(Autosuggested_elements));
	    for (WebElement suggestion : Autosuggested_elements) {
	    	if (suggestion.isDisplayed()) {
	    	    String suggestionText = suggestion.getText();
	    	    System.out.println(suggestionText);
	    	} else {
	    	    System.out.println("Suggestion is not visible");
	    	}
	    }
	}
	public void ClickOn_Requiredsuggestion(String sugg) {
	    for (WebElement suggestion : Autosuggested_elements) {
	        String suggestionText = suggestion.getText();
	        if (suggestionText.equals(sugg)) {
	            suggestion.click(); 
	            break; 
	        }
	    }
	}
}