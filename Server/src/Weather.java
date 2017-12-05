/**
 * @author: Christopher Morency
 */

public class Weather {
	
	private String temperature;
	private String weatherConditions;

	public Weather(String temperature, String weatherConditions){
		this.temperature = temperature;
		this.weatherConditions = weatherConditions;
	}

	public String getTemperature(){
		return temperature;
	}
	
	public String getWeatherConditions(){
		return weatherConditions;
	}
	
}
