package org.hquijano.utils;

import org.apache.logging.log4j.Logger;

public class LoggerHelper {
    public static Logger getLogger(Class<?> clazz) {
        return org.apache.logging.log4j.LogManager.getLogger(clazz);
    }
}
