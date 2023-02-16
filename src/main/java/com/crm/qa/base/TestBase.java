package com.crm.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBase() {
		
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("C:\\Users\\pankaj.kumar\\workspace\\CRMProject2023\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			
			
			try {
				prop.load(ip);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static void initialization() {
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\pankaj.kumar\\workspace\\CRMProject2023\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			driver=new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		
		driver.get(prop.getProperty("url"));
		
	}
	
	public static void failure(String methodName) {
		
		
		 File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		 
		try {
			
			String timestamp=new SimpleDateFormat("YYYY_MM_dd_hh_mm_ss").format(new Date());
			
					
			
			FileHandler.copy(src,new File("C:\\Users\\pankaj.kumar\\workspace\\CRMProject2023\\Screenshots from Scripts\\"+"failure"+"_"+methodName+"_"+timestamp+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
