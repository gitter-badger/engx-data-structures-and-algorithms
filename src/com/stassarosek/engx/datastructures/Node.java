package com.stassarosek.engx.datastructures;

/**
 * @author Stas Sarosek (stas.sarosek@gmail.com)
 */
class Node<T> {
  T item;
  Node<T> next;

  Node(T item) {
    this.item = item;
  }
}
