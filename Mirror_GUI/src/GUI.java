
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
	public JFrame window;
	private JLabel titleLabel;
	private JLabel newsTitleLabel;
	private JTextArea newsContentLabel;
	public JLabel indoorTempLabel;
	private JLabel outdoorTempLabel;
	private JLabel timeLabel;
	private JLabel timeToLeaveLabel;
	private JLabel sleepQualityLabel;
	private JLabel busLabel;
	/*
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
	*/
	public GUI() {
		this.panel=new JPanel();
		this.window =new JFrame();
		this.titleLabel=new JLabel("Morning Mirror");
		this.newsTitleLabel=new JLabel("Habs are bad");
		this.newsContentLabel=new JTextArea("MONTREAL — It would have been a fine time for an old-fashioned bag skate, but Montreal Canadiens coach Claude Julien didn't have that option even if that was what he wanted."
+"After closing a six-game homestand with what the coach called an embarrassing 5-4 loss to lowly Arizona followed by a 6-0 thrashing from the rival Toronto Maple Leafs, the old-school reaction would be to hold a punishing, no-sticks skate to drive home the message that such performances are unacceptable.",2,2);
		this.newsContentLabel.setLineWrap(true);
		this.newsContentLabel.setWrapStyleWord(true);
		this.indoorTempLabel=new JLabel("aaaaaaaaaaaaaaaaaa");
		this.outdoorTempLabel=new JLabel("outdoor temp");
		this.timeLabel=new JLabel("time");
		this.timeToLeaveLabel=new JLabel("time to leave");
		this.sleepQualityLabel=new JLabel("Sleep Quality");
		this.busLabel=new JLabel("bus");
		this.indoorTempLabel.setText("50");
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
		newsTitleLabel.setText(news.getHeadline());
		newsContentLabel.setText(news.getContent());
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
		System.out.println("333");
		System.out.println(indoorTempLabel);
		indoorTempLabel.setText(Float.toString(indoorTemp));
		indoorTempLabel.paintImmediately(this.indoorTempLabel.getVisibleRect());
//		window.repaint();
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
	 GUI MirrorGUI = new GUI();
	 MirrorGUI.makeLayout();
	 
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
		window = new JFrame();
		window.setSize(2100, 1050);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Container cp = window.getContentPane();
	    cp.setLayout(new MigLayout(""));
	    
		cp.add(titleLabel,"north");
		cp.add(timeLabel);
		cp.add(newsTitleLabel,"span 2 1");
		//TODO 
		//fix so it reads variables 
		cp.add(indoorTempLabel,"wrap");
		cp.add(timeToLeaveLabel);
		cp.add(newsContentLabel,"span 2 3");

		cp.add(outdoorTempLabel,"wrap");
		cp.add(busLabel);
		cp.add(sleepQualityLabel);
		//window.pack();
	    window.setVisible(true);
		
		
	}
	public void start()
	{
		//JFrame window = new JFrame();
		//GUI MirrorGUI = new GUI();
		//MirrorGUI.updateSleepQualityLabel(5);
//		MirrorGUI.
		makeLayout();
//		MirrorGUI.
		updateSleepQualityLabel(5);
		//window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Container cp = window.getContentPane();
	    //MirrorGUI.updateIndoorTempLabel(5.0f);
	}
}
