import java.net.*;
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
	public void reciveRequest(void) {
		//TODO
	}
	private final static int PACKETSIZE = 100 ;

	public static void main( String args[] )
	{ 
	      // Check the arguments
	      if( args.length != 1 )
	      {
	         System.out.println( "usage: UDPReceiver port" ) ;
	         return ;
	      }
	      try
	      {
	         // Convert the argument to ensure that is it valid
	         int port = Integer.parseInt( args[0] ) ;

	         // Construct the socket
	         DatagramSocket socket = new DatagramSocket( port ) ;

	         for( ;; )
	         {
		        System.out.println( "Receiving on port " + port ) ;
		        DatagramPacket packet = new DatagramPacket( new byte[PACKETSIZE], PACKETSIZE ) ;
	            socket.receive( packet ) ;

	            //System.out.println( packet.getAddress() + " " + packet.getPort() + ": " + new String(packet.getData()).trim() ) ;
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
	     }
	     catch( Exception e )
	     {
	        System.out.println( e ) ;
	     }
  }
}
