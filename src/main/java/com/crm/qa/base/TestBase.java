package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener eventlistner;
	public TestBase() {
		
		try {

			File file = new File("C:\\Users\\i839973\\Desktop\\Automation - Java\\WorkSpace\\TestAutomation\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream fileInput = new FileInputStream(file);
			prop = new Properties();
			prop.load(fileInput);
			fileInput.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}


public static void intitialization() {
	
         String browserName = prop.getProperty("browser");
         if(browserName.equals("chrome")) {
        	 System.setProperty("webdriver.chrome.driver", "C:/Automation - Java/ChromeDriver/chromedriver.exe");
 			driver= new ChromeDriver();
         }
         else if(browserName.equalsIgnoreCase("Firefox")){
        	 System.setProperty("webdriver.gecko.driver", "C:/Automation - Java/ChromeDriver/geckodriver.exe");
  			driver= new ChromeDriver(); 
         }
         
         
         e_driver = new EventFiringWebDriver(driver);
         //now create object of EventListnerHandler to register it with EventFiringWebdriver
         eventlistner =  new WebEventListener();
         e_driver.register(eventlistner);
         driver = e_driver;
         
         //driver.manage().window().maximize();
         driver.manage().deleteAllCookies();
         driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
         driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
         
         System.out.println(prop.getProperty("url"));
         driver.get(prop.getProperty("url"));
          

}
	

}
/*
 *package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
					+ "/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/naveenkhunteta/Downloads/chromedriver");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "/Users/naveenkhunteta/Documents/SeleniumServer/geckodriver");	
			driver = new FirefoxDriver(); 
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
	
	
	
	
	
	

}
*/
