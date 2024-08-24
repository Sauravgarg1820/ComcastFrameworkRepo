package practise.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class SampleRetryTest extends BaseClass{
	
	@Test(retryAnalyzer = com.comcast.crm.listernerutility.RetryListnerImp.class)
	public void activateSim() {
		System.out.println("Execute Activate Sim");
		Assert.assertEquals("", "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");

	}

}
