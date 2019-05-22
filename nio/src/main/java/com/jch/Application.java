package com.jch;

import com.jch.file.util.PrintUtil;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author JOHN
 * @createtime 2019/5/17
 **/
public class Application {
    public static void main(String[] args) {
       // Path userDir= Paths.get("");
        Paths.get("").getFileSystem().getFileStores().forEach(e->PrintUtil.println(e.type()));
        File userDir=new File("src/main");
        PrintUtil.println("用户工作相对目录"+userDir.getAbsolutePath());
        userDir=new File("/src/main");
        PrintUtil.println("用户工作根目录"+userDir.getAbsolutePath());

        PrintUtil.println("用户目录"+System.getProperty("user.home"));
        PrintUtil.println("用户工作目录"+System.getProperty("user.dir"));

    }
}
