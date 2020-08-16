package com.dahua.tc.gaea.driver;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * AndroidDriver扩展类
 *
 * @author kay
 * @since 2019-12-23
 */
public class AndroidDriverExt {

    /**
     * 元素显示等待
     *
     * @param driver               Android Driver
     * @param maxWaitTimeInSeconds 最长等待时间 单位：s
     * @param by                   元素定位Locator By
     * @return WebElement
     */
    public static WebElement waitForElementVisible(AndroidDriver<MobileElement> driver, long maxWaitTimeInSeconds, By by) {
        return new WebDriverWait(driver, maxWaitTimeInSeconds).until(
                ExpectedConditions.visibilityOfElementLocated(by)
        );
    }
}
