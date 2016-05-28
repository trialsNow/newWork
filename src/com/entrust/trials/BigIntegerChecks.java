package com.entrust.trials;

import java.math.*;
public class BigIntegerChecks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger b = new BigInteger("-12476767");
		System.out.println(b.add(new BigInteger("12476767")));
		System.out.println(b.signum());
	}

}
