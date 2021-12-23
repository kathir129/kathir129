package org.flip;

import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Flipkart extends BaseClass {

	@BeforeClass
	private void beforeClass() {
		chromeBrowser();
		impWait(10);
	}

	@BeforeMethod
	private void beforeMethod() {
		System.out.println("Starts Time" + new Date());

	}

	@Test
	private void test() {
		urlLaunch("https://www.flipkart.com/");
		Loginpage l = new Loginpage();
		click(l.getClose());
		sendKeys(l.getSrc(), "iphone 12");
		click(l.getBtnsrc());
		for (int i = 0; i < l.getnameList().size(); ) {
			for (int j = 0; j < l.getPricelist().size();j++ ) {
				String list = l.getnameList().get(i).getText();
				System.out.println(list);
				String list1 = l.getPricelist().get(j).getText();
				System.out.println(list1);
				i++;
				}
	
		}
	}

	@AfterMethod
	private void afterMethod() {
		System.out.println("Starts Time" + new Date());
	}

	@AfterClass
	private void afterClass() {

	}

}
