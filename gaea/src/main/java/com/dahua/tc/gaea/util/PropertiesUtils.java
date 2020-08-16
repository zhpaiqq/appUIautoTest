package com.dahua.tc.gaea.util;

import com.dahua.tc.gaea.constant.CharsetConst;
import com.dahua.tc.gaea.constant.ConfigConst;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * Properties工具类.
 *
 * @author kay
 * @since 2019-12-24
 */
@Slf4j
public class PropertiesUtils {

    /**
     * 读取配置文件
     *
     * @param key: 配置项
     * @return 配置项的值
     */
    public static String getValue(String key) {
        String value = readValue(ConfigConst.CONFIG_PROPERTIES, key);
        if (null == value || "".equals(value)) {
            log.error("【 " + key + " 】配置项 : 没有在config.properties中配置！！！！！！");
        }
        return value.replaceAll("\r", "").replaceAll("\n", "");
    }

    /**
     * 读取配置文件信息
     *
     * @param fileName: 配置文件名
     * @param key:      配置项
     * @return 配置项的值
     */
    public static String readValue(String fileName, String key) {
        Properties props = new Properties();
        try {
            InputStream in = new BufferedInputStream(new FileInputStream(fileName));
            props.load(new InputStreamReader(in, CharsetConst.UTF_8));
            String value = props.getProperty(key);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
