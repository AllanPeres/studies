package com.allanperes.studies.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void should_InsertFirstElem_when_QueueIsEmpty() {
        Queue<String> queue = new Queue<>(1);
        queue.push("Teste");
        String expected = "Teste";
        assertEquals(expected, queue.pop());
    }

    @Test
    void should_RemoveFirstElement_when_PushedMoreThanOne() {
        Queue<Integer> queue = new Queue<>(2);
        queue.push(3);
        queue.push(42);
        int expected = 3;
        assertEquals(expected, queue.pop());
    }

    @Test
    void should_RemoveFirstThreeElements_when_ExistsThreeElements() {
        Queue<Integer> queue = new Queue<>(3);
        queue.push(3);
        queue.push(42);
        queue.push(4);
        int firstExpected = 3;
        int secondExpected = 42;
        int thirdExpected = 4;
        assertAll(
                () -> assertEquals(firstExpected, queue.pop()),
                () -> assertEquals(secondExpected, queue.pop()),
                () -> assertEquals(thirdExpected, queue.pop())
        );
    }

    @Test
    void should_ThrowException_when_QueueIsFull() {
        Queue<Integer> queue = new Queue<>(0);
        assertThrows(RuntimeException.class, () -> queue.push(1), "Queue is full");
    }

    @Test
    void should_ThrowException_when_QueueIsEmpty() {
        Queue<Integer> queue = new Queue<>(0);
        assertThrows(RuntimeException.class, queue::pop, "Queue is empty");
    }
}
