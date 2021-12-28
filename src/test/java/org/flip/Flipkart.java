package org.flip;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
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
		Pricepage p = new Pricepage();
		click(p.getLowtohigh());
		Map<List<WebElement>,List<WebElement>> mp=new LinkedHashMap<List<WebElement>,List<WebElement>>();
         List<WebElement> put = mp.put(l.getnameList(), l.getPricelist());
		
         for (int i = 0; i < put.size(); i++) {
			System.out.println(ListgetText(put, i));
		}
	}

	@AfterMethod
	private void afterMethod() {
		System.out.println("Starts Time" + new Date());
	}

	@AfterClass
	private void afterClass() {
		quit();
	}

}
