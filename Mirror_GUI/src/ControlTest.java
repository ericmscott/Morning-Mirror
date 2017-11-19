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
		
		
		
		Assert.assertFalse(test.updateTime(newtime));
		//System.out.println("Testing updateTime with wrong hour.");
		
		
		
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
		//System.out.println("Testing updatenews");
		
		
		
	}
	@Test
	public void testUpdateNewsfail() {
		
		Control test = new Control();

		News newNews= new News("","");
		
		
		Assert.assertFalse(test.updateNews(newNews));
		//System.out.println("Testing updatenews");
		
		
		
		
		
	}
	@Test
	public void testUpdateIndoorTemp() {
		
		Control test = new Control();
		float newTemp= 2.0f;
		
		test.updateindoorTemp(newTemp);
		Assert.assertEquals(newTemp,test.getIndoorTemp(),0.0f);
		//System.out.println("Testing updateIndoorTemp");
		
		
		
	}
	@Test
	public void testUpdateIndoorTempExtremeTemp() {
		
		Control test = new Control();
		float newTemp= 45.0f;
		
		
		Assert.assertFalse(test.updateindoorTemp(newTemp));
		
		
		
		//System.out.println("Testing updateIndoorTemp with extreme temp");
		
		
		
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
	public void testUpdateOutdoorTempExtremeTemp() {
		
		
			
			Control test = new Control();
			float newTemp= 45.0f;
			
			
			Assert.assertFalse(test.updateindoorTemp(newTemp));
			
			
			
			//System.out.println("Testing updateIndoorTemp with extreme temp");
			
			
			
		
		
	}
	@Test
	public void testUpdateSleepQuality() {
		
		Control test = new Control();
		int newSleepQuality= 3;
		
		test.updateSleepQuality(newSleepQuality);
		Assert.assertEquals(newSleepQuality,test.getSleepQuality());
		//System.out.println("Testing updateSleepQuality");
		
		
		
	}
	@Test
	public void testUpdatesleepQualityOutOfRange() {
		
		Control test = new Control();
		int newSleepQuality= 11;
		
		
		Assert.assertFalse(test.updateSleepQuality(newSleepQuality));
		
		
		
		//System.out.println("Testing updateSleep Quality with int out of range");
		
		
		
	}
	@Test
	public void testUpdateBusData() {
		
		Control test = new Control();
		Bus newBus = new Bus(85);
		newBus.setNextBus(5, -1, -1);
		//final String expected="Bus Number: 85 Next Bus 1: 5";
		
		
		
		Assert.assertTrue(test.updateBusData(newBus));
		
			
	}
	@Test
	public void testUpdateBusDataFail() {
		
		Control test = new Control();
		Bus newBus = new Bus(85);
		newBus.setNextBus(-5, -1, -1);
		
		
		Assert.assertFalse(test.updateBusData(newBus));
		
	}
	@Test
	public void testUpdateTimeToLeave() {
		
		Control test = new Control();
		Time newTimeToLeave =new Time(0,0,1,13,11,2017);
		final String expected="11/13/2017  1:0:0";
		
		
		test.updateTimeToLeave(newTimeToLeave);
		Assert.assertEquals(expected,test.getTimeToLeave().toString());
		
			
	}
	@Test
	public void testUpdateTimeToLeaveWrongHour() {
		
		Control test = new Control();
		Time newtime=new Time(0,0,26,13,11,2017);
		
		
		
		Assert.assertFalse(test.updateTimeToLeave(newtime));
		//System.out.println("Testing updateTimeToLeave with wrong hour.");
		
		
		
	}
}
