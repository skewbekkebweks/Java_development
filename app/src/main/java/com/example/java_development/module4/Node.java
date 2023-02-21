package com.example.java_development.module4;

public class Node<T> {
    private T value;
    private Node<T> next;
    private Node<T> prev;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public Node<T> getPrev() { return prev; }

    public void setPrev(Node<T> prev) { this.prev = prev; }

    @Override
    public String toString() {
        return value.toString();
    }
}
