/**
 * @author: Christopher Morency
 */

public class GUIUpdate {
    UDPSender sender = new UDPSender();
	/**
	 * Description:
	 * Function which updates the GUI with new data
	 * 
	 * Parameters:
	 * float indoorTemp: Temperature inside from Arduino temperature sensor
	 * 
	 * Return: Void
	 */
	public void setIndoorTemp(float indoorTemp){
		String s = Float.toString(indoorTemp);
		sender.sendMessage("1" + s);
	}
	
	/**
	 * Description:
	 * Function which updates the GUI with new data
	 * 
	 * Parameters: 
	 * float outdoorTemp: temperature outside from Internet
	 * 
	 * Return: Void
	 */
	public void setOutdoorTemp(Weather weather){
		sender.sendMessage("2" + weather.getTemperature());
		sender.sendMessage("5" + weather.getWeatherConditions());
	}
	
	/**
	 * Description:
	 * Function which updates the GUI with new data
	 * 
	 * Parameters:
	 * News news: news object from internet
	 * 
	 * Return: Void
	 */
	public void setNews(News news){
		sender.sendMessage("3" + news.getHeadline());
		sender.sendMessage("4" + news.getContent());
	}
	
	/**
	 * Description:
	 * Function which toggles the GUI background colour
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void changeColour(){
		sender.sendMessage("6");
	}
	
	/**
	 * Description:
	 * Function which toggles the GUI background colour
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void toggleAlarmMode(){
		sender.sendMessage("7");
	}
	
	/**
	 * Description:
	 * Function which updates the GUI with new data
	 * 
	 * Parameters: 
	 * Bus bus: bus data from Internet
	 * 
	 * Return: Void
	 */
	public void setBusData(Bus bus){
		//TODO
	}
	
	/**
	 * Description:
	 * Function which updates the GUI with new data
	 * 
	 * Parameters:
	 * Time timeToLeave: time to leave as calculated by server
	 * 
	 * Return: Void
	 */
	public void setTimeToLeave(Time timeToLeave){
		//TODO
	}
	
	/**
	 * Description:
	 * Function which updates the GUI with new data
	 * 
	 * Parameters:
	 * Time time: current time
	 * 
	 * Return: Void
	 */
	public void setTime(Time time){
		//TODO
	}
	
	/**
	 * Description:
	 * Function which updates the GUI with new data
	 * 
	 * Parameters:
	 * int sleepQuality: sleep quality as determined by server
	 * 
	 * Return: Void
	 */
	public void setSleepQuality(int sleepQuality){
		//TODO
	}
	
	/**
	 * Description:
	 * Function which toggles sleep mode (on/off)
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void toggleSleep(){
		//TODO
	}
	
	/**
	 * Description:
	 * Function which tests GUI
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void testGUI(){
		//TODO
	}
	
}
