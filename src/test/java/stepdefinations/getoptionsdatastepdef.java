package stepdefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import steps.GetOptionsDataSteps;

public class getoptionsdatastepdef {
	
	@Steps
	GetOptionsDataSteps getOptionsDataSteps;
	
	@Given("^the user get the options data$")
	public void the_user_get_the_options_data() {
	    // Write code here that turns the phrase above into concrete actions
	   
		getOptionsDataSteps.getoptionsdata();
	}

	@When("^the user option the excel sheet$")
	public void the_user_option_the_excel_sheet() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}

	@Then("^the user selects the best option$")
	public void the_user_selects_the_best_option() {
	    // Write code here that turns the phrase above into concrete actions
	   
	}


}
