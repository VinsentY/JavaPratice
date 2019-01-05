package ninty;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

public class OpenFile {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Game");
		frame.setLayout(new FlowLayout());
		
		JFileChooser fc = new JFileChooser();
		fc.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				return ".txt";
			}
			
			@Override
			public boolean accept(File arg0) {
				return frame.getName().toLowerCase().endsWith(".txt");
			}
		});
		
		JButton bOpen = new JButton("Open File");
		JButton bSave = new JButton("Save File");
		frame.add(bOpen);
		frame.add(bSave);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(250,150);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		bOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = fc.showOpenDialog(frame);
				File file = fc.getSelectedFile();
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(frame, "File Open:" + file.getAbsolutePath());
					
				}
			}
		});
		
		bSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = fc.showSaveDialog(frame);
				File file = fc.getSelectedFile();
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(frame, "File Save:" + file.getAbsolutePath());
					
				}
			}
		});
				
		
	}

}
