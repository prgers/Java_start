package com.prger;

import lombok.extern.apachecommons.CommonsLog;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@CommonsLog
public class TestJCL_log4j1 {

    public static void main(String[] args) {
//        Log log = LogFactory.getLog(TestJCL_log4j.class);
        log.fatal("致命-FATAL");
        log.error("错误-ERROR");
        log.warn("警告-WARN");
        log.info("信息-INFO");
        log.debug("调试-DEBUG");
        log.trace("痕迹-TRACE");
    }
}
