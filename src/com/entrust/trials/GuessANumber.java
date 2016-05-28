package com.entrust.trials;

import java.util.Scanner;

public class GuessANumber {
private static Scanner scan; 
public static void main (String args[]){
   scan = new Scanner(System.in);
    System.out.println ("Think about a number from 0 to N:Enter the N value here");
    int resp = scan.nextInt();
    int number = search (0,resp);
    System.out.println("Your number is:"+number);
}

private static int search(int lo,int hi){
    int mid = lo+ (hi-lo)/2;
    if (hi-lo==1){return lo;}
    System.out.println ("Is your number lesser than"+mid+"?(Say true/false)");
    boolean lower = scan.nextBoolean();
    if (lower){
        return search(lo,mid);
    } else {
        return search(mid,hi);
    }
    
    
}
}