package org.flip;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;
import sun.net.www.content.image.png;

public class BaseClass {

	public static WebDriver driver;

	// chromeBrowserlauch
	public static WebDriver chromeBrowser() {
		WebDriverManager.chromedriver().setup();
		return driver = new ChromeDriver();
	}

	// edgeBrowser
	public static WebDriver edgeBrowser() {
		WebDriverManager.edgedriver().setup();
		return driver = new EdgeDriver();
	}

	// fireFox
	public static WebDriver firefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		return driver = new EdgeDriver();
	}

	// urlLaucnh
	public static void urlLaunch(String url) {
		driver.get(url);
	}

	// impWait and maximize
	public static void impWait(int sec) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}

	// geTitle
	public static String title() {
		return driver.getTitle();
	}

	// currentUrl
	public static String currentUrl() {
		return driver.getCurrentUrl();
	}

	// Normal Click
	public static void click(WebElement e) {
		e.click();
	}

	// clear
	public static void clear(WebElement e) {
		e.clear();
	}

	// quit
	public static void quit() {
		driver.quit();
	}

	// sendKeys
	public static void sendKeys(WebElement e, String data) {
		e.sendKeys(data);
	}

	// getText
	public static String getText(WebElement e) {
		return e.getText();
	}

	// getAttribute
	public static String getAttribute(WebElement e) {
		return e.getAttribute("Value");
	}

	// getSize
	public static Integer getSize(List<WebElement> e) {
		return e.size();
	}

	// index
	public static WebElement index(List<WebElement> e, int index) {
		return e.get(index);
	}

	// ListgetText
	public static String ListgetText(List<WebElement> e, int index) {
		return e.get(index).getText();
	}

	// dragAnddrop
	public static void dragAndDrop(WebElement from, WebElement to) {
		Actions a = new Actions(driver);
		a.dragAndDrop(from, to).perform();
	}

	// moveToElement
	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).perform();
	}

	// actionClick
	public static void actionClick(WebElement clk) {
		Actions a = new Actions(driver);
		a.click(clk).perform();
	}

	// doubleClick
	public static void doubleClick(WebElement e) {
		Actions a = new Actions(driver);
		a.doubleClick(e).perform();
	}

	// contextClick
	public static void contextClick(WebElement e) {
		Actions a = new Actions(driver);
		a.contextClick(e).perform();
	}

	// simpleAlert
	public static void simpleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// confirmAlert
	public static void confirmAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// promptAlert
	public static void promptAlert(String input) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(input);
		alert.accept();
	}

	// selectBYIndex
	public static void selectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.selectByIndex(index);
	}

	// selectByValue
	public static void selectByValue(WebElement e, String Value) {
		Select s = new Select(e);
		s.selectByValue(Value);
	}

	// selectByVisible
	public static void selectByVisibleText(WebElement e, String Text) {
		Select s = new Select(e);
		s.selectByVisibleText(Text);
	}

	// isMultiple
	public static boolean isMultiple(WebElement e) {
		Select s = new Select(e);
		return s.isMultiple();
	}

	// getFirstSelectedOptions
	public static String getFirstSelectedOPtion(WebElement e) {
		Select s = new Select(e);
		WebElement fOption = s.getFirstSelectedOption();
		return fOption.getText();
	}

	// deSelectedByIndex
	public static void deSelectByIndex(WebElement e, int index) {
		Select s = new Select(e);
		s.deselectByIndex(index);
	}

	// deSelectedByValue
	public static void deSelectedByValue(WebElement e, String value) {
		Select s = new Select(e);
		s.deselectByValue(value);
	}

	// deSelectedByVisible
	public static void deSelectedByVisible(WebElement e, String text) {
		Select s = new Select(e);
		s.deselectByVisibleText(text);
	}

	// deSelectedAll
	public static void deSelectedAll(WebElement e) {
		Select s = new Select(e);
		s.deselectAll();
	}

	// screenshot
	public static void screenshot(String filename) throws IOException {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File from = tk.getScreenshotAs(OutputType.FILE);
		File to = new File("C:\\Users\\MY PC\\eclipse-workspace\\Testmaven\\src\\test\\resources\\Screenshot\\"
				+ filename + ".png");
		FileUtils.copyFile(from, to);
	}

	// setAtrribute
	public static void setAttribute(String text, WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + text + "')", e);
	}

	// getAtrribute
	public static String jsgetAttribute(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object ggg = js.executeScript("return arguments[0].getAttribute('value')", e);
		return ggg.toString();
	}

	// javaClick
	public static void javaClick(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", e);
	}

	// down
	public static void down(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}

	// up
	public static void up(WebElement e) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(false)", e);
	}

	// frameIndex
	public static void frameIndex(int index) {
		driver.switchTo().frame(index);
	}

	// frameName
	public static void frameName(String name) {
		driver.switchTo().frame(name);
	}

	// frameWebElement
	public static void frameWebElement(WebElement e) {
		driver.switchTo().frame(e);
	}

	// defaultContent
	public static void defaultContent() {
		driver.switchTo().defaultContent();
	}

	// parentFrame
	public static void parentframe() {
		driver.switchTo().parentFrame();
	}

	// toUrl
	public static void toUrl(String url) {
		driver.navigate().to(url);
	}

	// back
	public static void back() {
		driver.navigate().back();
	}

	// forward
	public static void forward() {
		driver.navigate().forward();
	}

	// refresh
	public static void refresh() {
		driver.navigate().refresh();
	}

	// isDisplayed
	public static boolean isDisplayed(WebElement e) {
		return e.isDisplayed();
	}

	// isSelected
	public static boolean isSelected(WebElement e) {
		return e.isSelected();
	}

	// isEnabled
	public static boolean isEnabled(WebElement e) {
		return e.isEnabled();
	}

	// handleUrl
	public static void handleUrl(String text) {
		driver.switchTo().window(text);
	}

	// getHandle
	public static String getHandle() {
		return driver.getWindowHandle();
	}

	// getHandles
	public static void getHandles(int index) {
		Set<String> st = driver.getWindowHandles();
		List<String> li = new ArrayList<String>();
		li.addAll(st);

		driver.switchTo().window(li.get(index));

	}

	// getExcelData
	public static String getExcelData(String filename, String sheetname, int rowno, int cellno) throws IOException {
		File loc = new File("C:\\Users\\MY PC\\eclipse-workspace\\Testmaven\\src\\test\\resources\\Screenshot\\Excel\\"
				+ filename + ".xlsx");
		FileInputStream st = new FileInputStream(loc);
		Workbook w = new XSSFWorkbook(st);
		Sheet sheet = w.getSheet(sheetname);
		Row row = sheet.getRow(rowno);
		Cell cell = row.getCell(cellno);

		int type = cell.getCellType();
		// type-----1 String
		// type-----0 Number,Date
		String value = null;
		if (type == 1) {
			value = cell.getStringCellValue();
		} else {
			if (DateUtil.isCellDateFormatted(cell)) {
				value = new SimpleDateFormat("dd-MM-yyyy").format(cell.getDateCellValue());
			} else {
				value = String.valueOf((long) cell.getNumericCellValue());
			}
		}
		return value;

	}
}
