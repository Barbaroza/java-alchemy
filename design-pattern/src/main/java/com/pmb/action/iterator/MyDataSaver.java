package com.pmb.action.iterator;

import java.util.ArrayList;
import java.util.List;

public class MyDataSaver {
	
	private List<Object> list = new ArrayList<>();

	public MyDataSaver() {
		super();
	}
	
	public void removeObject(Object obj){
		list.remove(obj);
	}
	
	public void addObject(Object obj){
		list.add(obj);
	}
	
	public MyIterator getIterator(){
		return new CurrentIterator();
	}
	
	private class CurrentIterator implements MyIterator {
		
		private int cursor;
		
		@Override
		public void first() {
			cursor = 0;
		}

		@Override
		public void last() {
			cursor = list.size() -1;
		}

		@Override
		public boolean hasNext() {
			return cursor<list.size()-1?true:false;
		}

		@Override
		public void next() {
			cursor++;
		}

		@Override
		public Object getCurrentObject() {
			return list.get(cursor);
		}
	}

}
