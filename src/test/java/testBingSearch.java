
import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.*;


public class testBingSearch {

@BeforeTest
    public void driverSetup(){
    System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver");
    }

@Test
    public void scenario1() throws InterruptedException {
    WebDriver chromeDriver = new ChromeDriver();
    chromeDriver.get("https://www.bing.com");
    sleep(5000);
    chromeDriver.close();
    }

}

