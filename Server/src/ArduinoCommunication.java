
public class ArduinoCommunication {
	SerialConnection s;
	
	public ArduinoCommunication(){
		s = new SerialConnection();
	}
	
	/**
	 * Description:
	 * Function which gets Data from Arduino
	 * 
	 * Parameters: Void
	 * 
	 * Return: 
	 * boolean: Data whether pushButton is set or not
	 */
	public String getSensorData(){
		return s.sendRequest("1");
	}
	
	
	/**
	 * Description:
	 * Function which toggles Arduino buzzer
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 * @return 
	 */
	public void toggleBuzzer(){
		s.sendRequest("2");
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
		s.sendRequest("3");
	}
	
	/**
	 * Description:
	 * Function which tests Arduino
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void testArduino(){
		s.sendRequest("4");
	}
}
