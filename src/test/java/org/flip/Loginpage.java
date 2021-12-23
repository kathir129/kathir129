package org.flip;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends BaseClass{
	public Loginpage() {
		PageFactory.initElements(driver, this);
	}
 
	@FindBy(xpath="//button[text()='✕']")
	private WebElement close;
	
	@FindBy(name="q")
	private WebElement src;
	
	@FindBy(className="L0Z3Pu")
	private WebElement btnsrc;
	
	@FindBy(xpath="//div[@Class='_4rR01T']")
	private List<WebElement> namelist;
	
	@FindBy(xpath="//div[@class='_30jeq3 _1_WHN1']")
	private List<WebElement> pricelist;
	

	public WebElement getClose() {
		return close;
	}

	public WebElement getSrc() {
		return src;
	}

	public WebElement getBtnsrc() {
		return btnsrc;
	
	}

	public List<WebElement> getnameList() {
		return namelist;
	}

	public List<WebElement> getPricelist() {
		return pricelist;
	}
}
