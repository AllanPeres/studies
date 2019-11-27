package com.allanperes.studies.datastructure;

public class Queue<E> {

    private int tail = -1;
    private E[] elements;

    @SuppressWarnings("unchecked")
    public Queue(int length) {
        this.elements = (E[]) new Object[length];
    }

    public void push(E elem) {
        if (this.tail == this.elements.length - 1) {
            throw new RuntimeException("Queue is full");
        } else {
            this.elements[++tail] = elem;
        }
    }

    public E pop() {
        if (this.tail < 0) {
            throw new RuntimeException("Queue is empty");
        }
        E temp = this.elements[0];
        for (int i = 0; i < this.tail; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.tail--;
        return temp;
    }
}
