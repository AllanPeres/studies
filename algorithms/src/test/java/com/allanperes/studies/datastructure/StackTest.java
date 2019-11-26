package com.allanperes.studies.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//TODO Include more tests
public class StackTest {

    private Stack stack = new Stack(3);

    @Test
    public void should_InsertElemOnStack_when_StackIsNotFull() {
        stack.push(3);
        int expected = 3;
        assertEquals(expected, stack.pop());
    }
}
