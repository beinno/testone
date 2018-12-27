import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class keywordClass {

    // Keyword methods
    public void testBingSearch(WebDriver driver, WebDriverWait driverWait) {

        driver.get("https://www.bing.com");
        WebElement searchBox = driver.findElement(By.id("sb_form_q"));
        searchBox.sendKeys("selenium guru99");
        driver.findElement(By.id("sbBtn")).click();
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Selenium Tutorial for Beginners")));
        WebElement searchItem = driver.findElement(By.partialLinkText("Selenium Tutorial for Beginners"));
        searchItem.click();
        String webURL = driver.getCurrentUrl();
        Assert.assertEquals(webURL,"https://www.guru99.com/selenium-tutorial.html");
        Reporter.log("Bing Search Passed");
    }

    public void testGoogleSearch(WebDriver driver, WebDriverWait driverWait) {

        driver.get("https://www.google.com");
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("selenium guru99");
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Selenium Tutorial for Beginners")));
        WebElement searchItem = driver.findElement(By.partialLinkText("Selenium Tutorial for Beginners"));
        searchItem.click();
        String webURL = driver.getCurrentUrl();
        Assert.assertEquals(webURL,"https://www.guru99.com/selenium-tutorial.html");
        Reporter.log("Google Search Passed");

    }

    public void testDuckDuckSearch(WebDriver driver, WebDriverWait driverWait) {

        driver.get("https://www.duckduckgo.com");
        WebElement searchBox = driver.findElement(By.id("search_form_input_homepage"));
        searchBox.sendKeys("selenium guru99");
        driver.findElement(By.id("search_button_homepage")).click();
        WebElement searchItem = driver.findElement(By.cssSelector("a[href='https://www.guru99.com/selenium-tutorial.html']"));
        searchItem.click();
        String webURL = driver.getCurrentUrl();
        Assert.assertEquals(webURL,"https://www.guru99.com/selenium-tutorial.html");
        Reporter.log("DuckDuck Search Passed");

    }
}
