
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testWebBrowserSearch extends keywordClass {

    WebDriver chromeDriver, safariDriver ;
    WebDriverWait chromeDriverWait,safariDriverWait;

    @BeforeTest (groups = {"chromeTest"})
    public void chromeSetup(){
    System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver");
    chromeDriver = new ChromeDriver();
    chromeDriverWait = new WebDriverWait(chromeDriver, 2);
    }

    @BeforeTest (groups = {"safariTest"})
    public void safariSetup(){
    safariDriver = new SafariDriver();
    safariDriverWait = new WebDriverWait(safariDriver, 2);
    }

    @Test (priority = 1, groups = {"chromeTest", "GoogleTest"})
    public void webChrome_GoogleSearchTest() { testGoogleSearch(chromeDriver, chromeDriverWait); }

    @Test (priority = 2, groups = {"chromeTest", "BingTest"})
    public void webChrome_BingSearchTest() { testBingSearch(chromeDriver, chromeDriverWait); }

    @Test (priority = 3, groups = {"chromeTest", "DuckDuckTest"})
    public void webChrome_DuckDuckSearchTest() { testDuckDuckSearch(chromeDriver, chromeDriverWait); }

    @Test (priority = 4, groups = {"safariTest", "GoogleTest"})
    public void webSafari_GoogleSearchTest() { testGoogleSearch(safariDriver, chromeDriverWait); }

    @Test (priority = 5, groups = {"safariTest", "BingTest"})
    public void webSafari_BingSearchTest() { testBingSearch(safariDriver, chromeDriverWait); }

    @Test (priority = 6, groups = {"safariTest", "DuckDuckTest"})
    public void webSafari_DuckDuckSearchTest() { testDuckDuckSearch(safariDriver, safariDriverWait); }

    @AfterTest
    public void driverClose() {
    chromeDriver.close();
    safariDriver.close();
    }
}


