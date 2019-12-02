package DoorLock;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Frame {

	DoorLock doorLock = new DoorLock();

	public Frame() {
		final String[] btn_Title = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		final String[] btn_Title2 = { "*", "#"};
		JFrame frame = new JFrame();
		JLabel label = new JLabel("WELCOME");
		JPanel btnPanel = new JPanel();
		JPanel TextPanel = new JPanel();
		JButton[] btns = new JButton[10];
		JButton[] btnsT = new JButton[2];

		JPasswordField passwordtext = new JPasswordField(10);
		JTextField text2 = new JTextField(10);

		frame.setLayout(new BorderLayout());
		passwordtext.setEchoChar('*');

		frame.add(label, BorderLayout.NORTH);
		frame.add(TextPanel, BorderLayout.SOUTH);
		frame.add(btnPanel, BorderLayout.CENTER);


		for(int i = 0; i < 12; i++) {
			if(i == 9) btnPanel.add(btnsT[0] = new JButton(btn_Title2[0]));
			else if(i == 11) btnPanel.add(btnsT[1] = new JButton(btn_Title2[1]));
			else {
				if(i == 10) btnPanel.add(btns[i-1] = new JButton(btn_Title[i-1]));
				else btnPanel.add(btns[i] = new JButton(btn_Title[i]));
			}
		}


		btnsT[0].addActionListener(new ActionListener() {				// *버튼 클릭시 

			@Override
			public void actionPerformed(ActionEvent e) {
				label.setText(ComparedKeypad());						//패널의 값 변경	
			}
		});

		btnsT[1].addActionListener(new ActionListener() { 				// #버튼 클릭시

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}

		});


		for(int i = 0; i < btns.length; i++) { 
			btns[i].addActionListener(new ActionListener() {			// 숫자 클릭시

				@Override 
				public void actionPerformed(ActionEvent e) {

				}

			}); 
		}



		TextPanel.add(passwordtext);
		TextPanel.add(text2);
		btnPanel.setLayout(new GridLayout(4, 2));
		TextPanel.setLayout(new GridLayout(2, 1));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.setTitle("도어락");
		frame.setVisible(true);
		frame.setSize(440, 600/12*9);
		frame.setResizable(true);						//사이즈 고정false
		frame.setLocationRelativeTo(null);				//실행시 Frame 위치 센터
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//X버튼 클릭시 프로그램 영구 종료
	}

	//비밀번호 
	public String ComparedKeypad() {

		int count = 0;

		if((doorLock.myPassword[0] + doorLock.myPassword[1] + doorLock.myPassword[2]) == 0) {
			return String.format("비밀번호를 설정해주세요.");
		}

		for(int i = 0; i < doorLock.myPassword.length; i++) {
			if(doorLock.myPassword[i] == doorLock.inputPassword[i]) {
				count++;
			}
		}

		if(doorLock.myPassword.length == count) {
			return String.format("잠금장치가 해제되었습니다.");
		}

		return String.format("잘못된 번호가 입력되었습니다.");		

	}

	public void CipheredKeypad() {

	}



}
