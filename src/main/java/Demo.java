import base.utils.FilesUtils;

import java.io.IOException;

/**
 * @author JOHN
 * @createtime 2019/5/15
 **/
public class Demo {
    public static void main(String[] args) {
        try {
           // FilesUtils.batchMuiltDelete("lu","rar");
            FilesUtils.batchMove("p1","p2","100037");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
