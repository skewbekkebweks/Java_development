package com.example.java_development.module4;

import androidx.annotation.NonNull;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public String toString() {
        String s = "[";
        Node<T> cur = head;
        while (cur != null) {
            s += cur;
            if (cur != tail) {
                s += ", ";
            }
            cur = cur.getNext();
        }

        s += "]";
        return s;
    }

    public void add(T value) {
        Node<T> node = new Node<>();
        node.setValue(value);
        if (tail != null) {
            tail.setNext(node);
        }
        tail = node;
        if (head == null) {
            head = node;
        }
        size++;
    }

    public T get(int i) {
        Node<T> cur;
        cur = head;
        for (int j = 1; j <= i; j++) {
            cur = cur.getNext();
        }
        return cur.getValue();
    }

    public void remove(int i) {
        if (i >= size || i < 0) throw new ArrayIndexOutOfBoundsException();
        Node<T> prev;
        if (i == 0) {
            head = head.getNext();
            prev = head;
        } else {
            prev = head;
            for (int j = 1; j < i; j++) {
                prev = prev.getNext();
            }
            prev.setNext(prev.getNext().getNext());
        }
        if (i == size - 1) tail = prev;
        size--;
    }

    public int getSize() {
        return size;
    }

    @NonNull
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> cursor = head;
            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public T next() {
                T value = cursor.getValue();
                cursor = cursor.getNext();
                return value;
            }
        };
    }
}
