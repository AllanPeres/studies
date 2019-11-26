package com.allanperes.studies.datastructure;

public class Stack {

    private int top;
    private int[] items;

    public Stack(int length) {
        this.items = new int[length];
        this.top = -1;
    }

    public void push(int elem) {
        if (this.top >= items.length) {
            throw new RuntimeException("Full pile");
        } else {
            this.items[++this.top] = elem;
        }
    }

    public int pop() {
        if (top < 0) {
            throw new RuntimeException("Stack is empty");
        } else {
            return this.items[this.top--];
        }
    }

    public boolean isEmpty() {
        return this.top < 0;
    }
}
