
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;
//TODO
// fix imports
//import Server.News.*;
//TODO
//fix imports
//import Server.Time.*;
//TODO
//fix imports
//import Server.Bus.*;
//TODO
//fix imports


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
	
	public GUI() {
		this.panel=new JPanel();
		this.frame=new JFrame();
		this.titleLabel=new JLabel();
		this.newsLabel=new JLabel();
		this.indoorTempLabel=new JLabel();
		this.outdoorTempLabel=new JLabel();
		this.timeLabel=new JLabel();
		this.timeToLeaveLabel=new JLabel();
		this.sleepQualityLabel=new JLabel();
		this.busLabel=new JLabel();
	}
	
	
	
	
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
		newsLabel.setText(news.toString());
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
		timeLabel.setText(time.toString());
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
		timeToLeaveLabel.setText(timeToLeave.toString());
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
		busLabel.setText(bus.toString());
	}
	// Build GUI	//TODO
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
