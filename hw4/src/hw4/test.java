package hw4;
import java.util.Scanner; 

public class test {

	public static void main(String[] args) {
		
		String temp="";
		String temp1="你會不會";
		String temp2="你能不能";
		String temp3="你會";
		String temp4="你能";
		String temp5="?";
		String temp6="嗎";
		String temp7="！";
		
		Scanner quiz = new Scanner(System.in);
		System.out.println("這是可以陪你聊程式！你可以問我一些問題");
		
		while(true) {
			System.out.print("你說：");
			temp = quiz.next();
			
			if(temp.equals("0")) {
				System.out.println("離開聊天程序");
				break;
			}
			
			String after=temp.replace(temp1,"我會");
			String after2=after.replace(temp2,"我能");
			String after3=after2.replace(temp3,"我會");
			String after4=after3.replace(temp4,"我能");
			String after5=after4.replace(temp5,temp7);
			String after6=after5.replace(temp6,temp7);
			System.out.println(after6);
		}

	}

}
