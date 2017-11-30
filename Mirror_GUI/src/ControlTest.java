import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;



public class ControlTest {
	
	
	/*
	

	@Test
	public void testUpdateTime() {
		//GUI_control_1.1
		Control test = new Control();
		Time newTime =new Time(0,0,1,13,11,2017);
		final String expected="11/13/2017  1:0:0";
		//System.out.println("Testing updateTime.");
		
		test.updateTime(newTime);
		Assert.assertEquals(expected,test.getTime().toString());
		
			
	}

	@Test
	public void testUpdateTimeWrongHour() {
		//GUI_control_1.2
		Control test = new Control();
		Time newtime=new Time(0,0,26,13,11,2017);
		
		
		
		Assert.assertFalse(test.updateTime(newtime));
		//System.out.println("Testing updateTime with wrong hour.");
		
		
		
	}
	
	@Test
	public void testUpdateNews() {
		//GUI_control_2.1
		Control test = new Control();
		News newNews=new News("Today's News","Today is going to be great.");
		final String Headline="Today's News";
		final String Content="Today is going to be great.";
		
		test.updateNews(newNews);
		Assert.assertSame(Headline,test.getNews().getHeadline());
		Assert.assertSame(Content,test.getNews().getContent());
		//System.out.println("Testing updateNews");
		
		
		
	}
	@Test
	public void testUpdateNewsfail() {
		//GUI_control_2.2
		Control test = new Control();

		News newNews= new News("","");
		
		
		Assert.assertFalse(test.updateNews(newNews));
		//System.out.println("Testing updatenewsfail");
		
		
		
		
		
	}
	@Test
	public void testUpdateIndoorTemp() {
		//GUI_control_3.1
		Control test = new Control();
		float newTemp= 2.0f;
		
		test.updateindoorTemp(newTemp);
		Assert.assertEquals(newTemp,test.getIndoorTemp(),0.0f);
		//System.out.println("Testing updateIndoorTemp");
		
		
		
	}
	@Test
	public void testUpdateIndoorTempExtremeTemp() {
		//GUI_control_3.2
		Control test = new Control();
		float newTemp= 45.0f;
		
		
		Assert.assertFalse(test.updateindoorTemp(newTemp));
		
		
		
		//System.out.println("Testing updateIndoorTemp with extreme temp");
		
		
		
	}
	@Test
	public void testUpdateOutdoorTemp() {
		//GUI_control_4.1
		Control test = new Control();
		float newTemp= 2.0f;
		
		test.updateOutdoorTemp(newTemp);
		Assert.assertEquals(newTemp,test.getOutdoorTemp(),0.0f);
		//System.out.println("Testing updateOutdoorTemp");
		
		
		
	}
	@Test
	public void testUpdateOutdoorTempExtremeTemp() {
		//GUI_control_4.2
		
			
			Control test = new Control();
			float newTemp= 45.0f;
			
			
			Assert.assertFalse(test.updateindoorTemp(newTemp));
			
			
			
			//System.out.println("Testing updateIndoorTemp with extreme temp");
			
			
			
		
		
	}
	@Test
	public void testUpdateSleepQuality() {
		//GUI_control_5.1
		Control test = new Control();
		int newSleepQuality= 3;
		
		test.updateSleepQuality(newSleepQuality);
		Assert.assertEquals(newSleepQuality,test.getSleepQuality());
		//System.out.println("Testing updateSleepQuality");
		
		
		
	}
	@Test
	public void testUpdatesleepQualityOutOfRange() {
		//GUI_control_5.2
		Control test = new Control();
		int newSleepQuality= 11;
		
		
		Assert.assertFalse(test.updateSleepQuality(newSleepQuality));
		
		
		
		//System.out.println("Testing updateSleep Quality with int out of range");
		
		
		
	}
	@Test
	public void testUpdateBusData() {
		//GUI_control_6.1
		Control test = new Control();
		Bus newBus = new Bus(85);
		newBus.setNextBus(5, -1, -1);
		//final String expected="Bus Number: 85 Next Bus 1: 5";
		
		
		
		Assert.assertTrue(test.updateBusData(newBus));
		
			
	}
	@Test
	public void testUpdateBusDataFail() {
		//GUI_control_6.2
		Control test = new Control();
		Bus newBus = new Bus(85);
		newBus.setNextBus(-5, -1, -1);
		
		
		Assert.assertFalse(test.updateBusData(newBus));
		
	}
	@Test
	public void testUpdateTimeToLeave() {
		//GUI_control_7.1
		Control test = new Control();
		Time newTimeToLeave =new Time(0,0,1,13,11,2017);
		final String expected="11/13/2017  1:0:0";
		
		
		test.updateTimeToLeave(newTimeToLeave);
		Assert.assertEquals(expected,test.getTimeToLeave().toString());
		
			
	}
	@Test
	public void testUpdateTimeToLeaveWrongHour() {
		//GUI_control_7.2
		Control test = new Control();
		Time newtime=new Time(0,0,26,13,11,2017);
		
		
		
		Assert.assertFalse(test.updateTimeToLeave(newtime));
		//System.out.println("Testing updateTimeToLeave with wrong hour.");
		
		
		
	}*/
}
