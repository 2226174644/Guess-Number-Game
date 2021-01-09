import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;




public class Game extends JFrame implements ActionListener{
	static int length = 4;
  
     
    private JTextField rnumArea;
    private JLabel text;
    private JTextField asw;
    private JButton enter;
    private JLabel sc;
    private JButton close,rule;
    private JTextField scoreArea;
    JButton buttons[] = {new JButton("返回"),new JButton("换一个数"),new JButton("查看排名")};
    Guess one = new Guess(length);
    int[] rnum = new int[length];//rnum 随机数
    
    public Game(){
    	setBounds(500, 100, 400, 600);
    	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    	setVisible(true);
    	
    	//首栏菜单
    	JPanel menu =new JPanel();
    	menu.setLayout(new FlowLayout());
    	for (int index = 0; index < buttons.length; index++)
			{menu.add(buttons[index]);}
		add(menu, BorderLayout.NORTH);
		for (int index = 0; index < buttons.length; index++)
			buttons[index].addActionListener(new ActLis());
		
		JPanel panel=new JPanel();
		panel.setOpaque(false);
		panel.setLayout(null);
		//欢迎
		JLabel welcome = new JLabel("猜数字");
		welcome.setFont(new Font("猜数字",Font.BOLD,20) );
		
		 text = new JLabel("你猜的数字");
		text.setFont(new Font("猜数字",Font.BOLD,15) );
		
		//作答区
		 asw=new JTextField();
		 
		 //确认
		 enter=new JButton("确认");
		 enter.addActionListener(this);
		 //积分
		 sc = new JLabel("积分");
		 sc.setFont(new Font("积分",Font.BOLD,20) );
		 scoreArea=new JTextField();
		 //退出
		 close=new JButton("退出");
		 close.addActionListener(this);
		//规则
		 rule=new JButton("规则");
		 rule.addActionListener(this);
		 
		welcome.setBounds(130, 0, 150, 30);
		
		welcome.setText("欢迎,"+Start.users[Start.num].getName()+"!");//+Start.users[Start.num].getName()+"!"
		
		rnumArea=new JTextField();
		rnumArea.setBounds(45, 35, 300, 80);
		rnumArea.setFont(new Font("?",Font.BOLD,30));
		rnumArea.setHorizontalAlignment(JTextField.CENTER);
		rnumArea.setText("?");
		rnumArea.setEditable(false);
			
		text.setBounds(150, 120, 100, 30);
		
		asw.setBounds(45, 160, 300, 100);
		asw.setFont(new Font("?",Font.BOLD,40));
		asw.setHorizontalAlignment(JTextField.CENTER);
		//限制只能输入数字
				asw.addKeyListener(new KeyAdapter(){
					public void keyTyped(KeyEvent e) {
						int keyChar = e.getKeyChar();				
						if(keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
							
						}else{
							e.consume(); //关键，屏蔽掉非法输入
						}
					}
				});
			
		enter.setBounds(150, 270, 80, 40);
		
		sc.setBounds(170,320,50,30);
		
		scoreArea.setBounds(45, 355, 300, 80);
		scoreArea.setFont(new Font("?",Font.BOLD,30));
		scoreArea.setHorizontalAlignment(JTextField.CENTER);
		scoreArea.setText(Start.users[Start.num].getScore()+"");
		scoreArea.setEditable(false);
		
		close.setBounds(270,450, 60, 30);
		rule.setBounds(60,450,60,30);
		
		
		panel.add(welcome);
		panel.add(rnumArea);
		panel.add(text);
		panel.add(asw);
		panel.add(enter);
		panel.add(sc);
		panel.add(scoreArea);
		panel.add(close);
		panel.add(rule);
		add(panel);
		setVisible(true);
    
    	
    	
    	//users[count-1]=new Client();
    	process();
    }
    
    
    public  void process() {		
		rnum= one.rand(rnum);
		System.out.println(one.correct(rnum));
	}
  


    
    @Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if(e.getSource()==enter) {
			int[] gnum = new int[length];
			String gstr=asw.getText();
			if(gstr.length()!=4) {
				JOptionPane.showMessageDialog(null,"请输入4位数字！","提示",1);
				return;
			}
			gnum=one.guess(gstr,gnum);
			String str=one.compare(rnum,gnum,Start.users[Start.num]);
			rnumArea.setText(str);	
			int score=Start.users[Start.num].getScore();
			scoreArea.setText(score+"");
			if(str.equals("4A Correct!")) {
				process();
			}
		}
		if (e.getSource()==close) {
			this.dispose();
		}
		if(e.getSource()==rule) {
			JOptionPane.showMessageDialog(null,
					   "开始游戏后，产生一个没有重复数字的4位随机数，用户每猜一个数字，显示出“完全猜中的数字个数”和“猜中\n"
					+ "数字但位置错误的数字个数”，比如nAmB，数字n表示猜中的位置正确的数字个数，数字m表示数字正确而\n"
					+ "位置不对的数字个数。例如，正确答案为5234，如果猜5346，则显示：1A2B，数字1表示数字5及其位置猜对了，\n"
					+ "数字3和4这两个数字猜对了，但是位置没对，记为2B。然后，根据游戏提示的信息继续猜，直到猜中为止。","规则",1);
		}
		
}
    private class ActLis implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == buttons[0]) {

				run.start.setVisible(true);
				dispose();
			} else if (e.getSource() == buttons[1]) {
				rnumArea.setText("?");
				process();
			}
			 else if (e.getSource() == buttons[2]) {
				 Rank rank=new Rank();
				}
			
		}
	}
}
