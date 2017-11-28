import com.jaunt.*;
import java.io.*;

public class InternetCommunication {
	
	
	//OTTAWA JSON: http://samples.openweathermap.org/data/2.5/weather?id=6094817
	
	
	public void json(){
		try{
			  UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser).
			  userAgent.sendGET("http://api.openweathermap.org/data/2.5/weather?id=6094817&appid=5db02d37c7c36ce8bf3e9849b43e6982");   //send request
			  JNode weather = userAgent.json.findFirst("weather");
			  JNode weather2 = userAgent.json.findFirst("weather");
			  System.out.println(weather);
			  
			  //System.out.println(userAgent.json);            //print the retrieved JSON object
			  //System.out.println("Other response data: " + userAgent.response); //response metadata, including headers.
			  
			}
		catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
			System.err.println(e);
		}
	}

	 
	 
	 
	 /**
	 * Description:
	 * Function which gets data from Internet
	 * 
	 * Parameters: Void
	 * 
	 * Return: 
	 * float: Current outdoor temperature
	 */
	public float getWeather(){
		//TODO
		return -1;
	}
	
	/**
	 * Description:
	 * Function which gets data from Internet
	 * 
	 * Parameters: Void
	 * 
	 * Return: 
	 * News: news article retrieved with JSON
	 */
	public News getNews(){
		//TODO
		return null;
	}
	
	/**
	 * Description:
	 * Function which gets data from Internet
	 * 
	 * Parameters: 
	 * int bus: bus number to retrieve information for
	 * 
	 * Return:
	 * Bus: Bus information from OC Transpo
	 */
	public Bus getBus(int bus){
		//TODO
		return null;
	}
	
}
