
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//TODO
// fix imports
import Server.News.*;
//TODO
//fix imports
import Server.Time.*;
//TODO
//fix imports
import Server.Bus.*;
//TODO
//fix imports
import miglayout-4.0-swing.jar:
public class GUI {
//TODO
//Check variable type and private or public
	private JPanel panel;
	private JFrame frame;
	private JLabel titleLabel;
	private JLabel newsLabel;
	private JLabel indoorTempLabel;
	private JLabel outdoorTempLabel;
	private JLabel timeLabel;
	private JLabel timeToLeaveLabel;
	private JLabel sleepQualityLabel;
	private JLabel busLabel;
	//TODO
	//find sizes
	private int newsHeight=1;
	private int newsWidth=1;
	private int timeHeight=1;
	private int timeWidth=1;
	private int tempHight=1;
	private int tempWidth=1;
	private int sleepQualityHeight=1;
	private int sleepQualityWidth=1;
	private int heightGap=1;
	private int widthGap=1;
	
	
	
//TODO
	//update label functions
	/**
	 * Description:
	 * Function which updates the content of newsLabel with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new news.
	 * 
	 * Return: Void
	 */
	public void updateNewsLabel(News news) {
		newsLabel.setText(news);
	}
	/**
	 * Description:
	 * Function which updates the content of indoorTempLabel with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new indoorTemp.
	 * 
	 * Return: Void
	 */
	public void updateIndoorTempLabel(float indoorTemp) {
		indoorTempLabel.setText(Float.toString(indoorTemp));
	}
	/**
	 * Description:
	 * Function which updates the content of outdoorTempLabel with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new outdoorTemp.
	 * 
	 * Return: Void
	 */
	public void updateOutdoorTempLabel(float temp) {
		outdoorTempLabel.setText(Float.toString(temp));
	}
	/**
	 * Description:
	 * Function which updates the content of timeLabel with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new time.
	 * 
	 * Return: Void
	 */
	public void updateTimeLabel(Time time) {
		timeLabel.setText(time);
	}
	/**
	 * Description:
	 * Function which updates the content of timeToLeaveLabel with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new time to leave.
	 * 
	 * Return: Void
	 */
	public void updateTimeToLeaveLabel(Time timeToLeave) {
		timeToLeaveLabel.setText(timeToLeave);
	}
	/**
	 * Description:
	 * Function which updates the content of sleepQualityLabel with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new sleep Quality value.
	 * 
	 * Return: Void
	 */
	public void updateSleepQualityLabel(int sleepQuality) {
		sleepQualityLabel.setText(Integer.toString(sleepQuality));
	}
	/**
	 * Description:
	 * Function which updates the content of busLabel with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new bus value.
	 * 
	 * Return: Void
	 */
	public void updateBusLabel(Bus bus) {
		busLabel.setText(bus);
	}
	// Build GUI
	//TODO
	/**
	 * Description:
	 * Function which calls all functions required to build the GUI.
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void buildGUI() {
		
	}
	/**
	 * Description:
	 * Function which implements the Layout of the GUI.
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void makeLayout() {
		panel= new JPanel(new MigLayout());
		
		panel.add(titleLabel,"north");
		panel.add(timeLabel);
		//TODO 
		//fix so it reads variables 
		panel.add(newsLabel,"span newsHeight newsWidth");
		panel.add(indoorTempLabel,"wrap");
		panel.add(timeToLeaveLabel);
		panel.add(outdoorTempLabel,"wrap");
		panel.add(busLabel);
		panel.add(sleepQualityLabel);
		
		
	}
}
