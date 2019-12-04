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
		frame.setTitle("도어락");
		frame.setVisible(true);
		frame.setSize(440, 600/12*9);
		frame.setResizable(true);											//사이즈 고정false
		frame.setLocationRelativeTo(null);									//실행시 Frame 위치 센터
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);				//X버튼 클릭시 프로그램 영구 종료

		/*
		 * if(DoorLock.num_count == 3) { DoorLock.num_count = 0;
		 * 
		 * Timer time = new Timer(); TimerTask task = new TimerTask() {
		 * 
		 * @Override public void run() { label.setText("뒤에 다시 시도하세요.");
		 * 
		 * }
		 * 
		 * };
		 * 
		 * time.schedule(task, 5000);
		 * 
		 * }
		 */
		//타이머 미완성

		for(int i = 0; i < 12; i++) {
			if(i == 9) btnPanel.add(btnsT[0] = new JButton(btn_Title2[0]));
			else if(i == 11) btnPanel.add(btnsT[1] = new JButton(btn_Title2[1]));
			else {
				if(i == 10) btnPanel.add(btns[i-1] = new JButton(btn_Title[i-1]));
				else btnPanel.add(btns[i] = new JButton(btn_Title[i]));
			}
		}

		btnsT[0].addActionListener(new ActionListener() {					// *버튼 클릭시 일치 비교 

			@Override
			public void actionPerformed(ActionEvent e) {
				char [] pass = passwordtext.getPassword();

				for(char cha : pass)
				{
					Character.toString(cha);
					DoorLock.Pass += cha ; 									// Pass에 저장
				}

				DoorLock.inputPassword = DoorLock.Pass.split(""); 			//inputPassword 에 입력 비밀번호 저장 
				label.setText(ComparedKeypad());							//패널의 값 변경	
				passwordtext.setText("");
			}
		});

		btnsT[1].addActionListener(new ActionListener() { 						 // #버튼 클릭시 새로운 비밀번호 저장

			@Override
			public void actionPerformed(ActionEvent e) {

				char [] pass = passwordtext.getPassword();
				for(char cha : pass)
				{
					Character.toString(cha);
					DoorLock.Pass2 += cha ; // Pass1에 저장
				}

				if(doorBoolean == true) {
					if(CheckPassword() == true) {
						DoorLock.myPassword = DoorLock.Pass2.split("");
						label.setText(CipheredKeypad());
					}
					else label.setText("입력하신 비밀번호는 취약한 암호이므로 다시 설정해주세요.");
				}
				passwordtext.setText(""); 											// 다시 리셋

			}
		});

		for(int i = 0; i < btns.length; i++) {     									//숫자 버튼 
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

	public String ComparedKeypad() {									//*버튼 메소드

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
			return String.format("잠금장치가 해제되었습니다.");
		}
		doorBoolean = false;

		DoorLock.num_count++;

		if(DoorLock.num_count == 3) {
			DoorLock.num_count = 0;
			return String.format("30초 뒤에 다시 시도해주세요.");			//임시방편
		}
		

		return String.format("잘못된 번호가 입력되었습니다.");		

	}

	public String CipheredKeypad() {								//#버튼 메소드

		if(doorBoolean == false) return String.format("잠금장치 해제 후 시도해주세요.");

		doorBoolean = true;

		for(int i = 0; i < DoorLock.inputPassword .length; i++) DoorLock.inputPassword[i] = "";
		DoorLock.Pass = "";
		DoorLock.Pass1 = "";
		DoorLock.Pass2 = "";
		return String.format("새로운 비밀번호가 저장되었습니다.");

	}
	public Boolean CheckPassword() {

		String a = "";
		String temp = String.join(a, DoorLock.Pass2);
		String[] shelter = temp.split("");
		Boolean run = true;
		int count = 0;

		if(temp.length() < 4 || temp.length() > 8) return false;						//4이상 8이하의 자릿수 확인	
		/* 
		String length = "\\d{4,8}";
		boolean result = Pattern.matches(length, temp);
		if(!(result)) return false;
		 */

		for(int i = 0; i < shelter.length; i++) {
			if(shelter[i].equals(shelter[i+1]) && shelter[i].equals(shelter[i+2])) {	//중복된 숫자 3회이상 불가능
				return false;
			} //else if 4-ㄹ
		}

		return true;
	}
}