package org.hquijano.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private static Properties prop;

    public static Properties getProperties() {
        if (prop == null) {
            prop = new Properties();
            try {
                FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
                prop.load(fis);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load config", e);
            }
        }
        return prop;
    }

    public static String getBaseUrl() {
        return getProperties().getProperty("baseUrl");
    }
    public static String getBrowser(){
        return getProperties().getProperty("browser");
    }

    public static String getImplicitWaitTime(){
        return getProperties().getProperty("implicitWaitTime");
    }
}

