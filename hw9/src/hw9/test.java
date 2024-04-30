package hw9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		int a;
		int average;
		int max=0;
		int min=0;
		for(int n=0;n<=0;n++) {
			a = sc.nextInt();
			list.add(a);
			if(a>max) {
				max = a;
			}else if(a<min){
				min = a;
			}
	
		}
		System.out.println("average=");
	}

}
