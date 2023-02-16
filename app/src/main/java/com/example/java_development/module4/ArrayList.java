package com.example.java_development.module4;

import androidx.annotation.NonNull;

import java.util.Arrays;

public class ArrayList {
    private Double[] array;
    private int size = 0;

    public ArrayList(int n) {
        array = new Double[n];
    }

    public ArrayList() { this(10); }

    public void add(Double value) {
        if (size >= array.length) {
            Double[] a = new Double[array.length * 2];
            System.arraycopy(this.array, 0, a, 0, size);
            this.array = a;
        }
        this.array[size] = value;
        size++;
    }

    @NonNull
    @Override
    public String toString() {
        return "ArrayList{" +
                "array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    public int getSize() {
        return size;
    }

    private void setSize(int size) {
        this.size = size;
    }

    public Double get(int index) {
        if (index > size - 1)
            throw new ArrayIndexOutOfBoundsException("Index " + index + " out of bounds for length " + size);
        return this.array[index];
    }

    public boolean remove(int i) {
        if (i < size - 1) {
            System.arraycopy(array, i + 1, array, i, size - i - 1);
        }
        this.array[size - 1] = null;
        this.size--;
        return true;
    }

    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(23.0);
        arrayList.add(24.0);
        arrayList.add(25.5);
        System.out.println(arrayList);
        System.out.println(arrayList.get(100));

    }
}
