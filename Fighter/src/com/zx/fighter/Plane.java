package com.zx.fighter;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject{
    boolean left, up, right, down;
    boolean live = true;

    public void drawSelf(Graphics g){
        if (live){
            g.drawImage(img, (int)x, (int)y, null);

            if(left){
                x -= speed;
            }
            if(right){
                x += speed;
            }
            if(up){
                y -= speed;
            }
            if(down){
                y += speed;
            }
        }

    }

    public Plane(Image img, double x, double y){
        this.img = img;
        this.x = x;
        this.y = y;
        this.speed = 3;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
    }

    public void addDirecton(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                up = true;
                break;
            case KeyEvent.VK_A:
                left = true;
                break;
            case KeyEvent.VK_S:
                down = true;
                break;
            case KeyEvent.VK_D:
                right = true;
                break;
            default: break;
        }
    }

    public void minusDirecton(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                up = false;
                break;
            case KeyEvent.VK_A:
                left = false;
                break;
            case KeyEvent.VK_S:
                down = false;
                break;
            case KeyEvent.VK_D:
                right = false;
                break;
            default: break;
        }
    }
}
