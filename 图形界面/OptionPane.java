package nine;


import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class OptionPane {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Game");
		frame.setSize(400, 300);
		frame.setLocation(580,240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
		
		int option = JOptionPane.showConfirmDialog(frame, "Have you ever loved someone deeply?");
		
		if (option == JOptionPane.OK_OPTION) {
			String answer = JOptionPane.showInputDialog(frame, "Can you tell me the name of that people?");
			if (answer.equals("you")) {
				JOptionPane.showMessageDialog(frame, "Please don't joking!");
			}
			
		}

		
	}

}
