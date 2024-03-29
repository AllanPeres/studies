package com.allanperes.studies.datastructure;

import com.allanperes.studies.datastructure.utils.Node;

import java.util.Objects;

public class LinkedLinearList<E> {

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
            return true;
        }

        Node<E> currentNode = this.head;
        while(currentNode.getNext() != null) {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(node);
        return true;
    }

    private Node<E> searchNode(E searchData) {
        if (Objects.isNull(this.head)) {
            return null;
        }
        if (searchData.equals(this.head.getData())) {
            return head;
        }
        Node<E> currentNode = this.head;
        while(!Objects.isNull(currentNode.getNext())) {
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
        if (Objects.isNull(this.head)) {
            return false;
        }
        if (data.equals(this.head.getData())) {
            this.head = this.head.getNext();
            return true;
        }
        Node<E> currentNode = this.head;
        Node<E> previous;
        while(!Objects.isNull(currentNode.getNext())) {
            previous = currentNode;
            currentNode = currentNode.getNext();
            if (currentNode.getData().equals(data)) {
                previous.setNext(currentNode.getNext());
                return true;
            }
        }
        return false;
    }

    public void add(E data) {
        addAtEnd(data);
    }

}
