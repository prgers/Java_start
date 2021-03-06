package com.prger;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class TestLog4j1 {

    public static void main(String[] args) {

        Logger logger = LogManager.getLogger(TestLog4j1.class);
//        for (int i = 0; i < 1000; i++) {
            logger.fatal("致命-FATAL");
            logger.error("错误-ERROR");
            logger.warn("警告-WARN");
            logger.info("信息-INFO");
            logger.debug("调试-DEBUG");
            logger.trace("痕迹-TRACE");
//        }
    }
}
