package com.zx.fighter;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * 载入图片使用的工具类
 */

public class GameUtil {

    private GameUtil(){}  //私有化构造函数进行封装

    public static Image getImage(String path){
        BufferedImage bi = null;
        try{
            URL u = GameUtil.class.getClassLoader().getResource(path);
            bi = ImageIO.read(u);
        }catch (IOException e){
            e.printStackTrace();
        }

        return bi;
    }
}
