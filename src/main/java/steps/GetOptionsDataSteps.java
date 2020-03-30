package steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.Step;
import pages.OptionChainPage;

public class GetOptionsDataSteps  {
	
	private OptionChainPage optionChainPage;
	

	public void getoptionsdata()
	
	{	optionChainPage.openUrl("https://www1.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp");
		optionChainPage.getoptionsdata();
		System.out.println("hello");
		optionChainPage.sayhello();	
	}

}
