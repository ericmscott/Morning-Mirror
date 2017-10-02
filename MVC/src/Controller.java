import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller implements ActionListener {
	int counter;
	View view;
	Model model;
	
	public Controller (Model model, View view) {
		this.view = view;
		this.model = model;
		view.resetButton.addActionListener(this);
		view.setButton.addActionListener(this);
		while (true) {
			try { Thread.sleep(1000); } catch (Exception e) {};
			counter++;
			model.update(counter);	
		}
		
	}

	public void actionPerformed(ActionEvent e) { 
		if (e.getSource().equals (view.resetButton))
		{
			counter = 0;
		} else if (e.getSource().equals(view.setButton)) {
			String valueString = view.valueField.getText();
			try {
				int value = Integer.parseInt(valueString);
				counter = value;			
			} catch (Exception ex) { System.out.println("The text is not a valid integer");}
		}
	     
	}
}
