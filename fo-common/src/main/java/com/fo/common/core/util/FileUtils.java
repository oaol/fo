package com.fo.common.core.util;

import java.io.File;

/**
 * 文件操作工具类
 * @author bryce
 *
 */
public class FileUtils {
    
    /**
     * 获取多级父目录
     * @param file
     * @param num
     * @return
     */
    public static File getNParent(File file, int num) {
        // TODO check
        File parentFile = file.getParentFile();
        num --;
        if (num == 0) {
            return parentFile;
        } else {
            return getNParent(parentFile, num);
        }
    }

    private FileUtils() {
    }
}
