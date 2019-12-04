package DoorLock;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;


public class Frame {

	DoorLock doorLock = new DoorLock();
	boolean doorBoolean = false;

	public Frame() {

		final String[] btn_Title = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		final String[] btn_Title2 = { "*", "#"};
		JFrame frame = new JFrame();
		JLabel label = new JLabel("WELCOME");
		JPanel btnPanel = new JPanel();
		JPanel TextPanel = new JPanel();
		JButton[] btns = new JButton[10];
		JButton[] btnsT = new JButton[2];

		JPasswordField passwordtext = new JPasswordField("", 10);

		frame.setLayout(new BorderLayout());

		frame.add(label, BorderLayout.NORTH);
		frame.add(TextPanel, BorderLayout.SOUTH);
		frame.add(btnPanel, BorderLayout.CENTER);

		TextPanel.add(passwordtext);
		btnPanel.setLayout(new GridLayout(4, 2));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.setTitle("�����");
		frame.setVisible(true);
		frame.setSize(440, 600/12*9);
		frame.setResizable(true);											//������ ����false
		frame.setLocationRelativeTo(null);									//����� Frame ��ġ ����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//X��ư Ŭ���� ���α׷� ���� ����

		/*
		 * if(DoorLock.num_count == 3) { DoorLock.num_count = 0;
		 * 
		 * Timer time = new Timer(); TimerTask task = new TimerTask() {
		 * 
		 * @Override public void run() { label.setText("�ڿ� �ٽ� �õ��ϼ���.");
		 * 
		 * }
		 * 
		 * };
		 * 
		 * time.schedule(task, 5000);
		 * 
		 * }
		 */
		//Ÿ�̸� �̿ϼ�

		for(int i = 0; i < 12; i++) {
			if(i == 9) btnPanel.add(btnsT[0] = new JButton(btn_Title2[0]));
			else if(i == 11) btnPanel.add(btnsT[1] = new JButton(btn_Title2[1]));
			else {
				if(i == 10) btnPanel.add(btns[i-1] = new JButton(btn_Title[i-1]));
				else btnPanel.add(btns[i] = new JButton(btn_Title[i]));
			}
		}

		btnsT[0].addActionListener(new ActionListener() {					// *��ư Ŭ���� ��ġ �� 

			@Override
			public void actionPerformed(ActionEvent e) {
				char [] pass = passwordtext.getPassword();

				for(char cha : pass)
				{
					Character.toString(cha);
					DoorLock.Pass += cha ; 									// Pass�� ����
				}

				DoorLock.inputPassword = DoorLock.Pass.split(""); 			//inputPassword �� �Է� ��й�ȣ ���� 
				label.setText(ComparedKeypad());							//�г��� �� ����	
				passwordtext.setText("");
			}
		});

		btnsT[1].addActionListener(new ActionListener() { 						 // #��ư Ŭ���� ���ο� ��й�ȣ ����

			@Override
			public void actionPerformed(ActionEvent e) {

				char [] pass = passwordtext.getPassword();
				for(char cha : pass)
				{
					Character.toString(cha);
					DoorLock.Pass2 += cha ; // Pass1�� ����
				}

				if(doorBoolean == true) {
					if(CheckPassword() == true) {
						DoorLock.myPassword = DoorLock.Pass2.split("");
						label.setText(CipheredKeypad());
					}
					else label.setText("�Է��Ͻ� ��й�ȣ�� ����� ��ȣ�̹Ƿ� �ٽ� �������ּ���.");
				}
				passwordtext.setText(""); 											// �ٽ� ����

			}
		});

		for(int i = 0; i < btns.length; i++) {     									//���� ��ư 
			btns[i].addActionListener(new ActionListener() {

				@SuppressWarnings("deprecation")
				@Override
				public void actionPerformed(ActionEvent e) {
					JButton pushButton = (JButton)e.getSource();
					String temp = pushButton.getText();

					passwordtext.setText(passwordtext.getText() + temp + "");

				}
			});
		}
	}

	public String ComparedKeypad() {									//*��ư �޼ҵ�

		int count = 0;

		for(int i = 0; i < DoorLock.myPassword.length; i++) {

			if(DoorLock.myPassword.length != DoorLock.inputPassword.length ) break;
			if(DoorLock.myPassword[i].equals(DoorLock.inputPassword [i])) count++;

		}

		for(int i = 0; i < DoorLock.inputPassword .length; i++) DoorLock.inputPassword[i] = "";
		DoorLock.Pass = "";
		DoorLock.Pass1 = "";
		DoorLock.Pass2 = "";
		if(DoorLock.myPassword.length == count) {
			doorBoolean = true;
			return String.format("�����ġ�� �����Ǿ����ϴ�.");
		}
		doorBoolean = false;

		DoorLock.num_count++;

		if(DoorLock.num_count == 3) {
			DoorLock.num_count = 0;
			return String.format("30�� �ڿ� �ٽ� �õ����ּ���.");			//�ӽù���
		}
		

		return String.format("�߸��� ��ȣ�� �ԷµǾ����ϴ�.");		

	}

	public String CipheredKeypad() {								//#��ư �޼ҵ�

		if(doorBoolean == false) return String.format("�����ġ ���� �� �õ����ּ���.");

		doorBoolean = true;

		for(int i = 0; i < DoorLock.inputPassword .length; i++) DoorLock.inputPassword[i] = "";
		DoorLock.Pass = "";
		DoorLock.Pass1 = "";
		DoorLock.Pass2 = "";
		return String.format("���ο� ��й�ȣ�� ����Ǿ����ϴ�.");

	}
	public Boolean CheckPassword() {

		String a = "";
		String temp = String.join(a, DoorLock.Pass2);
		String[] shelter = temp.split("");
		Boolean run = true;
		int count = 0;

		if(temp.length() < 4 || temp.length() > 8) return false;						//4�̻� 8������ �ڸ��� Ȯ��	
		/* 
		String length = "\\d{4,8}";
		boolean result = Pattern.matches(length, temp);
		if(!(result)) return false;
		 */

		for(int i = 0; i < shelter.length; i++) {
			if(shelter[i].equals(shelter[i+1]) && shelter[i].equals(shelter[i+2])) {	//�ߺ��� ���� 3ȸ�̻� �Ұ���
				return false;
			} //else if 4-��
		}

		return true;
	}
}