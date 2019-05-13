package com.fo.test.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * test append image
 * 
 * @author bryce
 * @Date May 6, 2019
 */
public class ImageAppend {

    public static void main(String[] args) throws IOException {
        BufferedImage originalImage = ImageIO.read(new File("c:\\image\\mkyong.jpg"));
        int type = originalImage.getType() == 0? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
    }
    
}
