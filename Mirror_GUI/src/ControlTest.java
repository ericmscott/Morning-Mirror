import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;



public class ControlTest {
	
	
	
	

	@Test
	public void testUpdateTime() {
		
		Control test = new Control();
		Time newTime =new Time(0,0,1,13,11,2017);
		final String expected="11/13/2017  1:0:0";
		System.out.println("Testing updateTime.");
		
		test.updateTime(newTime);
		Assert.assertEquals(expected,test.getTime().toString());
		
			
	}

	@Test
	public void testUpdateTimeWrongHour() {
		
		Control test = new Control();
		Time newtime=new Time(0,0,26,13,11,2017);
		
		
		test.updateTime(newtime);
		Assert.assertFalse(test.getTime().getHour()<24);
		System.out.println("Testing updateTime with wrong hour.");
		
		
		
	}
	
	@Test
	public void testUpdateNews() {
		
		Control test = new Control();
		News newNews=new News("Today's News","Today is going to be great.");
		final String Headline="Today's News";
		final String Content="Today is going to be great.";
		
		test.updateNews(newNews);
		Assert.assertSame(Headline,test.getNews().getHeadline());
		Assert.assertSame(Content,test.getNews().getContent());
		System.out.println("Testing updatenews");
		
		
		
	}
	@Test
	public void testUpdateNewsfail() {
		
		Control test = new Control();

		
		final String newNews = "Today’s News";
		final String Headline="Today's News";
		final String Content="Today is going to be great";
		
		test.updateNews(newNews);
		Assert.assertNotSame(Content,test.getNews().getContent());
		System.out.println("Testing updatenews");
		
		//fail("news did not update");
		
		
		
	}
	@Test
	public void testUpdateIndoorTemp() {
		
		Control test = new Control();
		float newTemp= 2.0f;
		
		test.updateindoorTemp(newTemp);
		Assert.assertEquals(newTemp,test.getIndoorTemp(),0.0f);
		System.out.println("Testing updateIndoorTemp");
		
		
		
	}
	@Test
	public void testUpdateOutdoorTemp() {
		
		Control test = new Control();
		float newTemp= 2.0f;
		
		test.updateOutdoorTemp(newTemp);
		Assert.assertEquals(newTemp,test.getOutdoorTemp(),0.0f);
		System.out.println("Testing updateOutdoorTemp");
		
		
		
	}
	@Test
	public void testUpdateSleepQuality() {
		
		Control test = new Control();
		float newSleepQuality= 3;
		
		test.updateOutdoorTemp(newSleepQuality);
		Assert.assertEquals(newSleepQuality,test.getSleepQuality());
		System.out.println("Testing updateSleepQuality");
		
		
		
	}
	@Test
	public void testUpdateBusData() {
		
		Control test = new Control();
		Bus newBus = new Bus(85);
		newBus.setNextBus(5, -1, -1);
		final String expected="Bus Number: 85 Next Bus 1: 5";
		//System.out.println("Testing updateTime.");
		
		test.updateBusData(newBus);
		Assert.assertSame(expected,test.getBus().toString());
		
			
	}
	@Test
	public void testUpdateBusDataFail() {
		
		Control test = new Control();
		Bus newBus = new Bus(85);
		newBus.setNextBus(-5, -1, -1);
		//final String expected="Bus Number: 85 Next Bus 1: 5";
		//System.out.println("Testing updateTime.");
		
		test.updateBusData(newBus);
		Assert.assertFalse(test.getBus().getNextBus1()>0);
		
	}
	@Test
	public void testUpdateTimeToLeave() {
		
		Control test = new Control();
		Time newTimeToLeave =new Time(0,0,1,13,11,2017);
		final String expected="11/13/2017  1:0:0";
		//;System.out.println("Testing updateTimeToLeave.");
		
		test.updateTimeToLeave(newTimeToLeave);
		Assert.assertEquals(expected,test.getTimeToLeave().toString());
		
			
	}
}
