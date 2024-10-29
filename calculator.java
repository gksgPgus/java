package 한혜현;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
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
 * 2024-10-28
 * 2024-10-29
 */
public class calculator extends JFrame implements ActionListener{
	JTextField t;
	calculator(){
			setTitle("계산기");
			setSize(300, 450);
			setResizable(false);
			Container c=getContentPane();
			BoxLayout layout=new BoxLayout(c, BoxLayout.Y_AXIS);
			c.setLayout(layout);
			showNorth();
			showSouth();
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
	}
	void showNorth(){
		Container c=getContentPane();
		BoxLayout layout=new BoxLayout(c, BoxLayout.Y_AXIS);
		c.setLayout(layout);
		t=new JTextField();
		c.add(t);
	}
		
	JButton[] bt=new JButton[12];
	JButton 나누기=new JButton("÷");
	JButton 곱하기=new JButton("×");
	JButton 빼기=new JButton("-");
	JButton 더하기=new JButton("+");
	
	void showSouth() {
		Container c=getContentPane();
		BoxLayout layout=new BoxLayout(c, BoxLayout.Y_AXIS);
		c.setLayout(layout);
		JPanel clear=new JPanel(new GridLayout(1,3));
		JPanel panel=new JPanel(new GridLayout(1,2));
		c.add(clear);
		c.add(panel);
		JButton per=new JButton("%");
		JButton C=new JButton("C");
		JButton 지우기=new JButton("<×");
		clear.add(per);
		clear.add(C);
		clear.add(지우기);
		
		JPanel num=new JPanel(new GridLayout(4,3));
		JPanel ope=new JPanel(new GridLayout(4,1));
		
		panel.add(num);
		panel.add(ope);
		
		
		for(int i=0; i<12; i++) {
			bt[i]=new JButton();
			if(i<3) bt[i].setText(Integer.toString(i+7));
			if(i>2&&i<6) bt[i].setText(Integer.toString(i+1));
			if(i>5&&i<9) bt[i].setText(Integer.toString(i-5));
			bt[i].addActionListener(this);
		}
		bt[9].setText(".");
		bt[10].setText("0");
		bt[11].setText("=");
		
		for(int i=0; i<12; i++) {
			num.add(bt[i]);
		}
		ope.add(나누기);
		ope.add(곱하기);
		ope.add(빼기);
		ope.add(더하기);
		
	}
	public void actionPerformed(ActionEvent event) {
		double[] num=new double[10];
		String numi;
		int i=0;
		String s=t.getText();
		for(int j=0; j<9; j++) {
			if(event.getSource()==bt[j]) {
				s=t.getText();
				if(j<3) t.setText(s+Integer.toString(j+7));
				if(j>2&&j<6) t.setText(s+Integer.toString(j+1));
				if(j>5&&j<9) t.setText(s+Integer.toString(j-5));
			}
		}
		if(event.getSource()==bt[9]) {
			t.setText(s+".");
		}
		if(event.getSource()==bt[10]) {
			t.setText(s+"0");
		}
		if(event.getSource()==bt[11]) {
			double sum=0;
			for(int j=0; j<num.length; j++) {
				sum=+num[j];
			}
			t.setText(String.valueOf(sum));
		}
		if(event.getSource()==나누기) {
			t.setText("");
		}
		if(event.getSource()==곱하기) {
			t.setText("");
		}
		if(event.getSource()==빼기) {
			t.setText("");
		}
		if(event.getSource()==더하기) {
			numi=t.getText();
			num[i]=Double.parseDouble(numi);
			i++;
			t.setText("");
		}
	}
	public static void main(String[] args) {
		new calculator();
	}
}