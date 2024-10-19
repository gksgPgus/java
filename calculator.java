package 한혜현;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
/**
 * 2024-09-15
 * 2024-09-19
 */
public class calculator extends JFrame{
	calculator(){
		setTitle("계산기");
		setSize(300, 450);
		setResizable(false);
		
		showNorth(); showSouth();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		}
	void showNorth() {
		JPanel p1=new JPanel();
		JTextField t=new JTextField("0");
		t.setEnabled(false);
		p1.add(t);
		add(p1);
	}
	
	void showSouth() { 
		String[] num= {"%", "CE", "C", "<×", 
				"1/x", "X^2", "2√x", "÷", 
				"7", "8", "9", "×", 
				"4", "5", "6", "-", 
				"1", "2", "3", "+", 
				"+/-", "0", ".", "="};
		JButton[] bt=new JButton[24];
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(6,4,3,3));
		
		for(int i=0; i<bt.length; i++) {
			bt[i]=new JButton(num[i]);
			p2.add(bt[i]);
		}
		add(p2, BorderLayout.SOUTH);
	}
	public static void main(String[] args) {
		new calculator();
	}

}
