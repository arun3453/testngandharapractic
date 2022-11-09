package day_1;

import java.util.Date;

import org.seleniumhq.jetty9.server.Authentication.User;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import bsh.BshClassManager.Listener;
import day_2.extenddemo;
import org_day1.bass.baseclass;
import pomfile.cromapom;
import repotsandscreen.extendsreportts;

public class croma extends baseclass {

	@BeforeClass
	private void befclass() {
		openedgedriver();
		impandmin();

	}
	@AfterClass
	private void aftcl() {
		quit();

	}

	@BeforeMethod
	private void befmet() {
		Date d=new Date();
		System.out.println("=====" +d);
	}
	@AfterMethod
	private void aftmet(ITestResult r) {
		Date d=new Date();
		System.out.println("=====" +d);

	}
    
	@Test(priority=1)
	private void test1() throws InterruptedException {
		geturl();
		cromapom c=new cromapom();
		c.getGotomenu();
		c.getGototelevision();
		c.getGotoledtv2();
		c.getGotoQleedtv();
		c.getGodown();
		c.getGoup();
		c.getGocheckbox();
	}
	@Test(priority=2)
	private void test2() throws InterruptedException {
		cromapom c=new cromapom();
		c.getserch();
		c.getserchbutton();
		c.geterroemess1();

	}
}
//*[@id="258509"]/div[2]/div[1]/h3

//*[@id="comp_00006K4G"]/div/div/div/div/div/div/div/a/span/img
//html/body/main/div[3]/div/div[2]/div[1]/div/div/div/div/div/div/div/a/span/img
