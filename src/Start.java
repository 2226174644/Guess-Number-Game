import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class Start extends JFrame  implements ActionListener{
	private String nametxt;
	private JTextField Username;
	private JButton startButton,rankButton,closeButton;
	static int count=0;//用户人数
	static int num=0;//目前的用户编号
	static User[] users=new User[10];
	public Start() {
		super("猜数字");
		
		for(int i=0;i<10;i++) {
			users[i]=new User();
		}
		
		setBounds(500, 100, 410, 630);
		
		//id输入
		 nametxt = null;
		 Username= new JTextField(nametxt);
		 Username.setName("Username");
		 Username.setBorder(null);
		 Username.setBackground(Color.WHITE);
		 Username.setOpaque(false);
		
		//按钮
		 startButton = new JButton();
		 rankButton = new JButton();
		 closeButton = new JButton();
		 startButton.setBackground(Color.white);
		 startButton.setBorderPainted(false); //如果进度条应该绘制边框，则为 true；否则为 false
		 startButton.setBorder(null);
		 startButton.setOpaque(false);
		 startButton.addActionListener(this);
		 
		 rankButton.setBackground(Color.white);
		 rankButton.setBorderPainted(false); 
		 rankButton.setBorder(null);
		 rankButton.setOpaque(false);
		 rankButton.addActionListener(this);
		 
		 closeButton.setBackground(Color.white);
		 closeButton.setBorderPainted(false); 
		 closeButton.setBorder(null);
		 closeButton.setOpaque(false);
		 closeButton.addActionListener(this);

		//背景
		ImageIcon bg = new ImageIcon("img/background.png");
		JLabel label = new JLabel(bg);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel jp=(JPanel)this.getContentPane(); jp.setOpaque(false);
		
		//组件位置
		JPanel  panel=new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		startButton.setSize(180, 70);
		startButton.setLocation(115, 365);
		rankButton.setBounds(70, 475, 120, 40);
		closeButton.setBounds(228, 475, 120, 40);
		Username.setBounds(95, 300, 220, 35);
		panel.add(startButton);
		panel.add(rankButton);
		panel.add(closeButton);
		panel.add(Username);
		add(panel);
		

//		}
	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==startButton) {
			String user_name=Username.getText().trim();
			if("".equals(user_name)||user_name==null) {
				JOptionPane.showMessageDialog(null,"请输入用户名再进行游戏！","提示",1); //弹出警告窗口
				return;
			}
			boolean flag=false;
			
			for(int i=0;i<count;i++) {
				if(user_name.equals(users[i].getName())||user_name==users[i].getName()) {
					System.out.println(i+"the old id:"+users[i].getName());
					num=i;
					flag=true;
					}
			}
			if(flag==false) {
				users[count].setName(user_name);
				num=count;
				count++;
			}
			setVisible(false);
//        	run.frames[1].setVisible(true);
			 Game game=new Game();
			
		}
		
		if(e.getSource()==rankButton) {
			Rank rank=new Rank();
		}
		if(e.getSource()==closeButton){
       	System.exit(0);
        }
	}
}
