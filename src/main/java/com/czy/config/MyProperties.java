package com.czy.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Chenzy
 * @description: 元数据配置
 * @create 2022/5/6 16:48
 **/
@Data
@Configuration
@ConfigurationProperties(prefix = "com.czy")
public class MyProperties {

    //项目名称
    private String name;

}
