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
		JCheckBox b1 = new JCheckBox("物理英雄");
		b1.setSelected(true);
		b1.setBounds(50, 50, 130, 30);
		JCheckBox b2 = new JCheckBox("魔法 英雄");
		b2.setBounds(50, 100, 130, 30);

		// 按钮分组
		ButtonGroup bg = new ButtonGroup();
		// 把b1，b2放在 同一个 按钮分组对象里 ，这样同一时间，只有一个 按钮 会被选中
		bg.add(b1);
		bg.add(b2);

		f.add(b1);
		f.add(b2);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setVisible(true);

	}
}