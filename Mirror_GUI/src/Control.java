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
	public boolean updateNews(News news) {
		//TODO
		if (news.getHeadline()=="" || news.getContent()==""){
			return false;
		}
		this.news=news;
		gui.updateNewsLabel(news);
		return true;
	}
	/**
	 * Description:
	 * Function which updates the class variable indoorTemp with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new indoorTemp.
	 * 
	 * Return: Void
	 */
	public boolean updateindoorTemp(float temp) {
		if (temp>40f||temp<0f){
			return false;
		}
		
		indoorTemp=temp;
		gui.updateIndoorTempLabel(temp);
		return true;
	}
	/**
	 * Description:
	 * Function which updates the class variable outdoorTemp with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new outdoorTemp.
	 * 
	 * Return: Void
	 */
	public boolean updateOutdoorTemp(float temp) {
		if (temp>40f||temp<-40f){
			return false;
		}
		
		outdoorTemp= temp;
		gui.updateOutdoorTempLabel(temp);
		return true;
	}
	/**
	 * Description:
	 * Function which updates the class variable time with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new time.
	 * 
	 * Return: Void
	 */
	public boolean updateTime(Time time) {
		if (time.getHour()>23||time.getHour()<0){
			return false;
		}
		this.time=time;
		gui.updateTimeLabel(time);
		return true;
	}
	/**
	 * Description:
	 * Function which updates the class variable sleepQuality with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new sleep quality value.
	 * 
	 * Return: Void
	 */
	public boolean updateSleepQuality(int sleepQuality) {
		if (sleepQuality<0||sleepQuality>10){
			return false;
		}
		this.sleepQuality=sleepQuality;
		gui.updateSleepQualityLabel(sleepQuality);
		return true;
	}
	/**
	 * Description:
	 * Function which updates the class variable bus with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new bus data.
	 * 
	 * Return: Void
	 */
	public boolean updateBusData(Bus bus) {
		if(bus.getBusNumber()<1||bus.getNextBus1()<-1||bus.getNextBus2()<-1||bus.getNextBus3()<-1){
			return false;
		}
		this.bus=bus;
		gui.updateBusLabel(bus);
		return true;
	}
	/**
	 * Description:
	 * Function which updates the class variable timeToLeave with the data that is passed as the function parameter.
	 * 
	 * Parameters: the new timeToLeave.
	 * 
	 * Return: Void
	 */
	public boolean updateTimeToLeave(Time timeToLeave) {
		if (timeToLeave.getHour()>23||timeToLeave.getHour()<0){
			return false;
		}
		this.timeToLeave=timeToLeave;
		gui.updateTimeToLeaveLabel(timeToLeave);
		return true;
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
	public float getIndoorTemp() {
		return indoorTemp;
	}
	public float getOutdoorTemp() {
		
		return outdoorTemp;
	}
	public Object getSleepQuality() {

		return sleepQuality;
	}
	public Bus getBus() {
		return bus;
	}
	public Time getTimeToLeave() {
		
		return timeToLeave;
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

