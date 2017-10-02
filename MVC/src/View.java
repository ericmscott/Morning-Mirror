import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View {
	
	JButton resetButton;
	JButton setButton;
	JTextField counterField, valueField;
	
	public View() {
		
		JFrame frame = new JFrame("A Simple MVC");
		Container contentPane = frame.getContentPane();
		contentPane.setLayout( new BorderLayout());
		
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		contentPane.add( "West", topPanel );
		contentPane.add ("East", bottomPanel);
				
		topPanel.add("West", new JLabel("Counter"));
		counterField = new JTextField( "0", 10);
		counterField.setEditable(false);
		topPanel.add("East",counterField);
		
		bottomPanel.setLayout(new BorderLayout());
		valueField = new JTextField( 10);
		counterField.setEditable(true);
		bottomPanel.add("North",valueField);
		JPanel buttonPanel = new JPanel();
		bottomPanel.add("South",buttonPanel);
		buttonPanel.setLayout(new FlowLayout());
		resetButton = new JButton ("RESET");
		buttonPanel.add(resetButton);
		buttonPanel.add(resetButton);
		setButton = new JButton ("SET");
		buttonPanel.add(setButton);
		buttonPanel.add(setButton);

		frame.setSize(350,100);
		frame.setLocation(100,100);
		frame.setVisible(true);
		
	}
	
	public void update(int counter) {
		counterField.setText(Integer.toString(counter));
		return;
	}
}
