package hw3;
import java.util.Scanner;

public class hw3_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx=0;
		int num;
		System.out.println("Enter how many:");
		num=sc.nextInt();
		int arr[]=new int[num];
		System.out.printf("Enter numbers(%d):\n",num);
		
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();	
		}
		
		idx=num-1;	
		System.out.print("Answer¡G\n");
		
		while(idx>=0) {		
			System.out.print(arr[idx]);
			idx-=1;
			System.out.print(" ");
		}

	}

}
