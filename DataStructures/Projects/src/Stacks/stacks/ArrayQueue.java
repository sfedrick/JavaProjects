/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
//package net.datastructures;
package homework4.stacks;


/**
 * Implementation of the queue ADT using a fixed-length array. All
 * operations are performed in constant time. An exception is thrown
 * if an enqueue operation is attempted when the size of the queue is
 * equal to the length of the array.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */

public class ArrayQueue<E> implements Queue<E> {
  // instance variables
  /** Default array capacity. */
  public static int CAPACITY = 1000;      // default array capacity

  /** Generics  used for storage of queue elements. */
  private ArrayStack<E> buffer;                             // generic array used for storage
  private ArrayStack<E> finish; 
  
  /** update the que will tell if buffer needs to be reversed instead of reversing after every enque*/
  
  /** Current number of elements in the queue. */
  private int sz = 0;                           // current number of elements

  // constructors
  /** Constructs an empty queue using the default array capacity. */
  public ArrayQueue() {this(CAPACITY);}         // constructs queue with default capacity

  /**
   * Constructs and empty queue with the given array capacity.
   * @param capacity length of the underlying array
   */
  @SuppressWarnings({"unchecked"})
  public ArrayQueue(int capacity) {             
	// constructs queue with given capacity
	CAPACITY=capacity;
    buffer = new ArrayStack<>(capacity); 
    finish = new ArrayStack<>(capacity); 
  }

  // methods
  /**
   * Returns the number of elements in the queue.
   * @return number of elements in the queue
   */
  @Override
  public int size() { return sz; }

  /** Tests whether the queue is empty. */
  @Override
  public boolean isEmpty() { return (sz == 0); }

  /**
   * Inserts an element at the rear of the queue.
   * This method runs in O(1) time.
   * @param e   new element to be inserted
   * @throws IllegalStateException if the array storing the elements is full
   */
  @Override
  public void enqueue(E e) throws IllegalStateException {
    if (sz == CAPACITY) throw new IllegalStateException("Queue is full");
    
    buffer.push(e);
    sz++;
  }

  /**
   * Returns, but does not remove, the first element of the queue.
   * @return the first element of the queue (or null if empty)
   */
  @Override
  public E first() {
    if (isEmpty()) return null;
    if(buffer.isEmpty()) {
    	return finish.top();
    }
    else {
    	reverse();
    	return finish.top();
    }
    
  }

  /**
   * Removes and returns the first element of the queue.
   * @return element removed (or null if empty)
   */
  @Override
  public E dequeue(){
	 if(isEmpty()) {
		 return null;
	 }
	 else if(buffer.isEmpty()) {
		sz--;
		return finish.pop();
		
	}
	else {
		reverse();
		sz--;
		return finish.pop();
		
	}
  
  }
  private void reverse(){
	  while(finish.top()!=null) {
		 
		  buffer.push(finish.pop());
		 
	  }
	  while(buffer.top()!=null) {
		  
		  finish.push(buffer.pop());
	  }
	  
  }
  /**
   * Returns a string representation of the queue as a list of elements.
   * This method runs in O(n) time, where n is the size of the queue.
   * @return textual representation of the queue.
   */
  public String toString() {
    
    if(buffer.isEmpty()) {
  		  return finish.toString();
  	  
    }
    else {
    	reverse();
    	return finish.toString();
    }
    
   
  }
}
