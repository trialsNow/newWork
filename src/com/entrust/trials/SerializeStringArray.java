package com.entrust.trials;

import java.io.*;
import java.util.*;

public class SerializeStringArray {
	public static void stringArrayTest() throws IOException, ClassNotFoundException {
	    String[] strs = new String[] {"test 1", "test 2", "test 3"};
	    System.out.println(Arrays.toString(strs));

	    // serialize
	    ByteArrayOutputStream out = new ByteArrayOutputStream();
	    new ObjectOutputStream(out).writeObject(strs);

	    // your string
	    String yourString = new String(Base64.getEncoder().encode(out.toByteArray()));
	    System.out.println(yourString);

	    // deserialize
	    ByteArrayInputStream in = new ByteArrayInputStream(Base64.getDecoder().decode(yourString.getBytes()));
	    System.out.println(Arrays.toString((String[]) new ObjectInputStream(in).readObject()));
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		stringArrayTest();
	}
}
