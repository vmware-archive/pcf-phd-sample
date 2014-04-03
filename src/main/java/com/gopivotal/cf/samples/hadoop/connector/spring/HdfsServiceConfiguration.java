package com.gopivotal.cf.samples.hadoop.connector.spring;

import org.apache.hadoop.conf.Configuration;

public class HdfsServiceConfiguration {

    private Configuration hdfsConfiguration;
    private String hdfsDir;

    public HdfsServiceConfiguration(Configuration hdfsConfiguration, String hdfsDir) {
        this.hdfsConfiguration = hdfsConfiguration;
        this.hdfsDir = hdfsDir;
    }

    public Configuration getHdfsConfiguration() {
        return hdfsConfiguration;
    }

    public String getHdfsDir() {
        return hdfsDir;
    }
}
