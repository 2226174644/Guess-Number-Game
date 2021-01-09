import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.*;

public class Rank extends JFrame{
	JTextArea d = new JTextArea();
	public Rank(){
		super("排行榜");

		setBounds(600, 100, 430, 660);
		setVisible(true);
		add(d);
		
		ImageIcon bg = new ImageIcon("img/bcg2.png");
		JLabel label = new JLabel(bg);
		label.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
		getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));
		JPanel jp=(JPanel)this.getContentPane(); jp.setOpaque(false);
		
    	d.setEditable(false);
		d.setOpaque(false);
		d.setLineWrap(true);
    	d.setFont(new Font("",0,25));
    	d.setText(printRank());
    	
	}
	
	public User[] rank(){
		User[] cli=new User[Start.count];
		for(int i=0;i<cli.length;i++)
		    cli[i]=Start.users[i];
		for(int i=0;i<Start.count;i++){
			User temp=cli[i];
			int n=i;
			for(int j=i+1;j<Start.count;j++){
				if(cli[j].getScore()>temp.getScore()){
					temp=cli[j];
				    n=j;
				}
			}
		    cli[n]=cli[i];
		    cli[i]=temp;
		}
		
		return cli;
	}
	
	public String printRank(){
		User[] cli=rank();
		String str="\n    Rank            Name            Scores\n\n";

		if(Start.users[0].getName()==" ") {str+="                         暂无";}
		else{for(int i=0;i<Start.count;i++)
		    str+="     "+(i+1)+"                 "+cli[i].getName()+"                 "+cli[i].getScore()+"\n\n";}
		return str;
	}
}
