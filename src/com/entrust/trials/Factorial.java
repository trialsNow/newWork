package com.entrust.trials;

import java.util.*;
public class Factorial {

public static void main (String[] args){

Scanner scan = new Scanner(System.in);
System.out.println ("Enter a number for factorial calculation:");
int number = scan.nextInt();
int result = computeFactorial (number);
System.out.println ("Result:"+ result);
}

private static int computeFactorial(int i) {
if (i==1) { return  0;}
else {
int factorial = i * computeFactorial(i-1);
return factorial;
}
}
}