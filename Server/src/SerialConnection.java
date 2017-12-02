import com.pi4j.io.serial.Serial;
import com.pi4j.io.serial.SerialFactory;
import com.pi4j.io.serial.SerialPortException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Write data, from the Raspberry to the Arduino, through the serial port.
 * Receives a response from the Arduino.
 */
public class SerialConnection {
 
    public String payload;
    public String request;
    public static int received = 1;
    public Serial serial;
    
    public SerialConnection(){
        this.serial = SerialFactory.createInstance();
        
        serial.addListener(event -> {
            // print out the data received to the console
	            try {
	                payload = event.getAsciiString();
	                System.out.println(payload);
	                received = 1;
	            } catch (IOException ioe) {
	                throw new RuntimeException(ioe);
	            }
        });
        
        String port = System.getProperty("serial.port", "/dev/ttyACM0");
        int br = Integer.parseInt(System.getProperty("baud.rate", "9600"));
        // create an instance of the serial communications class
        // create and register the serial data listener
        
        try {
            try {
                serial.open(port, br);
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
            }
        } catch (SerialPortException ex) {
            System.out.println(" ==>> SERIAL SETUP FAILED : " + ex.getMessage());
            return;
        }
        
    }
    
    public void request(String req){
            try {
                serial.write(req);
            } catch (IllegalStateException ex) {
                ex.printStackTrace();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }

            
            while(received == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
            }
        //System.exit(0);
    }
    
    public String sendRequest(String s){
       received = 0;
       request(s);
       return payload;
    }
    
    
}