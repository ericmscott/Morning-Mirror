
public class Control {
	private News news;
	private float indoorTemp;
	private float outdoorTemp;
	private Time time;
	private Time timeToLeave;
	private int sleepQuality;
	private Bus bus;

	//TODO
	//double check public or private
	public void updateNews(News news) {
		this.news=news;
	}
	public void updateindoorTemp(float temp) {
		indoorTemp=temp;
	}
	public void updateOutdoorTemp(float temp) {
		outdoorTemp= temp;
	}
	public void updateTime(Time time) {
		this.time=time;
	}
	public void updateSleepQuality(int sleepQuality) {
		this.sleepQuality=sleepQuality;
	}
	public void updateBusData(Bus bus) {
		this.bus=bus;
	}
	public void updateTimeToLeave(Time timeToleave) {
		this.timeToLeave=timeToLeave;
	}
	public void testGUI(void) {
		//TODO
	}
}

