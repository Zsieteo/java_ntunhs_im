package hw11;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class hw11_3 {

	static TicTacToe game = new TicTacToe();
	static JButton[][] buttons = new JButton[3][3];
	static JLabel statusLabel;
	
	public static void main(String[] args) {
		JFrame demo = new JFrame();
		JButton[][] buttons = new JButton[3][3];
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setSize(300,300);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		demo.add(panel,BorderLayout.CENTER);
		
		statusLabel = new JLabel("Player"+game.getCurrentPlayer()+"'s turn");
		demo.add(statusLabel,BorderLayout.SOUTH);
	
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setFont(new Font("Arial",Font.BOLD,40));
				final int row = i;
				final int col = j;
				buttons[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if(game.makeMove(row,col)) {
							buttons[row][col].setText(String.valueOf(game.getCurrentPlayer()));
							if(game.hasWinner()) {
								statusLabel.setText("Player"+game.getCurrentPlayer()+" wins");
							}else if(game.isBoardFull()) {
								statusLabel.setText("its a draw");
							}else {
								game.switchPlayer();
								statusLabel.setText("Player"+game.getCurrentPlayer()+"'s turn");
							}
						}
					}						
				});
				panel.add(buttons[i][j]);
			}
		}
		demo.setVisible(true);
	}

}

