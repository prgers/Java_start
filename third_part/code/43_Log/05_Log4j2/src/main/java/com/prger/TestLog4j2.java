package com.prger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLog4j2 {
    public static void main(String[] args) {
        Logger logger = LogManager.getLogger(TestLog4j2.class);
        logger.fatal("致命-FATAL");
        logger.error("错误-ERROR");
    }
}
