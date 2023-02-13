package utils;

import org.apache.log4j.Logger;

public class MyLog4j {
    static Logger logger = Logger.getLogger(MyListener.class);

    public static void info(String info) {
        logger.info("\u001B[32m" + info + "\u001B[0m");
    }

    public static void error(String error) {
        logger.error("\u001B[31m" + error + "\u001B[0m");
    }

    public static void trace(String msg) {
        logger.trace("\u001B[33m" + msg + "\u001B[33m");
    }

    public static void debug(String msg) {
        logger.debug("\u001B[33m" + msg + "\u001B[33m");
    }

    public static void fatal(String msg) {
        logger.fatal("\u001B[33m" + msg + "\u001B[33m");
    }


}