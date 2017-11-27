
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
		String str;
		try{
			str = s.sendRequest("1");
			System.out.println("Test Successful");
		} catch(Exception e){
			System.out.println("Test Failed");
			return null;
		}
		
		return str;
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
		try{
			s.sendRequest("2");
			System.out.println("Send Successful");
		} catch(Exception e){
			System.out.println("Send Failed");
		}
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
		try{
			s.sendRequest("3");
			System.out.println("Test Successful");
		} catch(Exception e){
			System.out.println("Test Failed");
		}
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
		try{
			s.sendRequest("4");
			System.out.println("Test Successful");
		} catch(Exception e){
			System.out.println("Test Failed");
		}
	}
}
