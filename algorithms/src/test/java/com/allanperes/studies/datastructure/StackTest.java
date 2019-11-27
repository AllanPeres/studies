package com.allanperes.studies.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void should_InsertElemOnStack_when_StackIsNotFull() {
        Stack stack = new Stack(3);
        stack.push(3);
        int expected = 3;
        assertEquals(expected, stack.pop());
    }

    @Test
    void should_ThrowException_when_StackGetFull() {
        Stack stack = new Stack(3);
        stack.push(4);
        stack.push(3);
        stack.push(6);
        assertThrows(RuntimeException.class, () -> stack.push(7), "Full pile");
    }

    @Test
    void should_PopLastInsertedItem_when_InsertElements() {
        Stack stack = new Stack(2);
        stack.push(4);
        stack.push(3);
        int expected = 3;
        assertEquals(expected, stack.pop());
    }

    @Test
    void should_ThrowException_when_TryToPopEmptyStack() {
        Stack stack = new Stack(1);
        assertThrows(RuntimeException.class, stack::pop, "Stack is empty");
    }

    @Test
    void should_ReturnTrue_when_StackIsEmpty() {
        assertTrue(new Stack(0).isEmpty());
    }

    @Test
    void should_ReturnFalse_when_StackIsNotEmpty() {
        Stack stack = new Stack(1);
        stack.push(1);
        assertFalse(stack.isEmpty());
    }
}
