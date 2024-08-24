package practise.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class SimpleTestForScreenshot {
	
	@Test
	public void amazonTest() throws IOException {

	WebDriver driver= new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	driver.get("https://amazon.in/");
	
	EventFiringWebDriver edriver= new EventFiringWebDriver(driver);
	File scrfile = edriver.getScreenshotAs(OutputType.FILE);
	File descfile= new File("./Screenshot/test1.png");
	Files.copy(scrfile, descfile);
	driver.quit();
	
	
	}
}
