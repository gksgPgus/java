package 한혜현;

import java.awt.BorderLayout;
import java.awt.Color;
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
 * 2024-10-27
 */
public class calculator extends JFrame{
	JTextField t;
	calculator(){
		setTitle("계산기");
		setSize(300, 450);
		setResizable(false);
		setLayout(new BorderLayout());
		showNorth();
		showSouth();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		}
	
	void showNorth() {
		JPanel p1=new JPanel();
		t=new JTextField("0");
		t.setEnabled(false);
		p1.add(t);
		add(p1, BorderLayout.NORTH);
		}
	
	void showSouth() { 
		setLayout(new BorderLayout());
		JPanel panel=new JPanel();
		JPanel clear=new JPanel();
		JPanel num=new JPanel(new GridLayout(4,3));
		JPanel ope=new JPanel(new GridLayout(4,1));
		
		JButton per=new JButton("%");
		JButton C=new JButton("C");
		JButton 지우기=new JButton("<×");
		
		JButton[] bt=new JButton[12];

		JButton 나누기=new JButton("÷");
		JButton 곱하기=new JButton("×");
		JButton 빼기=new JButton("-");
		JButton 더하기=new JButton("+");
		
		for(int i=0; i<12; i++) {
			bt[i]=new JButton();
			if(i<3) bt[i].setText(Integer.toString(i+7));
			if(i>2&&i<6) bt[i].setText(Integer.toString(i+1));
			if(i>5&&i<9) bt[i].setText(Integer.toString(i-5));
		}
		bt[9].setText(".");
		bt[10].setText("0");
		bt[11].setText("=");
		
		clear.add(per);
		clear.add(C);
		clear.add(지우기);
		for(int i=0; i<12; i++) {
			num.add(bt[i]);
		}
		ope.add(나누기);
		ope.add(곱하기);
		ope.add(빼기);
		ope.add(더하기);
		
		panel.add(clear, BorderLayout.NORTH);
		panel.add(num, BorderLayout.CENTER);
		panel.add(ope, BorderLayout.EAST);
		add(panel, BorderLayout.CENTER);
		
		ActionListener listener1 = e ->{
			if (e.getSource()==per) {
				String s = t.getText();
                double n = Double.parseDouble(s);
                n=n/100;
                t.setText(Double.toString(n));
			}
			else if (e.getSource()==C) {
				t.getText().isEmpty();
			}
			else if (e.getSource()==지우기) {
				int l=t.getText().length();
				t.setText();
			}
			else if (e.getSource()==bt) {
				t.setText()
			}
		};
	}
	public static void main(String[] args) {
		new calculator();
	}

}
