package de.unistuttgart.dsaws2018.ex01.p3;

import java.util.Iterator;

public interface ISpeedListIterable<T> {
	
	/*
	* Returns an iterator that enumerates every
	* element in the collection, starting with the
	* first element.
	*
	* @return The iterator.
	*/
	public Iterator<T> iterator();
	
	/*
	* Returns an iterator that enumerates every nth
	* element in the collection, starting with the
	* first element .
	*
	* @param n The number of skipped elements+1.
	* @return The iterator.
	* @throws IllegalArgumentException if n is less than 1.
	*/
	public Iterator<T> skippingIterator(int n);
}
