package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LRULinkedHashMapTest {

	@Test
	public void LRULinkedHashMapSizeOne01() {
		LRULinkedHashMap lru = new LRULinkedHashMap(1);
		
		lru.set(2, 1);
		lru.set(2, 2);
		
		assertThat(lru.get(2), equalTo(2));
		
		lru.set(1, 1);
		lru.set(4, 1);
		
		assertThat(lru.get(2), equalTo(-1));
	}
	
	@Test
	public void LRULinkedHashMapSizeOne02() {
		LRULinkedHashMap lru = new LRULinkedHashMap(1);
		
		lru.set(2, 1);
		
		assertThat(lru.get(2), equalTo(1));
		
		lru.set(3, 2);
		
		assertThat(lru.get(2), equalTo(-1));
		assertThat(lru.get(3), equalTo(2));
	}
	
	@Test
	public void LRULinkedHashMapSizeTwo01() {
		LRULinkedHashMap lru = new LRULinkedHashMap(2);
		
		lru.set(2, 1);
		lru.set(1, 1);
		lru.set(2, 3);
		lru.set(4, 1);
		
		assertThat(lru.get(1), equalTo(-1));
		assertThat(lru.get(2), equalTo(3));
	}

}
