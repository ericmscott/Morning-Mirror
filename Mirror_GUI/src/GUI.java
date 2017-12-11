
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import net.miginfocom.swing.MigLayout;



public class GUI {
//TODO
//Check variable type and private or public
	private JPanel panel;
	public JFrame window;
	private JLabel titleLabel;
	private JTextArea newsTitleLabel;
	private JTextArea newsContentLabel;
	private JLabel indoorTempLabel;
	private JLabel outdoorTempLabel;
	private JLabel outdoorWeatherLabel;
	private JLabel timeLabel;
	private JLabel timeToLeaveLabel;
	private JLabel sleepQualityLabel;
	private JLabel busLabel;
	private JLabel nextNewsLabel;
	private JLabel prevNewsLabel;
	public Font myFontTitle; 
	public Font myFontElse;
	public Font myFontContent;
	private int currentColour = 0;
	
	public GUI() {
		this.panel = new JPanel();
		this.window = new JFrame();
		myFontTitle= new Font("my font", Font.PLAIN,90);
		myFontElse= new Font("my font", Font.PLAIN,35);
		myFontContent=new Font("my font", Font.PLAIN,25);
		
		
		
		this.titleLabel=new JLabel("Morning Mirror");
		titleLabel.setFont(myFontTitle);
		titleLabel.setForeground(Color.RED);
		this.newsTitleLabel=new JTextArea("Alfredsson to be inducteed to IIHF HOF",2,40);
		newsTitleLabel.setFont(myFontElse);
		this.newsTitleLabel.setLineWrap(true);
		this.newsTitleLabel.setWrapStyleWord(true);
		newsTitleLabel.setForeground(Color.WHITE);
		newsTitleLabel.setBackground(Color.BLACK);
		
		
		
		this.newsContentLabel=new JTextArea("Ottawa Senators legend Daniel Alfredsson will be among the inductees to the International Ice Hockey Federation Hall of Fame, world hockey's governing body announced on Friday."
+"A five-time Swedish Olympian and a gold medalist at Torino 2006, Alfredsson will join Dallas Stars and Finland great Jere Lehtinen, long-time French official Philippe Lacarriere, Danish player Jesper Damgaard and Latvian president Kirovs Lipmans."
,2,40);
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
		
		this.nextNewsLabel=new JLabel("Next Article");
		nextNewsLabel.setFont(myFontElse);
		nextNewsLabel.setForeground(Color.WHITE);
		
		this.prevNewsLabel=new JLabel("Previous Article");
		prevNewsLabel.setFont(myFontElse);
		prevNewsLabel.setForeground(Color.WHITE);
		
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
		newsTitleLabel.setText(null);
		newsTitleLabel.insert(news,0);
		
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
		
		indoorTempLabel.setText("Indoor Temperature: "+Float.toString(indoorTemp)+" degree(s) Celsius");
		
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
	
	public void changeColour(){
		if(currentColour == 0){
			window.getContentPane().setBackground(Color.BLUE);
			newsTitleLabel.setBackground(Color.BLUE);
			newsContentLabel.setBackground(Color.BLUE);
			currentColour++;
		} else if(currentColour == 1){
			window.getContentPane().setBackground(Color.GREEN);
			newsTitleLabel.setBackground(Color.GREEN);
			newsContentLabel.setBackground(Color.GREEN);
			currentColour++;
		} else if(currentColour == 2){
			window.getContentPane().setBackground(Color.ORANGE);
			newsTitleLabel.setBackground(Color.ORANGE);
			newsContentLabel.setBackground(Color.ORANGE);
			currentColour++;
		} else if(currentColour == 3){
			window.getContentPane().setBackground(Color.PINK);
			newsTitleLabel.setBackground(Color.PINK);
			newsContentLabel.setBackground(Color.PINK);
			currentColour++;
		} else if(currentColour == 4){
			window.getContentPane().setBackground(Color.CYAN);
			newsTitleLabel.setBackground(Color.CYAN);
			newsContentLabel.setBackground(Color.CYAN);
			currentColour++;
		} else {
			window.getContentPane().setBackground(Color.BLACK);
			newsTitleLabel.setBackground(Color.BLACK);
			newsContentLabel.setBackground(Color.BLACK);
			currentColour = 0;
		}

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
		
		cp.add(timeLabel,"wrap");
		
		cp.add(indoorTempLabel,"wrap");
		

		cp.add(outdoorTempLabel,"wrap");
		cp.add(outdoorWeatherLabel,"wrap");
		cp.add(timeToLeaveLabel, "span 2 1,wrap");
		//cp.add(newsTitleLabel,"span 2 1,wrap");
		cp.add(newsTitleLabel,"gapy 40sp, span 2 1");
		cp.add(prevNewsLabel,"gapx 15sp");
		cp.add(nextNewsLabel,"gapx 10sp,wrap");
		cp.add(newsContentLabel);
		//cp.add(prevNewsLabel,"gapx 20sp");
		//cp.add(nextNewsLabel,"gapx 20sp");
		
		//cp.add(busLabel);
		//cp.add(sleepQualityLabel);
		
	    window.setVisible(true);
		
		
	}
	public void start()
	{
		
//		MirrorGUI.
		makeLayout();
//		MirrorGUI.
		
	}
}
