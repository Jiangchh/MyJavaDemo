package base.visitor;

import base.utils.FilesUtils;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author JOHN
 * @createtime 2019/5/15
 **/
public class MyVisitor extends SimpleFileVisitor<Path> {
    private String target;
    private String startwith;
    public MyVisitor(String target,String startwith){
        this.target=target;
        this.startwith=startwith;
    }
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(file.toFile().isFile()&&file.toFile().getName().startsWith(startwith)){
            //要移动文件，必须为新的路径添加名字
            String newtarget=target+"/"+file.getFileName();
            FilesUtils.move(file, newtarget);
        }
        return FileVisitResult.CONTINUE;
    }
}
