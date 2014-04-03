package com.gopivotal.cf.samples.hadoop.model;

import org.springframework.hateoas.ResourceSupport;

public class HdfsFile extends ResourceSupport {

    private String name;
    private String owner;
    private String group;
    private long len;

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public String getGroup() {
        return group;
    }

    public long getLen() {
        return len;
    }

    public HdfsFile(String name, String owner, String group, long len) {
        this.name = name;
        this.owner = owner;
        this.group = group;
        this.len = len;
    }
}
