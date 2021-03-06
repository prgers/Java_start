package com.prger;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
public class TestSLF4J_logback {

    public static void main(String[] args) {
//        Logger log = LoggerFactory.getLogger(TestSLF4J_logback.class);
        log.error("错误-ERROR");
        log.warn("警告-WARN");
        log.info("信息-INFO");
        log.debug("调试-DEBUG");
    }
}
