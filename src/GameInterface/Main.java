package GameInterface;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class Main {
	public static void main(String[] args) {
		JFrame obj=new JFrame();
		GameStartPanel gameStartPanel = new GameStartPanel();
		
		obj.setBounds(10, 10, 800, 650);
		obj.setTitle("Game Tank 2D");	
		obj.setBackground(Color.gray);
		obj.setResizable(false);
		obj.setLocationRelativeTo(obj);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameStartPanel);	
		obj.setVisible(true);
		
		ImageIcon image = new ImageIcon("image\\logo.jpg");
		obj.setIconImage(image.getImage());
		
	}

}
