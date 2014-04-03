package com.gopivotal.cf.samples.hadoop.connector.spring;

import com.gopivotal.cf.samples.hadoop.connector.cloudfoundry.HdfsServiceInfo;
import org.apache.hadoop.conf.Configuration;
import org.springframework.cloud.service.AbstractServiceConnectorCreator;
import org.springframework.cloud.service.ServiceConnectorConfig;

public class HdfsServiceConnectorCreator extends AbstractServiceConnectorCreator<HdfsServiceConfiguration, HdfsServiceInfo> {
    @Override
    public HdfsServiceConfiguration create(HdfsServiceInfo serviceInfo, ServiceConnectorConfig serviceConnectorConfig) {
        Configuration configuration = new Configuration(true);
        configuration.set("fs.default.name", serviceInfo.getHdfsNamenode());
        configuration.set("hadoop.job.ugi", serviceInfo.getHdfsUser());

        return new HdfsServiceConfiguration(configuration, serviceInfo.getHdfsDir());
    }
}
