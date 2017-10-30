
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class GUI {
//TODO
//Check variable type and private or public	
	private JFrame frame;
	private JLabel newsLabel;
	private JLabel indoortempLabel;
	private JLabel outdoorLabel;
	private JLabel timeLabel;
	private JLabel timeToLeaveLabel;
	private JLabel sleepQualityLabel;
	private JLabel busLabel;
	
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
		indoortempLabel.setText(Float.toString(indoorTemp));
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
		timeLabel.setText(Float.toString(temp));
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
		timeLabel.setText(Integer.toString(sleepQuality));
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
		timeLabel.setText(bus);
	}
}
