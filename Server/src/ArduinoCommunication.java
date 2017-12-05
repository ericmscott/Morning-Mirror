/**
 * @author: Christopher Morency
 */

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
		} catch(Exception e){
			System.out.println("Request Failed");
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
		} catch(Exception e){
			System.out.println("Request Failed");
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
		} catch(Exception e){
			System.out.println("Request Failed");
		}
	}
}
