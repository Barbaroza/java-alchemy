package com.pmb.action.iterator;

public interface MyIterator {
	void first();
	void last();
	boolean hasNext();
	void next();
	Object getCurrentObject();
}
