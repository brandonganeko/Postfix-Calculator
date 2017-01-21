package ics211;
import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack<E> implements Stack211<E>{
	
	private E[] data;
	private int top;
	private int size;

	public ArrayStack() {
		this.data = (E[]) new Object[20];
		this.top = 0;
	}
	
	public boolean empty() {
		return top == 0;
	}
	
	public E peek() {
		if(empty()) {
			throw new EmptyStackException();
		}
		return data[top-1];
	}
	
	public E pop() {
		if(empty()) {
			throw new EmptyStackException();
		}
		return data[top--];
	}

	public E push(E item) {
		if (top == data.length) {
			reallocate();
		}
		data[top++] = item;
		return item;
	}
	
	/**
	 * A method that makes to sure the index is a valid point.
	 * @param index, represents a point in the array.
	 */
	private void checkIndex(int index) {
		if (index < 0 || index >= size) {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	
	/**
	 * A method that sets an object at a certain index. 
	 * @param index, represents a point in the array.
	 * @param element, represents a general object that is being set at the index.
	 */
	public E set(int index, E element) {
		checkIndex(index);
		E old = data[index];
		data[index] = element;
		return old;
	}
	
	/**
	 * A method that finds the index of a certain object. 
	 * @param obj, an object in an array.
	 * @return i
	 * @return -1 
	 */
	public int indexOf(Object obj) {
		for(int i = 0; i < size; i++) {
			if (obj.equals(data[i])) {
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * A method that returns the size of an array.
	 * @return size, the size of the array.
	 */
	public int size(){
		return size;
	}
	
	/**
	 * A method that adds an object at the end of the array list.
	 * @param e, the object being added to the array list. 
	 * @return true
	 */
	public boolean add(E e) {
		if (size == data.length) {
			reallocate();
		}
		data[size] = e;
		size++;
		return true;
	}
	
	/**
	 * A method that doubles the capacity of the array list. 
	 */
	private void reallocate() {
		int capacity = data.length * 2;
		data = Arrays.copyOf(data, capacity);
	}

	/**
	 * A method that adds an object to an index
	 * @param index, represents a point in the array.
	 * @param element, represents a general object that is being set at the index.
	 * */
	public void add(int index, E element) {
		if (index < 0 || index > size) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if (size == data.length) {
			reallocate();
		}
		for (int i = size; i>index; i--) {
			data[i] = data[i-1];
		}
		data[index] = element;
		size++;
	}

	/**
	 * A method that removes an object at a point
	 * @param index, represents a point in the array.
	 * @return returnValue, the value of the item being removed. 
	 */
	public E remove(int index) {
		checkIndex(index);
		E returnValue = data[index];
		for (int i = index; i < size; i++) {
			data[i] = data[i+1];
		}
		size--;
		return returnValue;
	}

	/**
	 * A method that gets the object at the index
	 * @param index, a point in the array.
	 * @return data[index], an object in the data array at the index.
	 */
	public E get(int index) {
		checkIndex(index);
		return data[index];
	}
	
	
}
