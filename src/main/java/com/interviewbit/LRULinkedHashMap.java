package com.interviewbit;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRULinkedHashMap {

	private final Map<Integer, Integer> cache;

	public LRULinkedHashMap(final int cacheCapacity) {
        this.cache = new LinkedHashMap<Integer, Integer>(cacheCapacity, 1.0f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > cacheCapacity;
            }
        };
    }

	public int get(int key) {
		return cache.getOrDefault(key, -1);
	}

	public void set(int key, int value) {
		cache.put(key, value);
	}
}
