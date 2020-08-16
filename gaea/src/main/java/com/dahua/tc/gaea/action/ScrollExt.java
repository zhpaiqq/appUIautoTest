package com.dahua.tc.gaea.action;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

/**
 * 滚屏扩展类.
 *
 * @author kay
 * @since 2019-12-16
 */
@Slf4j
public class ScrollExt {
    /**
     * find element by xpath
     */
    public static final String XPATH = "XPATH";
    /**
     * find element by name
     */
    public static final String NAME = "NAME";
    /**
     * find element by id
     */
    public static final String ID = "ID";
    /**
     * find element by classname
     */
    public static final String CLASSNAME = "CLASSNAME";
    /**
     * find element by AccessibilityId
     */
    public static final String ACCESSIBILITYID = "AccessibilityId";

    public static final String INDEX = "INDEX";

    public static final String INSTANCE = "INSTANCE";

    //name,id,AccessibilityId method
    public static String scrollTo(String content, String type) {
        String uiautomatorStr = null;
        if (type == "NAME") {
            uiautomatorStr = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + content
                    + "\"))";
        } else if (type == "ID") {
            uiautomatorStr = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\""
                    + content + "\"))";
        } else if (type == "AccessibilityId") {
            uiautomatorStr = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\""
                    + content + "\"))";
        } else if (type == "XPATH") {
            uiautomatorStr = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().xpath(\"//*[@text=\"" + content
                    + "]\"))";
        }
        return uiautomatorStr;
    }

    //className method
    public static String scrollTo(String content, String className, String type, int number) {
        String uiautomatorStr = null;
        if (className == "CLASSNAME" && type == "INDEX") {
            uiautomatorStr = "new UiScrollable(new UiSelector().scrollable(true).index(" + number
                    + ")).getChildByText(new UiSelector().className(\"" + content + "\")";
        } else if (className == "CLASSNAME" && type == "INSTANCE") {
            uiautomatorStr = "new UiScrollable(new UiSelector().scrollable(true).instance(" + number
                    + ")).getChildByText(new UiSelector().className(\"" + content + "\")";
        }

        return uiautomatorStr;
    }


    /**
     * 滑动屏幕
     *
     * @param driver Android driver
     */
    public static void swipeInScreen(AndroidDriver<MobileElement> driver, int startX, int startY, int endX, int endY) {
        log.info("滑动屏幕: ({},{}) -> ({},{})", startX, startY, endX, endY);
        new TouchAction<>(driver)
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ZERO))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    /**
     * 滑动屏幕查找元素
     *
     * @param driver        Android driver
     * @param by            By
     * @param maxSwipeCount 最大滑动次数
     * @return WebElement
     */
    public static WebElement swipeInScreenAndFindElement(AndroidDriver<MobileElement> driver, By by, int maxSwipeCount) {
        Dimension size = driver.manage().window().getSize();
        int width = size.width;
        int height = size.height;
        int startX = (int) (0.5 * width);
        int startY = (int) (0.9 * height);
        int endX = (int) (0.5 * width);
        int endY = (int) (0.3 * height);
        int tmpX = 0;
        int tmpY = 0;
        try {
            return driver.findElement(by);
        } catch (Exception e) {
        }

        for (int i = 0; i < maxSwipeCount; i++) {
            log.info("开始滑动第{}次屏幕", i + 1);
            swipeInScreen(driver, startX, startY, endX, endY);
            try {
                return driver.findElement(by);
            } catch (Exception e) {
                tmpX = startX;
                tmpY = startY;
                startX = endX;
                startY = endY;
                endX = tmpX;
                endY = tmpY;
            }
        }
        return driver.findElement(by);
    }
}
