package com.bike.bananacard.common.tools;

import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

/**
 * created with bananaCard.
 * user: yanghui@700bike.com
 * date: 16/1/11
 * time: 下午2:27
 * description: 获取配置文件
 */
public class PropertiesUtils {
    private final static Logger LOG = Logger.getLogger(PropertiesUtils.class);
    private static Properties properties;

    static {
        if (properties == null) {
            try {
                File file = new File(PropertiesUtils.class.getResource("/config").getPath());
                if (file.exists()) {
                    File[] configFiles = file.listFiles();
                    if (configFiles != null) {
                        properties = new Properties();
                        for (File configFile : configFiles) {
                            EncodedResource resource = new EncodedResource(new FileSystemResource(configFile.getPath()));
                            PropertiesLoaderUtils.fillProperties(properties, resource);
                        }
                    }
                }
            } catch (IOException e) {
                LOG.error("加载配置文件出现异常", e);
            }
        }
    }

    public static String getValue(String key, String defaultValue) {
        String value = getValue(key);
        return StringUtils.isEmpty(value) ? defaultValue : value;
    }

    public static int getValue(String key, int defaultValue) {
        String value = getValue(key);
        return StringUtils.isEmpty(value) ? defaultValue : Integer.parseInt(value);
    }

    public static Long getValue(String key, Long defaultValue) {
        String value = getValue(key);
        return StringUtils.isEmpty(value) ? defaultValue : Long.valueOf(value);
    }

    public static String getValue(String key) {
        String value = properties.getProperty(key);
        if (value != null) {
            value = value.trim();
        }

        return value;
    }
}
