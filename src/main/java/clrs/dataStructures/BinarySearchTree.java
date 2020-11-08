package clrs.dataStructures;

import java.util.List;
import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTree {

	Node root = null;

	// implementation Order - 1
	public boolean isEmpty() {
		return root == null;
	}

	// implementation Order - 1
	public void insert(Integer key) {
		Node parent = null;
		Node current = root;
		Node newNode = new Node(key);

		while (current != null) {
			parent = current;
			if (newNode.key < current.key)
				current = current.left;
			else
				current = current.right;
		}

		newNode.parent = parent;

		if (parent == null) {
			root = newNode;
		} else if (newNode.key < parent.key) {
			parent.left = newNode;
		} else {
			parent.right = newNode;
		}
	}

	// implementation Order - 1
	// We could maintain size member variable for efficiency, but it will complicate
	// code and deviate it a lot from book
	public int size() {
		return size(root);
	}

	private int size(Node node) {
		if (node == null)
			return 0;
		return 1 + size(node.left) + size(node.right);
	}

	// implementation Order - 1
	public List<Integer> inorder() {
		List<Integer> keys = new LinkedList<>();
		inorder(root, keys);

		return keys;
	}

	private void inorder(Node current, List<Integer> visited) {
		if (current == null)
			return;

		inorder(current.left, visited);
		visited.add(current.key);
		inorder(current.right, visited);
	}

	public List<Integer> inorderIterative() {
		List<Integer> result = new LinkedList<>();
		Deque<Node> stack = new LinkedList<>();
		Node current = root;
		Node top = null;

		while (!stack.isEmpty() || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				top = stack.pop();
				result.add(top.key);
				current = top.right;
			}
		}

		return result;
	}

	//TODO
	// Morris inorder tree traversal
	// https://www.youtube.com/watch?v=wGXB9OWhPTg
	public List<Integer> morrisinorder() {
		return null;
	}

	public List<Integer> preorder() {
		List<Integer> visited = new LinkedList<>();
		preorder(root, visited);
		return visited;
	}

	private void preorder(Node current, List<Integer> visited) {
		if (current == null)
			return;
		visited.add(current.key);
		preorder(current.left, visited);
		preorder(current.right, visited);
	}

	public List<Integer> postorder() {
		List<Integer> visited = new LinkedList<>();
		postorder(root, visited);
		return visited;
	}

	private void postorder(Node current, List<Integer> visited) {
		if (current == null)
			return;
		postorder(current.left, visited);
		postorder(current.right, visited);
		visited.add(current.key);
	}

	public boolean contains(Integer key) {
		return contains(root, key);
	}

	// search
	private boolean contains(Node current, int key) {
		if (current == null)
			return false;

		if (key == current.key)
			return true;

		if (key < current.key)
			return contains(current.left, key);
		else
			return contains(current.right, key);
	}

	public boolean containsIterative(int key) {
		return searchNode(key) != null;
	}

	private Node searchNode(int key) {
		Node current = root;

		while (current != null) {
			if (key == current.key)
				return current;

			if (key < current.key)
				current = current.left;
			else
				current = current.right;
		}

		return null;
	}

	public int min() {
		if (size() == 0)
			throw new IllegalArgumentException("tree is empty");

		return min(root).key;
	}

	private Node min(Node current) {
		while (current.left != null)
			current = current.left;

		return current;
	}

	public int max() {
		if (size() == 0)
			throw new IllegalArgumentException("tree is empty");

		return max(root).key;
	}
	
	private Node max(Node current) {
		while (current.right != null)
			current = current.right;

		return current;
	}

	public Integer successor(int key) {
		Node successorNode = successor(searchNode(key));
		return successorNode != null ? successorNode.key : null;
	}
	
	private Node successor(Node node) {
		if (node == null)
			return null;

		if (node.right != null) {
			return min(node.right);
		} else {
			Node parent = node.parent;

			while (parent != null && parent.right == node) {
				node = parent;
				parent = node.parent;
			}

			return parent;
		}
	}

	public Integer predecessor(int key) {
		Node current = searchNode(key);

		if (current == null)
			return null;

		if (current.left != null) {
			Node maxInLeftTree = max(current.left);
			return maxInLeftTree != null ? maxInLeftTree.key : null;
		} else {
			Node parent = current.parent;

			while (parent != null && parent.left == current) {
				current = parent;
				parent = current.parent;
			}

			return parent != null ? parent.key : null;
		}
	}
	
	public void delete(int key) {
		Node nodeToDelete = searchNode(key);
		
		if(nodeToDelete == null)
			return;
		
		if(nodeToDelete.left == null) {
			transplant(nodeToDelete, nodeToDelete.right);
		}
		else if(nodeToDelete.right == null) {
			transplant(nodeToDelete, nodeToDelete.left);
		}
		else {
			Node replacement = min(nodeToDelete);
			if(replacement.parent != nodeToDelete) {
				transplant(replacement, replacement.right);
				replacement.right = nodeToDelete.right;
				replacement.right.parent = replacement;
			}
			
			transplant(nodeToDelete, replacement);
			replacement.left = nodeToDelete.left;
			replacement.left.parent = replacement;
		}
	}

	private void transplant(Node u, Node v) {
		if(u.parent == null) {
			root = v;
		}
		else {
			if(u == u.parent.left) {
				u.parent.left = v;
			}
			else {
				u.parent.right = v;
			}
		}
		
		if(v != null)
			v.parent = u.parent;
	}
	
	static class Node {
		Integer key;
		Node left;
		Node right;
		Node parent;

		Node(Integer key) {
			this.key = key;
		}
	}
}
