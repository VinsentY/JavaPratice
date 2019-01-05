package five;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Layout {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Game");
		frame.setSize(400, 300);
		frame.setLocation(200, 200);
//		frame.setLayout(new FlowLayout());
//		frame.setLayout(new BorderLayout());
		frame.setLayout(new GridLayout(2, 3));
		
		JButton button1 = new JButton("Button1");
		JButton button2 = new JButton("Button2");
		JButton button3 = new JButton("Button3");
		JButton button4 = new JButton("Button4");
		JButton button5 = new JButton("Button5");
		JButton button6 = new JButton("Button6");
		
		frame.add(button1);
		frame.add(button2);
		frame.add(button3);
		frame.add(button4);
		frame.add(button5);
		frame.add(button6);
		
//		frame.add(button1,BorderLayout.NORTH);
//		frame.add(button2,BorderLayout.SOUTH);
//		frame.add(button3,BorderLayout.WEST);
//		frame.add(button4,BorderLayout.EAST);
//		frame.add(button5,BorderLayout.CENTER);
////		frame.add(button6, BorderLayout.NORTH);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
