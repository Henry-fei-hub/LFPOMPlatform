/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package delicacy.servlet;

import java.io.InputStream;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 *
 * @author CL
 */
public class TimerPropertiesUtils {

    private static final Logger __logger = Logger.getLogger(TimerPropertiesUtils.class);
    private final static Properties properties = new Properties();
    private final static String propertyName = "/timer.properties";

    static {
        try (InputStream resourceAsStream = TimerPropertiesUtils.class.getResourceAsStream(propertyName)) {
            properties.load(resourceAsStream);
        } catch (Exception e) {
            __logger.error("timer.properties", e);
        }
    }

    public static String getValue(String key) {
        return properties.getProperty(key);
    }
}
