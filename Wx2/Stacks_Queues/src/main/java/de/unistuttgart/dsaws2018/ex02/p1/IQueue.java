package de.unistuttgart.dsaws2018.ex02.p1;

public interface IQueue<T> {
	
	/** Enqueues an element */
	public void enqueue(T t);
	/** Dequeues the first element */
	public T dequeue();
	/** Returns the first element */
	public T front();
	/** Checks if the queue is empty */
	public boolean isEmpty();
	
}
