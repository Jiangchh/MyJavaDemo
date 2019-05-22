package com.jch;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;

/**
 * @author JOHN
 * @createtime 2019/5/20
 **/
public class WatchServiceDemo {
    public static void main(String[] args) throws IOException {
        WatchService watchService= FileSystems.getDefault().newWatchService();
        Path path= Paths.get(System.getProperty("user.dir"));
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        while (true){
            WatchKey watchKey=watchService.poll();
            if(watchKey!=null)
             watchKey.pollEvents().forEach(
                     (e)->{
                             System.out.println(e);
                     }
             );
        }
    }
}
