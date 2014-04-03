package com.gopivotal.cf.samples.hadoop.connector.cloudfoundry;

import org.springframework.cloud.service.BaseServiceInfo;

public class HdfsServiceInfo extends BaseServiceInfo {

    private String hdfsUser;
    private String hdfsDir;
    private String hdfsNamenode;

    public HdfsServiceInfo(String id, String hdfsUser, String hdfsDir, String hdfsNamenode) {
        super(id);
        this.hdfsUser = hdfsUser;
        this.hdfsDir = hdfsDir;
        this.hdfsNamenode = hdfsNamenode;
    }

    @ServiceProperty
    public String getHdfsUser() {
        return hdfsUser;
    }

    @ServiceProperty
    public String getHdfsDir() {
        return hdfsDir;
    }

    @ServiceProperty
    public String getHdfsNamenode() {
        return hdfsNamenode;
    }

}
