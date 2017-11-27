import java.net.*;

public class UDPSender {

	private int rpiPort = 50000;
	private String hostName = "10.0.0.23";
	
	public void sendMessage(String message){
	      DatagramSocket socket = null ;
	      try
	      {
	         InetAddress host = InetAddress.getByName( hostName ) ;
	         int port = rpiPort;
	         socket = new DatagramSocket() ;

       		 if (message.length()==0) return;
    		 byte [] data = message.getBytes() ;
    		 DatagramPacket packet = new DatagramPacket( data, data.length, host, port ) ;
    		 socket.send( packet ); 
	         System.out.println ("Closing down");
	      }
	      catch( Exception e )
	      {
	         System.out.println( e ) ;
	      }
	      finally
	      {
	         if( socket != null )
	            socket.close() ;
      }
   }
}

