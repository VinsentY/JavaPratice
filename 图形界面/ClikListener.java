package eleven;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ClikListener {

	public static void main(String[] args) {
		JFrame frame = new JFrame("LOL");
		frame.setSize(400, 300);
		frame.setLocation(580, 200);
		frame.setLayout(null);

		final JLabel lable = new JLabel();

		ImageIcon i = new ImageIcon("res/shana.png");
		lable.setIcon(i);
		lable.setBounds(50, 50, i.getIconWidth(), i.getIconHeight());

		// ����ť���Ӽ���

		JButton button = new JButton("����ͼƬ");
		button.setBounds(150, 200, 100, 30);

		button.addActionListener(new ActionListener() {

			boolean visible = true;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				visible = !visible;
				lable.setVisible(visible);
				button.setText(visible ? "����ͼƬ" : "��ʾͼƬ");
				
				//�������Ҫ��
				frame.requestFocus();
			}
		});
				
		// ���Ӽ��̼���
		frame.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				super.keyPressed(e);
				switch (e.getKeyCode()) {
				// ��
				case 38:
					lable.setLocation(lable.getX(), lable.getY() - 10);
					break;
				// ��
				case 39:
					lable.setLocation(lable.getX() + 10, lable.getY());
					break;
				// ��
				case 40:
					lable.setLocation(lable.getX(), lable.getY() + 10);
					break;
				// ��
				case 37:
					lable.setLocation(lable.getX() - 10, lable.getY());
					break;
				default:
					break;
				}

			}

		});

		frame.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				lable.setVisible(true);

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				lable.setVisible(false);

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		frame.add(lable);
		frame.add(button);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
		frame.requestFocus();
		

	}

}
