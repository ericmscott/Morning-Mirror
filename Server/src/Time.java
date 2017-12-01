
public class Time {
	
	private int second; 
	private int minute;
	private int hour;
	private int day; 
	private int month; 
	private int year; 
	
	public Time(int second, int minute, int hour, int day, int month, int year){
		this.second = second;
		this.minute = minute;
		this.hour = hour;
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public String toString(){
		String string = new String(month+"/"+day+"/"+year+"  " + hour + ":" + minute + ":" + second);
		return string;
	}
	
}
