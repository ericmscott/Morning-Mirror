
public class ArduinoCommunication {
	
	/**
	 * Description:
	 * Function which gets Data from Arduino
	 * 
	 * Parameters: Void
	 * 
	 * Return: 
	 * boolean: Data whether pushButton is set or not
	 */
	public boolean getPushButtonState(){
		//TODO
		return false;
	}
	
	/**
	 * Description:
	 * Function which gets Data from Arduino
	 * 
	 * Parameters: Void
	 * 
	 * Return: 
	 * IRButtons: holds state of IR buttons
	 */
	public IRButtons getIRButtonState(){
		//TODO
		return null;
	}
	
	/**
	 * Description:
	 * Function which gets Data from Arduino
	 * 
	 * Parameters: Void
	 * 
	 * Return: 
	 * int: current temperature as measured by Arduino
	 * @throws InterruptedException 
	 * @throws NumberFormatException 
	 */
	public String getTemperature() throws NumberFormatException, InterruptedException{
		new SerialReaderWriter();
		return SerialReaderWriter.request("2");
	}
	
	/**
	 * Description:
	 * Function which toggles Arduino buzzer
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void toggleBuzzer(){
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
	 * Function which tests Arduino
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void testArduino(){
		//TODO
	}
}
