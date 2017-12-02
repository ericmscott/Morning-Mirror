import java.net.*;
import java.util.Calendar;
import java.util.Date;
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
	
	
	private String time;
	private Time destinationTime;
	private Time timeToLeave;
	private Time wakeUp;
	private News news;
	private Bus bus;
	private Location currentLocation;
	private SleepData sleepData;

	private Weather outdoorTemp;
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
	private int currentArticle = 0;
	int internetCount;
	
	
	/**
	 * Description:
	 * Function which calls Internet logic to get/refresh content
	 * 
	 * Parameters: None
	 * 
	 * Return: Void
	 */
	public void refreshInternetContent() {
		
		Weather tempOutdoorTemp = InternetCommunication.getWeather();
		if(outdoorTemp == null || !tempOutdoorTemp.getWeatherConditions().equals(outdoorTemp.getWeatherConditions()) || !tempOutdoorTemp.getTemperature().equals(outdoorTemp.getTemperature())){
			System.out.println(tempOutdoorTemp.getTemperature());
			System.out.println(tempOutdoorTemp.getWeatherConditions());
			outdoorTemp = tempOutdoorTemp;
			GUIUpdate.setOutdoorTemp(outdoorTemp);
		}
		
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		News temp2 = InternetCommunication.getNews(currentArticle);
		if ( news == null || !temp2.getHeadline().equals(news.getHeadline())){ //TODO: Fix this (add isEqual to news or whatever)
			news = temp2;
			GUIUpdate.setNews(news);
			System.out.println("Headline: " + news.getHeadline());
			System.out.println("Content: " + news.getContent());
		}
			
		if(internetCount == 20){
			currentArticle++;
			internetCount = 0;
		} else{
			internetCount++;
		}

		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		/*
		Bus temp3 = InternetCommunication.getBus(bus.getBusNumber());
		if (bus != null && temp3 != bus){ //TODO: Fix this (add isEqual to news or whatever)
			GUIUpdate.setBusData(temp3);
			bus = temp3;
		}*/

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
		
		boolean IR_Button1Temp, IR_Button2Temp, IR_Button3Temp, IR_Button4Temp;
		if(sensorData.getBytes()[0] == '1') IR_Button1Temp = true;	
		else IR_Button1Temp = false;	
		if(sensorData.getBytes()[1] == '1') IR_Button2Temp = true;	
		else IR_Button2Temp = false;	
		if(sensorData.getBytes()[2] == '1') IR_Button3Temp = true;	
		else IR_Button3Temp = false;	
		if(sensorData.getBytes()[3] == '1') IR_Button4Temp = true;	
		else IR_Button4Temp = false;	
		
		if((IR_Button1Temp != IR_Button1) || (IR_Button2Temp != IR_Button2) || (IR_Button3Temp != IR_Button3) || (IR_Button4Temp != IR_Button4)){
			IR_Button1 = IR_Button1Temp;
			if(IR_Button1){ 
				currentArticle++;
				internetCount = 0;
			}
			IR_Button2 = IR_Button2Temp;
			if(IR_Button2){ 
				currentArticle--;
				internetCount = 0;
			}
			IR_Button3 = IR_Button3Temp;
			IR_Button4 = IR_Button4Temp;
			if(IR_Button1) System.out.println("IR button 1 pressed");
			else System.out.println("IR button 1 unpressed");
			if(IR_Button2) System.out.println("IR button 2 pressed");
			else System.out.println("IR button 2 unpressed");
			if(IR_Button3) System.out.println("IR button 3 pressed");
			else System.out.println("IR button 3 unpressed");
			if(IR_Button4) System.out.println("IR button 4 pressed");
			else System.out.println("IR button 4 unpressed");
		}
	
		boolean pushButtonTemp;
		if(sensorData.getBytes()[4] == '1') pushButtonTemp = true;	
		else pushButtonTemp = false;
		
		if (pushButtonTemp != pushButton){
			pushButton = pushButtonTemp;
			if(pushButton) System.out.println("Push button pressed");
			else System.out.println("Push button unpressed");
		}
		
		
		if(Float.parseFloat(sensorData.substring(5, 9)) != indoorTemp){
			GUIUpdate.setIndoorTemp(Float.parseFloat(sensorData.substring(5, 9)));
			indoorTemp = Float.parseFloat(sensorData.substring(5, 9));
			System.out.println(Float.toString(indoorTemp));
		}
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
				
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
		try{
			int port = 3000;
			DatagramSocket socket = new DatagramSocket(port);
			for(;;){
				DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);
				socket.receive(packet);
				//int hour = packet.getData()[0];
				//int hour = (new Calendar()).HOUR_OF_DAY;
				System.out.println(new String(packet.getData()).trim());
			}
			
		} catch(Exception e){
			e.printStackTrace();
		}
		/*
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
		*/
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
		instance.AndroidCommunication = new AndroidCommunication();
		instance.ArduinoCommunication = new ArduinoCommunication();
		instance.InternetCommunication = new InternetCommunication();
		instance.GUIUpdate = new GUIUpdate();
		for(int i=0; i<3; i++){
		      new Thread("" + i){
		        @SuppressWarnings("static-access")
				public void run(){
		          if(Thread.currentThread().getName().equals("0")){
		        	  while(true){
		        		  try{
		        			  instance.refreshInternetContent();
		        		  } catch(Exception e){ 
		        			  System.out.println("Internet Communication Failure");
		        			  try {
								Thread.currentThread().sleep(5000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
		        		  }
		        	  }
		          } else if(Thread.currentThread().getName().equals("1")){
		        	  while(true){
		        		  try{
				      			instance.processArduinoContent();
		        		  } catch(Exception e){ 
		        			  System.out.println("Arduino Communication Failure");
		        			  try {
								Thread.currentThread().sleep(5000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
		        		  }
		        	  }
		          } else if(Thread.currentThread().getName().equals("2")){
	        		  try{
		        		  instance.processAndroidData();
	        		  } catch(Exception e){ 
	        			  System.out.println("Android Communication Failure");
	        			  try {
							Thread.currentThread().sleep(5000);
						} catch (InterruptedException e1) {
							e1.printStackTrace();
						}
	        		  
		        	  }
		          }

		        }
		      }.start();
		}

	}
}
