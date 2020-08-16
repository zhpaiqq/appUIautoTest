package com.dahua.tc.gaea.base;

import com.dahua.tc.gaea.constant.AssertConst;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

/**
 * 测试基类
 *
 * @author kay
 * @since 2019-12-06
 */
@Slf4j
public class BaseCase {

    public static AndroidDriver<MobileElement> driver;
    public static String result;

    public static AndroidDriver<MobileElement> getInstance(String udid, String packageName, String activity) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "m1");
        capabilities.setCapability("noReset", true);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);
        capabilities.setCapability("appPackage", packageName);
        capabilities.setCapability("appActivity", activity);
        capabilities.setCapability("newCommandTimeout", 600000);
        try {
            driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
            driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS); //隐性等待
        } catch (Exception e) {
            e.printStackTrace();
        }

        return driver;
    }

    /**
     * 封装断言的返回操作
     */
    public static void goBack(String result, String message) {
        log.info("【Action】返回操作");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
        if (result.equals(AssertConst.PASS)) {
            assertTrue(true, message);
        } else {
            assertFalse(true, result);
        }
    }

    /**
     * 返回操作
     */
    public static void goBack() {
        log.info("【Action】返回操作");
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    /**
     * 睡眠时间
     *
     * @param milliSecond 毫秒
     */
    public static void sleep(Integer milliSecond) {
        try {
            Thread.sleep(milliSecond);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 比对结果
     */
    public static void result(String result, String message) {
        log.info("【Action】返回操作");
        if (result.equals(AssertConst.PASS)) {
            assertTrue(true, message);
        } else {
            assertFalse(true, result);
        }
    }

}
