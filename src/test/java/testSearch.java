
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import static java.lang.Thread.*;

public class testSearch {

    WebDriver chromeDriver, safariDriver ;
    WebDriverWait chromeDriverWait,safariDriverWait;
    Long startTime;

@BeforeTest
    public void chromeSetup(){
    System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver");
    chromeDriver = new ChromeDriver();
    chromeDriverWait = new WebDriverWait(chromeDriver, 2);
    chromeDriver.get("https://www.bing.com");
    }

@BeforeTest
    public void safariSetup(){
    safariDriver = new SafariDriver();
    safariDriverWait = new WebDriverWait(safariDriver, 2);
    safariDriver.get("https://www.bing.com");
}

@Test (priority = 0)
    public void scenario1_test_chrome() { testGoogleSearch(chromeDriver, chromeDriverWait); }
@Test (priority = 1)
    public void scenario1_test_safari() { testGoogleSearch(safariDriver, safariDriverWait); }


@AfterTest
    public void driverClose() {
    chromeDriver.close();
    safariDriver.close();
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

