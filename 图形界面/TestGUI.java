package four;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class TestGUI {
	public static void main(String[] args) {

		JFrame f = new JFrame("LoL");
		f.setSize(400, 300);
		f.setLocation(580, 240);
		f.setLayout(null);
		JCheckBox b1 = new JCheckBox("����Ӣ��");
		b1.setSelected(true);
		b1.setBounds(50, 50, 130, 30);
		JCheckBox b2 = new JCheckBox("ħ�� Ӣ��");
		b2.setBounds(50, 100, 130, 30);

		// ��ť����
		ButtonGroup bg = new ButtonGroup();
		// ��b1��b2���� ͬһ�� ��ť��������� ������ͬһʱ�䣬ֻ��һ�� ��ť �ᱻѡ��
		bg.add(b1);
		bg.add(b2);

		f.add(b1);
		f.add(b2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);

	}
}