package championIT.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppleCartPOM {
	
	WebDriver driver;
	
	public AppleCartPOM(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@id='ac-gn-link-search']")
	WebElement search_icon;
	
	@FindBy(xpath="//input[@id='ac-gn-searchform-input']")
	WebElement search_box;
	
	@FindBy(xpath="(//ul[@id='quicklinks']//li//a//b)[1]")
	WebElement first_result;
	
	@FindBy(xpath="(//a[@href='/us/shop/goto/buy_mac/macbook_pro_14'])[1]")
	WebElement buy_button_2nd;
	
	@FindBy(xpath="(//button[@name='proceed'])[3]")
	WebElement select_mac_pro_base_model;
	
	@FindBy(xpath="//select[@class='form-dropdown-select']")
	WebElement MacBook_Pro_14inch_base_model_keyboard_select;
	
	@FindBy(xpath="//button[@name='add-to-cart']")
	WebElement add_to_cart;
	
	@FindBy(xpath="//button[text()='Review Bag']")
	WebElement review_bag;
	
	@FindBy(xpath="//div[@class='rs-summary-labelandvaluecontainer rs-summary-total']//div[@class='rs-summary-value']")
	WebElement total_incl_tax;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearch_icon() {
		return search_icon;
	}

	public WebElement getSearch_box() {
		return search_box;
	}

	public WebElement getFirst_result() {
		return first_result;
	}

	public WebElement getBuy_button_2nd() {
		return buy_button_2nd;
	}

	public WebElement getSelect_mac_pro_base_model() {
		return select_mac_pro_base_model;
	}

	public WebElement getMacBook_Pro_14inch_base_model_keyboard_select() {
		return MacBook_Pro_14inch_base_model_keyboard_select;
	}

	public WebElement getAdd_to_cart() {
		return add_to_cart;
	}

	public WebElement getReview_bag() {
		return review_bag;
	}

	public WebElement getTotal_incl_tax() {
		return total_incl_tax;
	}

	

}
