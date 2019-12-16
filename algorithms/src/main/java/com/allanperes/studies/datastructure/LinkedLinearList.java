package com.allanperes.studies.datastructure;

import java.util.Objects;

public class LinkedLinearList<E> {

    private Node<E> head;

    private boolean addAtFront(E data) {
        Node<E> node = new Node<>(data);
        node.next = this.head;
        this.head = node;
        return true;
    }

    private boolean addAtEnd(E data) {
        Node<E> node = new Node<>(data);

        if (Objects.isNull(this.head)) {
            this.head = node;
            return true;
        }

        Node<E> currentNode = this.head;
        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = node;
        return true;
    }

    private Node<E> searchNode(E searchData) {
        if (Objects.isNull(this.head)) {
            return null;
        }
        if (searchData.equals(this.head.data)) {
            return head;
        }
        Node<E> currentNode = this.head;
        while(!Objects.isNull(currentNode.next)) {
            currentNode = currentNode.next;
            if (currentNode.data.equals(searchData)) {
                return currentNode;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return Objects.isNull(this.head);
    }

    public E search(E searchData) {
        Node<E> findedNode = searchNode(searchData);
        return Objects.isNull(findedNode) ? null : findedNode.data;
    }

    public boolean delete(E data) {
        if (Objects.isNull(this.head)) {
            return false;
        }
        if (data.equals(this.head.data)) {
            this.head = this.head.next;
            return true;
        }
        Node<E> currentNode = this.head;
        Node<E> previous;
        while(!Objects.isNull(currentNode.next)) {
            previous = currentNode;
            currentNode = currentNode.next;
            if (currentNode.data.equals(data)) {
                previous.next = currentNode.next;
                return true;
            }
        }
        return false;
    }

    public void add(E data) {
        addAtEnd(data);
    }

    static class Node<E> {
        Node<E> next;
        E data;

        private Node(E data) {
            this.next = null;
            this.data = data;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }

        public E getData() {
            return data;
        }

        public void setData(E data) {
            this.data = data;
        }
    }
}
