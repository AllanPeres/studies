package com.allanperes.studies.datastructure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CircularLinkedListTest {

    @Test
    void shouldAddDataToLinkedList() {
        CircularLinkedList<Long> list = new CircularLinkedList<>();
        list.add(35L);
        Long expected = 35L;
        assertThat(list.search(35L)).isEqualTo(expected);
    }

    @Test
    void shouldDeleteDataOfLinkedList() {
        CircularLinkedList<Long> list = new CircularLinkedList<>();
        list.add(35L);
        assertThat(list.delete(35L)).isTrue();
        assertThat(list.search(35L)).isNull();
    }

    @Test
    void shouldDeleteDataOfTheEndOfTheList() {
        CircularLinkedList<Long> list = new CircularLinkedList<>();
        list.add(35L);
        list.add(25L);
        assertThat(list.delete(35L)).isTrue();
        assertThat(list.search(35L)).isNull();
        assertThat(list.search(25L)).isEqualTo(25L);
    }

    @Test
    void shouldDeleteDataThatHavePreviousNodes() {
        CircularLinkedList<Long> list = new CircularLinkedList<>();
        list.add(35L);
        list.add(25L);
        list.add(12L);
        assertThat(list.delete(25L)).isTrue();
        assertThat(list.search(25L)).isNull();
        assertThat(list.search(35L)).isEqualTo(35L);
        assertThat(list.search(12L)).isEqualTo(12L);
    }

    @Test
    void shouldDeleteAllNodes() {
        CircularLinkedList<Long> list = new CircularLinkedList<>();
        list.add(35L);
        list.add(25L);
        list.add(12L);
        assertThat(list.delete(25L)).isTrue();
        assertThat(list.delete(35L)).isTrue();
        assertThat(list.delete(12L)).isTrue();
        assertThat(list.search(25L)).isNull();
        assertThat(list.isEmpty()).isTrue();
    }

}