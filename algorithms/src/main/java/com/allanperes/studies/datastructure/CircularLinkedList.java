package com.allanperes.studies.datastructure;

import com.allanperes.studies.datastructure.utils.Node;

import java.util.Objects;

public class CircularLinkedList<E> {

    private Node<E> head;

    private boolean addAtFront(E data) {
        Node<E> node = new Node<>(data);
        node.setNext(this.head);
        this.head = node;
        return true;
    }

    private boolean addAtEnd(E data) {
        Node<E> node = new Node<>(data);

        if (Objects.isNull(this.head)) {
            this.head = node;
            node.setNext(null);
            return true;
        }
        Node<E> lastNode = getLastNode();
        lastNode.setNext(node);
        node.setNext(this.head);
        return true;
    }

    private Node<E> getLastNode() {
        if (Objects.isNull(this.head.getNext())) {
            return this.head;
        }
        Node<E> currentNode = this.head;
        while(!this.head.equals(currentNode.getNext())) {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }

    private Node<E> searchNode(E searchData) {
        if (Objects.isNull(this.head)) {
            return null;
        }
        if (searchData.equals(this.head.getData())) {
            return head;
        }
        Node<E> currentNode = this.head;
        while(!Objects.isNull(currentNode.getNext()) && !this.head.equals(currentNode.getNext())) {
            currentNode = currentNode.getNext();
            if (currentNode.getData().equals(searchData)) {
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
        return Objects.isNull(findedNode) ? null : findedNode.getData();
    }

    public boolean delete(E data) {
        var node = searchNode(data);
        if (this.head == null || node == null) {
            return false;
        }
        if (this.head.equals(node)) {
            this.head = head.getNext();
            if (this.head != null) this.head.setNext(null);
            return true;
        }
        var currentNode = this.head;
        Node<E> previous = null;
        while (currentNode.getNext().equals(node)) {
            previous = currentNode;
            currentNode = currentNode.getNext();
        }
        if (previous != null) previous.setNext(node.getNext());
        return true;
    }

    public void add(E data) {
        addAtEnd(data);
    }
}
