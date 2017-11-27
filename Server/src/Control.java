
public class Control {
	
	// Singleton Design Pattern
	private static Control instance = null;
	public Control(){}
	public static Control getInstance(){
		if (instance == null) instance = new Control();
		return instance;
	}
	// End of Singleton Design Pattern
	
	private AndroidCommunication AndroidCommunication;
	private ArduinoCommunication ArduinoCommunication;
	private InternetCommunication InternetCommunication;
	private GUIUpdate GUIUpdate;
	
	
	private Time time;
	private Time destinationTime;
	private Time timeToLeave;
	private Time wakeUp;
	private News news;
	private Bus bus;
	private Location currentLocation;
	private SleepData sleepData;

	private float outdoorTemp;
	private float indoorTemp;
	private int sleepQuality;
	private boolean sleepMode;
	private boolean IR_Button1;
	private boolean IR_Button2;
	private boolean IR_Button3;
	private boolean IR_Button4;
	private boolean pushButton;
	private boolean buzzer;
	private String destination;
	
	
	/**
	 * Description:
	 * Function which calls Internet logic to get/refresh content
	 * 
	 * Parameters: None
	 * 
	 * Return: Void
	 */
	public void refreshInternetContent() {
		float temp = InternetCommunication.getWeather();
		if (temp != outdoorTemp){
			//GUIUpdate.setOutdoorTemp(temp);
			outdoorTemp = temp;
		}
		
		News temp2 = InternetCommunication.getNews();
		if ( news != null && temp2 != news){ //TODO: Fix this (add isEqual to news or whatever)
			//GUIUpdate.setNews(temp2);
			news = temp2;
		}

		Bus temp3 = InternetCommunication.getBus(7/*bus.getBusNumber()*/);
		if (bus != null && temp3 != bus){ //TODO: Fix this (add isEqual to news or whatever)
			//GUIUpdate.setBusData(temp3);
			bus = temp3;
		}

	}
	
	/**
	 * Description:
	 * Function calls ArduinoLogic.java to get and process sensor data
	 * 
	 * Parameters: None
	 * 
	 * Return: Void
	 * @throws InterruptedException 
	 * @throws NumberFormatException 
	 */
	private void processArduinoContent() {		
		String sensorData = ArduinoCommunication.getSensorData();
		System.out.println(sensorData);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		float temp = Float.parseFloat(sensorData);
		if (temp != indoorTemp){
			GUIUpdate.setIndoorTemp(temp);
			indoorTemp = temp;
		}
		// TODO: Parse Rest of Data + Logic
	}
	
	/**
	 * Description:
	 * Function which calls AndroidLogic.java to get and process sleep data
	 * 
	 * Parameters: None
	 * 
	 * Return: Void
	 */
	public void processAndroidData() {
		sleepData = AndroidCommunication.getSleepData();
		wakeUp = AndroidCommunication.getWakeUp();
		bus = AndroidCommunication.getBusData();
		currentLocation = AndroidCommunication.getCurrentLocation();
		destination = AndroidCommunication.getDestination();
		destinationTime = AndroidCommunication.getDestinationTime();
		
		
		sleepQuality = 0;
		timeToLeave = new Time(2, 3, 1, 3, 2, 1);
		// TODO: Actual logic For these updates
		//GUIUpdate.setTimeToLeave(timeToLeave);
		//GUIUpdate.setTime(time);
		//GUIUpdate.setSleepQuality(sleepQuality);

	}
	
	/**
	 * Description:
	 * Function which puts GUI and Arduino to sleep
	 * 
	 * Parameters: None
	 * 
	 * Return: Void
	 */
	private void sleep(){
		GUIUpdate.toggleSleep();
		ArduinoCommunication.toggleSleep();
	}

	/**
	 * Description:
	 * Function which tests GUI, Arduino and Android
	 * 
	 * Parameters: None
	 * 
	 * Return: Void
	 */
	private void test(){
		GUIUpdate.testGUI();
		ArduinoCommunication.testArduino();
		AndroidCommunication.testAndroid();
	}
	
	public static void main(String[] args){
		Control instance = getInstance();
		//instance.AndroidCommunication = new AndroidCommunication();
		instance.ArduinoCommunication = new ArduinoCommunication();
		//instance.InternetCommunication = new InternetCommunication();
		instance.GUIUpdate = new GUIUpdate();
		/*
		//TODO: Thread stuff
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		Thread t3 = new Thread();
		*/
		while(true){
			//instance.refreshInternetContent();
			instance.processArduinoContent();
			//instance.processAndroidData();
		}
	}

}
