package ics211;

public interface Stack211<E> {
	boolean empty();
	E peek();
	E pop();
	E push(E item);
}
