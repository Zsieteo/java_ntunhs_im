package hw2;

import java.util.Scanner;

public class hw2_2 {

	public static void main(String[] args) {
		int result = (int)(Math.random()*100+1);								//��������(�d��0~99)
		int playerInput = -1;										//���a��J�Ȫ�l��(-1�קK�@�}�l�M�����ۦP)
		int minNumber = 0, maxNumber = 100;								//�̤j��,�̤p�Ȫ�l��
		
		while(playerInput != result) {									//�i�J�C���j��,�S�q�������}
			Scanner keyboardInput = new Scanner(System.in);						//�[�J���y��J����k
			
			do {											//�ϥΫ���հj��P�_��J�ȬO�_�ŦX�d��
				System.out.println("�п�J�Ʀr(�d��" + minNumber + "~" + maxNumber + "):");
				playerInput = Integer.parseInt(keyboardInput.nextLine());
			}while((playerInput < minNumber) || (playerInput > maxNumber));
			
			if(playerInput > result) {							        //�S�q���ɹ��J�d�򰵧��
				maxNumber = playerInput;
			} else if(playerInput < result) {
				minNumber = playerInput;
			}
			
		}
		
		System.out.println("You guessed it!");								//�q�����׮����}�j�骺����
		
	}

}