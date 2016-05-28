package com.entrust.trials;

import java.awt.Point;
public class PolynomialTimeSumMatrix {
	private static final int[][] rating = { {3,5,7,9}, {4,2,7,8}};
	
	public int pointsCalculate(Point nTopLeft,Point nBottomRight){
		int sum=0;
		for (int i=nTopLeft.x;i<=nBottomRight.x;i++){
			for (int j=nTopLeft.y;j<=nBottomRight.y;j++){
				System.out.println("Element:"+rating[i][j]);
				sum+=rating[i][j];
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		for (int i =0;i<rating.length;i++){
			for (int j=0;j<rating[i].length;j++){
				System.out.printf("%4d",rating[i][j]);
			}	
			System.out.println();
		}
		Point topLeft = new Point(0,1);
		Point bottomRight = new Point(1,3);
		PolynomialTimeSumMatrix matrx = new PolynomialTimeSumMatrix();
		System.out.println(matrx.pointsCalculate(topLeft, bottomRight));
		
	}
}
