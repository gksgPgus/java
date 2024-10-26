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
 * 2024-10-26
 */
public class calculator extends JFrame{
	calculator(){
		setTitle("계산기");
		setSize(300, 450);
		setResizable(false);
		showNorth();
		showSouth();
		
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
		setLayout(new BorderLayout());
		JPanel panel=new JPanel();
		JPanel panel1=new JPanel();
		JPanel panel2=new JPanel();
		JPanel panel3=new JPanel();
		
		JButton CE=new JButton("CE");
		JButton C=new JButton("C");
		JButton 지우기=new JButton("지우기");
		
		JButton[] bt=new JButton[12];

		JButton 나누기=new JButton("÷");
		JButton 곱하기=new JButton("×");
		JButton 빼기=new JButton("-");
		JButton 더하기=new JButton("+");
		
		for(int i=0; i<12; i++) {
			bt[i]=new JButton();
			if(i<3) bt[i].setText(Integer.toString(i+6));
			if(i>2&&i<6) bt[i].setText(Integer.toString(i));
			if(i>5&&i<9) bt[i].setText(Integer.toString(i-6));
		}
		bt[9].setText(".");
		bt[10].setText("0");
		bt[11].setText("=");
		
		panel.add(panel1, BorderLayout.NORTH);
		panel.add(panel2, BorderLayout.CENTER);
		panel.add(panel3, BorderLayout.EAST);
		add(panel);
		
		
//		String[][] num= {{"%", "CE", "C"}, 
//				{"1/x", "X^2", "2√x"}, 
//				{"7", "8", "9"}, 
//				{"4", "5", "6"}, 
//				{"1", "2", "3"}, 
//				{"+/-", "0", "."},
//				{"<×", "÷", "×"}, {"-", "+", "="}};
//		JButton[] bt=new JButton[24];
//		JPanel p2=new JPanel();
//		p2.setLayout(new GridLayout(6,4,3,3));
//		
//		for(int i=0; i<num.length; i++) {
//			for(int j=0; j<3; i++) {
//				bt[i]=new JButton(num[i][j]);
//				if(i==6||i==7) {
//					p2.add(bt[i],BorderLayout.EAST);
//				}
//				else {
//					
//				}
//			}
//		}
//		add(p2, BorderLayout.SOUTH);
		
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
