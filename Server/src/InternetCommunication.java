import com.jaunt.*;
import java.io.*;

public class InternetCommunication {	
	
	public void json(){

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
	public String getWeather(){
		String str = null;
		try{
			  UserAgent userAgent = new UserAgent();         //create new userAgent (headless browser).
			  userAgent.sendGET("http://api.openweathermap.org/data/2.5/weather?id=6094817&appid=5db02d37c7c36ce8bf3e9849b43e6982");   //send request
			  JNode weather = userAgent.json.findFirst("weather");
			  str = "Weather Conditions: " + weather.findFirst("description");
			  weather = userAgent.json.getFirst("main");
			  str += "    Temperature: " + (weather.findFirst("temp").toLong()-273) + " degree(s) Celsius";
		} catch(JauntException e){         //if an HTTP/connection error occurs, handle JauntException.
			System.err.println(e);
		}
		return str;
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
