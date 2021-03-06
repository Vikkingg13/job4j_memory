package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    protected void put(K key, V value) {
        cache.put(key, new SoftReference<>(value));
    }

    public V get(K key) {
        V value = cache.getOrDefault(key, new SoftReference<>(null)).get();
        if (value == null) {
            put(key, load(key));
            value = cache.get(key).get();
        }
        return value;
    }

    public void save(K key) {
        if (!cache.containsKey(key)) {
            put(key, load(key));
        }
    }

    protected abstract V load(K key);
}
