package practise.test;

import org.checkerframework.framework.qual.DefaultQualifier.List;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

//@Listeners(com.comcast.crm.listernerutility.ListImpClass.class)
public class InvoiceTest extends BaseClass{
	
	@Test
	public void createInvoiceTest() {
		System.out.println("excecute createInvoiceTest");
		String acttitle = driver.getTitle();
		Assert.assertEquals(acttitle, "Login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");

		
	}
	@Test
	public void createInvoiceWithContactTest() {
		System.out.println("excecute createInvoiceWithContactTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");

	}

}
