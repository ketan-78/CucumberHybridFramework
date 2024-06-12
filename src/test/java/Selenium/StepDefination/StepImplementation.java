package Selenium.StepDefination;

import java.io.IOException;

import org.testng.Assert;

import Selenium.PageObject.PersonalDetails;
import Selenium.PageObject.Product_Selection;
import Selenium.TestComponents.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepImplementation extends BaseTest{
 
	
	public Product_Selection select;
	public PersonalDetails pd;
	public String Actual;
	@Given("I landed on the E-commerce page")
	public void I_landed_on_the_E_commerce_page() throws IOException
	{
		login=Launch();
	}
	@Given("^I logged in with username (.+) and password (.+)$")
	//(.+) it represent any char or value and to make sure string knows, that it is a regular 
	//expression we must put ^ at the start and $ at the end
	public void I_logged_in_with_username_and_password_(String name,String password)
	{
		select=login.details(name,password);
	}
	@When("^I add product (.+) and (.+) to cart$")
	public void I_dd_product_to_cart(String ProductName1,String ProductName2) throws InterruptedException
	{
		select.selection(ProductName1,ProductName2);
	}
	@And("^checkout (.+) and (.+) and submit the order$")//we can also @When here
	public void checkout_products_and_submit_the_order(String ProductName1,String ProductName2) throws InterruptedException
	{
		boolean yes=select.ToCheck(ProductName1);
		Assert.assertTrue(yes); 
		pd=select.checkout();
		pd.details("IND");
		Actual=pd.orderID(ProductName1,ProductName2);
	}
	@Then("{string} message is displayed on confirmation page")
	public void message_is_displayed_on_confirmation_page(String string)
    {
		Assert.assertTrue(Actual.equalsIgnoreCase(string));
		driver.close();
	}
}
