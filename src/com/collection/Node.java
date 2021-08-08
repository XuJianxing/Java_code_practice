package com.collection;

public class Node<E> {
    // list 里的 Node

    E element;
    Node<E> next;
    Node<E> previous;

    Node(Node<E> previous, E element, Node<E> next) {
        this.element = element;
        this.next = next;
        this.previous = previous;
    }

}
