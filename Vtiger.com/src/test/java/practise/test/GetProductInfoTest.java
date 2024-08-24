package practise.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;

public class GetProductInfoTest {
	
	
	
	@Test(dataProvider = "getdata")
	public void getProductInfoTest(String brandName, String productName) {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://amazon.in/");
		
		//search product
		driver.findElement(By.xpath("//input[@id=\"twotabsearchtextbox\"]")).sendKeys(brandName);
		driver.findElement(By.xpath("//div[@class=\"nav-search-submit nav-sprite\"]")).click();
		//capture product info
		driver.findElement(By.xpath("//img[contains(@alt, '"+productName+"')]/ancestor::div[@class='puisg-row']/descendant::span[@class='a-price-whole']")).getText();
		
		driver.quit();
	}
	
	@DataProvider
	public Object[][] getdata() {
		Object[][] objArr= new Object[3][2];
		objArr[0][0]="iphone";
		objArr[0][1]="Apple iPhone 13 (128GB) - Midnight";
		//objArr[0][2]="52,999";
		
		objArr[1][0]="iphone";
		objArr[1][1]="Apple iPhone 13 (128GB) - Green";
		//objArr[1][2]="52,999";
		
		objArr[2][0]="iphone";
		objArr[2][1]="Apple iPhone 13 (128GB) - Starlight";
		//objArr[2][2]="52,999";
		
		return objArr;


	}

}
