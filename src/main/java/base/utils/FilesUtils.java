package base.utils;

import base.visitor.MyVisitor;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author JOHN
 * @createtime 2019/5/15
 **/
public class FilesUtils {
    /**
     * 复制文件
     * @param source
     * @param target
     */
    public static void copy(String source,String target) throws IOException {
        Path mysource= Paths.get(source);
        Path mytarget= Paths.get(target);
        Files.copy(mysource,mytarget, StandardCopyOption.REPLACE_EXISTING);
    }

    /**
     * 剪切文件
     * @param source
     * @param target
     */
    public static void move(String source,String target) throws IOException {
        Path mysource= Paths.get(source);
        Path mytarget= Paths.get(target);
        Files.copy(mysource,mytarget, StandardCopyOption.ATOMIC_MOVE);
    }  /**
     * 剪切文件
     * @param source
     * @param target
     */
    public static void move(Path source,String target) throws IOException {
        Path mytarget= Paths.get(target);
        Files.move(source,mytarget, StandardCopyOption.ATOMIC_MOVE);
    }

    /**
     * 批量剪切
     * @param path
     */
    public static void batchMove(String path,String target,String start) throws IOException {

        Files.walkFileTree(Paths.get(path), new MyVisitor(target,start));
    }

    /**
     * 批量删除以某个的文件,只能是一级目录
     * @param path
     * @param grep
     * @throws IOException
     */
    public static void batchDelete(String path,String grep) throws IOException {

        DirectoryStream<Path> rar = Files.newDirectoryStream(Paths.get(path),grep);
        rar.forEach(x->{
            System.err.println(x.getFileName());
            try {
                Files.deleteIfExists(x);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
    /**
     * 批量删除以某个结尾的文件
     * @param path
     * @param endwith
     * @throws IOException
     */
    public static void batchMuiltDelete(String path,String endwith) throws IOException {
        Files.walkFileTree(Paths.get(path), new MyVisitor2(endwith));
    }
    public static class MyVisitor2 extends SimpleFileVisitor<Path> {
        private String endwith;
        public MyVisitor2(String endwith){
            this.endwith=endwith;
        }
        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            FileSystem fs = file.getFileSystem();
            final PathMatcher matcher = fs.getPathMatcher("glob:" + endwith);
            if(file.toFile().isFile()&&file.toFile().getName().endsWith(endwith)){
                System.err.println(file);
                Files.deleteIfExists(file);
            }
            return FileVisitResult.CONTINUE;
        }
    }
}
