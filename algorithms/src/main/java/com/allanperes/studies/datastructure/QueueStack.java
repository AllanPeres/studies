package com.allanperes.studies.datastructure;

public class QueueStack {

    private Stack mainStack;
    private Stack secondStack;

    public QueueStack(int length) {
        this.mainStack = new Stack(length);
        this.secondStack = new Stack(length);
    }

    public void enqueue(int elem) {
        this.mainStack.push(elem);
    }

    public int dequeue() {
        while (!this.mainStack.isEmpty()) {
            this.secondStack.push(this.mainStack.pop());
        }
        int temp = this.secondStack.pop();
        while (!this.secondStack.isEmpty()) {
            this.mainStack.push(this.secondStack.pop());
        }
        return temp;
    }
}
