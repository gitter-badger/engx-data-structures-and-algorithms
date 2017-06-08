package com.stassarosek.engx.datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Stas Sarosek (stas.sarosek@gmail.com)
 */
public class Queue<T> implements Iterable<T> {
  private Node<T> first = null;
  private Node<T> last = null;
  private int size = 0;

  public boolean isEmpty() {
    return first == null;
  }

  public int size() {
    return size;
  }

  public void enqueue(T item) {
    if (item == null) {
      throw new NullPointerException();
    }
    Node<T> oldLast = last;
    last = new Node<>(item);
    if (isEmpty()) {
      first = last;
    } else {
      oldLast.next = last;
    }
    size++;
  }

  public T dequeue() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }
    T item = first.item;
    first = first.next;
    if (isEmpty()) {
      last = null;
    }
    size--;
    return item;
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
