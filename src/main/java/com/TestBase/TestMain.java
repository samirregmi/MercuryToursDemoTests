package com.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;

import com.Utils.GlobalWaits;

public class TestMain {
public static WebDriver driver;
public static Properties prop;

public TestMain() {
	try {
		prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\TESTNG PROJECT WORKSPACE\\MercuryToursTests\\src\\main\\java\\com\\Properties\\config.properties");
		prop.load(file);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	public static void initialization() {
	 String browserName  = prop.getProperty("Browser");
	 if(browserName.equals("Chrome")) {
		System.setProperty(prop.getProperty("ChromeKey"), prop.getProperty("ChromePath"));
		driver = new ChromeDriver();
	 }
	 else if(browserName.equals("fireFox")) {
	System.setProperty(prop.getProperty("fireFoxKey"), prop.getProperty("fireFoxPath"));
	driver = new FirefoxDriver();
	}
	 else if(browserName.equals("Edge")) {
			System.setProperty(prop.getProperty("MsEdgeKey"), prop.getProperty("MsEdgePath"));
			driver = new EdgeDriver();
			}
	 else {
		 System.err.println("Driver not in Scope\n Please Try With Valid Driver Instance");
	 }

	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalWaits.IMPLICIT_WAITS));
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GlobalWaits.PAGE_LOAD_TIMEOUT));
	 driver.get(prop.getProperty("QAUrl"));
	 try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

	public static void tearDown() {
		driver.quit();
	}
}



