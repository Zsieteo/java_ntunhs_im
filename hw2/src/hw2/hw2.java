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
		
		System.out.println("�[��ϥ������E�_�t�ΡA�Ш̧Ǧ^�����D");		
		System.out.println("============================");		
		System.out.println("�аݱz�̪�O�_�o�N(y/n)=>");		
		fever=sc.next();
		if(fever.toLowerCase().equals("y")) {
			
			System.out.println("�аݱz�̪�O�_�y��(y/n)=>");
			cough=sc.next();
			if(cough.toLowerCase().equals("y")) {
				
				System.out.println("�аݱz�̪�O�_�Pı�h��(y/n)=>");
				tired=sc.next();
				if(tired.toLowerCase().equals("y")) {
					System.out.println("����/�p�j�z�i��o�P�_�I�I");
				}else {
					System.out.println("����/�p�j�z�i��o��L�t�ΡI�I");
				}
				
			}else {
				System.out.println("�аݱz�̪�O�_�����ɰ�(y/n)=>");
				highbool=sc.next();
				if(highbool.toLowerCase().equals("y")) {
					
					System.out.println("�аݱz�̪�O�_�f��(y/n)=>");
					dry=sc.next();
					if(dry.toLowerCase().equals("y")) {
						System.out.println("����/�p�j�z�i��o�x�f�I�I");
					}else {
						System.out.println("����/�p�j�z�i��o��L�t�ΡI�I");
						
					}
				}else {
					System.out.println("�аݱz�̪�O�_�s��(y/n)=>");
					sweat=sc.next();
					if(sweat.toLowerCase().equals("y")) {
						System.out.println("����/�p�j�z�i��o�ͯf�I�I");
					}else {
						System.out.println("����/�p�j�z�i��o��L�t�ΡI�I");
					}
				}
			}
		}else {
			System.out.println("����/�p�j�z���饿�`�I�I");
		}
		
	}			
}
