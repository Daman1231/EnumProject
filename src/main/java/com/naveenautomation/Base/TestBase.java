package com.naveenautomation.Base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.naveenautomation.Browser.Browser;
import com.naveenautomation.Listener.WebDriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	// testing webhook
	public static ThreadLocal<WebDriver> local = new ThreadLocal<>();

	public static WebDriver driver;
	public Browser DEFAULT_BROWSER = Browser.GOOGLE_CHROME;
	public static WebDriverEvents events;
	public EventFiringWebDriver eventFiringWebDriver;
	DesiredCapabilities desiredCapabilities = new DesiredCapabilities();

	public void launchBrowser() {
		desiredCapabilities.setBrowserName("chrome");
		desiredCapabilities.setPlatform(Platform.WINDOWS);
		desiredCapabilities.setVersion("109.0.5414.74");

		switch (DEFAULT_BROWSER) {
		case GOOGLE_CHROME:
			ChromeOptions options = new ChromeOptions();
			options.merge(desiredCapabilities);
			// options.setExperimentalOption("prefs", chromePreferences);
//			WebDriverManager.chromedriver().setup();
			try {
				driver = new RemoteWebDriver(new URL("http://192.168.2.254:4444"), options);
				local.set(driver);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			driver = new ChromeDriver();
			break;
		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;

		default:
			System.out.println("Browser Not Found");
			break;
		}

		eventFiringWebDriver = new EventFiringWebDriver(local.get());
		events = new WebDriverEvents();
		eventFiringWebDriver.register(events);
		local.set(eventFiringWebDriver);
		local.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		local.get().manage().window().maximize();
		local.get().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		local.get().manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		local.get().get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
	}

	public void quitBrowser() {
		local.get().quit();
	}

}
