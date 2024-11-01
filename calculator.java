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
 * 2024-10-15: 최초생성
 * 2024-10-19
 * 2024-10-20
 * 2024-10-26
 * 2024-10-27
 * 2024-10-28
 * 2024-10-29
 * 2024-10-30
 * 2024-10-31
 * 2024-11-01
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
	JButton per=new JButton("%");
	JButton C=new JButton("C");
	JButton 지우기=new JButton("<×");
	void showSouth() {
		Container c=getContentPane();
		BoxLayout layout=new BoxLayout(c, BoxLayout.Y_AXIS);
		c.setLayout(layout);
		JPanel clear=new JPanel(new GridLayout(1,3));
		JPanel panel=new JPanel(new GridLayout(1,2));
		c.add(clear);
		c.add(panel);
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

		per.addActionListener(this);
		C.addActionListener(this);
		지우기.addActionListener(this);
		나누기.addActionListener(this);
		곱하기.addActionListener(this);
		빼기.addActionListener(this);
		더하기.addActionListener(this);
		for(int i=9; i<=11; i++) {
			bt[i]=new JButton();
		}
		bt[9].setText(".");
		bt[10].setText("0");
		bt[11].setText("=");
		bt[9].addActionListener(this);
		bt[10].addActionListener(this);
		bt[11].addActionListener(this);
		
		for(int i=0; i<12; i++) {
			num.add(bt[i]);
		}
		ope.add(나누기);
		ope.add(곱하기);
		ope.add(빼기);
		ope.add(더하기);
		
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
		if(event.getSource()==나누기) {
			sb.append("÷");
			t.setText(sb.toString());
		}
		if(event.getSource()==곱하기) {
			sb.append("×");
			t.setText(sb.toString());
		}
		if(event.getSource()==빼기) {
			sb.append("-");
			t.setText(sb.toString());
		}
		if(event.getSource()==더하기) {
			sb.append("+");
			t.setText(sb.toString());
		}
		if(event.getSource()==지우기) {
			sb.delete(sb.length()-1,sb.length());
			t.setText(sb.toString());
		}
		if(event.getSource()==C) {
			sb.setLength(0);
			t.setText(sb.toString());
		}
		
		if(event.getSource()==bt[11]) {
			calc();
			sb.setLength(0);
		}
	}
	private void calc() {
		ArrayList<String> data = new ArrayList<String>();
		for(int i=0; i<sb.length(); i++) {
			data.add(i, sb.substring(i,i+1));
		}
		for(int i=1; i<data.size(); i=i+2) {
			if(data.get(i)=="*") {
				data.set(i-1, String.valueOf(Double.parseDouble(data.get(i-1))*Double.parseDouble(data.get(i+1))));
			}
			if(data.get(i)=="÷") {
				data.set(i-1, String.valueOf(Double.parseDouble(data.get(i-1))/Double.parseDouble(data.get(i+1))));
			}
		}
		for(int i=1; i<data.size(); i=i+2) {
			if("+".equals(data)) {
				data.set(i-1, String.valueOf(Double.parseDouble(data.get(i-1))+Double.parseDouble(data.get(i+1))));
				data.remove("+");
			}
			if(data.get(i)=="-") {
				data.set(i-1, String.valueOf(Double.parseDouble(data.get(i-1))-Double.parseDouble(data.get(i+1))));
			}
		}
		t.setText(data.get(0));
	}
	public static void main(String[] args) {
		new calculator();
	}
}