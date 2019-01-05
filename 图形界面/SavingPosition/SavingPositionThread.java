package eight;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFrame;

import javafx.scene.chart.PieChart.Data;

public class SavingPositionThread extends Thread {
	
	private JFrame frame;
	
	File file = new File("location.txt");
	
	public SavingPositionThread(JFrame frame) {
		super();
		this.frame = frame;
	}

	public void run() {
		while(true) {
			int x = frame.getX();
			int y = frame.getY();
			
			try (FileOutputStream fos = new FileOutputStream(file)) {
				DataOutputStream dos = new DataOutputStream(fos);
				
				dos.writeInt(x);
				dos.writeInt(y);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
