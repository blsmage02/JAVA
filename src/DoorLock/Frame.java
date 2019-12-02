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

			if(btns[i].equals('*')) {		//*입력시 비밀번호 비교
				btns[i].addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {

						ComparedKeypad();
						
					}

				});
			} else if(btns[i].equals('#')) {	//#입력시 비밀번호 설정 if 값이 있을시 기존번호 입력 후 
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
		frame.setTitle("도어락");
		frame.setVisible(true);
		frame.setSize(440, 600/12*9);
		frame.setResizable(false);						//사이즈 고정
		frame.setLocationRelativeTo(null);				//실행시 Frame 위치 센터
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//X버튼 클릭시 프로그램 영구 종료
	}
	
	//비밀번호 
	public String ComparedKeypad() {

		int count = 0;

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
