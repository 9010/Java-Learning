package com.zx.fighter;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date; //注意一定要使用Util包下的Date类

public class MyGameFrame extends Frame {
    /*JFrame需要来自java.swing包，
    来自java.awt包的Frame需要解决屏幕闪烁问题，
    要用到双缓冲方法，JFrame也存在闪烁，需要额外解决，
    但在不做任何处理的情况下，效果要比Frame好*/

    //双缓冲方法
    private Image offScreenImage = null;
    public void update(Graphics g){
        if (offScreenImage == null){
            offScreenImage = this.createImage(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);
        }
        Graphics gOff = offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    Image plane = GameUtil.getImage("images/plane.png");
    Image bg = GameUtil.getImage("images/bg.jpg");

    Plane fighter = new Plane(plane, 300, 300);
    Shell[] shells = new Shell[25]; //生成25枚炮弹
    Explode explode; //爆炸对象

    Date startTime = new Date();
    Date endTime;
    int period;

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.drawImage(bg, 0, 0, null);
        fighter.drawSelf(g);

        for(int i = 0; i < shells.length; i++){ //画出所有炮弹
            shells[i].draw(g);

            boolean collision = shells[i].getRect().intersects(fighter.getRect());  //碰撞检测
            if (collision){
                fighter.live = false;  //如果碰撞，飞机死亡

                if (explode == null) {  //爆炸效果
                    explode = new Explode(fighter.x, fighter.y);

                    endTime = new Date();
                    period = (int)((endTime.getTime() - startTime.getTime()) / 1000); //开始到结束
                }
                explode.draw(g);
            }
            if (!fighter.live) { //飞机死亡，播放持续时间
                g.setColor(Color.RED); //设置颜色红色
                Font f = new Font("宋体", Font.BOLD, 50);  //设置字体
                g.setFont(f);
                g.drawString("时间：" + period + "秒", 120, 250);
            }
        }
        g.setColor(c);
    }

    /**
     * 实现动画效果
     */
    class PaintThread extends Thread{
        @Override
        public void run(){
            while(true){  //重画窗口
                repaint();

                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 键盘监听
     */
    class KeyMonitor extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            fighter.addDirecton(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            fighter.minusDirecton(e);
        }
    }

    /**
     * 初始化窗口
     */
    public void launchFrame(){
        this.setTitle("Fighter");  //设置窗口名称
        this.setVisible(true); //设置窗口可见（默认不可见）
        this.setSize(Constant.GAME_WIDTH, Constant.GAME_HEIGHT);  //设置窗口大小
        this.setLocation(700,300);  //设置窗口出现位置

        this.addWindowListener(new WindowAdapter() {  //未解释
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().start(); //启动动画效果的线程
        addKeyListener(new KeyMonitor());

        for(int i = 0; i < shells.length; i++){
            shells[i] = new Shell();
        }
    }

    public static void main(String[] args){
        MyGameFrame Frame = new MyGameFrame();
        Frame.launchFrame();
    }

}
