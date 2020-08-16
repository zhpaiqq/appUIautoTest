package com.dahua.tc.gaea.util;

import org.apache.commons.lang3.StringUtils;

/**
 * StringUtils扩展工具类.
 *
 * @author kay
 * @since 2019-12-27
 */
public class StringUtilsExt extends StringUtils {

    public static String deleteCRLFOnce(String str) {
        return str.replaceAll("((\r\n)|\n)", "");
    }
}
