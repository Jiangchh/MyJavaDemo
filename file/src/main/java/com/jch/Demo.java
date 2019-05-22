package com.jch;

import com.jch.file.util.FilesUtils;

import java.io.IOException;

/**
 * @author JOHN
 * @createtime 2019/5/15
 **/
public class Demo {
    public static void main(String[] args) {
        try {
            FilesUtils.batchMuiltDelete("G:\\视频资料\\VIP专享\\2017期-前一期所有视频及资料","vep");
           // FilesUtils.batchMove("p1","p2","100037");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
