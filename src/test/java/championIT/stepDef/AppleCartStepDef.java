package championIT.stepDef;


import championIT.test.AppleCartTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AppleCartStepDef {


	
	AppleCartTest test = new AppleCartTest();
	
	@Given("user have access to apple homepage")
	public void user_have_access_to_apple_homepage() {
	    	
		test.visitHomePage("https://www.apple.com/");
		
		

	}

	@When("user search for {string}")
	public void user_search_for(String product_name) {
		
		test.searchOn(product_name);
		test.selectFromSearchSuggestions();
	}

	@When("user select the product")
	public void user_select_the_product() {
		
		test.selectMacBookProBaseModel();
		
	}

	@When("choose {string} keyboard and add to cart")
	public void choose_keyboard_and_add_to_cart(String KeyBoardLang) {
		
		test.chooseKeyBoardType(KeyBoardLang);
		System.out.println("test ***************");
	    
	    
	}

	
	
	@Then("user see the correct {string} on page")
	public void user_see_the_correct_on_page(String expectedPrice) {
		test.gotoCart();
		test.finalPriceOnCart(expectedPrice);
	}

	
}
