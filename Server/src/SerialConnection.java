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
    

    public void request(String req){
        String port = System.getProperty("serial.port", "/dev/ttyACM0");
        int br = Integer.parseInt(System.getProperty("baud.rate", "9600"));
        System.out.println("Serial Communication.");
        System.out.println(" ... connect using settings: " + Integer.toString(br) + ", N, 8, 1.");
        System.out.println(" ... data received on serial port should be displayed below.");
        // create an instance of the serial communications class
        // create and register the serial data listener
        final Serial serial = SerialFactory.createInstance();
        
        serial.addListener(event -> {
            // print out the data received to the console
            try {
                payload = event.getAsciiString();
                System.out.println(payload);
                received = 1;
                
                return;
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
        });

        try {
            System.out.println("Opening port [" + port + ":" + Integer.toString(br) + "]");
            try {
                serial.open(port, br);
            } catch (IOException ioe) {
                throw new RuntimeException(ioe);
            }
            System.out.println("Port is opened.");
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
            }

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
            try {
                serial.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (SerialPortException ex) {
            System.out.println(" ==>> SERIAL SETUP FAILED : " + ex.getMessage());
            return;
        }
        //System.exit(0);
    }

    
    public boolean checkIfReceived(){
        if(received == 0) return false;
        return true;
    }
    
    public String getResponse(){
        return payload;
    }
    
    public String setRequest(String s){
       received = 0;
       request(s);
       return payload;
    }
    
    
}