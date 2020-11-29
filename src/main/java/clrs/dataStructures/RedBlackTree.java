package clrs.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//member variables have no private access to enable tests to verify internal state
public class RedBlackTree {
	
	static final Node NIL = new Node(0, NodeColor.BLACK);
	
	Node root;
	
	RedBlackTree() {
		root = NIL;
		root.parent = NIL;
	}
	
	public void insert(int key) {
		Node node = new Node(key, NodeColor.RED);
		node.size = 1;
		Node parent = NIL;
		Node current = root;
		
		while(current != NIL) {
			parent = current;
			parent.size++;
			
			if(node.key < current.key) {
				current = current.left;
			}
			else {
				current = current.right;
			}
		}
		
		node.parent = parent;
		
		if(parent == NIL)
			root = node;
		else if(node.key < parent.key)
			parent.left = node;
		else
			parent.right = node;
		
		insertFixUp(node);
	}
	
	private void insertFixUp(Node node) {
		
		while(node.parent.color == NodeColor.RED) {
			if(node.parent == node.parent.parent.left) {
				Node uncle = node.parent.parent.right;
				
				if(uncle.color == NodeColor.RED) {
					node.parent.color = NodeColor.BLACK;
					uncle.color = NodeColor.BLACK;
					node.parent.parent.color = NodeColor.RED;
					node = node.parent.parent;
				}
				else {
					if(node == node.parent.right) {
						node = node.parent;
						leftRotate(node);
					}
					
					node.parent.color = NodeColor.BLACK;
					node.parent.parent.color = NodeColor.RED;
					rightRotate(node.parent.parent);
				}
			
			}
			else {
				Node uncle = node.parent.parent.left;
				
				if(uncle.color == NodeColor.RED) {
					node.parent.color = NodeColor.BLACK;
					uncle.color = NodeColor.BLACK;
					node.parent.parent.color = NodeColor.RED;
					node = node.parent.parent;
				}
				else {
					if(node == node.parent.left) {
						node = node.parent;
						rightRotate(node);
					}
					
					node.parent.color = NodeColor.BLACK;
					node.parent.parent.color = NodeColor.RED;
					leftRotate(node.parent.parent);
				}
			}
		}
		
		root.color = NodeColor.BLACK;
	}
	
	//TODO
	public void delete(int key) {
		
	}
	
	private void rightRotate(Node node) {
		Node y = node.left;
		
		node.left = y.right;
		if(y.right != NIL)
			y.right.parent = node;
				
		y.parent = node.parent;
		if(node.parent == NIL)
			root = y;
		else if(node == node.parent.left)
			node.parent.left = y;
		else
			node.parent.right = y;
		
		y.right = node;
		node.parent = y;
		
		y.size = node.size;
		node.size = node.left.size + node.right.size + 1;
	}

	private void leftRotate(Node node) {
		Node y = node.right;
		
		node.right = y.left;
		if(y.left != NIL)
				y.left.parent = node;
		
		y.parent = node.parent;
		if(node.parent == NIL)
			root = y;
		else if(node == node.parent.left)
			node.parent.left = y;
		else
			node.parent.right = y;
		y.left = node;
		node.parent = y;
		
		y.size = node.size;
		node.size = node.left.size + node.right.size + 1;
	}

	public boolean isEmpty() {
		return root == NIL;
	}
	
	//with size attribute added for augmented red-black tree, we can simply return root node's size
	public int size() {
//		return root.size;
		return size(root);
	}

	private int size(Node node) {
//		return node.size;
		if (node == NIL)
			return 0;
		return 1 + size(node.left) + size(node.right);
	}

	public List<Integer> inorder() {
		List<Integer> keys = new LinkedList<>();
		inorder(root, keys);

		return keys;
	}

	private void inorder(Node current, List<Integer> visited) {
		if (current == NIL)
			return;

		inorder(current.left, visited);
		visited.add(current.key);
		inorder(current.right, visited);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(List<String> row: printTree(root)) {
			for(String col: row) {
				sb.append(col);
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public List<List<String>> printTree(Node root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        int rows = getHeight(root);
        int cols = (int)Math.pow(2, rows) - 1;
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add(" ");
            }
            res.add(row);
        }
        
        Queue<Node> queue = new LinkedList<>();
        Queue<int[]> indexQ = new LinkedList<>();
        queue.offer(root);
        indexQ.offer(new int[] { 0, cols - 1 });
        int row = -1;
        while (!queue.isEmpty()) {
            row++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                int[] indices = indexQ.poll();
                
                if (cur == null) {
                    continue;
                }
                
                int left = indices[0];
                int right = indices[1];
                int mid = left + (right - left) / 2;
                
                if(cur == NIL)
                	res.get(row).set(mid, "NIL");
                else
                	res.get(row).set(mid, String.valueOf(cur.key)+"-"+cur.color.name().charAt(0));
                
                queue.offer(cur.left);
                queue.offer(cur.right);
                indexQ.offer(new int[] { left, mid - 1 });
                indexQ.offer(new int[] { mid + 1, right });
            }
        }
        
        return res;
    }
    
	public Node os_select(int rank) {
		return os_select(root, rank);
	}
	
	private Node os_select(Node node, int rank) {
		if(node.size < rank)
			return null;
		
		int currentRank = node.left.size + 1;
		
		if(rank == currentRank)
			return node;
		
		else if(rank < currentRank)
			return os_select(node.left, rank);
		else
			return os_select(node.right, rank - currentRank);
	}
	
	public int os_rank(Node x) {
		int rank = x.left.size + 1;
		Node y = x;
		while(y != root) {
			if( y == y.parent.right) {
				rank = rank + y.parent.left.size + 1;
			}
			
			y = y.parent;
		}
		
		return rank;
	}
	
	public int os_key_rank(int key) {
		return os_key_rank(root, key);
	}
	
	private int os_key_rank(Node node, int key) {
		if(node == NIL)
			return -1;
		
		if(key == node.key)
			return node.left.size + 1;
		
		if(key < node.key)
			return os_key_rank(node.left, key);
		
		else
			return node.left.size + 1 + os_key_rank(node.right, key);
	}

	//helper for test
	Node searchNode(int key) {
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
	
    private int getHeight(Node root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
	
	static enum NodeColor {
		RED,
		BLACK
	}
	
	static class Node {
		Integer key;
		Node left;
		Node right;
		Node parent;
		NodeColor color;
		int size;
		
		Node(Integer key, NodeColor color) {
			this.key = key;
			this.color = color;
			this.left = NIL;
			this.right = NIL;
			this.size = 0;
		}
		
		Node addLeftChild(Node left) {
			this.left = left;
			left.parent = this;
			return left;
		}
		
		Node addRightChild(Node right) {
			this.right = right;
			right.parent = this;
			return right;
		}
		
		@Override
		public String toString() {
			return "key = " + key + ", color = "+ color + ", size = " + size;
		}
	}
}
