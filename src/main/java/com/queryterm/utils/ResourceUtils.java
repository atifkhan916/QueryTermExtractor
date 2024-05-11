package com.queryterm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ResourceUtils {

    private static Properties prop = new Properties();

    static {

        try (InputStream input = ResourceUtils.class.getClassLoader().getResourceAsStream("config.properties")) {

            if (input == null) {
                System.out.println("Unable to find config.properties");
                throw new IOException("No config.properties file found");
            }
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private ResourceUtils() {}

    public static String getPropertyValue(String key) {
        return prop.getProperty(key);
    }
}
