
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.*;

public class testSearch {

    WebDriver chromeDriver, safariDriver,iOSDriver ;
    WebDriverWait chromeDriverWait,safariDriverWait,iOSWaitDriver;
    Long startTime;

//@BeforeTest
//    public void chromeSetup(){
//    System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver");
//    chromeDriver = new ChromeDriver();
//    chromeDriverWait = new WebDriverWait(chromeDriver, 2);
//    chromeDriver.get("https://www.bing.com");
//    }
//
//@BeforeTest
//    public void safariSetup(){
//    safariDriver = new SafariDriver();
//    safariDriverWait = new WebDriverWait(safariDriver, 2);
//    safariDriver.get("https://www.bing.com");
//}

@BeforeTest
    public void iOSSetup() throws MalformedURLException {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XS");
    capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
    iOSDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    iOSWaitDriver = new WebDriverWait(iOSDriver, 4);

}

//@Test (priority = 0)
//    public void scenario1_test_chrome() { testGoogleSearch(chromeDriver, chromeDriverWait); }
//@Test (priority = 1)
//    public void scenario1_test_safari() { testGoogleSearch(safariDriver, safariDriverWait); }

    @Test
    public void scenario3_test_iPhoneXR_safari(){
    iOSDriver.get("https://www.google.com");
    //testGoogleSearch(iOSDriver, iOSWaitDriver);
    }


    @AfterTest
    public void driverClose() {
//    chromeDriver.close();
//    safariDriver.close();
    iOSDriver.close();
    }

    // Keyword methods
    public void testBingSearch(WebDriver driver, WebDriverWait driverWait) {

        startTime = System.currentTimeMillis();
        WebElement searchBox = driver.findElement(By.id("sb_form_q"));
        searchBox.sendKeys("selenium guru99");
        searchBox.submit();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Selenium Tutorial for Beginners")));
        WebElement searchItem = driver.findElement(By.partialLinkText("Selenium Tutorial for Beginners"));
        searchItem.click();

        String webURL = driver.getCurrentUrl();

        Assert.assertEquals(webURL,"https://www.guru99.com/selenium-tutorial.html");
        Long runTime = (System.currentTimeMillis() - startTime);
        Reporter.log("Total Run time" + runTime.toString());
    }

    public void testGoogleSearch(WebDriver driver, WebDriverWait driverWait) {

        startTime = System.currentTimeMillis();
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium guru99");
        searchBox.submit();

        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Selenium Tutorial for Beginners")));
        WebElement searchItem = driver.findElement(By.partialLinkText("Selenium Tutorial for Beginners"));
        searchItem.click();

        String webURL = driver.getCurrentUrl();

        Assert.assertEquals(webURL,"https://www.guru99.com/selenium-tutorial.html");
        Long runTime = (System.currentTimeMillis() - startTime);
        Reporter.log("Total Run time" + runTime.toString());
    }

}

