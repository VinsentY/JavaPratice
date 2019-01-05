package eight;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGUI {

	static class Point {
		int x;
		int y;
		
		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
		
	}
	
	public static void main(String[] args) {
		// Ö÷´°Ìå
		JFrame frame = new JFrame();
		frame.setSize(400,300);
		frame.setLayout(null);
		Point point = getPointFromLocationFile();
		if (point != null) {
			frame.setLocation(point.x,point.y);
		} else {
			frame.setLocation(200,200);
		}
		
		
		
		JButton button = new JButton("LOVE OR DEATH");
		button.setBounds(50, 50, 280, 30);
		
		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		new SavingPositionThread(frame).start();
		
	}
	
	public static Point getPointFromLocationFile() {
		
		File file = new File("location.txt");
		
		Point point = null;
		
		try(FileInputStream fis = new FileInputStream(file)) {
			DataInputStream dis = new DataInputStream(fis);
			
			int x = dis.readInt();
			int y = dis.readInt();
			
			point = new Point(x, y);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return point;
		
	}
   
}

