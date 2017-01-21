package ics211;
/**
 * Interface for the array and contact list. 
 * @author Brandon
 *
 * @param <E>
 */
public interface List211<E> {
  boolean add(E e);
  void add(int index, E element);
  E remove(int index);
  E get(int index);
  E set(int index, E element);
  int indexOf(Object obj);
  int size();
}