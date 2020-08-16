package com.dahua.tc.gaea.util;

import java.util.Random;

/**
 * 随机数工具类.
 *
 * @author kay
 * @since 2019-12-12
 */
public class RandomUtils {

    private static String randomBase = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static String randomNumberBase = "0123456789";

    /**
     * Unicode 基本汉字编码范围0x4e00~0x9fa5 共 20902个
     */
    private final static int HANZI_LENGTH = 20902;

    private static Random random = new Random();

    /**
     * 随机生成一个字母或者数字
     *
     * @return
     */
    public static char getRandomStr() {
        Random ran = new Random();
        return (char) randomBase.charAt(ran.nextInt(62));
    }

    /**
     * 获取特定长度的字符串
     *
     * @param length     随机数长度
     * @param onlyNumber 纯数字开关，true-打开，false-关闭
     * @return 随机数
     */
    public static String getRandom(int length, boolean onlyNumber) {
        String base;
        if (onlyNumber) {
            base = randomNumberBase;
        } else {
            base = randomBase;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char chr;
            // 第一个字符不能为0
            do {
                int number = random.nextInt(base.length());
                chr = base.charAt(number);
            } while (i == 0 && chr == '0');

            sb.append(chr);
        }
        return sb.toString();
    }

    /**
     * 获取特定长度的随机int数字
     *
     * @param len: 长度
     * @return 随机int数字
     */
    public static String getRandomNum(int len) {

        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        int number = 0;
        for (int i = 0; i < len; i++) {
            number = random.nextInt(9);
            sb.append(number);
        }
        return sb.toString();
    }
}
