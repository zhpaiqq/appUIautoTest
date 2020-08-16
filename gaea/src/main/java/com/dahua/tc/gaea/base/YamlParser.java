package com.dahua.tc.gaea.base;

import lombok.extern.slf4j.Slf4j;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Yaml文件解析器
 *
 * @author kay
 * @since 2020-01-15
 */
@Slf4j
public class YamlParser {

    public static <T> Object parser(String yaml, Class<T> clazz) {
        try {
            String configFileName = System.getProperty("user.dir") + File.separator + "locator" + File.separator + yaml;
            InputStream inputStream = new FileInputStream(new File(configFileName));
            Object result = new Yaml().loadAs(inputStream, clazz);
            return result;
        } catch (Exception e) {
            log.error("Fail to read resource config file");
        }
        return null;
    }
}
