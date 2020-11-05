package clrs.dataStructures;

import java.util.List;

import static java.util.Objects.isNull;

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTree {
	
	Node root = null;
	
	//implementation Order - 1
	public boolean isEmpty() {
		return isNull(root);
	}
	
	//implementation Order - 1
	public void insert(int item) {
		Node parent = null;
		Node current = root;
		Node newNode = new Node(item);
		
		while(!isNull(current)) {
			parent = current;
			if(newNode.item < current.item)
				current = current.left;
			else
				current = current.right;
		}
		
		newNode.parent = parent;
		
		if(isNull(parent)) {
			root = newNode;
		}
		else if(newNode.item < parent.item) {
			parent.left = newNode;
		}
		else {
			parent.right = newNode;
		}
	}
	
	//implementation Order - 1
	//We could maintain size member variable for efficiency, but it will complicate code and deviate it a lot from book
	public int size() {
		return size(root);
	}
	
	private int size(Node node) {
		if(node == null)
			return 0;
		return 1 + size(node.left) + size(node.right);
	}

	//implementation Order - 1
	public List<Integer> inorder() {
		List<Integer> items = new LinkedList<>();
		inorder(root, items);
		
		return items;
	}
	
	private void inorder(Node node, List<Integer> items) {
		if(isNull(node))
			return;
		
		inorder(node.left, items);
		items.add(node.item);
		inorder(node.right, items);
	}

	public List<Integer> inorderIterative() {
		List<Integer> result = new LinkedList<>();
		Deque<Node> stack = new LinkedList<>();
		Node current = root;
		Node top = null;
		
		while(!stack.isEmpty() || current != null) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			}
			else {
				top = stack.pop();
				result.add(top.item);
				current = top.right;
			}
		}
		
		return result;
	}
	
	public List<Integer> preorder(int item) {
		return null;
	}
	
	public List<Integer> postorder(int item) {
		return null;
	}
	
	public Node search(int item) {
		return null;
	}
	
	public Node searchIterative(int item) {
		return null;
	}
	
	
	
	static class Node {
		int item;
		Node left;
		Node right;
		Node parent;
		
		Node(int item) {
			this.item = item;
		}
	}
}
