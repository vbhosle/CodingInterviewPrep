package clrs.dataStructures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import clrs.dataStructures.RedBlackTree.Node;
import clrs.dataStructures.RedBlackTree.NodeColor;

public class RedBlackTreeTest {

	@Rule
	public ExpectedException exceptionRule = ExpectedException.none();
	
	private RedBlackTree tree;

	private void givenATree() {
		this.tree = new RedBlackTree();
	}

	private void initializedWith(List<Integer> keys) {
		for (Integer key : keys) {
			tree.insert(key);
		}
	}

	private void traversingReturns(Function<RedBlackTree, List<Integer>> traverser, List<Integer> keys) {
		List<Integer> traversedItems = traverser.apply(tree);
		assertThat("traversed keys has same size as tree keys", traversedItems, hasSize(tree.size()));
		assertThat("traversed in expected order", traversedItems, equalTo(keys));
	}

	private List<Integer> randomList(int size) {
		List<Integer> keys = new ArrayList<>();

		for (Integer j = 1; j <= size; j++) {
			Integer key = ThreadLocalRandom.current().nextInt(1, size + 1);
			keys.add(key);
		}
		return keys;
	}


	@Test
	public void newTreeState() {
		givenATree();
		assertTrue("New tree is empty", tree.isEmpty());
		assertThat("New tree has size zero", tree.size(), equalTo(0));
		checkRedBlack(tree);
	}

	@Test
	public void insertInIncreasingOrder() {
		testInsert(Arrays.asList(1, 2, 3, 4, 5, 6));
	}

	@Test
	public void insertInDecreasingOrder() {
		testInsert(Arrays.asList(6, 5, 4, 3, 2, 1));
	}

	@Test
	public void insertInRandomOrder() {

		final int MIN_SIZE = 6;
		final int MAX_SIZE = 10;

		for (int i = 1; i <= 5; i++) {
			int size = ThreadLocalRandom.current().nextInt(MIN_SIZE, MAX_SIZE + 1);
			List<Integer> keys = randomList(size);

			testInsert(keys);
		}
	}

	public void testInsert(List<Integer> keys) {
		givenATree();
		initializedWith(keys);

		assertThat("tree size is same as keys", tree.size(), equalTo(keys.size()));

		Collections.sort(keys);
		traversingReturns(RedBlackTree::inorder, keys);
		checkRedBlack(tree);
	}

	@Test
	public void orderStatisticKeyRank() {
		final int CYCLES = 5;
		List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		for(int cycle = 1; cycle <= CYCLES; cycle++) {
			Collections.shuffle(keys);
			testOrderStatisticKeyRank(keys);
		}
	}

	public void testOrderStatisticKeyRank(List<Integer> keys) {
		givenATree();
		initializedWith(keys);

		checkRedBlack(tree);
		
		assertThat("tree size is same as keys", tree.size(), equalTo(keys.size()));

		Collections.sort(keys);
		
		for(int i = 0; i < keys.size(); i++) {
			assertThat(tree.os_key_rank(keys.get(i)), equalTo(i+1));
		}
		
	}
	
	@Test
	public void orderStatisticOnKeysInsertedInRandomOrder() {
		final int CYCLES = 5;
		List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		
		for(int cycle = 1; cycle <= CYCLES; cycle++) {
			Collections.shuffle(keys);
			testOrderStatisticsOperations(keys);
		}
		
	}

	public void testOrderStatisticsOperations(List<Integer> keys) {
		givenATree();
		initializedWith(keys);

		checkRedBlack(tree);
		
		assertThat("tree size is same as keys", tree.size(), equalTo(keys.size()));

		Collections.sort(keys);
		
		for(int i = 0; i < keys.size(); i++) {
			assertThat(tree.os_rank(tree.os_select(i+1)), equalTo(i+1));
		}
		
	}

	// These are tests to test the tests that I referred from users.cis.fiu.edu Lol
	@Test
	public void checkRedBlackIdentifiesThatRedNodeHasRedParent() {
		exceptionRule.expect(IllegalStateException.class);
 		exceptionRule.expectMessage("Parent of red 4 is red");
		
		RedBlackTree redBlackTree = new RedBlackTree();
		Node root = new RedBlackTree.Node(11, NodeColor.BLACK);
		
		Node rootLeft = root.addLeftChild(new RedBlackTree.Node(2, NodeColor.RED));
		Node rootLeftLeft = rootLeft.addLeftChild(new RedBlackTree.Node(1, NodeColor.BLACK));
		Node rootLeftRight = rootLeft.addRightChild(new RedBlackTree.Node(7, NodeColor.BLACK));
		Node rootLeftRightLeft = rootLeftRight.addLeftChild(new RedBlackTree.Node(5, NodeColor.RED));
		Node rootLeftRightRight = rootLeftRight.addRightChild(new RedBlackTree.Node(8, NodeColor.RED));
		
		Node rootRight = root.addRightChild(new RedBlackTree.Node(14, NodeColor.BLACK));
		Node rootRightRight = rootRight.addRightChild(new RedBlackTree.Node(15, NodeColor.RED));
		
		rootLeftRightLeft.size = 1;
		rootLeftRightRight.size = 1;
		rootRightRight.size = 1;
		
		rootLeftRight.size = rootLeftRight.left.size + rootLeftRight.right.size + 1;
		rootLeftLeft.size = rootLeftLeft.left.size + rootLeftLeft.right.size + 1;
		rootRight.size = rootRight.left.size + rootRight.right.size + 1;
		rootLeft.size = rootLeft.left.size + rootLeft.right.size + 1;
		root.size = root.left.size + root.right.size + 1;
		
		redBlackTree.root = root;
		root.parent = RedBlackTree.NIL;
		
		checkRedBlack(redBlackTree);
 		
 		rootLeftRightLeft.addLeftChild(new RedBlackTree.Node(4, NodeColor.RED));
 		checkRedBlack(redBlackTree);
 		
	}
	
	@Test
	public void checkRedBlackIdentifiesThatPathHasDifferentBlackDepth() {
		exceptionRule.expect(IllegalStateException.class);
 		exceptionRule.expectMessage("Left and right children of 5 have different black depths");
		
		RedBlackTree redBlackTree = new RedBlackTree();
		Node root = new RedBlackTree.Node(11, NodeColor.BLACK);
		
		Node rootLeft = root.addLeftChild(new RedBlackTree.Node(2, NodeColor.RED));
		Node rootLeftLeft = rootLeft.addLeftChild(new RedBlackTree.Node(1, NodeColor.BLACK));
		Node rootLeftRight = rootLeft.addRightChild(new RedBlackTree.Node(7, NodeColor.BLACK));
		Node rootLeftRightLeft = rootLeftRight.addLeftChild(new RedBlackTree.Node(5, NodeColor.RED));
		Node rootLeftRightRight = rootLeftRight.addRightChild(new RedBlackTree.Node(8, NodeColor.RED));
		
		Node rootRight = root.addRightChild(new RedBlackTree.Node(14, NodeColor.BLACK));
		Node rootRightRight = rootRight.addRightChild(new RedBlackTree.Node(15, NodeColor.RED));
		
		
		//certainly it's a hacky to define sizes like that but unfortunately currently it is least of my concerns
		rootLeftRightLeft.size = 1;
		rootLeftRightRight.size = 1;
		rootRightRight.size = 1;
		
		rootLeftLeft.size = rootLeftLeft.left.size + rootLeftLeft.right.size + 1;
		rootLeftRight.size = rootLeftRight.left.size + rootLeftRight.right.size + 1;
		rootRight.size = rootRight.left.size + rootRight.right.size + 1;
		rootLeft.size = rootLeft.left.size + rootLeft.right.size + 1;
		root.size = root.left.size + root.right.size + 1;
		
		
		redBlackTree.root = root;
		root.parent = RedBlackTree.NIL;
		
		checkRedBlack(redBlackTree);
 		
 		rootLeftRightLeft.addLeftChild(new RedBlackTree.Node(4, NodeColor.BLACK));
 		checkRedBlack(redBlackTree);
 		
	}
	
	//courtesy - http://users.cis.fiu.edu/~shawg/syl/BJ4-Old/ch17/worked_example_2/RedBlackTreeTester.java
	//only the code that needs change to handle NIL node is changed, it may need more cleanup

	/**
	 * Checks whether a red-black tree is valid and throws an exception if not.
	 * 
	 * @param t the tree to test
	 */
	public static void checkRedBlack(RedBlackTree t) {
		checkRedBlack(t.root, true);

		// Check that it's a BST
		RedBlackTree.Node[] nodes = getNodes(t);
		for (int i = 0; i < nodes.length - 1; i++) {
			if (nodes[i].key > nodes[i + 1].key) {
				throw new IllegalStateException(nodes[i].key + " is larger than " + nodes[i + 1].key);
			}
		}
	}

	/**
	 * Checks that the tree with the given node is a red-black tree, and throws an
	 * exception if a structural error is found.
	 * 
	 * @param node      the root of the subtree to check
	 * @param isRoot true if this is the root of the tree
	 * @return the black depth of this subtree
	 */
	private static int checkRedBlack(RedBlackTree.Node node, boolean isRoot) {
		if (node == RedBlackTree.NIL) {
			return 0;
		}
		
		if(isRoot) {
			assertThat("Root is not null", node, notNullValue());
			assertSame("Root's parent is NIL", RedBlackTree.NIL, node.parent);
			assertThat("Root's color is BLACK", node.color, equalTo(RedBlackTree.NodeColor.BLACK));
		}
		
		int nleft = checkRedBlack(node.left, false);
		int nright = checkRedBlack(node.right, false);
		if (nleft != nright) {
			throw new IllegalStateException("Left and right children of " + node.key + " have different black depths");
		}
		if (node.parent == null) {
			if (!isRoot) {
				throw new IllegalStateException(node.key + " is not root and has no parent");
			}
			if (node.color != NodeColor.BLACK) {
				throw new IllegalStateException("Root " + node.key + " is not black");
			}
		} else {
			if (isRoot && node.parent != RedBlackTree.NIL) {
				throw new IllegalStateException(node.key + " is root and doesn't have NIL as parent");
			}
			if (node.color == NodeColor.RED && node.parent.color == NodeColor.RED) {
				throw new IllegalStateException("Parent of red " + node.key + " is red");
			}
		}
		if (node.left != RedBlackTree.NIL && node.left.parent != node) {
			throw new IllegalStateException("Left child of " + node.key + " has bad parent link");
		}
		if (node.right != RedBlackTree.NIL && node.right.parent != node) {
			throw new IllegalStateException("Right child of " + node.key + " has bad parent link");
		}
		if (node.color != NodeColor.RED && node.color != NodeColor.BLACK) {
			throw new IllegalStateException(node.key + " has color " + node.color);
		}
		
		return (node.color == NodeColor.BLACK ? 1 : 0) + nleft;
	}

	/**
	 * Gets all nodes of this tree in sorted order.
	 * 
	 * @param t a red-black tree
	 * @return an array of all nodes in t
	 */
	private static RedBlackTree.Node[] getNodes(RedBlackTree t) {
		RedBlackTree.Node[] nodes = new RedBlackTree.Node[t.size()];
		getNodes(t.root, nodes, 0);
		return nodes;
	}

	/**
	 * Gets all nodes of a subtree and fills them into an array.
	 * 
	 * @param n     the root of the subtree
	 * @param nodes the array into which to place the nodes
	 * @param start the offset at which to start placing the nodes
	 * @return the number of nodes placed
	 */
	private static int getNodes(RedBlackTree.Node n, RedBlackTree.Node[] nodes, int start) {
		if (n == null || n == RedBlackTree.NIL) {
			return 0;
		}
		int leftFilled = getNodes(n.left, nodes, start);
		nodes[start + leftFilled] = n;
		int rightFilled = getNodes(n.right, nodes, start + leftFilled + 1);
		return leftFilled + 1 + rightFilled;
	}
}
