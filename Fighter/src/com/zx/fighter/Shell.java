package com.zx.fighter;

import java.awt.*;

/**
 * 炮弹类
 */
public class Shell extends GameObject{
    double degree;

    public Shell(){
        x = 100;
        y = 100;
        width = 10;
        height = 10;
        speed = 4;
        degree = Math.random() * Math.PI * 2;  //随机 0 - 2π 之间的随机角度
    }

    public void draw(Graphics g) {
        Color c = g.getColor();  //记录现有的颜色
        g.setColor(Color.yellow);  //炮弹颜色设置为黄色
        g.fillOval((int)x, (int)y, width, height);

        if(x < 10 | x > Constant.GAME_WIDTH - width - 10){  //遇到边界翻转角度
            degree = Math.PI - degree;
        }
        if(y < 35 | y > Constant.GAME_HEIGHT - height - 10){
            degree = -degree;
        }
        x += speed * Math.cos(degree);
        y += speed * Math.sin(degree);

        g.setColor(c); //返回之前记录的颜色
    }
}
