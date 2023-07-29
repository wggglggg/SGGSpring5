package com.sggspring5.spring5.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ClassName: UserLog
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/29 21:13
 * @Version 1.0
 */
public class UserLog {

    private static final Logger log = LoggerFactory.getLogger(UserLog.class);
    public static void main(String[] args) {
        log.info("hello log4j2");
        log.warn("hello log4j2");
    }
}
