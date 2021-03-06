package com.prger;

import lombok.extern.slf4j.Slf4j;
//import org.slf4j.log;
//import org.slf4j.logFactory;

@Slf4j
public class TestSLF4J_log4j1 {

    public static void main(String[] args) {
//        log log = logFactory.getlog(TestSLF4J_log4j1.class);
        log.error("错误-ERROR");
        log.warn("警告-WARN");
        log.info("信息-INFO");
        log.debug("调试-DEBUG");
        log.trace("痕迹-TRACE");
    }
}
