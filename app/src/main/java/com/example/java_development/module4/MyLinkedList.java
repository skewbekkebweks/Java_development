package com.example.java_development.module4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<T> implements List<T> {
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

    public boolean add(T value) {
        Node<T> node = new Node<>();
        node.setValue(value);
        if (tail != null) {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
        if (head == null) {
            head = node;
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(@Nullable Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean addAll(@NonNull Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean addAll(int i, @NonNull Collection<? extends T> collection) {
        return false;
    }

    @Override
    public boolean removeAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public boolean retainAll(@NonNull Collection<?> collection) {
        return false;
    }

    @Override
    public void clear() {

    }

    public T get(int i) {
        Node<T> cur;
        cur = head;
        for (int j = 1; j <= i; j++) {
            cur = cur.getNext();
        }
        return cur.getValue();
    }

    @Override
    public T set(int i, T t) {
        return null;
    }

    @Override
    public void add(int i, T t) {

    }

    public T remove(int i) {
        if (i >= size || i < 0) {
//            throw new ArrayIndexOutOfBoundsException();
            return null;
        }
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
        return null;
    }

    @Override
    public int indexOf(@Nullable Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(@Nullable Object o) {
        return 0;
    }

    @NonNull
    @Override
    public ListIterator<T> listIterator() {
        return new ListIterator<T>() {
            Node<T> cursor = head;
            int ci = 0;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public T next() {
                T value = cursor.getValue();
                cursor = cursor.getNext();
                ci++;
                return value;
            }

            @Override
            public boolean hasPrevious() {
                return cursor.getPrev() != null;
            }

            @Override
            public T previous() {
                ci--;
                return (cursor = cursor.getPrev()).getValue();
            }

            @Override
            public int nextIndex() {
                return ci;
            }

            @Override
            public int previousIndex() {
                return ci - 1;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(T t) {

            }

            @Override
            public void add(T t) {

            }
        };
    }

    @NonNull
    @Override
    public ListIterator<T> listIterator(int i) {
        return null;
    }

    @NonNull
    @Override
    public List<T> subList(int i, int i1) {
        return null;
    }

    public int getSize() {
        return size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public boolean contains(@Nullable Object o) {
        return false;
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

    @NonNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NonNull
    @Override
    public <T1> T1[] toArray(@NonNull T1[] t1s) {
        return null;
    }
}
