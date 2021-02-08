package mobile.testing.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {
    private static Logger log = LogManager.getRootLogger();

    public static void writeErrorMessage(String message) {
        log.error(message);
    }

    public static void writeErrorMessage(String message, Object object) {
        log.error(message, object);
    }

    public static void writeInfoMessage(String message) {
        log.info(message);
    }

    public static void writeInfoMessage(String message, Object object) {
        log.info(message, object);
    }

    public static void writeWarnMessage(String message) {
        log.warn(message);
    }

    public static void writeWarnMessage(String message, Object object) {
        log.warn(message, object);
    }
}
