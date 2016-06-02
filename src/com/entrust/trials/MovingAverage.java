package com.entrust.trials;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Iterator;
import java.io.DataInputStream;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.DataOutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileOutputStream;
/**
 * Rolling Mean/Moving Average
 * Write to data stream, get from data stream put it in queue and as it goes
 * calculate average. Either from a data file DataInputStream or from a scanner 
 * Buffered Reader (Input Stream reader)
 * @author rathna
 *
 */

public class MovingAverage{
	
	Deque<Double> queue;
	//int windowSize;
	private static final String dataFile ="integerData";
	
	public MovingAverage(){
		this.queue= new LinkedList<>();
		//this.windowSize = windowSize;
	}
   public double readNext(double n){
         int sum=0;
         queue.offer(n);
         Iterator<Double> itr = queue.iterator();
         while(itr.hasNext()){
             sum+=itr.next();
         }
         return (double)sum/queue.size();
     }
   
   public static void main(String[] args) throws IOException{
	   DataOutputStream outData = null;
	   try{
	   outData = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)));
	   long[] coordinates = {10,20,30,50,60,3487684,3768573,546745,495867945,486783456};
	   for (Long i: coordinates){
		   outData.writeLong(i);
	   }
	   }finally{
		   outData.close();
	   }
	   
	   DataInputStream inData = null;
	   MovingAverage avg = new MovingAverage();
	   try {
	   // USing system console
	   BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	   //Or use File values
	   //inData = new DataInputStream(new BufferedInputStream(new FileInputStream(dataFile)));
			   	  try {
			   		while (true){
					   //long fromFile= inData.readLong();
			   			double l = Double.parseDouble(reader.readLine());
					   double average = avg.readNext(l);
					   System.out.println("Moving Average:"+ average);
			   		}
				   
			   	  }catch (EOFException e){ }
	   	
	   }
	   finally{
		   if (inData!=null){
		   inData.close();
		   }
	   }
   }
}
   
