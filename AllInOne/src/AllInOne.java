
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.*;
import java.lang.Integer;


public class AllInOne implements ActionListener {

	private JButton resetButton, setButton;
	private JTextField counterField, valueField;
	private int counter;
	
	public static void main(String[] args) {
			AllInOne program = new AllInOne();
			while (true) {
				try { Thread.sleep(1000); } catch (Exception e) {};
				program.counter++;
				program.counterField.setText( Integer.toString(program.counter) );	
			}
	}

	public AllInOne() {
		
		counter = 0;
		
		JFrame frame = new JFrame("A Simple MVC");
		Container contentPane = frame.getContentPane();
		contentPane.setLayout( new BorderLayout());
		
		JPanel topPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		contentPane.add( "West", topPanel );
		contentPane.add ("East", bottomPanel);
				
		topPanel.add("West", new JLabel("Counter"));
		counterField = new JTextField( Integer.toString(counter), 10);
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
		resetButton.addActionListener(this);
		buttonPanel.add(resetButton);
		setButton = new JButton ("SET");
		buttonPanel.add(setButton);
		setButton.addActionListener(this);
		buttonPanel.add(setButton);

		frame.setSize(350,100);
		frame.setLocation(100,100);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) { 
		if (e.getSource().equals (resetButton))
		{
			counter = 0;
		} else if (e.getSource().equals(setButton)) {
			String valueString = valueField.getText();
			try {
				int value = Integer.parseInt(valueString);
				counter = value;				
			} catch (Exception ex) { System.out.println("The text is not a valid integer");}
		}
	     
	}
}
