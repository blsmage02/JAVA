package DoorLock;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame {
	
	DoorLock doorLock = new DoorLock();
	
	public Frame() {
		final String[] btn_Title = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "*", "0", "#" };
		JFrame frame = new JFrame();
		JLabel label = new JLabel("WELCOME");
		JPanel btnPanel = new JPanel();
		JButton[] btns = new JButton[12];


		frame.setLayout(new BorderLayout());


		frame.add(label, BorderLayout.NORTH);
		frame.add(btnPanel, BorderLayout.CENTER);

		for(int i = 0; i < btns.length; i++) {
			btnPanel.add(btns[i] = new JButton(btn_Title[i]));
		}

		for(int i = 0; i < btns.length; i++) {

			if(btns[i].equals('*')) {		//*�Է½� ��й�ȣ ��
				btns[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						ComparedKeypad();
						
					}

				});
			} else if(btns[i].equals('#')) {	//#�Է½� ��й�ȣ ���� if ���� ������ ������ȣ �Է� �� 
				btns[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {


					}

				});
			}

			btns[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					
					
				}

			});
		}
		
		btnPanel.setLayout(new GridLayout(5, 1));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.setTitle("�����");
		frame.setVisible(true);
		frame.setSize(440, 600/12*9);
		frame.setResizable(false);						//������ ����
		frame.setLocationRelativeTo(null);				//����� Frame ��ġ ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//X��ư Ŭ���� ���α׷� ���� ����
	}
	
	//��й�ȣ 
	public String ComparedKeypad() {

		int count = 0;

		for(int i = 0; i < doorLock.myPassword.length; i++) {
			if(doorLock.myPassword[i] == doorLock.inputPassword[i]) {
				count++;
			}
		}

		if(doorLock.myPassword.length == count) {
			return String.format("�����ġ�� �����Ǿ����ϴ�.");
		}

		return String.format("�߸��� ��ȣ�� �ԷµǾ����ϴ�.");		

	}
	
	public void CipheredKeypad() {

	}

}
