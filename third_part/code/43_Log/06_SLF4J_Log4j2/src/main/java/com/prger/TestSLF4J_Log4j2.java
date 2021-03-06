package com.prger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestSLF4J_Log4j2 {

    public static void main(String[] args) {

        Logger logger = LoggerFactory.getLogger(TestSLF4J_Log4j2.class);
        logger.error("错误-ERROR");
        logger.warn("警告-WARN");
        logger.info("信息-INFO");
        logger.debug("调试-DEBUG");
        logger.trace("痕迹-TRACE");
    }
}
