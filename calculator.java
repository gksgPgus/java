package 한혜현;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class calculator extends JFrame{
	calculator(){
		setTitle("계산기");
		setSize(300, 350);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		showNorth(); showSouth();
		
		setVisible(true);
		}
	void showNorth() {
		JPanel p1=new JPanel();
		JTextField t=new JTextField(10);
		t.setEnabled(false);
		p1.add(t);
		add(p1, BorderLayout.NORTH);
	}
	
	void showSouth() {
		String[] num= {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
		JPanel p2=new JPanel();
		setLayout(new GridLayout(0, 3));
		for(int i=0; i<num.length; i++) {
			p2.add(new JButton(num[i])); 
		}
		add(p2, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		new calculator();
	}

}
