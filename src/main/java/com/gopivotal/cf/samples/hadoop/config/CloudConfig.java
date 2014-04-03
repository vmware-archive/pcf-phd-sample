package com.gopivotal.cf.samples.hadoop.config;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {

    @Bean
    public org.apache.hadoop.conf.Configuration configuration() {
        return connectionFactory().service(org.apache.hadoop.conf.Configuration.class);
    }

}
