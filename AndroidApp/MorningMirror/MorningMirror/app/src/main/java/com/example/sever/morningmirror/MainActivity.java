 package com.example.sever.morningmirror;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

 public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set title bar color
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#34c3ad"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);

        //create listener for button
        final Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                runUdpClient();
            }
        });



    }
    @TargetApi(23)
    private String getTime() {
        final TimePicker timePicker = (TimePicker)findViewById(R.id.timePicker);
        String time = "";
        String am_pm = (timePicker.getHour() < 12) ? "AM" : "PM";
        int hour = timePicker.getHour();
        int min = timePicker.getMinute();
        if(am_pm.equals("PM")) {
            if(timePicker.getHour()==12)
                time+= Integer.toString(hour); //change so not using 24 hour clock
            else
                time+= Integer.toString(hour-12); //change so not using 24 hour clock
        }
        else{
            if(timePicker.getHour()==0)
                time+= Integer.toString(12); //change so not using 24 hour clock
            else
                time+= Integer.toString(hour); //change so not using 24 hour clock

        }


        time+=':';
        if(min< 10)
            time += '0';

        time+= Integer.toString(min);
        time+= am_pm;

        return time;
    }
    private static final int UDP_SERVER_PORT = 3000;
    private void runUdpClient()  {
        String udpMsg =getTime();
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress serverAddr = InetAddress.getByName("172.20.10.7");
            DatagramPacket dp;
            dp = new DatagramPacket(udpMsg.getBytes(), udpMsg.length(), serverAddr, UDP_SERVER_PORT);
            socket.send(dp);
        }catch (SocketException e) {
            e.printStackTrace();
        }catch (UnknownHostException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (socket != null) {
                socket.close();
            }
        }
    }


}
