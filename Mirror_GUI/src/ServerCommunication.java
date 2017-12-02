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
	private final static int PACKETSIZE = 1024 ;

	public static void main( String args[] )
	{ 
		Control serverCom = new Control();
		
		for(int i=0; i<2; i++){
		      new Thread("" + i){
		        @SuppressWarnings("static-access")
				public void run(){
		          if(Thread.currentThread().getName().equals("0")){
		        	  while(true){
		        		  try{
		        			 // Start of thread 1 
		        			  
		        			  
		        			  
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
		        						
//		        						float f1 = 1.15f;
		        						
		        						//System.out.println("value of float is:" + Float.toString(f1) );
		        						serverCom.updateTime((new Date()).toString());
		        						switch (type){
		        						case '1': 
		        						float f1 = Float.parseFloat(s.substring(1));
		        						serverCom.updateindoorTemp(f1);
		        						break;
		        						case '2': serverCom.updateOutdoorTemp(s.substring(1));
		        						break;
		        						case '3': serverCom.updateNewsHeadline(s.substring(1));
		        						break;	
		        						case '4': serverCom.updateNewsContent(s.substring(1));
		        						break;
		        						case '5': serverCom.updateOutdoorWeather(s.substring(1));
		        						break;
		        						}


		        					} 
		        					//socket.close();

		        				}
		        				catch( Exception e )
		        				{
		        					//socket.close();
		        					System.out.println( e ) ;
		        				}
		        			  
		        			  
		        			  // End of thread 1
		        			  
		        			  
		        			  
		        		  } catch(Exception e){ 
		        			  System.out.println("GUI receiver Failure");
		        			  try {
								Thread.currentThread().sleep(5000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
		        		  }
		        	  }
		          } else if(Thread.currentThread().getName().equals("1")){
		        	  while(true){
		        		  try{

		        			  serverCom.updateTime((new Date()).toString());
		        			  try {
									Thread.currentThread().sleep(1000);
								} catch (InterruptedException e1) {
									e1.printStackTrace();
								}
		        			  
		        		  } catch(Exception e){ 
		        			  System.out.println("Time Updater Failure");
		        			  try {
								Thread.currentThread().sleep(5000);
							} catch (InterruptedException e1) {
								e1.printStackTrace();
							}
		        		  }
		        	  }
		          }
		        }
		      }.start();
		}
	}
}
