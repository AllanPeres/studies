package com.allanperes.studies.datastructure;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HashTable <K, V> {

    private static final int NUMBER_OF_BUKETS = 10;
    private final List<List<Entry<K, V>>> bukets;

    public HashTable() {
        this.bukets = new LinkedList<>();
        IntStream.range(0, NUMBER_OF_BUKETS)
                .forEach(i -> bukets.add(
                        i, new LinkedList<Entry<K, V>>())
                );
    }

    public void put(K key, V value) {
        int index = key.hashCode() % NUMBER_OF_BUKETS;
        Entry<K, V> kvEntry = new Entry<>(key, value);
        List<Entry<K, V>> bucket = bukets.get(index);
        bucket.remove(kvEntry);
        bucket.add(kvEntry);
   }

   public int size() {
        return bukets.stream()
                .map(List::size)
                .reduce(Integer::sum)
                .orElse(0);
   }

   public V get(K key) {
        int index = key.hashCode() % NUMBER_OF_BUKETS;
        List<Entry<K, V>> bucket = bukets.get(index);
        List<V> result = bucket.stream()
                .filter(kv -> kv.key.equals(key))
                .map(Entry::getValue)
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            return null;
        }
        return result.get(0);
   }

   public boolean contains(K key) {
        return this.get(key) != null;
   }

   private static class Entry<K, V> {
        private final K key;
        private final V value;


        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

       @Override
       public boolean equals(Object o) {
           if (this == o) return true;
           if (o == null || getClass() != o.getClass()) return false;
           Entry<?, ?> entry = (Entry<?, ?>) o;
           return Objects.equals(key, entry.key) &&
                   Objects.equals(value, entry.value);
       }

       @Override
       public int hashCode() {
           return Objects.hash(key, value);
       }
   }
}
