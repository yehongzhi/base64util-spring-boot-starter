package com.lovebilibili.me.config;

import com.lovebilibili.me.service.Base64Service;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ye Hongzhi
 * @program Base64AutoConfiguration
 * @description
 * @date 2020-02-17 15:16
 **/
@Configuration
public class Base64AutoConfiguration {

    @Bean
    Base64Service base64Service(){
        return new Base64Service();
    }
}
