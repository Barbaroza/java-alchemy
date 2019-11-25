package com.pmb.structure.flyweight;

public interface ChessFlyWeight {
	void setColor(String color);
	String getColor();
	void disPlay(Coordinate c);
}

class ConcreteChess implements ChessFlyWeight {
	
	private String color;
	
	public ConcreteChess(String color) {
		this.color = color;
	}

	@Override
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String getColor() {
		return color;
	}

	@Override
	public void disPlay(Coordinate c) {
		System.out.println("棋子颜色"+this.getColor());
		System.out.println("棋子位置"+c);
	}
	
} 