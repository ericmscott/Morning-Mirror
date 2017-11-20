
public class ArduinoCommunication {
	SerialConnection s = new SerialConnection();
	/**
	 * Description:
	 * Function which gets Data from Arduino
	 * 
	 * Parameters: Void
	 * 
	 * Return: 
	 * boolean: Data whether pushButton is set or not
	 * @throws InterruptedException 
	 */
	public String getPushButtonState() throws InterruptedException{
		//TODO
		s.setRequest("4");
		while(!s.checkIfReceived()){
			Thread.sleep(50);
		}
		return s.getResponse();
	}
	
	/**
	 * Description:
	 * Function which gets Data from Arduino
	 * 
	 * Parameters: Void
	 * 
	 * Return: 
	 * IRButtons: holds state of IR buttons
	 * @throws InterruptedException 
	 */
	public String getIRButtonState() throws InterruptedException{
		//TODO
		s.setRequest("5");
		while(!s.checkIfReceived()){
			Thread.sleep(50);
		}
		return s.getResponse();
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
		s.setRequest("2");
		while(!s.checkIfReceived()){
			Thread.sleep(50);
		}
		return s.getResponse();
	}
	
	/**
	 * Description:
	 * Function which toggles Arduino buzzer
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 * @return 
	 * @throws InterruptedException 
	 */
	public String toggleBuzzer() throws InterruptedException{
		s.setRequest("3");
		while(!s.checkIfReceived()){
			Thread.sleep(50);
		}
		return s.getResponse();
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
