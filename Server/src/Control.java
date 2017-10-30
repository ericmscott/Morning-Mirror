
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
	private void refreshInternetContent() {
		outdoorTemp = InternetCommunication.getWeather();
		news = InternetCommunication.getNews();
		bus = InternetCommunication.getBus(bus.getBusNumber());

	}
	
	/**
	 * Description:
	 * Function calls ArduinoLogic.java to get and process sensor data
	 * 
	 * Parameters: None
	 * 
	 * Return: Void
	 */
	private void processArduinoContent() {
		pushButton = ArduinoCommunication.getPushButtonState();
		indoorTemp = ArduinoCommunication.getTemperature();
		
		// Get individual buttons from Object containing the four button states
		IRButtons IRButtonStates = ArduinoCommunication.getIRButtonState();
		IR_Button1 = IRButtonStates.getIRButton1();
		IR_Button2 = IRButtonStates.getIRButton2();
		IR_Button3 = IRButtonStates.getIRButton3();
		IR_Button4 = IRButtonStates.getIRButton4();
		
		// TODO: Actual Logic

	}
	
	/**
	 * Description:
	 * Function which calls AndroidLogic.java to get and process sleep data
	 * 
	 * Parameters: None
	 * 
	 * Return: Void
	 */
	private void processAndroidData() {
		sleepData = AndroidCommunication.getSleepData();
		wakeUp = AndroidCommunication.getWakeUp();
		bus = AndroidCommunication.getBusData();
		currentLocation = AndroidCommunication.getCurrentLocation();
		destination = AndroidCommunication.getDestination();
		destinationTime = AndroidCommunication.getDestinationTime();
		// TODO: Actual Logic
	}
	
	/**
	 * Description:
	 * Function which updates the GUI with new data
	 * 
	 * Parameters: None
	 * 
	 * Return: Void
	 */
	private void updateGUI() {
		GUIUpdate.setIndoorTemp(indoorTemp);
		GUIUpdate.setOutdoorTemp(outdoorTemp);
		GUIUpdate.setNews(news);
		GUIUpdate.setBusData(bus);
		GUIUpdate.setTimeToLeave(timeToLeave);
		GUIUpdate.setTime(time);
		GUIUpdate.setSleepQuality(sleepQuality);
		//TODO: Actual Logic
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
	
	public static void main(String[] args) {
		Control instance = getInstance();
		instance.AndroidCommunication = new AndroidCommunication();
		instance.ArduinoCommunication = new ArduinoCommunication();
		instance.InternetCommunication = new InternetCommunication();
		instance.GUIUpdate = new GUIUpdate();

		//TODO: Thread stuff
		Thread t1 = new Thread();
		Thread t2 = new Thread();
		Thread t3 = new Thread();
		Thread t4 = new Thread();

		while(true){
			instance.refreshInternetContent();
			instance.processArduinoContent();
			instance.processAndroidData();
			instance.updateGUI();
		}
	}

}
