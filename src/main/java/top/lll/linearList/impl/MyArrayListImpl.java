package top.lll.linearList.impl;

import top.lll.linearList.MyList;

import java.util.Arrays;

public class MyArrayListImpl<E> implements MyList<E> {
//    private final int INITIAL_CAPACITY = 16;

    private int size;
    private Object[] elementData;

    public MyArrayListImpl() {
        this.size = 0;
//        this.elementData = (E[]) new Object[INITIAL_CAPACITY];
        this.elementData = new Object[16];
    }

    public MyArrayListImpl(int capacity) {
        this.size = 0;
        this.elementData =  new Object[capacity];
    }

    private void ensureCapacity() {
        if (elementData.length == size) {
            Object[] oldElementData = elementData;
            elementData = new Object[elementData.length * 2];
            System.arraycopy(oldElementData, 0, elementData, 0, oldElementData.length);
        }
    }


    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity();
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = element;
        size++;
    }

    @Override
    public boolean add(E element) {
        ensureCapacity();
        add(size, element);
        return true;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E remove(int index) {
        checkIndex(index);
        Object element = elementData[index];
        System.arraycopy(elementData, index + 1, elementData, index, size - index - 1);
        elementData[size--] = null;
        return (E)element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E set(int index, E element) {
        checkIndex(index);
        Object oldElement = elementData[index];
        elementData[index] = element;
        return (E)oldElement;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }

    @SuppressWarnings("unchecked")
    @Override
    public E get(int index) {
        ensureCapacity();
        return (E)elementData[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clean() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }


    @Override
    public String toString() {
//        if (size == 0) {
//            return "[]";
//        }
//        StringBuilder sb = new StringBuilder();
//        sb.append("[");
//        for (int i = 0; i < size; i++) {
//            sb.append(elementData[i]);
//            if (i < size - 1) {
//                sb.append(", ");

//            }
//        }
//        sb.append("]");
//        return sb.toString();
//    }
        return Arrays.toString(Arrays.copyOf(elementData, size));
    }
}