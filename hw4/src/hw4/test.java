package hw4;
import java.util.Scanner; 

public class test {

	public static void main(String[] args) {
		
		String temp="";
		String temp1="�A�|���|";
		String temp2="�A�ण��";
		String temp3="�A�|";
		String temp4="�A��";
		String temp5="?";
		String temp6="��";
		String temp7="�I";
		
		Scanner quiz = new Scanner(System.in);
		System.out.println("�o�O�i�H���A��{���I�A�i�H�ݧڤ@�ǰ��D");
		
		while(true) {
			System.out.print("�A���G");
			temp = quiz.next();
			
			if(temp.equals("0")) {
				System.out.println("���}��ѵ{��");
				break;
			}
			
			String after=temp.replace(temp1,"�ڷ|");
			String after2=after.replace(temp2,"�گ�");
			String after3=after2.replace(temp3,"�ڷ|");
			String after4=after3.replace(temp4,"�گ�");
			String after5=after4.replace(temp5,temp7);
			String after6=after5.replace(temp6,temp7);
			System.out.println(after6);
		}

	}

}
