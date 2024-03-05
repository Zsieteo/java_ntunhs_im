package hw2;
import java.util.Scanner;


public class hw2 {
	
	static String fever;
	static String cough;
	static String tired;
	static String highbool;
	static String dry;
	static String sweat;
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		System.out.println("觀迎使用醫療診斷系統，請依序回答問題");		
		System.out.println("============================");		
		System.out.println("請問您最近是否發燒(y/n)=>");		
		fever=sc.next();
		if(fever.toLowerCase().equals("y")) {
			
			System.out.println("請問您最近是否咳嗽(y/n)=>");
			cough=sc.next();
			if(cough.toLowerCase().equals("y")) {
				
				System.out.println("請問您最近是否感覺疲倦(y/n)=>");
				tired=sc.next();
				if(tired.toLowerCase().equals("y")) {
					System.out.println("先生/小姐您可能得感冒！！");
				}else {
					System.out.println("先生/小姐您可能得其他系統！！");
				}
				
			}else {
				System.out.println("請問您最近是否血壓升高(y/n)=>");
				highbool=sc.next();
				if(highbool.toLowerCase().equals("y")) {
					
					System.out.println("請問您最近是否口乾(y/n)=>");
					dry=sc.next();
					if(dry.toLowerCase().equals("y")) {
						System.out.println("先生/小姐您可能得肝病！！");
					}else {
						System.out.println("先生/小姐您可能得其他系統！！");
						
					}
				}else {
					System.out.println("請問您最近是否盜汗(y/n)=>");
					sweat=sc.next();
					if(sweat.toLowerCase().equals("y")) {
						System.out.println("先生/小姐您可能得肺病！！");
					}else {
						System.out.println("先生/小姐您可能得其他系統！！");
					}
				}
			}
		}else {
			System.out.println("先生/小姐您身體正常！！");
		}
		
	}			
}
