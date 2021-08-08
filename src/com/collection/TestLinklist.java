package com.collection;

import java.util.LinkedList;

public class TestLinklist<E> {
    private Node<E> first;
    private Node<E> last;
    private int size;

    public boolean get(int index){
        if(index<0||index>size-1){
            // throw new RuntimeException("index out of boundary");
            return false;
        }
        if (index < (size >> 1)) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return true;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.previous;
            return true;
        }
    }
    public void add(E e){
        Node<E> node = new Node<>(first,e,null);
        if(first==null){
            // node.previous = null;
            // node.next = null;
            first = node;
            last = node;
        }else {
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }
        size++;
    }

}

