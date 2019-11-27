package com.allanperes.studies.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularQueueTest {

    @Test
    void should_RemoveFirstElement_when_enqueueedMoreThanOne() {
        CircularQueue queue = new CircularQueue(2);
        queue.enqueue(3);
        queue.enqueue(42);
        int expected = 3;
        assertEquals(expected, queue.dequeue());
    }

    @Test
    void should_RemoveFirstThreeElements_when_ExistsThreeElements() {
        CircularQueue queue = new CircularQueue(3);
        queue.enqueue(3);
        queue.enqueue(42);
        queue.enqueue(4);
        int firstExpected = 3;
        int secondExpected = 42;
        int thirdExpected = 4;
        assertAll(
                () -> assertEquals(firstExpected, queue.dequeue()),
                () -> assertEquals(secondExpected, queue.dequeue()),
                () -> assertEquals(thirdExpected, queue.dequeue())
        );
    }

    @Test
    void should_ThrowException_when_QueueIsFull() {
        CircularQueue queue = new CircularQueue(0);
        assertThrows(RuntimeException.class, () -> queue.enqueue(1), "Queue is full");
    }

    @Test
    void should_ThrowException_when_QueueIsEmpty() {
        CircularQueue queue = new CircularQueue(0);
        assertThrows(RuntimeException.class, queue::dequeue, "Queue is empty");
    }
}
