package hw9;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Scanner;

public class hw9_2 {

	public static void main(String[] args) {
		
		int sum = 0;
		String line;
		boolean isLoop = true;
		Set<String> set = new HashSet<>();
		
		while(isLoop) {
			line = input("輸入號碼，為0退出");
			if(line.equals("0")) isLoop=false;
			else {
				set.add(line);
			}
		}
		System.out.println("數量有："+set.size());
		System.out.println(set);
	}
	static String input(String prompt) {
		System.out.println(prompt);
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();	
		return line;
	}
}
