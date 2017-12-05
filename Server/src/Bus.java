/**
 * @author: Christopher Morency
 */

public class Bus {
	private int busNumber;
	private int nextBus1 = -1;
	private int nextBus2 = -1; 
	private int nextBus3 = -1;
	
	public Bus(int busNumber){
		this.busNumber = busNumber;
	}
	
	public void setNextBus(int nextBus1, int nextBus2, int nextBus3){
		this.nextBus1 = nextBus1;
		if(!(nextBus2 == -1)) this.nextBus2 = nextBus2;
		if(!(nextBus3 == -1)) this.nextBus3 = nextBus3;
	}
	
	public int getBusNumber(){
		return busNumber;
	}
	
	public String toString(){
		String string = new String("Bus Number: " + busNumber);
		if(!(nextBus1 == -1)) string = string + " Next Bus 1: " + nextBus1;
		if(!(nextBus2 == -1)) string = string + " Next Bus 2: " + nextBus2;
		if(!(nextBus3 == -1)) string = string + " Next Bus 3: " + nextBus3;
		return string;
	}
}
