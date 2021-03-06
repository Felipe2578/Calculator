package sample;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertEquals;

public class Calc {

    private AndroidDriver <MobileElement> driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "9.0");
        desiredCapabilities.setCapability("browserName", "");
        desiredCapabilities.setCapability("appiumVersion", "1.19.2");
        desiredCapabilities.setCapability("deviceName", "Samsung Galaxy S9 FHD GoogleAPI Emulator");
        desiredCapabilities.setCapability("deviceOrientation", "portrait");
        desiredCapabilities.setCapability("app", "storage:filename=Calculator_v7.8 (271241277)_apkpure.com.apk");
        desiredCapabilities.setCapability("appPackage", "com.google.android.calculator");
        desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        desiredCapabilities.setCapability("ensureWebviewsHavePages", true);
        desiredCapabilities.setCapability("SAUCE_USERNAME", "FELIPEmoralesSouza");
        desiredCapabilities.setCapability("SAUCE_ACCESS_KEY", "3506f927-c911-4034-83e3-032f2b6253b5");

        URL remoteUrl = new URL("https://FELIPEmoralesSouza:3506f927-c911-4034-83e3-032f2b6253b5@ondemand.us-west-1.saucelabs.com:443/wd/hub");

        driver = new AndroidDriver<MobileElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        String expectdresult = "5";

        MobileElement btn2 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_2");
        btn2.click();
        MobileElement btnPlus = (MobileElement) driver.findElementByAccessibilityId("plus");
        btnPlus.click();
        MobileElement btn3 = (MobileElement) driver.findElementById("com.google.android.calculator:id/digit_3");
        btn3.click();
        MobileElement btnEqual = (MobileElement) driver.findElementByAccessibilityId("equals");
        btnEqual.click();
        MobileElement lblResult = (MobileElement) driver.findElementById("com.google.android.calculator:id/result_final");
        lblResult.click();

        assertEquals(expectdresult, lblResult.getText());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
