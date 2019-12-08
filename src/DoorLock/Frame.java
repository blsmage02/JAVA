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
					else {
						DoorLock.Pass2 = "";
						label.setText("�Է��Ͻ� ��й�ȣ�� ����� ��ȣ�̹Ƿ� �ٽ� �������ּ���.");
					}
				}
				passwordtext.setText(""); 
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
		int b=3;
		for(int i = 0; i < DoorLock.myPassword.length; i++) {

			if(DoorLock.myPassword.length != DoorLock.inputPassword.length ) break;
			if(DoorLock.myPassword[i].equals(DoorLock.inputPassword [i])) count++;

		}

		for(int i = 0; i < DoorLock.inputPassword .length; i++) DoorLock.inputPassword[i] = "";  // �ʱ�ȭ
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
			new newWindow();
			try {
			      Thread.sleep(b * 10000);
			    } catch (InterruptedException e) { }
			
			
			return String.format("�߸��� ��ȣ�� �ԷµǾ����ϴ�."+DoorLock.num_count+"�� �����Ͽ����ϴ�.");			
		}
		

		return String.format("�߸��� ��ȣ�� �ԷµǾ����ϴ�."+DoorLock.num_count+"�� �����Ͽ����ϴ�.");		

	}

	public String CipheredKeypad() {								//#��ư �޼ҵ�

		if(doorBoolean == false) return String.format("�����ġ ���� �� �õ����ּ���.");

		else {
		for(int i = 0; i < DoorLock.inputPassword .length; i++) DoorLock.inputPassword[i] = "";
		DoorLock.Pass = "";
		DoorLock.Pass1 = "";
		DoorLock.Pass2 = "";
		}
		return String.format("���ο� ��й�ȣ�� ����Ǿ����ϴ�.");

	}
	public Boolean CheckPassword() {

		String a = "";
		String temp = String.join(a, DoorLock.Pass2);
		String[] shelter = temp.split("");
		int[] temp2 = new int[DoorLock.Pass2.length()];
		boolean run = true;
		int count = 0;
		
		for(int i = 0; i < temp2.length; i++) {
			try {
				temp2[i] = Integer.parseInt(shelter[i]);
			} catch (NumberFormatException nfe) {
				//NOTE: write something here if you need to recover from formatting errors
			}
		}

		//4�̻� 8������ �ڸ��� Ȯ��
		if(temp2.length < 4 || temp2.length > 8) return false;

		//�ߺ��� ���� 3ȸ �̻� Ȯ��
		for(int i = 0; i < temp2.length - 2; i++) {
			if(temp2[i] == temp2[i+1] && temp2[i] == temp2[i+2]) return false;
		}

		//���� Ȯ��
		if(run) {
			//1�� ����ϰų� 1�� �����ϴ� ���� Ȯ��
			for(int i = 0; i < temp2.length - 3; i++) {
				if(temp2[i] == temp2[i] && temp2[i+1] == temp2[i]+1 && temp2[i+2] == temp2[i]+2) run = false;
				else if(temp2[i+1] == temp2[i+1] && temp2[i+2] == temp2[i+1]+1 && temp2[i+3] == temp2[i+1]+2) run = false;
				else if(temp2[i] == temp2[i] && temp2[i+1] == temp2[i]-1 &&temp2[i+2] == temp2[i]-2) run = false;
				else if(temp2[i+1] == temp2[i+1] && temp2[i+2] == temp2[i+1]-1 && temp2[i+3] == temp2[i+1]-2) run = false;
			}
			//+2ĭ ���� ���� Ȯ�� ex)3434
			for(int i = 0; i < temp2.length; i++) {
				for(int j = 0; j < temp2.length - 2; j++) {
					if(temp2[j] == temp2[j] && temp2[j] == temp2[j+2]) count++;
				}
			}
			
			if(count >= 2) run = false;
			return run;
		}

		return true;
	}
}

class newWindow extends JFrame {
    newWindow() {
        setTitle("30�� �ڿ� �ٽ� �õ����ּ���.");
        
        JPanel NewWindowContainer = new JPanel();
        setContentPane(NewWindowContainer);
        
        JLabel NewLabel = new JLabel("â�� �ݰ� �ٽ� �õ��� �ּ���");
        
        NewWindowContainer.add(NewLabel);
        setLocationRelativeTo(null);
        setSize(440, 440);
        setResizable(false);
        setVisible(true);
    }
}