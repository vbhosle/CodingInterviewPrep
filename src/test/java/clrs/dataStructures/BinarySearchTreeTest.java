package clrs.dataStructures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;

import org.junit.Test;

public class BinarySearchTreeTest {

	private BinarySearchTree tree;

	private void givenATree() {
		this.tree = new BinarySearchTree();
	}

	private void initializedWith(List<Integer> items) {
		for (int item : items) {
			tree.insert(item);
		}
	}

	private void traversingReturns(Function<BinarySearchTree, List<Integer>> traverser, List<Integer> items) {
		List<Integer> traversedItems = traverser.apply(tree);
		assertThat("traversed items has same size as tree items", traversedItems, hasSize(tree.size()));
		assertThat("traversed in expected order", traversedItems, equalTo(items));
	}

	private List<Integer> randomList(int size) {
		List<Integer> items = new ArrayList<>();

		for (int j = 1; j <= size; j++) {
			int item = ThreadLocalRandom.current().nextInt(1, size + 1);
			items.add(item);
		}
		return items;
	}

	@Test
	public void newTreeState() {
		givenATree();
		assertTrue("New tree is empty", tree.isEmpty());
		assertThat("New tree has size zero", tree.size(), equalTo(0));
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
			List<Integer> items = randomList(size);

			testInsert(items);
		}
	}

	public void testInsert(List<Integer> items) {
		givenATree();
		initializedWith(items);

		assertThat("tree size is same as items", tree.size(), equalTo(items.size()));

		Collections.sort(items);
		traversingReturns(BinarySearchTree::inorder, items);
	}

	@Test
	public void testInorderIterative() {
		final int MIN_SIZE = 6;
		final int MAX_SIZE = 10;

		for (int i = 1; i <= 5; i++) {
			int size = ThreadLocalRandom.current().nextInt(MIN_SIZE, MAX_SIZE + 1);
			List<Integer> items = randomList(size);

			givenATree();
			initializedWith(items);

			Collections.sort(items);
			traversingReturns(BinarySearchTree::inorderIterative, items);
		}
	}
}
