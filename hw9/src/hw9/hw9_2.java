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
			line = input("��J���X�A��0�h�X");
			if(line.equals("0")) isLoop=false;
			else {
				set.add(line);
			}
		}
		System.out.println("�ƶq���G"+set.size());
		System.out.println(set);
	}
	static String input(String prompt) {
		System.out.println(prompt);
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();	
		return line;
	}
}
