package com.zx.fighter;

import java.awt.*;

/**
 * 运动物体的根类
 * 例如：飞机、子弹等
 */
public class GameObject {
    Image img;
    double x, y;
    int speed;
    int width, height;

    public void drawSelf(Graphics g){ //绘画函数
        g.drawImage(img, (int)x, (int)y, null);
    }

    //提取物体矩形，进行碰撞检测
    public Rectangle getRect(){  //返回物体矩形，进行碰撞检测
        return new Rectangle((int)x, (int)y, width, height);
    }

    public GameObject(Image img, double x, double y, int speed, int width, int height) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.width = width;
        this.height = height;
    }

    public GameObject(Image img, double x, double y) {
        this.img = img;
        this.x = x;
        this.y = y;
    }

    public GameObject() {
    }
}
