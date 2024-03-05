package hw2;

import java.util.Scanner;

public class hw2_2 {

	public static void main(String[] args) {
		int result = (int)(Math.random()*100+1);								//產生謎底(範圍0~99)
		int playerInput = -1;										//玩家輸入值初始化(-1避免一開始和謎底相同)
		int minNumber = 0, maxNumber = 100;								//最大值,最小值初始化
		
		while(playerInput != result) {									//進入遊戲迴圈,沒猜中不離開
			Scanner keyboardInput = new Scanner(System.in);						//加入掃描輸入的方法
			
			do {											//使用後測試迴圈判斷輸入值是否符合範圍
				System.out.println("請輸入數字(範圍" + minNumber + "~" + maxNumber + "):");
				playerInput = Integer.parseInt(keyboardInput.nextLine());
			}while((playerInput < minNumber) || (playerInput > maxNumber));
			
			if(playerInput > result) {							        //沒猜中時對輸入範圍做更動
				maxNumber = playerInput;
			} else if(playerInput < result) {
				minNumber = playerInput;
			}
			
		}
		
		System.out.println("You guessed it!");								//猜中答案時離開迴圈的提示
		
	}

}