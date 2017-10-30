
public class Control {
	
	// Singleton Design Pattern
	private static Control instance = null;
	public Control(){}
	public static Control getInstance(){
		if (instance == null) instance = new Control();
		return instance;
	}
	// End of Singleton Design Pattern
	
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
		// TODO

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
		// TODO 

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
		// TODO

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
		// TODO

	}
	
	
	
	public static void main(String[] args) {
		Control instance = getInstance();
		while(true){
			instance.refreshInternetContent();
			instance.processArduinoContent();
			instance.processAndroidData();
			instance.updateGUI();
		}
	}

}
