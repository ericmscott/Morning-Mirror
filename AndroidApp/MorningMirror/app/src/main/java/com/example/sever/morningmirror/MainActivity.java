//Author: Sever Hussein
package com.example.sever.morningmirror;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

 public class MainActivity extends AppCompatActivity {
     //when the App first starts, this method is run.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set title bar color
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#34c3ad"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        //create event listener for button
        final Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView tv = (TextView)findViewById(R.id.textView);
                //when the button is clicked, send udp message to server
                runUdpClient();
                tv.setText("Alarm Time has been sent to Morning Mirror.");
            }
        });
    }
    @TargetApi(23)
    /*
    This function gets the time from the TimePicker and converts it to bytes.
     */
    private byte[] getTime() {
        final TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);

        byte time[] = new byte[2];
        time[0] = (byte)timePicker.getHour();
        time[1] = (byte)timePicker.getMinute();

        return time;
    }

    private static final int UDP_SERVER_PORT = 3000;
    /*
    This function opens a socket, and sends a message to the IP of the RPi Server.
    The message contains the alarm time the user wants to wake up.
    */
    private void runUdpClient()  {
        //get Time and store it in byte array
        byte udpMsg[] =getTime();

        DatagramSocket socket = null;
        try {
            //create new socket and put time into datagram packet
            socket = new DatagramSocket();
            InetAddress serverAddr = InetAddress.getByName("172.20.10.7");
            DatagramPacket dp;
            dp = new DatagramPacket(udpMsg,udpMsg.length, serverAddr, UDP_SERVER_PORT);
            //send packet
            socket.send(dp);

        }catch (IOException e) {
            //catch exceptions
            e.printStackTrace();
        }finally {
            //close socket
            if (socket != null) {
                socket.close();
            }
        }
    }
}
