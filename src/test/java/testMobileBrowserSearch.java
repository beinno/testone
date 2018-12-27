
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class testMobileBrowserSearch extends keywordClass {

    WebDriver iOSDriver ;
    WebDriverWait iOSWaitDriver;

    @BeforeTest
    public void iOSSetup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XS");
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        iOSDriver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        iOSWaitDriver = new WebDriverWait(iOSDriver, 4);
        iOSDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void test_iPhoneXR_safari() {
        testDuckDuckSearch(iOSDriver, iOSWaitDriver);
    }


    @AfterTest
    public void driverClose() {
        iOSDriver.close();
    }
}



