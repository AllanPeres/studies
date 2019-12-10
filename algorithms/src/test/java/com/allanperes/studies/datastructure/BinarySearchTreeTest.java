package com.allanperes.studies.datastructure;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BinarySearchTreeTest {

    @Test
    void testBinarySeachTree() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(3);
        bst.insert(8);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(2);
        bst.insert(10);
        bst.insert(9);
        bst.insert(20);
        bst.insert(25);
        bst.insert(15);
        bst.insert(16);

        List<Integer> results = bst.getInOrder();
        assertThat(results).containsExactly(
                1,2,3,4,6,8,9,10,15,16,20,25
        );
        assertThat(bst.find(4)).isTrue();
        assertThat(bst.find(26)).isFalse();
    }

    @Test
    void testDeleteNodeFromBinarySearchTree() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(3);
        bst.insert(8);
        bst.insert(1);

        bst.delete(8);
        List<Integer> results = bst.getInOrder();
        assertThat(results).containsExactly(
                1, 3
        );
    }

    @Test
    void testDeleteNodeComplexBinarySeachTree() {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(3);
        bst.insert(8);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(2);
        bst.insert(10);
        bst.insert(9);
        bst.insert(20);
        bst.insert(25);
        bst.insert(15);
        bst.insert(16);
        bst.delete(10);

        List<Integer> results = bst.getInOrder();
        assertThat(results).containsExactly(
                1,2,3,4,6,8,9,15,16,20,25
        );
        assertThat(bst.find(4)).isTrue();
        assertThat(bst.find(26)).isFalse();
    }
}
