import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class run {
	static Start start=new Start();
//	static Game game=new Game();
//	static Rank rank=new Rank();
//	static JFrame[] frames = { start,game,rank};

	public static void main(String args[]) throws InterruptedException {
		//Start start=new Start();
		start.setVisible(true);
		start.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		for (int index = 0; index < frames.length; index++) {
//			frames[index].setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//			//frames[index].setPreferredSize(new Dimension(1000,900));
////            screencentre(frames[index]);
//
////			frames[index].pack();
//		}
//		frames[0].setVisible(true);

	}
    //使框架显示在屏幕中央
//	public static void screencentre(JFrame frame) {
//
//		Toolkit kit = Toolkit.getDefaultToolkit(); // 定义工具包
//
//		Dimension screenSize = kit.getScreenSize(); // 获取屏幕的尺寸
//
//		int screenWidth = screenSize.width; // 获取屏幕的宽
//
//		int screenHeight = screenSize.height; // 获取屏幕的高
//
//		
//		frame.setLocation(screenWidth/4, screenHeight/15);// 设置窗口居中显示
//	}
}
