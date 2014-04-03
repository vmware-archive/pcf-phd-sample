package com.gopivotal.cf.samples.hadoop.config;

import com.gopivotal.cf.samples.hadoop.connector.spring.HdfsServiceConfiguration;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class CloudConfig extends AbstractCloudConfig {

    @Bean
    public HdfsServiceConfiguration configuration() {
        return connectionFactory().service(HdfsServiceConfiguration.class);
    }

}
