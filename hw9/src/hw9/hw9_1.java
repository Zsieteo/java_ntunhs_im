package hw9;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.List;
import java.util.Scanner;

public class hw9_1 {

	public static void main(String[] args) {
		
		int sum = 0;
		int line = 0;
		boolean isLoop = true;
		List<Integer> list = new ArrayList<>();
		
		while(isLoop) {
			line = input("輸入數字，輸入-1退出\n");
			if(line==-1) isLoop=false;
			else {
				list.add(line);
			}
		}
		Collections.sort(list);
		for(int n:list) sum+=n;
		
		System.out.println("min:"+list.get(0)+" max:"+list.get(list.size()-1)+" avg:"+sum/list.size());
		
	}
	static int input(String prompt) {
		System.out.print(prompt);
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt();	
		return line;
	}
}
