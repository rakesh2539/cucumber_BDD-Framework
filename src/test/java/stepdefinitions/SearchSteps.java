package stepdefinitions;

import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import hooks.MyHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.HomePage_Search;

public class SearchSteps {
	
	WebDriver driver;
	HomePage_Search Hsp;

	@Given("user Launch the brwoser and navigate to application url")
	public void user_launch_the_brwoser_and_navigate_to_application_url() {
	   driver = MyHooks.driver;
	   Hsp = new HomePage_Search(MyHooks.driver);
		
	}
	@When("user Enter the valid text in search box")
	public void user_enter_the_valid_text_in_search_box() {
		
		Hsp.setText_Searchbox("Selenium");
		
	    
	}
	@When("user click on the search button")
	public void user_click_on_the_search_button() {
		
		Hsp.click_Search_btn();
	}
	@Then("user verify the Autosuggistions are appearing or not")
	public void user_verify_the_autosuggistions_are_appearing_or_not() {
	
      Hsp.GetAutoSuggistions()	;	
	}
	@Then("user click on the required related suggistion")
	public void user_click_on_the_required_related_suggistion() {
		
		Hsp.ClickOn_Requiredsuggestion("Selenium in biology");

	}
	

	@Then("user verify the page is navigating to corrsponding search page or not")
	public void user_verify_the_page_is_navigating_to_corrsponding_search_page_or_not() {
	    
		 Set<String> windowIds = driver.getWindowHandles();
		 
		 for (String window : windowIds) {
			 
			String Title= driver.switchTo().window(window).getTitle();
			
			if(Title.equals("Selenium in biology - Wikipedia")) {
				
				
			}
		
			System.out.println("The Page Title is : ...."+Title);
			
		}
		 String expTitle="Selenium in biology - Wikipedia";
		 Assert.assertEquals(expTitle,driver.getTitle());
		
	}
		
		
}

	



