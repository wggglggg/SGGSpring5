package com.ssgspring5.spring5.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * ClassName: ConfigAOP
 * Description:
 *
 * @Author wggglggg
 * @Create 2023/7/28 19:43
 * @Version 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.ssgspring5.spring5")
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigAOP {
}
