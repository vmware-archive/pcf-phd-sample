package com.gopivotal.cf.samples.hadoop.model;

public final class HdfsFile {

    private final String name;
    private final String owner;
    private final String group;
    private final long len;

    public HdfsFile(String name, String owner, String group, long len) {
        this.name = name;
        this.owner = owner;
        this.group = group;
        this.len = len;
    }

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
}
