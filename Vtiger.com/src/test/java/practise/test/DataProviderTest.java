package practise.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.generic.fileutility.ExcelUtility;

public class DataProviderTest {
	
	@Test(dataProvider = "getdata")
	public void getPinfoTest(String brandName, String productName) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://amazon.in/");
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys(brandName);
		driver.findElement(By.xpath("//div[@class=\"nav-search-submit nav-sprite\"]")).click();

		driver.findElement(By.xpath("//span[contains(text(),'"+productName+"')]/ancestor::div[@class=\"a-section a-spacing-small a-spacing-top-small\"]/descendant::span[@class=\"a-price-whole\"]")).getText();
		
		
		}
	
	


@DataProvider
public Object[][] getdata() throws Throwable {
	ExcelUtility eLib= new ExcelUtility();
	int rowcount = eLib.getRowcount("product");
	Object[][] objarr = new Object[rowcount][2];

	for(int i=0; i<rowcount; i++) {
		
		objarr[i][0] = eLib.getDataFromExcel("product", i+1, 0);
		objarr[i][1] = eLib.getDataFromExcel("product", i+1, 1);
	}
	return objarr;
}}
