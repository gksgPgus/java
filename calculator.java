package 한혜현;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
 * 2024-10-30
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
		
		int[] numb = {7,8,9,4,5,6,1,2,3};
		for(int i=0; i<numb.length; i++) {
			bt[i]=new JButton();
			bt[i].setText(Integer.toString(numb[i]));
			bt[i].addActionListener(this);
		}

		나누기.addActionListener(this);
		곱하기.addActionListener(this);
		빼기.addActionListener(this);
		더하기.addActionListener(this);
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
		
		sb.setLength(0);
	}
	
	StringBuilder sb = new StringBuilder();
	public void actionPerformed(ActionEvent event) {
		
		for(int j=0; j<9; j++) {
			if(event.getSource()==bt[j]) {
				sb.append(bt[j].getText());
				t.setText(sb.toString());
			}
		}
		if(event.getSource()==bt[9]) {
			sb.append(".");
			t.setText(sb.toString());
		}
		if(event.getSource()==bt[10]) {
			sb.append("0");
			t.setText(sb.toString());
		}
		if(event.getSource()==bt[11]) {
			
		}
		if(event.getSource()==더하기) {
			sb.append("+");
			t.setText(sb.toString());
		}
			
	}
	public static void main(String[] args) {
		new calculator();
	}
}