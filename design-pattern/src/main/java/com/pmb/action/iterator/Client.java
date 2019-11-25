package com.pmb.action.iterator;

public class Client {
	public static void main(String[] args) {
		
		MyDataSaver saver = new MyDataSaver();
		saver.addObject("a");
		saver.addObject("b");
		saver.addObject("c");
		saver.addObject("d");
		
		MyIterator iterator = saver.getIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.getCurrentObject());
			iterator.next();
		}
		
	}
}
