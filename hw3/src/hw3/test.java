package hw3;

import java.util.Arrays;

public class test {

	public static void main(String[] args) {
		
		int arr1[]=new int[] {3,1,5,6,9};
		int arr2[]=Arrays.copyOf(arr1,arr1.length-1);
		int arr3[]=Arrays.copyOfRange(arr1,0,arr1.length-1);
		
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		System.out.println(Arrays.toString(arr3));
		
	}
}
