package com.entrust.trials;

import java.awt.Point;
/* I(x,y) = i(x,y) + I(x-1,y) + I(x,y-1) - I(x-1,y-1)
 * I(x,y) = I(D) + I(A) - I(B) - I(C)
 * A     B
 * C     D
 */
public class ConstantTimeSumMatrix {
	private static final int[][] rating = { {3,5,7,9}, {4,2,7,8}};
	
	public static int FindMatrixSubSumStandard(int[][] nMatrix, Point nTopLeft, Point nBottomRight)
	   {
	      int nSum = 0;

	      for (int i = nTopLeft.x; i <= nBottomRight.x; ++i)
	      {
	         for (int j = nTopLeft.y; j <= nBottomRight.y; ++j)
	         {
	            nSum += nMatrix[i][j];
	         }
	      }

	      return nSum;
	   }
	   
	   public static int[][] ComputeMatrixSubSums(int[][] nMatrix)
	   {
	      int nRows = nMatrix.length;
	      int nColumns = nMatrix[0].length;
	      //Shows the computed sums of the rectangle from point 0,0 to here inclusive.
	      int nComputedSums[][] = new int[nRows][nColumns];

	      //Compute sums for the firt row and first column
	      nComputedSums[0][0] = nMatrix[0][0];
	      
	      for (int j = 1; j < nColumns; ++j)
	      {
	         nComputedSums[0][j] = nComputedSums[0][j-1] + nMatrix[0][j];
	      }
	      
	      for (int i = 1; i < nRows; ++i)
	      {
	         nComputedSums[i][0] = nComputedSums[i-1][0] +nMatrix[i][0];
	      }
	      //Compute sums for the rest
	      for (int i = 1; i <  nRows; ++i)
	      {
	         for (int j = 1; j < nColumns; ++j)
	         {
	            nComputedSums[i][j] = nComputedSums[i][j-1] + nComputedSums[i-1][j] -
	               nComputedSums[i-1][j-1] + nMatrix[i][j];
	         }
	      }

	      return nComputedSums;
	   }
	   
	   public static int FindMatrixSubSumByCache(Point nTopLeft, Point nBottomRight, int[][] computedSums)
	   {
	      int d = computedSums[nBottomRight.x][nBottomRight.y];
	      int a= computedSums[nTopLeft.x][nTopLeft.y];
	      int b= computedSums[nTopLeft.x][nBottomRight.y];
	      int c = computedSums[nBottomRight.x][nTopLeft.y];

	      System.out.println(d);
	      System.out.println(a);
	      System.out.println(c);
	      System.out.println(b);
	      return d+a-b-c;
	   }
	public static void main(String[] args) {
		System.out.println("*****Original*******");
		for (int i =0;i<rating.length;i++){
			for (int j=0;j<rating[i].length;j++){
				System.out.printf("%4d",rating[i][j]);
			}	
			System.out.println();
		}
		Point topLeft = new Point(0,1);
		Point bottomRight = new Point(1,3);
		int[][] sum = ConstantTimeSumMatrix.ComputeMatrixSubSums(rating);
		System.out.println("*****Computed Sum*******");
		for (int i =0;i<sum.length;i++){
			for (int j=0;j<sum[i].length;j++){
				System.out.printf("%4d",sum[i][j]);
			}	
			System.out.println();
		}
		
		System.out.println(FindMatrixSubSumByCache(topLeft, bottomRight,sum));

	}

}
