import org.json.*;

public class InternetCommunication {
	
	
	
	public void json(){
			
		      JSONParser parser = new JSONParser();
		      String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";
				
		      try{
		         Object obj = parser.parse(s);
		         JSONArray array = (JSONArray)obj;
					
		         System.out.println("The 2nd element of array");
		         System.out.println(array.get(1));
		         System.out.println();

		         JSONObject obj2 = (JSONObject)array.get(1);
		         System.out.println("Field \"1\"");
		         System.out.println(obj2.get("1"));    

		         s = "{}";
		         obj = parser.parse(s);
		         System.out.println(obj);

		         s = "[5,]";
		         obj = parser.parse(s);
		         System.out.println(obj);

		         s = "[5,,2]";
		         obj = parser.parse(s);
		         System.out.println(obj);
		      }catch(ParseException pe){
				
		         System.out.println("position: " + pe.getPosition());
		         System.out.println(pe);
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
