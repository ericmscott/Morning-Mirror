import static org.easymock.EasyMock.*;
import org.easymock.EasyMockRule;
import org.easymock.TestSubject;
import org.easymock.Mock;
import org.junit.Rule;
import org.junit.Test;

public class MockTest {
	
	@Rule
	public EasyMockRule mocks = new EasyMockRule(this);
	
	@TestSubject
	private Control control = new Control();
	
	@Mock
	private AndroidCommunication mock;
	@Mock
	private GUIUpdate mock2;
	@Mock
	private InternetCommunication mock3;
	  
	@Test
	public void test1() {
	
	  expect(mock.getSleepData()).andReturn(new SleepData());
      expect(mock.getWakeUp()).andReturn(new Time(1, 2, 3, 4, 5, 6));
      expect(mock.getBusData()).andReturn(new Bus(7));
      expect(mock.getCurrentLocation()).andReturn(new Location());
      expect(mock.getDestination()).andReturn("destination");
      expect(mock.getDestinationTime()).andReturn(new Time(1, 2, 3, 4, 5, 6));
      replay(mock);
      control.processAndroidData();	 
      verify();
      
	}
	
	@Test
	public void test2() {
		
		  expect(mock3.getWeather()).andReturn((float) 27.3);
	      expect(mock3.getNews()).andReturn(new News("abcd", "efgh"));
	      expect(mock3.getBus(7)).andReturn(new Bus(7));
	      replay(mock3);
	      
	      control.refreshInternetContent();	 
	      verify();
		}

	
}

