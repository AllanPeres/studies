package com.allanperes.studies.datastructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {

    @Test
    void shouldAddValuesAndRecoverFromHashTable() {
        HashTable<String, Integer> hashTable = new HashTable<>();

        hashTable.put("A", 32);
        hashTable.put("B", 33);
        hashTable.put("C", 34);
        hashTable.put("C", 34);

        assertEquals(32, hashTable.get("A"));
        assertEquals(33, hashTable.get("B"));
        assertEquals(34, hashTable.get("C"));
        assertTrue(hashTable.contains("A"));
        assertTrue(hashTable.contains("B"));
        assertTrue(hashTable.contains("C"));
        assertEquals(3, hashTable.size());
    }

}