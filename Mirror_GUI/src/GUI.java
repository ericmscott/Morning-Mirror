
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
	private JLabel outdoorWeatherLabel;
	private JLabel timeLabel;
	private JLabel timeToLeaveLabel;
	private JLabel sleepQualityLabel;
	private JLabel busLabel;
	public Font myFontTitle; 
	public Font myFontElse;
	public Font myFontContent;
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
		this.panel = new JPanel();
		this.window = new JFrame();
		myFontTitle= new Font("my font", Font.PLAIN,90);
		myFontElse= new Font("my font", Font.PLAIN,35);
		myFontContent=new Font("my font", Font.PLAIN,25);
		
		
		
		this.titleLabel=new JLabel("Morning Mirror");
		titleLabel.setFont(myFontTitle);
		titleLabel.setForeground(Color.RED);
		this.newsTitleLabel=new JLabel("Alfredsson to be inducteed to IIHF HOF");
		newsTitleLabel.setFont(myFontElse);
		newsTitleLabel.setForeground(Color.WHITE);
		
		
		
		this.newsContentLabel=new JTextArea("Ottawa Senators legend Daniel Alfredsson will be among the inductees to the International Ice Hockey Federation Hall of Fame, world hockey's governing body announced on Friday."
+"A five-time Swedish Olympian and a gold medalist at Torino 2006, Alfredsson will join Dallas Stars and Finland great Jere Lehtinen, long-time French official Philippe Lacarriere, Danish player Jesper Damgaard and Latvian president Kirovs Lipmans."
,2,2);
		this.newsContentLabel.setLineWrap(true);
		this.newsContentLabel.setWrapStyleWord(true);
		newsContentLabel.setFont(myFontContent);
		newsContentLabel.setBackground(Color.BLACK);
		newsContentLabel.setForeground(Color.WHITE);

		this.indoorTempLabel=new JLabel("aaaaaaaaaaaaaaaaaa");
		indoorTempLabel.setFont(myFontElse);
		indoorTempLabel.setForeground(Color.WHITE);
		indoorTempLabel.setText("Indoor Temp Label");
		indoorTempLabel.setFont(myFontElse);
		indoorTempLabel.setForeground(Color.WHITE);
		
		
		this.outdoorTempLabel=new JLabel("outdoor temp");
		outdoorTempLabel.setFont(myFontElse);
		outdoorTempLabel.setForeground(Color.WHITE);
		outdoorTempLabel.setText("Outdoor Temp Label");
		outdoorTempLabel.setFont(myFontElse);
		outdoorTempLabel.setForeground(Color.WHITE);
		
		this.outdoorWeatherLabel=new JLabel("Weather");
		outdoorWeatherLabel.setFont(myFontElse);
		outdoorWeatherLabel.setForeground(Color.WHITE);
		outdoorWeatherLabel.setText("Outdoor Weather Label");
		outdoorWeatherLabel.setFont(myFontElse);
		outdoorWeatherLabel.setForeground(Color.WHITE);
		
		
		
		this.timeLabel=new JLabel("time");
		timeLabel.setFont(myFontElse);
		timeLabel.setForeground(Color.WHITE);
		this.timeToLeaveLabel=new JLabel("Leave in 10 minutes to catch your bus");
		timeToLeaveLabel.setFont(myFontElse);
		timeToLeaveLabel.setForeground(Color.WHITE);
		
		
		
		this.sleepQualityLabel=new JLabel("Sleep Quality");
		sleepQualityLabel.setFont(myFontElse);
		sleepQualityLabel.setForeground(Color.WHITE);
		
		
		
		this.busLabel=new JLabel("bus");
		busLabel.setFont(myFontElse);
		busLabel.setForeground(Color.WHITE);
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
	public void updateNewsHeadlineLabel(String news) {
		newsTitleLabel.setText(news);
		
	}
	public void updateNewsContentLabel(String news) {
		
		newsContentLabel.setText(null);
		newsContentLabel.insert(news,0);
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
		//System.out.println("333");
		//System.out.println(indoorTempLabel);
		indoorTempLabel.setText("Indoor Temperature: "+Float.toString(indoorTemp)+" degree(s) Celsius");
		//indoorTempLabel.paintImmediately(this.indoorTempLabel.getVisibleRect());
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
	public void updateOutdoorTempLabel(String  temp) {
		outdoorTempLabel.setText(temp);
	}
	public void updateOutdoorWeatherLabel(String  weather) {
		outdoorWeatherLabel.setText(weather);
	}
	/**
	 * Description:
	 * Function which updates the content of timeLabel with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new time.
	 * 
	 * Return: Void
	 */
	public void updateTimeLabel(String time) {
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
	public void updateTimeToLeaveLabel(String timeToLeave) {
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
		panel = new JPanel(new MigLayout());
		window = new JFrame();
		window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		window.setUndecorated(true);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	    Container cp = window.getContentPane();
	    cp.setLayout(new MigLayout(""));
	    cp.setBackground(Color.BLACK);
		cp.add(titleLabel,"north");
		//cp.add(newsContentLabel," grow,south");
		cp.add(timeLabel,"wrap");
		//cp.add(newsTitleLabel,"align center, span 2 1,wrap");
		//TODO 
		//fix so it reads variables 
		cp.add(indoorTempLabel,"wrap");
		//cp.add(timeToLeaveLabel, "span 2 1");
		//cp.add(newsContentLabel,"align center,span 3 3,wrap");

		cp.add(outdoorTempLabel,"wrap");
		cp.add(outdoorWeatherLabel,"wrap");
		cp.add(timeToLeaveLabel, "span 2 1,wrap");
		cp.add(newsTitleLabel,"gapy 40sp, span 2 1,wrap");
		cp.add(newsContentLabel," grow");
		//cp.add(newsContentLabel,"align center,span 3 3,south");
		//cp.add(busLabel);
		//cp.add(sleepQualityLabel);
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
