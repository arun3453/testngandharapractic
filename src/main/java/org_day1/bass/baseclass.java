package org_day1.bass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {

	public static WebDriver driver;
	public static String url;
	static  Properties property;
	public static String dir = System.getProperty("user.dir");
	//edge launch
	public static WebDriver openedgedriver() {
		WebDriverManager.edgedriver().setup();
		return driver=new EdgeDriver();

	}

	//	private void websites() {
	//		switch (browsername) {
	//		case edge:
	//			WebDriverManager.edgedriver().setup();
	//		    driver=new EdgeDriver();
	//			break;
	//
	//		case crome:
	//			WebDriverManager.chromedriver().setup();
	//			driver=new ChromeDriver();
	//			break;
	//			
	//		case firfox:
	//			WebDriverManager.firefoxdriver().setup();
	//		    return driver=new EdgeDriver();
	//		}

	//chromeBrowserlauch
	public static WebDriver openchromeBrowser() {
		WebDriverManager.chromedriver().setup();
		return driver=new ChromeDriver();
	}
	//fireFox
	public static WebDriver openfirefoxBrowser() {
		WebDriverManager.firefoxdriver().setup();
		return driver=new EdgeDriver();
	}

	//implicitywait
	public static void impandmin() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}
	//get
	public static void get(String url) {
		driver.get(url);
	}
	//url from the properties file
	public static void geturl() {
		url=getPropertyValue("Data", "URL1");
		driver.get(url);
		System.out.println("url launched"); 
	}
	//sendkey
	public static void sendkey(WebElement e,String data) {
		e.sendKeys(data);

	}
	//click
	public static void clik(WebElement w1) {
		w1.click();

	}
	//getcurrenturl
	public static String getcurrenturl() {
		String url = driver.getCurrentUrl();
		return url;

	}
	//getattributes value
	public static String getattributeval(WebElement g) {
		String a1 = g.getAttribute("value");
		return a1;

	}
	//getattributes inner text
	public static String getattributeinnt(WebElement g) {
		String a1 = g.getAttribute("innerText");
		return a1;

	}
	// geTitle
	public static  String gettitle() {
		return driver.getTitle();
	}
	// quit
	public static void quit() {
		driver.quit();
	} 
	//actions click
	public static void actclick(WebElement target) {
		Actions a=new Actions(driver);
		a.click(target).perform();

	}
	//actions drag and drop
	public static void dragandtdrop(WebElement from,WebElement to) {
		Actions a=new Actions(driver);
		a.dragAndDrop(from, to).perform();

	}
	// actions moveToElement
	public static void moveToElement(WebElement e) {
		Actions a=new Actions(driver);
		a.moveToElement(e).perform();
	}
	//actions click and hold
	public static void clickAndHold(WebElement target) {
		Actions a=new Actions(driver);
		a.clickAndHold(target).perform();

	}
	//actions context click
	public static void contextClick(WebElement t) {
		Actions a=new Actions(driver);
		a.contextClick(t).perform();

	}
	//actions double click
	public static void doubleClick(WebElement c) {
		Actions a=new Actions(driver);
		a.doubleClick(c).perform();

	}
	//actions triple click
	public static void tripleClick(WebElement c) {
		Actions a=new Actions(driver);
		a.doubleClick(c).click().perform();

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
	public static void selectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.selectByIndex(index);

	}
	// selectByValue
	public static void selectByValue(WebElement e,String Value) {
		Select s=new Select(e);
		s.selectByValue(Value);
	}
	// selectByVisible
	public static void selectByVisibleText(WebElement e,String Text) {
		Select s=new Select(e);
		s.selectByVisibleText(Text);
	}
	// isMultiple
	public static boolean isMultiple(WebElement e) {
		Select s=new Select(e);
		return s.isMultiple();
	}
	// getFirstSelectedOptions
	public static String getFirstSelectedOPtion(WebElement e) {
		Select s=new Select(e);
		WebElement fOption = s.getFirstSelectedOption();
		return fOption.getText();
	}
	// deSelectedByIndex
	public static void deSelectByIndex(WebElement e,int index) {
		Select s=new Select(e);
		s.deselectByIndex(index);
	}
	// deSelectedByValue
	public static void deSelectedByValue(WebElement e,String value) {
		Select s=new Select(e);
		s.deselectByValue(value);
	}
	// deSelectedByVisible
	public static void deSelectedByVisible(WebElement e,String text) {
		Select s=new Select(e);
		s.deselectByVisibleText(text);
	}   
	// deSelectedAll
	public static void deSelectedAll(WebElement e) {
		Select s=new Select(e);
		s.deselectAll();
	}
	// screenshot
	public static void screenshot() throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File from = tk.getScreenshotAs(OutputType.FILE);
		//		Scanner s=new Scanner(System.in);
		//		String name = s.next();
		long time = System.currentTimeMillis();
		File to=new File("C:\\Users\\91805\\eclipse-workspace\\MavenProject\\src\\test\\resources\\Screenshot\\"+time+".png");
		FileUtils.copyFile(from, to);
	}
	public static void takescreenshot(String a) throws IOException {
		TakesScreenshot tk=(TakesScreenshot)driver;
		File from = tk.getScreenshotAs(OutputType.FILE);
		File to=new File(dir+"\\src\\test\\resources\\screenshot\\repscreeen"+a+".png");
		FileUtils.copyFile(from, to);
	}
	// java setAtrribute
	public static void javasetAttribute(String text,WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','"+text+"')", e);
	}
	// java getAtrribute
	public static String javagetAttribute(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		Object ggg = js.executeScript("return arguments[0].getAttribute('value')", e);
		return ggg.toString();
	}
	// javaClick
	public static void javaClick(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", e);
	}
	// java scrolldown
	public static void down(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", e);
	}
	//java scrollup
	public static void up(WebElement e) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
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
	//handleUrl
	public static void handleUrl(String text) {
		driver.switchTo().window(text);
	}
	//getHandle
	public static String getHandle() {
		return driver.getWindowHandle();
	}
	//getHandles
	public static void getHandles(int index) {
		Set<String> st = driver.getWindowHandles();
		List<String> li=new ArrayList<String>();
		li.addAll(st);

		driver.switchTo().window(li.get(index));
	}
	//getexeldata
	public static void exeal(String filname,int ro,String fname,int co) throws IOException {

		File f=new File(filname);

		FileInputStream f1=new FileInputStream(f);		

		Workbook w=new XSSFWorkbook(f1);

		Sheet s1 = w.getSheet(fname);
		Row r = s1.getRow(ro);
		Cell c1 = r.getCell(co);

		int c2 = c1.getCellType();
		System.out.println(c2);


		if(c2==1) {
			String value = c1.getStringCellValue();
			System.out.println(value);
		}else {
			if(DateUtil.isCellDateFormatted(c1)) {
				Date da1 = c1.getDateCellValue();
				SimpleDateFormat dte=new SimpleDateFormat("dd/yyyy/MMM");
				String dat2 = dte.format(da1);
				System.out.println(dat2);

			}else {
				double nomb = c1.getNumericCellValue();
				long p=(long)nomb;
				String value = String.valueOf(p);
				System.out.println(value);
			}
		}


	}
	/////////////html report generate
	//	static ExtentHtmlReporter htmlrep;
	//	static ExtentReports repot;
	//	
	//	public static void htmlstartrep(String f) {
	//		 htmlrep=new ExtentHtmlReporter(f);
	//		htmlrep.config().setDocumentTitle("testng 8am green");	
	//		htmlrep.config().setReportName("fipkart login");
	//		htmlrep.config().setTheme(Theme.DARK);
	//		
	//		repot=new ExtentReports();
	//		repot.attachReporter(htmlrep);
	//		repot.setSystemInfo("browser name", "edge");
	//		repot.setSystemInfo("browser ver", "105");
	//		repot.setSystemInfo("os", "windows 11");
	//		repot.setSystemInfo("env", "QA");
	//		repot.setSystemInfo("sprint", "20");
	//
	//	}
	//	public static void htmlcontindoce(ITestResult r) {
	//		String name = r.getName();
	//		
	//		int status = r.getStatus();
	//		switch (status) {
	//		case 1:
	//			repot.createTest(name).pass("test ca se pass");
	//			break;
	//		case 2:
	//			repot.createTest(name).fail("test ca se fail");
	//			break;
	//
	//		default:
	//			repot.createTest(name).skip("test ca se skip");
	//
	//			break;
	//		}
	//
	//	}
	//	public static void htmlendrep() {
	//		repot.flush();
	//
	//	}



	//it is used for extends report(siva send)

	public static String getPropertyValue(String fileName, String Key) {
		property = new Properties();
		try {
			InputStream inputFile = new FileInputStream(dir + "\\src\\main\\resources\\properties\\" + fileName + ".properties");
			property.load(inputFile);
			System.out.println("Properties file has been loaded and ready to access.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String value = property.getProperty(Key);
		if (fileName.equalsIgnoreCase("path")) {
			System.out.println("The path for the given key is : " + dir + value);
		}
		if (fileName.equalsIgnoreCase("global")) {
			System.out.println("The expected key value is ------------------ " + Key + " : " + value);
		}
		return value;
	}




}
