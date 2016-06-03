package com.entrust.trials;

/**
 * The "Java letters" include uppercase and lowercase ASCII Latin letters 
 * A-Z (\u0041-\u005a), 
 * and a-z (\u0061-\u007a), and, for historical reasons, 
 (_,or \u005f) and dollar sign ($, or \u0024). 
The "Java digits" include the ASCII digits 0-9 (\u0030-\u0039).
 * @author rathna
 *
 */
public class UniCodeAsciiPractice {
	//static final \u0069nt \u611b = 3;
	public static void main(String[] args) {
		int bitmask = 0x6400;
        int val = 0x2222;
        int binaryVal= 0b110101010;
        int x =10;
        //System.out.println(x>>2);
        int binaryVal2= 0b1110;
        int y =-20;
        System.out.println(Integer.toBinaryString(y));
        System.out.println(Integer.toBinaryString(2));
        System.out.println(Integer.toBinaryString(y^2));
        System.out.println(y^2);
        System.out.println(40<<3);
        System.out.println(40>>3);
        System.out.println(Integer.toString(binaryVal));
        System.out.println(1>>2);
        System.out.println((~0<<2));
        System.out.println(0b1011 & (~0<<2));
        System.out.println(getBit(10,1));
        System.out.println(clearBitMSBthroughI(10,1));
        //System.out.println(Integer.toBinaryString(val));
        //System.out.println(val & bitmask);
		//System.out.println( \u611b );
	}
	
	static boolean getBit(int num,int i){
		return ((num & (1<<i)))!=0;
	}
	
	static int clearBitMSBthroughI(int num,int i){
		int mask = (1<< (i+1))-1;
		return num & mask;
	}

}
