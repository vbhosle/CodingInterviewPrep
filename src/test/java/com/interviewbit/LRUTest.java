package com.interviewbit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class LRUTest {

	@Test
	public void LRUSizeOne01() {
		LRU lru = new LRU(1);
		
		lru.set(2, 1);
		lru.set(2, 2);
		
		assertThat(lru.get(2), equalTo(2));
		
		lru.set(1, 1);
		lru.set(4, 1);
		
		assertThat(lru.get(2), equalTo(-1));
	}
	
	@Test
	public void LRUSizeOne02() {
		LRU lru = new LRU(1);
		
		lru.set(2, 1);
		
		assertThat(lru.get(2), equalTo(1));
		
		lru.set(3, 2);
		
		assertThat(lru.get(2), equalTo(-1));
		assertThat(lru.get(3), equalTo(2));
	}
	
	@Test
	public void LRUSizeTwo01() {
		LRU lru = new LRU(2);
		
		lru.set(2, 1);
		lru.set(1, 1);
		lru.set(2, 3);
		lru.set(4, 1);
		
		assertThat(lru.get(1), equalTo(-1));
		assertThat(lru.get(2), equalTo(3));
	}

}
