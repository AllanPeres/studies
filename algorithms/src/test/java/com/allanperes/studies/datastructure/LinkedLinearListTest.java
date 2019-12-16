package com.allanperes.studies.datastructure;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedLinearListTest {

    @Test
    void shouldAddDataToLinkedList() {
        LinkedLinearList<Long> list = new LinkedLinearList<>();
        list.add(35L);
        Long expected = 35L;
        assertThat(list.search(35L)).isEqualTo(expected);
    }

    @Test
    void shouldDeleteDataOfLinkedList() {
        LinkedLinearList<Long> list = new LinkedLinearList<>();
        list.add(35L);
        list.delete(35L);
        assertThat(list.search(35L)).isNull();
    }

    @Test
    void shouldDeleteDataOfTheEndOfTheList() {
        LinkedLinearList<Long> list = new LinkedLinearList<>();
        list.add(35L);
        list.add(25L);
        list.delete(35L);
        assertThat(list.search(35L)).isNull();
        assertThat(list.search(25L)).isEqualTo(25L);
    }

    @Test
    void shouldDeleteDataThatHavePreviousNodes() {
        LinkedLinearList<Long> list = new LinkedLinearList<>();
        list.add(35L);
        list.add(25L);
        list.add(12L);
        list.delete(25L);
        assertThat(list.search(25L)).isNull();
        assertThat(list.search(35L)).isEqualTo(35L);
        assertThat(list.search(12L)).isEqualTo(12L);
    }

    @Test
    void shouldDeleteAllNodes() {
        LinkedLinearList<Long> list = new LinkedLinearList<>();
        list.add(35L);
        list.add(25L);
        list.add(12L);
        list.delete(25L);
        list.delete(35L);
        list.delete(12L);
        assertThat(list.search(25L)).isNull();
        assertThat(list.isEmpty()).isTrue();
    }

}