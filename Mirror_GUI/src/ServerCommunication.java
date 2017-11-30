import java.net.*;
import java.util.Date;
public class ServerCommunication {
	//TODO
	/**
	 * Description:
	 * Function which processes requests from the server.
	 * 
	 * Parameters: Void
	 * 
	 * Return: Void
	 */
	public void reciveRequest() {
		//TODO
	}
	private final static int PACKETSIZE = 100 ;

	public static void main( String args[] )
	{ 
		Control serverCom = new Control();
//		float f = (float) 70.0;
//		System.out.println("111");
//		serverCom.updateindoorTemp(f);
		// Check the arguments
		serverCom.updateTime((new Date()).toString());
		if( args.length != 1 )
		{
			System.out.println( "usage: UDPReceiver port" ) ;
		}
		try
		{
			// Convert the argument to ensure that is it valid
			int port = 50000 ;

			// Construct the socket
			DatagramSocket socket = new DatagramSocket( port ) ;

			for( ;; )
			{
				System.out.println( "Receiving on port " + port ) ;
				DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
				socket.receive( packet ) ;

				//serverCom.updateindoorTemp(Float.parseFloat(new String(packet.getData()).trim()));
				System.out.println( packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()).trim() ) ;
				
				byte type = packet.getData()[0];
				
				String s = new String(packet.getData()).trim();
				
//				float f1 = 1.15f;
				
				//System.out.println("value of float is:" + Float.toString(f1) );
				serverCom.updateTime((new Date()).toString());
				switch (type){
				case '1': 
				float f1 = Float.parseFloat(s.substring(1));
				serverCom.updateindoorTemp(f1);
				break;
				case '2': serverCom.updateOutdoorTemp(s.substring(1));
				break;
				case '3': serverCom.updateNewsContent(s.substring(1));
					
				case '4': serverCom.updateNewsHeadline(s.substring(1));
				break;
				
				}
				//TODO
				//parse data 
				/*
				 *set variables from parsed data
				 *
	            if(time!=NULL) {
	            	updateTime(time)
	            }
	            if(news!=NULL) {
	            	updateNews(news)
	            }
	            if(indoorTemp!=NULL){
	            	updateIndoorTemp(indoorTemp)
	            }
	            ...
				 */

			} 
			//socket.close();

		}
		catch( Exception e )
		{
			//socket.close();
			System.out.println( e ) ;
		}

	}
}
