package com.dahua.tc.gaea.action;

import com.dahua.tc.gaea.base.BaseCase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

/**
 * 行为扩展类.
 *
 * @author kay
 * @since 2019-12-10
 */
@Slf4j
public class ActionExt {

    /**
     * 点击操作
     *
     * @param driver   Android driver
     * @param by       元素定位
     * @param pageName 页面名称
     */
    public static void click(AndroidDriver<MobileElement> driver, By by, String pageName) {
        log.info("点击进入 {} 界面", pageName);
        driver.findElement(by).click();
    }

    /**
     * 点击操作
     *
     * @param driver   Android driver
     * @param by       元素定位
     * @param duration 时长 单位：秒
     * @param pageName 页面名称
     */
    public static void click(AndroidDriver<MobileElement> driver, By by, int duration, String pageName) {
        BaseCase.sleep(duration * 1000);
        log.info("点击进入 {} 界面", pageName);
        driver.findElement(by).click();
    }

    /**
     * 点击操作
     *
     * @param driver   Android driver
     * @param by       元素定位
     * @param duration 时长 单位：秒
     */
    public static void click(AndroidDriver<MobileElement> driver, By by, int duration) {
        BaseCase.sleep(duration * 1000);
        driver.findElement(by).click();
    }

    /**
     * 点击操作
     *
     * @param driver Android driver
     * @param by     元素定位
     */
    public static void click(AndroidDriver<MobileElement> driver, By by) {
        driver.findElement(by).click();
    }

    /**
     * 点击操作
     *
     * @param driver   Android driver
     * @param content  定位内容
     * @param type     定位类型
     * @param pageName 页面名称
     */
    public static void click(AndroidDriver<MobileElement> driver, String content, String type, String pageName) {
        log.info("点击进入 {} 界面", pageName);
        driver.findElementByAndroidUIAutomator(ScrollExt.scrollTo(content, type)).click();
    }

    /**
     * 上滑
     *
     * @param driver Android driver
     */
    public static void swipeUp(AndroidDriver<MobileElement> driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction<>(driver).longPress(PointOption.point(width / 2, 100))
                .moveTo(PointOption.point(width / 2, height - 100))
                .release()
                .perform();
    }

    /**
     * 自定义上滑
     *
     * @param driver Android driver
     */
    public static void swipeUp(AndroidDriver<MobileElement> driver, int heightCustom) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction<>(driver).longPress(PointOption.point(width / 2, heightCustom))
                .moveTo(PointOption.point(width / 2, height - heightCustom))
                .release()
                .perform();
    }

    /**
     * 下滑
     *
     * @param driver Android driver
     */
    public static void swipeDown(AndroidDriver<MobileElement> driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - 100))
                .moveTo(PointOption.point(width / 2, 100))
                .release()
                .perform();
    }

    /**
     * 自定义下滑
     *
     * @param driver       Android driver
     * @param heightCustom 自定义顶侧起始位置
     */
    public static void swipeDown(AndroidDriver<MobileElement> driver, int heightCustom) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction<>(driver).longPress(PointOption.point(width / 2, height - heightCustom))
                .moveTo(PointOption.point(width / 2, heightCustom))
                .release()
                .perform();
    }

    /**
     * 左滑：默认从右边100的位置开始
     *
     * @param driver Android driver
     */
    public static void swipeLeft(AndroidDriver<MobileElement> driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction<>(driver).longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(100, height / 2))
                .release()
                .perform();
    }

    /**
     * 自定义左滑
     *
     * @param driver      Android driver
     * @param widthCustom 自定义左侧起始位置
     */
    public static void swipeLeft(AndroidDriver<MobileElement> driver, int widthCustom) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction<>(driver).longPress(PointOption.point(width - widthCustom, height / 2))
                .moveTo(PointOption.point(widthCustom, height / 2))
                .release()
                .perform();
    }

    /**
     * 右滑：默认从左边100的位置开始
     *
     * @param driver Android driver
     */
    public static void swipeRigth(AndroidDriver<MobileElement> driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction<>(driver).longPress(PointOption.point(100, height / 2))
                .moveTo(PointOption.point(width - 100, height / 2))
                .release()
                .perform();
    }

    /**
     * 自定义右滑
     *
     * @param driver      Android driver
     * @param widthCostom 自定义左侧起始位置
     */
    public static void swipeRigth(AndroidDriver<MobileElement> driver, int widthCostom) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction<>(driver).longPress(PointOption.point(widthCostom, height / 2))
                .moveTo(PointOption.point(width - widthCostom, height / 2))
                .release()
                .perform();
    }

    /**
     * 单点触屏
     *
     * @param driver Android driver
     */
    public static void singleTouchScreen(AndroidDriver<MobileElement> driver) {
        Dimension size = driver.manage().window().getSize();
        int height = size.height;
        int width = size.width;
        new TouchAction<>(driver).press(PointOption.point(width / 2, height / 2))
                .release()
                .perform();
    }

    /**
     * 根据坐标输入单个数字键
     *
     * @param driver Android driver
     * @param width  width
     * @param height width
     * @param number 数字键说明
     */
    public static void digitalKey(AndroidDriver<MobileElement> driver, int width, int height, String number) {
        log.info("点击【{}】", number);
        new TouchAction<>(driver).press(PointOption.point(width, height))
                .release()
                .perform();
    }

    /**
     * 根据坐标输入多个数字键
     *
     * @param driver  Android driver
     * @param widths  横坐标数组
     * @param heights 纵坐标数组
     * @param numbers 数字键说明数组
     */
    public static void digitalMultKeys(AndroidDriver<MobileElement> driver, int[] widths, int[] heights, String[] numbers) {
        if (widths.length != heights.length) {
            log.error("指针输入错误，width和height数量必须一致");
        }
        for (int i = 0; i < widths.length; i++) {
            log.info("点击【{}】", numbers[i]);
            new TouchAction<>(driver).press(PointOption.point(widths[i], heights[i]))
                    .release()
                    .perform();
        }
    }

    /**
     * 根据坐标输入数字123456
     *
     * @param driver Android driver
     */
    public static void digitalKeysFromOneToSix(AndroidDriver<MobileElement> driver) {
        int initWidth = 400;
        int initHeight = 265;
        for (int i = 1; i <= 6; i++) {
            log.info("点击数字【{}】", i);
            if (i == 1 || i == 2 || i == 3) {
                new TouchAction<>(driver).press(PointOption.point(initWidth + (i - 1) * 110, initHeight))
                        .release()
                        .perform();
            }
            if (i == 4 || i == 5 || i == 6) {
                new TouchAction<>(driver).press(PointOption.point(initWidth + (i - 4) * 110, initHeight + 100))
                        .release()
                        .perform();
            }
            BaseCase.sleep(1000);
        }
    }

    /**
     * 根据坐标点击按钮
     *
     * @param driver  Android driver
     * @param width   横坐标
     * @param height  纵坐标
     * @param btnName 按钮名字
     */
    public static void buttonByCoordinate(AndroidDriver<MobileElement> driver, int width, int height, String btnName) {
        log.info("点击按钮【{}】", btnName);
        new TouchAction<>(driver).press(PointOption.point(width, height))
                .release()
                .perform();
    }

    /**
     * 根据坐标点击按钮,并自定义等待时长
     *
     * @param driver   Android driver
     * @param width    横坐标
     * @param height   纵坐标
     * @param btnName  按钮名字
     * @param duration 时长 单位：秒
     */
    public static void buttonByCoordinate(AndroidDriver<MobileElement> driver, int width, int height, String btnName, int duration) {
        log.info("点击按钮【{}】", btnName);
        new TouchAction<>(driver).press(PointOption.point(width, height))
                .release()
                .perform();
        BaseCase.sleep(duration * 1000);
    }

}
