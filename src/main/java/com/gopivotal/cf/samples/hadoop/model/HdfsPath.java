package com.gopivotal.cf.samples.hadoop.model;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

public class HdfsPath extends ResourceSupport {

    private String name;
    private List<HdfsFile> files = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<HdfsFile> getFiles() {
        return files;
    }

    public void addFile(HdfsFile file) {
        files.add(file);
    }
}
