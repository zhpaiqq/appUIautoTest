package com.dahua.tc.gaea.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Map;

/**
 * yaml解析工具类.
 *
 * @author kay
 * @since 2019-12-19
 */
public class ResourceUtils {
    private static final Logger log = LoggerFactory.getLogger(RandomUtils.class);

    private static Map<String, String> map;
    private static String configFileName;

    public static Map<String, String> getYamlMap(String yamlPath, String yamlFile) {
        configFileName = System.getProperty("user.dir") + File.separator + yamlPath + File.separator + yamlFile;
        try {
            InputStream inputStream = new FileInputStream(new File(configFileName));
            map = (Map<String, String>) new Yaml().load(inputStream);
            log.info("ResourceUtils file " + configFileName);
        } catch (Exception e) {
            log.error("Fail to read resource config file");
        }
        return map;
    }

}
