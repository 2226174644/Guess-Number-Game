
public class Client {
    String name;
    int scores;
   
	public void winscores(){
		scores++;
	}
	
	
	public static String greetings(int num){
		String str="你好,user "+num+"! 请输入名字:";
		return str;
	}
}
