import java.awt.*;
import javax.swing.*;

public class BallGame extends JFrame{
	
	Image ball = Toolkit.getDefaultToolkit().getImage("images/ball.png"); //读入图片
	Image desk = Toolkit.getDefaultToolkit().getImage("images/desk.jpg");
	
	double x = 100; //球横坐标
	double y = 100; //球纵坐标
	double degree = 3.14/3; //角度，弧度表示，默认60度
	
	public void paint(Graphics g) {
		System.out.println("Draw window once"); //测试输出
		g.drawImage(desk, 0, 0, null);
		g.drawImage(ball, (int)x, (int)y, null);
		
		x = x + 10 * Math.cos(degree);
		y = y + 10 * Math.sin(degree);
		
		if(y > 500-40-30 || y < 40 + 30) { //500为桌子宽度，40为桌子边缘宽度，30为球直径
			degree = -degree;
		}
		
		if(x < 40 || x > 856 - 40 - 30) {
			degree = 3.14 - degree;
		}
	}
	
	void launchFrame() {
		setSize(856, 500); //设置窗口大小
		setLocation(50, 50); //设置窗口出现位置
		setVisible(true); //设置窗口可见
		
		while(true) { //每秒20此重绘图片来形成动画效果
			repaint();
			try { //异常抛出机制
				Thread.sleep(40); //设置刷新窗口时间
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		BallGame game = new BallGame();
		game.launchFrame();
	}
}
