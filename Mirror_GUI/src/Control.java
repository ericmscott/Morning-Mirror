//TODO
//import Server.News.*;
//TODO
//import Server.Time;
//TODO
//import Server.Bus.*;

public class Control {
	private News news;
	private float indoorTemp;
	private float outdoorTemp;
	private Time time;
	private Time timeToLeave;
	private int sleepQuality;
	private Bus bus;
	
	GUI gui= new GUI();
	//TODO
	//double check public or private
	/**
	 * Description:
	 * Function which updates the class variable news with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new news.
	 * 
	 * Return: Void
	 */
	public void updateNews(News news) {
		//TODO
		this.news=news;
		gui.updateNewsLabel(news);
	}
	/**
	 * Description:
	 * Function which updates the class variable indoorTemp with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new indoorTemp.
	 * 
	 * Return: Void
	 */
	public void updateindoorTemp(float temp) {
		indoorTemp=temp;
		gui.updateIndoorTempLabel(temp);
	}
	/**
	 * Description:
	 * Function which updates the class variable outdoorTemp with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new outdoorTemp.
	 * 
	 * Return: Void
	 */
	public void updateOutdoorTemp(float temp) {
		outdoorTemp= temp;
		gui.updateOutdoorTempLabel(temp);
	}
	/**
	 * Description:
	 * Function which updates the class variable time with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new time.
	 * 
	 * Return: Void
	 */
	public void updateTime(Time time) {
		this.time=time;
		gui.updateTimeLabel(time);
	}
	/**
	 * Description:
	 * Function which updates the class variable sleepQuality with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new sleep quality value.
	 * 
	 * Return: Void
	 */
	public void updateSleepQuality(int sleepQuality) {
		this.sleepQuality=sleepQuality;
		gui.updateSleepQualityLabel(sleepQuality);
	}
	/**
	 * Description:
	 * Function which updates the class variable bus with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new bus data.
	 * 
	 * Return: Void
	 */
	public void updateBusData(Bus bus) {
		this.bus=bus;
		gui.updateBusLabel(bus);
	}
	/**
	 * Description:
	 * Function which updates the class variable timeToLeave with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new timeToLeave.
	 * 
	 * Return: Void
	 */
	public void updateTimeToLeave(Time timeToLeave) {
		this.timeToLeave=timeToLeave;
		gui.updateTimeToLeaveLabel(timeToLeave);
	}
	/**
	 * Description:
	 * Function which returns the current time.
	 * 
	 * Parameters: Void
	 * 
	 * Return: current time
	 */
	public Time getTime() {
		return time;
	}
	public News getNews() {
		return news;
	}
	/**
	 * Description:
	 * Function which test the GUI to make sure everything is displayed correctly.
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void testGUI() {
		//TODO
	}
}

