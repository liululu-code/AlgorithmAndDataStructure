package top.lll.linearList.impl;

import top.lll.linearList.MyList;

public class MyLinkedListImpl<E> implements MyList<E> {
    private Node<E> head;
    private int size;

    private static class Node<E> {
        private E item;
        private Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public MyLinkedListImpl() {
        this.head = new Node<E>(null, null);
    }

    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node<E> getPreNode(int index) {
        Node<E> preNode = head;
        while (index-- > 0) {
            preNode = preNode.next;
        }
        return preNode;
    }

    @Override
    public void add(int index, E element) {
        checkIndexForAdd(index);
        Node<E> preNode = getPreNode(index);
        preNode.next = new Node<>(element, preNode.next);
        size++;
    }

    @Override
    public boolean add(E element) {
        add(size, element);
        return true;
    }


    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> preNode = getPreNode(index);
        Node<E> nodeToRemove = preNode.next;
        E oldItem = preNode.next.item;
        preNode.next = nodeToRemove.next;
        nodeToRemove.next = null;
        size--;
        return oldItem;
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        Node<E> preNode = getPreNode(index);
        E oldItem = preNode.next.item;
        preNode.next.item = element;
        return oldItem;
    }

    @Override
    public boolean contains(E element) {
        return indexOf(element) != -1;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = head;
        for(int i = 0; i < size; i++) {
            if (node.next.item.equals(element)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> preNode = getPreNode(index);
        return preNode.next.item;
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
        size = 0;
        Node<E> node = head;
        while(node.next != null) {
            Node<E> nextNode = node.next;
            node.next = null;
            node.item = null;
            node = nextNode;
        }
        head.next = null;
    }
}
