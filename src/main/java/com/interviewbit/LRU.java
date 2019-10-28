package com.interviewbit;

import java.util.HashMap;
import java.util.Map;

public class LRU {
	int capacity;
	int size;
	Map<Integer, Node> map;
	Node head;
	Node tail;

	public LRU(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new Node();
        this.tail = new Node();
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.size = 0;
    }

	public int get(int key) {
		Node node = map.get(key);
		if (node == null)
			return -1;

		moveToHead(node);
		return node.value;
	}

	public void set(int key, int value) {
		Node node = map.get(key);

		if (node == null) {
			size++;
			ensureCapacity();
			node = new Node(key, value, null, null);
			addToFront(node);
			map.put(key, node);
		} else {
			removeFromList(node);
			addToFront(node);
			node.value = value;
		}

	}

	private void ensureCapacity() {
		if (size > capacity) {
			Node tailNode = tail.prev;
			if (tailNode != head) {
				removeFromList(tailNode);
				tailNode.next = null;
				tailNode.prev = null;
				map.remove(tailNode.key);
				size--;
			}
		}
	}

	private void moveToHead(Node node) {
		removeFromList(node);
		addToFront(node);
	}

	private void removeFromList(Node node) {
		Node prev = node.prev;
		Node next = node.next;

		prev.next = next;
		next.prev = prev;
	}

	private void addToFront(Node node) {
		node.next = head.next;
		head.next.prev = node;
		node.prev = head;
		head.next = node;
	}

	private static class Node {
		int key;
		int value;
		Node prev;
		Node next;

		Node() {

		}

		Node(int key, int value, Node prev, Node next) {
			this.key = key;
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}
}
