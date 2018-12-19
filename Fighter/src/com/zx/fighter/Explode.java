package com.zx.fighter;

import java.awt.*;

/**
 * 爆炸类
 */
public class Explode {
    double x, y;
    static Image[] imgs = new Image[16];
    static { //静态初始化块
        for (int i = 0; i < 16; i++) {
            imgs[i] = GameUtil.getImage("images/explode/e" + (i + 1) + ".gif");
            imgs[i].getWidth(null);
        }
    }
    int count = 0;

    public void draw(Graphics g){  //轮播16张图片，形成爆炸效果
        if (count <= 15){
            g.drawImage(imgs[count], (int)x, (int)y, null);
            count++;
        }
    }

    public Explode(double x, double y){
        this.x = x;
        this.y = y;
    }
}
