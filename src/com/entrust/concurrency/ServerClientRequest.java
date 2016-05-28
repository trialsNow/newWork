package com.entrust.concurrency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.*;

import com.entrust.trials.SocketInterface;

public class ServerClientRequest implements SocketInterface {
	private static int requestCount=0;
	private Timer timer = new Timer();
	
    public static void main(String[] args) throws IOException {
    	ServerClientRequest req = new ServerClientRequest();
    	req.sendRequest();
        req.processRequest();
    }

    public void sendRequest() {
    	ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    		Runnable periodicTask = new Runnable() {
    		    public void run() {
    		    	  try {
    	                    Socket s = new Socket("localhost", 8082);
    	                    BufferedWriter out = new BufferedWriter(
    	                            new OutputStreamWriter(s.getOutputStream()));
    	                    
    	                    while (true) {
    	                        out.write("Request Sent");
    	                        out.newLine();
    	                        out.flush();
    	                        Thread.sleep(4000);
    	                    }

    	                } catch (UnknownHostException e) {
    	                    e.printStackTrace();
    	                } catch (IOException e) {
    	                    e.printStackTrace();
    	                } catch (InterruptedException e) {
    	                    e.printStackTrace();
    	                }
    		    }
    		};
    		executor.execute(periodicTask);

    }

    public void processRequest() {
 
        (new Thread() {
            @Override
            public void run() {
                ServerSocket ss;
                try {
                    ss = new ServerSocket(8082);

                    Socket s = ss.accept();

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(s.getInputStream()));
                    String line = null;
                    // Check time every 1 minute
                    timer.scheduleAtFixedRate(new TimerTask() {
                    	  @Override
                    	  public void run() {
                             System.out.println("Request Per min:"+getNumberOfRequestsInAMinute());
                    	  }
                    	}, 1*60*1000,1*60*1000);
                    while ((line = in.readLine()) != null) {
                    	trackRequests();
                        System.out.println("Request Received at:"+LocalTime.now());
                    }
                    
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
    
    @Override
    public void trackRequests(){
    	requestCount++;
    }
    
    @Override
    public int getNumberOfRequestsInAMinute(){
    	int lastReqCount = requestCount;
    	requestCount=0;
    	return lastReqCount;
    	
    }
}