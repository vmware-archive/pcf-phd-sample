package com.gopivotal.cf.samples.hadoop.connector.cloudfoundry;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;

import java.util.Map;

public class HdfsServiceInfoCreator extends CloudFoundryServiceInfoCreator<HdfsServiceInfo> {

    public HdfsServiceInfoCreator() {
        super("hdfs");
    }

    @Override
    public HdfsServiceInfo createServiceInfo(Map<String, Object> serviceData) {
        Map<String, Object> credentials = (Map<String, Object>) serviceData.get("credentials");

        String id = (String) serviceData.get("name");
        String hdfsUser = (String) credentials.get("hdfs_user");
        String hdfsDir = (String) credentials.get("hdfs_dir");
        String hdfsNamenode = (String) credentials.get("hdfs_namenode");

        return new HdfsServiceInfo(id, hdfsUser, hdfsDir, hdfsNamenode);
    }

    @Override
    public boolean accept(Map<String, Object> serviceData) {
        String label = (String) serviceData.get("label");
        return label.startsWith("p-hd-hdfs-cf");
    }
}


