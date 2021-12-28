package org.flip;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pricepage extends BaseClass {
	public Pricepage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Price -- Low to High']")
	private WebElement lowtohigh;

	public WebElement getLowtohigh() {
		return lowtohigh;
	}

}
