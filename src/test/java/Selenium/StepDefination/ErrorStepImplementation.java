package Selenium.StepDefination;

import java.io.IOException;

import org.testng.Assert;

import Selenium.PageObject.Product_Selection;
import Selenium.TestComponents.BaseTest;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ErrorStepImplementation extends BaseTest{

	public Product_Selection select;
	@Given("I landed on the E-commerce pagee")
	public void I_landed_on_the_E_commerce_page() throws IOException
	{
		login=Launch();
	}
	@When("^I try to login with username (.+) and password (.+)$")
	public void I_try_to_login_with_username_and_password(String username,String psw)
	{
		select=login.details(username,psw);
	}
	@Then("{string} message is displayed")
	public void message_is_displayed(String string)
	{
		String val=login.errorMessage();
		if(val.equalsIgnoreCase(string))
			System.out.println("Incorrect Credentials"); 
	}

	@But("Test failed")
	public void Test_failed()
	{
		Assert.assertTrue(false);
	}
}
