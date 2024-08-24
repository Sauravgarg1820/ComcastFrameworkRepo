package com.comcast.crm.basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.beust.jcommander.Parameter;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.generic.databaseutility.DataBaseUtility;
import com.comcast.generic.fileutility.ExcelUtility;
import com.comcast.generic.fileutility.FileUtility;
import com.comcast.generic.webdriverutility.JavaUtility;
import com.comcast.generic.webdriverutility.UtilityClassObject;
import com.comcast.generic.webdriverutility.WebdriverUtility;

public class BaseClass {
    public WebDriver driver= null;
    public static WebDriver sdriver= null;
   
    

	//object creation
	public DataBaseUtility dLib= new DataBaseUtility();
	public FileUtility fLib= new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public JavaUtility jLib= new JavaUtility();
	public WebdriverUtility wLib= new WebdriverUtility();
    
    @BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void configBS() throws Throwable {
    	System.out.println("Connect to DB");
		dLib.getDbconnection();
		
		}
	
   // @Parameters("Browser")
    	@BeforeClass(groups = {"smokeTest", "regressionTest"})
		public void configBC() throws Throwable {
		
		String BROWSER = fLib.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {
		driver= new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			driver= new FirefoxDriver();
		}
		else if(BROWSER.equals("edge")) {
			driver= new EdgeDriver();
		}
		sdriver= driver;
		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	 public void configBM() throws Throwable {
		LoginPage lp= new LoginPage(driver);
		String URL = fLib.getDataFromPropertiesFile("url");
		String USERNAME = fLib.getDataFromPropertiesFile("username");
		String PASSWORD = fLib.getDataFromPropertiesFile("password");
		lp.loginToApp(URL, USERNAME, PASSWORD);
		//System.out.println("Login in the application");
	}

	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void configAM() throws Throwable {
		HomePage hp= new HomePage(driver);
		hp.logout();
		//System.out.println("Logout in the application");
	}
 
	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void configAC() throws Throwable {
		driver.quit();
	
		//System.out.println("close the browser");
	}

	
    @AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void configAS() throws Throwable {
		dLib.closeDbconnection();

		//System.out.println("Close the DB connection");
	}
	

}
