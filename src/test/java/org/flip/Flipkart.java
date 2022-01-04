package org.flip;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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

		List<String> li = new ArrayList<String>();
		for (int i = 0; i < l.getnameList().size(); i++) {
			String names = l.getnameList().get(i).getText();
			li.add(names);

		}
		List<Integer> lp = new ArrayList<Integer>();
		for (int i = 0; i < l.getPricelist().size(); i++) {
			String pricetext = l.getPricelist().get(i).getText();
			String s = pricetext;
			String rp = "";
			if (s.contains("₹")) {
				rp = s.replace("₹", "");
				System.out.println(rp);
			}
			if (rp.contains(",")) {
				rp = rp.replace(",", "");
				System.out.println(rp);
				int k = Integer.parseInt(rp);
				lp.add(k);
				System.out.println();
			}
		}

		System.out.println(li.size());
		System.out.println(lp.size());

		Map<String, Integer> mp = new LinkedHashMap<String, Integer>();
		for (int i = 0; i < li.size(); i++) {
			mp.put(li.get(i), lp.get(i));
		}
		
		Set<Entry<String, Integer>> et = mp.entrySet();
		for (Entry<String, Integer> entry : et) {
			System.out.println(entry);
		}
		
		Collections.sort(lp);
		System.out.println(lp);
		
		System.out.println(Collections.min(lp));
		System.out.println(Collections.max(lp));
		
	}
	
	@AfterMethod
	private void afterMethod() {
		System.out.println("End Time" + new Date());
	}

	@AfterClass
	private void afterClass() {
		quit();
	}

}
