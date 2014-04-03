package com.gopivotal.cf.samples.hadoop.model;

import org.springframework.hateoas.ResourceSupport;

import java.util.ArrayList;
import java.util.List;

public class HdfsPath extends ResourceSupport {

    private final String name;
    private final List<HdfsFile> files = new ArrayList<>();

    public HdfsPath(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<HdfsFile> getFiles() {
        return files;
    }

    public void addFile(HdfsFile file) {
        files.add(file);
    }
}
