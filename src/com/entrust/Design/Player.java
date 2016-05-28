package com.entrust.Design;

public class Player {
	private String name;
	private int coin;
	
	public Player(String name,int coin){
		this.name=name;
		this.coin=coin;
	}
	
	public String getName(){
		return name;
	}

	public int getCoin(){
		return coin;
	}
	
}
