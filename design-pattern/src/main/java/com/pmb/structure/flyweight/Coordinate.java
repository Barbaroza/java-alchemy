package com.pmb.structure.flyweight;

public class Coordinate {
	private int x;
	private int y;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public Coordinate() {
	}
	@Override
	public String toString() {
		return "Coordinate [x=" + x + ", y=" + y + "]";
	}
	
}
