package pomfile;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import org_day1.bass.baseclass;

public class cromapom extends baseclass {
	
	public cromapom() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='menu-icon-hamb']")
	private WebElement gotomenu;
	@FindBy(xpath="//h4[text()='Televisions & Accessories']")
	private WebElement gototelevision;
	@FindBy(xpath="(//h5[text()='LED TVs'])[1]")
	private WebElement gotoledtv2;
	@FindBy(xpath="(//h6[text()='QLED TVs'])[1]")
	private WebElement gotoQleedtv;
	@FindBy(xpath="//a[text()='Top Brands']")
	private WebElement godown;
	@FindBy(xpath="//*[@id=\"container\"]/div[3]/div[1]/div[2]/div/div[1]/div[2]/div[2]/h3")
	private WebElement goup;
	@FindBy(xpath="//*[@id=\"panel0bh-content\"]/div/p/div/ul/li[1]/div/label/span[2]")
	private WebElement gocheckbox;
	

	
	
	@FindBy(xpath="//input[contains(@class,'MuiAutocomplete-input MuiAutocomplete')]")
	private WebElement serch;
	@FindBy(xpath="//span[@class='icon']")
	private WebElement serchbutton;
	@FindBy(xpath="//*[@id=\"nullsearchdatael\"]/div[1]/div[3]/h2[1]")
	private WebElement erroemess1;
	
	//h2[@class='no-result-sub-headline']
	
	public void getGotomenu() {
		clik(gotomenu);
	}
	public void getGototelevision() {
		moveToElement(gototelevision);
	}
	public void getGotoledtv2() {
		moveToElement(gotoledtv2);
	}
	public void getGotoQleedtv() {
		moveToElement(gotoQleedtv);
		clik(gotoQleedtv);
	}
	public void getGocheckbox() throws InterruptedException {
		
		clik(gocheckbox);
		if(gocheckbox.isSelected()) {
			Thread.sleep(3000);
			System.out.println("is select");
		}
		else
		{
			System.out.println("not displayed");
		}
		
	}
	public void getGodown() throws InterruptedException {
		Thread.sleep(2000);
		down(godown);
		
	}
	public void getGoup() throws InterruptedException {
		Thread.sleep(2000);
		up(goup);
		
	}

	public void getserch() throws InterruptedException {
        refresh();
		Thread.sleep(5000);
		clik(serch);	
		sendkey(serch, "kmgkfm");
	}
	public void getserchbutton() throws InterruptedException {
		Thread.sleep(2000);
		clik(serchbutton);
		
	}

	
	public void geterroemess1() {
		WebDriverWait w=new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.visibilityOf(erroemess1));
		if(erroemess1.isDisplayed()) {
		String e1 = erroemess1.getText();
		System.out.println(e1);
		String e2 = "We couldn't find any matches!";
		Assert.assertEquals(e1, e2);
		System.out.println("error is occure");
		}
		else {
			System.out.println("error is not occure");
		}
		
		
	}
	
	
	


}
