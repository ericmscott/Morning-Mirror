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
		float newTemp= 2.0;
		
		test.updateNews(newNews);
		Assert.assertSame(Headline,test.getNews().getHeadline());
		Assert.assertSame(Content,test.getNews().getContent());
		System.out.println("Testing updatenews");
		
		
		
	}
}
