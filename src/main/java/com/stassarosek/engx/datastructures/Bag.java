package com.stassarosek.engx.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Stas Sarosek (stas.sarosek@gmail.com)
 */
public class Bag<T> implements Iterable<T> {
  private Node<T> first = null;
  private int size = 0;

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return size;
  }

  public void add(T item) {
    if (item == null) {
      throw new NullPointerException();
    }
    Node<T> oldFirst = first;
    first = new Node<>(item);
    first.next = oldFirst;
    size++;
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> current = first;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        if (!hasNext()) {
          throw new NoSuchElementException();
        }
        T item = current.item;
        current = current.next;
        return item;
      }
    };
  }
}
