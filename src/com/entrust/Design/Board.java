package com.entrust.Design;

import java.util.Arrays;

public class Board {
   int[][] grid;
   int dim;
	
   public Board(int[][] grid,int dim){
	   this.grid=grid;
	   this.dim=dim;
   }
  
	public BoardState initializeBoard(){
		grid = new int[dim][dim];
		for (int[] row:grid){
		Arrays.fill(row, 0);
		}
		return BoardState.CONTINUE;
	}
	
	public BoardState makeMove(int x,int y,int key){
		if (isEmpty(grid[x][y])){
			grid[x][y]=key;
			return isEmptySlotAvailable()? BoardState.CONTINUE:BoardState.FINISHED;
		} 
		return BoardState.CONFLICT;
	}
	public int checkWinPosition(){
		return Math.max(calculateDiagonalSum(), calculateRowColSum());
	}
	
	public int calculateDiagonalSum(){
		int sum=0;
		for(int r=0; r<grid.length; r++) {
		       for(int c=0; c<grid[r].length; c++){
		    	   if (r==c){
		    		   sum+=grid[r][c];  
		    	   }
				if (Math.abs(sum)==dim){
					return sum;
				}
			}
		}
		return 0;
	}
	
	private int calculateRowColSum(){
		for(int r=0; r<grid.length; r++) {
			int sum=0;
		       for(int c=0; c<grid[r].length; c++){
				sum+=grid[r][c];
				if (Math.abs(sum)==dim){
					return sum;
				}
			}
		}
		return 0;
	}
	
	public boolean isEmptySlotAvailable(){
		for(int r=0; r<grid.length; r++) {
		       for(int c=0; c<grid[r].length; c++){
				if (isEmpty(grid[r][c])){
					return true;
				}
			}
		}
		return false;
	}
	
	public void printBoard(){
		 for(int r=0; r<grid.length; r++) {
		       for(int c=0; c<grid[r].length; c++)
		           System.out.print(grid[r][c] + " ");
		       System.out.println();
		    }
	}
	
	private boolean isEmpty(int n){
		return n==0; 
	}
	
}
