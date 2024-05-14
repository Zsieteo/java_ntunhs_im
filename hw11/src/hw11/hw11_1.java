package hw11;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;

public class hw11_1 {

	public static void main(String[] args) {
		JFrame demo = new JFrame();
		JButton[][] buttons = new JButton[3][3];
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		demo.setSize(300,300);
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3,3));
		demo.add(panel,BorderLayout.CENTER);
		
		JLabel statusLabel = new JLabel("Player X's turn");
		demo.add(statusLabel,BorderLayout.SOUTH);
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setFont(new Font("Arial",Font.BOLD,40));
				panel.add(buttons[i][j]);
			}
		}
		demo.setVisible(true);
	}

}
