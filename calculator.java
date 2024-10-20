package 한혜현;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * 2024-10-15
 * 2024-10-19
 * 2024-10-20
 */
public class calculator extends JFrame{
	calculator(){
		setTitle("계산기");
		setSize(300, 450);
		setResizable(false);
		
		JPanel p1=new JPanel();
		JTextField t=new JTextField("0");
		t.setEnabled(false);
		p1.add(t);
		add(p1);
		
		showSouth();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		}
	
	void showSouth() { 
		String[][] num= {{"%", "CE", "C"}, 
				{"1/x", "X^2", "2√x"}, 
				{"7", "8", "9"}, 
				{"4", "5", "6"}, 
				{"1", "2", "3"}, 
				{"+/-", "0", "."},
				{"<×", "÷", "×"}, {"-", "+", "="}};
		JButton[] bt=new JButton[24];
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(6,4,3,3));
		
		for(int i=0; i<num.length; i++) {
			for(int j=0; j<3; i++) {
				bt[i]=new JButton(num[i][j]);
				if(i==6||i==7) {
					p2.add(bt[i],BorderLayout.EAST);
				}
				else {
					
				}
			}
		}
		add(p2, BorderLayout.SOUTH);
		
//		ActionListener listener1=e->{
//			if(e.getSource()==num[2]||e.getSource()==num[3]||e.getSource()==num[4]) {
//				t.getText("");
//			}
//		};
	}
	public static void main(String[] args) {
		new calculator();
	}

}
