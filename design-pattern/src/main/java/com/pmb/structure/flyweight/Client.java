package com.pmb.structure.flyweight;

public class Client {
	public static void main(String[] args) {
		
		ChessFlyWeight chess1 = ChessFlyWeigthFactory.getChess("黑色");
		ChessFlyWeight chess2 = ChessFlyWeigthFactory.getChess("黑色");
		System.out.println(chess1);
		System.out.println(chess2);
		
		chess1.disPlay(new Coordinate(12,8));
		chess1.disPlay(new Coordinate(15,19));
		
	}
}
