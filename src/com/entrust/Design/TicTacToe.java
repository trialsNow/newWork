package com.entrust.Design;

import java.util.*;
public class TicTacToe {
   
	public static void main(String[] args){
		Player p1 = new Player("Rathna",1);
		Player p2 = new Player("Hemanth",-1);
		Board board= new Board(new int[3][3],3);
		Scanner sc = new Scanner(System.in);
		BoardState state = board.initializeBoard();
		while (state.equals(BoardState.CONTINUE)){	
			board.printBoard();
			System.out.println("Player 1,Enter the coordinates:");
			String coordinates = sc.nextLine();
			String[] strSplit= coordinates.split("\\s");
			state = goGame(board,p1,strSplit);
			if (!state.equals(BoardState.CONTINUE)){
				break;
			}
			board.printBoard();
			System.out.println("Player 2,Enter the coordinates:");
			coordinates = sc.nextLine();
			strSplit= coordinates.split("\\s");
			state = goGame(board,p2,strSplit);
			if (!state.equals(BoardState.CONTINUE)){
				break;
			}
		}
		
	}
	
	private static BoardState goGame(Board board,Player player,String[] input){
		BoardState state= board.makeMove(Integer.parseInt(input[0]), Integer.parseInt(input[1]), player.getCoin());
		if (state.equals(BoardState.CONFLICT)){
			board.printBoard();
			System.out.println("Cant be same coordinates."+player.getName()+" Disqualified!!");
			 return BoardState.FINISHED;
		}
		int result = board.checkWinPosition();
		if (result!=0){
			board.printBoard();
			System.out.println(player.getName().toUpperCase()+" WON THE GAME!!!");
			 return BoardState.FINISHED;
		} 
		if (state.equals(BoardState.FINISHED)){
			board.printBoard();
			System.out.println("No More Moves.Its a Draw!!");
			state= BoardState.FINISHED;
		}
		return state;
	}
	

	
	
}
