package pages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import pojos.OptionsStrikePriceData;

@DefaultUrl("https://www1.nseindia.com/live_market/dynaContent/live_watch/option_chain/optionKeys.jsp")
public class OptionChainPage extends PageObject {

	@FindBy(id = "octable")
	WebElementFacade optionchaintbl;

	@FindBy(xpath = "//*[@id=\"niftyDiv\"]/p[2]/font/nobr")
	WebElementFacade niftyvalue;

	ArrayList<OptionsStrikePriceData> lstOptionsStrikePriceData = new ArrayList<OptionsStrikePriceData>();

	public void getoptionsdata() {

		List<WebElement> tbloptionsdatarow = optionchaintbl.findElements(By.xpath(".//tr"));

		// https://javabeginnerstutorial.com/selenium/9w-webdriver-looping-table-elements

		for (int z = 0; z < tbloptionsdatarow.size(); z++) {

			List<WebElement> tbloptionsdata = tbloptionsdatarow.get(z).findElements(By.xpath(".//td"));
			OptionsStrikePriceData opts = new OptionsStrikePriceData();

			if (z > 37 && z < 43) {
				System.out.println("value of z is " + z);

				for (int e = 0; e < tbloptionsdata.size(); e++) {

					// opts.setCallchart(e.getText());
					if (e == 1) {
						System.out.println("setCallOI " + tbloptionsdata.get(e).getText());
						opts.setCallOI(tbloptionsdata.get(e).getText());
					}

					if (e == 2) {
						System.out.println("setCallChnginOI " + tbloptionsdata.get(e).getText());
						opts.setCallChnginOI(tbloptionsdata.get(e).getText());
					}

					if (e == 3) {
						System.out.println("setCallVolume " + tbloptionsdata.get(e).getText());
						opts.setCallVolume(tbloptionsdata.get(e).getText());
					}

					if (e == 4) {
						opts.setCallIV(tbloptionsdata.get(e).getText());
					}

					if (e == 5) {
						System.out.println("setCallLTP " + tbloptionsdata.get(e).getText());
						opts.setCallLTP(tbloptionsdata.get(e).getText());
					}
					if (e == 6) {
						opts.setCallNetChng(tbloptionsdata.get(e).getText());
					}

					// opts.setCallBidQty(e.getText());
					// opts.setCallBidPrice(e.getText());
					// opts.setCallAskPrice(e.getText());
					// opts.setCallAskQty(e.getText());
					if (e == 11) {
						System.out.println("strike price " + tbloptionsdata.get(e).getText());
						opts.setStrikePrice(tbloptionsdata.get(e).getText());

					}
					// opts.setPutBidQty(e.getText());
					// opts.setPutBidPrice(e.getText());
					// opts.setPutAskPrice(e.getText());
					// opts.setPutAskQty(e.getText());
					if (e == 16) {
						System.out.println("Call NetChng  " + tbloptionsdata.get(e).getText());
						opts.setPutNetChng(tbloptionsdata.get(e).getText());
					}

					if (e == 17) {
						System.out.println("Put LTP  " + tbloptionsdata.get(e).getText());
						opts.setPutLTP(tbloptionsdata.get(e).getText());
					}

					if (e == 18) {
						opts.setPutIV(tbloptionsdata.get(e).getText());
					}

					if (e == 19) {
						opts.setPutVolume(tbloptionsdata.get(e).getText());
					}

					if (e == 20) {
						System.out.println("Put Change on OI " + tbloptionsdata.get(e).getText());
						opts.setPutChnginOI(tbloptionsdata.get(e).getText());
					}

					if (e == 21) {
						opts.setPutOI(tbloptionsdata.get(e).getText());
					}

					// opts.setPutChart(e.getText());

				}

				lstOptionsStrikePriceData.add(opts);
			}

		}

	}

	public void sayhello()  {
		for (int r = 0; r < lstOptionsStrikePriceData.size(); r++) {

			System.out.println(" CallLTP  " + lstOptionsStrikePriceData.get(r).getCallLTP());

			System.out.println(" CallChnginOI  " + lstOptionsStrikePriceData.get(r).getCallChnginOI());

			System.out.println(" CallVolume  " + lstOptionsStrikePriceData.get(r).getCallVolume());

			System.out.println(" CallOI  " + lstOptionsStrikePriceData.get(r).getCallOI());

			System.out.println(" strike price  " + lstOptionsStrikePriceData.get(r).getStrikePrice());

			System.out.println(" change in OI " + lstOptionsStrikePriceData.get(r).getPutChnginOI());

			System.out.println(" total OI " + lstOptionsStrikePriceData.get(r).getPutOI());

			System.out.println(" total volumne " + lstOptionsStrikePriceData.get(r).getPutVolume());

			System.out.println(" put LTP " + lstOptionsStrikePriceData.get(r).getPutLTP());

			System.out.println(" Nifty value is " + niftyvalue.getTextValue());
			
			
	         String connectionUrl =
	                 "jdbc:sqlserver://10.0.75.1:1433;databaseName=optionsanalysis;integratedSecurity=true";

	         SQLServerDriver driver = new SQLServerDriver();
	         
	         try 
	         {
	        	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        		 Connection con = DriverManager.getConnection(connectionUrl);
	                 Statement stmt = con.createStatement(); 
	               
	             String SQL = "SELECT TOP 10 * FROM dbo.NiftyOptionsAnalysis;";
	             ResultSet rs = stmt.executeQuery(SQL);
	             while (rs.next()) {
	                 System.out.println(rs.getString("Name"));
	             }
	         } catch (SQLException e) {
	             e.printStackTrace();
	         } catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
