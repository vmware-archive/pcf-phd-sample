package com.gopivotal.cf.samples.hadoop.web;

import com.gopivotal.cf.samples.hadoop.connector.spring.HdfsServiceConfiguration;
import com.gopivotal.cf.samples.hadoop.model.HdfsFile;
import com.gopivotal.cf.samples.hadoop.model.HdfsPath;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.fs.FsShell;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Collection;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
public class HdfsController {

    @Autowired
    private HdfsServiceConfiguration configuration;

    private FsShell shell;

    @PostConstruct
    public void init() {
        shell = new FsShell(configuration.getHdfsConfiguration());
    }

    @RequestMapping(value = "/hdfs", method = RequestMethod.GET)
    public ResponseEntity<HdfsPath> ls(@RequestParam(value = "path", required = false) String fsPath) {
        if (fsPath == null) {
            fsPath = pathSuffix(configuration.getHdfsDir());
        }

        HdfsPath path = new HdfsPath(pathPrefix(configuration.getHdfsDir()) + Path.SEPARATOR + fsPath);

        path.add(linkTo(methodOn(HdfsController.class).ls(fsPath)).withSelfRel());
        path.add(linkTo(methodOn(HdfsController.class).ls(pathPrefix(path.getName()))).withRel("parent"));

        Collection<FileStatus> files = shell.ls(false, path.getName());

        for (FileStatus file : files) {
            if (file.isDirectory() && !file.getPath().getName().equals(pathSuffix(fsPath))) {
                path.add(linkTo(methodOn(HdfsController.class).ls(fsPath + Path.SEPARATOR + file.getPath().getName())).withRel("child"));
            } else if (file.isFile()) {
                path.addFile(new HdfsFile(file.getPath().getName(), file.getOwner(), file.getGroup(), file.getLen()));
            }
        }

        return new ResponseEntity<>(path, HttpStatus.OK);
    }

    private String pathSuffix(String path) {
        return path.substring(path.lastIndexOf(Path.SEPARATOR) + 1);
    }

    private String pathPrefix(String path) {
        return path.substring(0, path.lastIndexOf(Path.SEPARATOR));
    }

}
