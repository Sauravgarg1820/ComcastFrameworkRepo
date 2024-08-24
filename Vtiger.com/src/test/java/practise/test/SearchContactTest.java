package practise.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest {
	WebDriver driver;

	@Test
	public void searchcontactTest() {
		LoginPage lp= new LoginPage(driver);
	}
}
