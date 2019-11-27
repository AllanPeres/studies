package com.allanperes.studies.datastructure;

public class CircularQueue {

    private int tail;
    private int head;
    private int[] elements;
    private int size;

    public CircularQueue(int size) {
        this.elements = new int[size];
        this.size = size;
        this.tail = -1;
        this.head = -1;
    }

    public boolean isFull() {
        if (this.head == 0 && this.tail == this.size - 1) {
            return true;
        }
        return this.head == this.tail + 1;
    }

    public boolean isEmpty() {
        if (this.head == -1) {
            return true;
        }
        return false;
    }

    public void enqueue(int elem) {
        if (this.isFull()) {
            throw new RuntimeException("Queue is full");
        }
        if (this.head == -1) {
            this.head = 0;
        }
        this.tail = (this.tail + 1) % this.size;
        this.elements[this.tail] = elem;
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        int temp = this.elements[this.head];
        if (this.head == this.tail) {
            this.head = -1;
            this.tail = -1;
        } else {
            this.head = (this.head + 1) % this.size;
        }
        return temp;
    }
}
