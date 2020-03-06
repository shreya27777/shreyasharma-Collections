package org.example;

import java.util.AbstractList;

public class MyList<T> extends AbstractList<T> {
    private Object[] arr;
    private int i;
    int capacity;

    public MyList(T[] arr) throws Exception {
        i = -1;
        capacity = 10;
        this.arr = new Object[capacity];
        if (arr.length < 10) {
            throw new Exception("List size is too small");
        } else {
            for (int i = 0; i < 10; i++) {
                add(arr[i]);
            }
        }
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index <= i) {
            return (T) arr[index];
        } else {
            throw new RuntimeException("Index Out of Bound");
        }
    }

    @Override
    public int size() {
        return i + 1;
    }

    @Override
    public boolean add(T t) {
        if (i + 1 >= capacity) {
            grow();
        }
        arr[++i] = t;
        return true;
    }

    private void grow() {
        capacity = capacity * 2;
        Object[] objects = new Object[capacity];
        for (int j = 0; j < size(); j++) {
            objects[j] = arr[j];
        }
        arr = objects;
    }

    @Override
    public T remove(int index) {
        if (size() > 0) {
            T element = get(index);
            for (int j = 0; j < i; j++) {
                if (j >= index) {
                    arr[j] = arr[j + 1];
                }
            }
            i--;
            return element;
        } else {
            throw new RuntimeException("Index Out of Bound");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int j = 0; j < size(); j++) {
            if (j == size() - 1) {
                stringBuilder.append(arr[j]);
            } else {
                stringBuilder.append(arr[j]).append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
