package hw3;
import java.util.Scanner;

public class hw3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int idx=0;
		int num;
		System.out.print("Enter how many:");
		num=sc.nextInt();
		int arr[]=new int[num];
		
		for(int i=0; i<num; i++) {
			arr[i] = sc.nextInt();	
		}
		
		idx=num-1;	
		while(idx>=0) {
			System.out.print(arr[idx]);
			idx-=1;
			System.out.print(" ");
		}

	}

}
