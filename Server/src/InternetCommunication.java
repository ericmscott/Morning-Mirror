/**
 * @author: Christopher Morency
 */

import com.jaunt.*;
import java.io.*;

public class InternetCommunication {	

	 /**
	 * Description:
	 * Function which gets data from Internet
	 * 
	 * Parameters: Void
	 * 
	 * Return: 
	 * float: Current outdoor temperature
	 */
	public Weather getWeather(){
		Weather weather = null;
		String weatherConditions = null;
		String temperature = null;
		
		try{
			  UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser).
			  userAgent.sendGET("http://api.openweathermap.org/data/2.5/weather?id=6094817&appid=5db02d37c7c36ce8bf3e9849b43e6982");   //send request
			  JNode weatherNode = userAgent.json.findFirst("weather");
			  weatherConditions = "Weather Conditions: " + weatherNode.findFirst("description");
			  weatherNode = userAgent.json.getFirst("main");
			  temperature = "Outdoor Temperature: " + (weatherNode.findFirst("temp").toLong()-273) + " degree(s) Celsius";
			  weather = new Weather(temperature, weatherConditions);
		} catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
			System.err.println(e);
		}
		return weather;
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
	public News getNews(int articleNum){
		// API Key: 4b3bd34b9265430ea040352562478442
		News news = null;
		String headline = null;
		String content = null;
		try{
			  UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser).
			  userAgent.sendGET("https://newsapi.org/v2/top-headlines?sources=google-news-ca&apiKey=4b3bd34b9265430ea040352562478442");   //send request
			  JNode newsNode = userAgent.json.findEach("title");
			  if(articleNum < 0) articleNum = newsNode.size() + 1 - articleNum; 
			  headline = newsNode.get(articleNum % newsNode.size()).toString();
			  newsNode = userAgent.json.findEach("description");
			  content = newsNode.get(articleNum % newsNode.size()).toString();
			  news = new News(headline, content);
		} catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
			System.err.println(e);
		}
		return news;
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
