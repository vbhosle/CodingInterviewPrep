package clrs.dataStructures;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

public class BinarySearchTreeTest {

	private BinarySearchTree tree;

	private void givenATree() {
		this.tree = new BinarySearchTree();
	}

	private void initializedWith(List<Integer> keys) {
		for (Integer key : keys) {
			tree.insert(key);
		}
	}

	private void traversingReturns(Function<BinarySearchTree, List<Integer>> traverser, List<Integer> keys) {
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
		traversingReturns(BinarySearchTree::inorder, keys);
	}

	@Test
	public void inorderIterative() {
		final int MIN_SIZE = 6;
		final int MAX_SIZE = 10;

		for (int i = 1; i <= 5; i++) {
			int size = ThreadLocalRandom.current().nextInt(MIN_SIZE, MAX_SIZE + 1);
			List<Integer> keys = randomList(size);

			givenATree();
			initializedWith(keys);

			Collections.sort(keys);
			traversingReturns(BinarySearchTree::inorderIterative, keys);
		}
	}

	public void testTraversal(Function<BinarySearchTree, List<Integer>> traverser, List<Integer> insertItems, List<Integer> expectedTraversedItems) {
		givenATree();
		initializedWith(insertItems);
		traversingReturns(traverser, expectedTraversedItems);
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void preorder() {
		Pair<List<Integer>, List<Integer>>[] parameters = new Pair[] {
				Pair.of(Collections.emptyList(), Collections.emptyList()),
				Pair.of(asList(1, 2, 3, 4, 5, 6, 7), asList(1, 2, 3, 4, 5, 6, 7)),
				Pair.of(asList(7, 6, 5, 4, 3, 2, 1), asList(7, 6, 5, 4, 3, 2, 1)),
				Pair.of(asList(40, 20, 60, 10, 30, 50, 70), asList(40, 20, 10, 30, 60,50, 70)),
				Pair.of(asList(40, 20, 30), asList(40, 20, 30)),
				Pair.of(asList(40, 60, 50), asList(40, 60, 50)),
		};
		
		Arrays.stream(parameters)
			  .forEach(parameter -> testTraversal(BinarySearchTree::preorder, parameter.getLeft(), parameter.getRight()));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void postorder() {
		Pair<List<Integer>, List<Integer>>[] parameters = new Pair[] {
				Pair.of(Collections.emptyList(), Collections.emptyList()),
				Pair.of(asList(1, 2, 3, 4, 5, 6, 7), asList(7, 6, 5, 4, 3, 2, 1)),
				Pair.of(asList(7, 6, 5, 4, 3, 2, 1), asList(1, 2, 3, 4, 5, 6, 7)),
				Pair.of(asList(40, 20, 60, 10, 30, 50, 70), asList(10, 30, 20, 50, 70, 60, 40)),
				Pair.of(asList(40, 20, 30), asList(30, 20, 40)),
				Pair.of(asList(40, 60, 50), asList(50, 60, 40)),
		};
		
		Arrays.stream(parameters)
		  .forEach(parameter -> testTraversal(BinarySearchTree::postorder, parameter.getLeft(), parameter.getRight()));
	}
	
	@Test
	public void contains() {
		List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		for (int i = 1; i <= 5; i++) {
			Collections.shuffle(keys);
			givenATree();
			initializedWith(keys);
			keys.stream().forEach(key -> assertTrue("tree contains " + key, tree.contains(key)));
			
			assertFalse("tree doesn't contain key", tree.contains(100));
		}
	}
	
	@Test
	public void containsIterative() {
		List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		for (int i = 1; i <= 5; i++) {
			Collections.shuffle(keys);
			givenATree();
			initializedWith(keys);
			keys.stream().forEach(key -> assertTrue("tree contains " + key, tree.containsIterative(key)));
			
			assertFalse("tree doesn't contain key", tree.containsIterative(100));
		}
	}
	
	@Test
	public void min() {
		List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		for (int i = 1; i <= 5; i++) {
			Collections.shuffle(keys);
			givenATree();
			initializedWith(keys);
			keys.stream().forEach(key -> assertThat("1 is min", tree.min(), equalTo(1)));
		}
	}
	
	@Test
	public void max() {
		List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

		for (int i = 1; i <= 5; i++) {
			Collections.shuffle(keys);
			givenATree();
			initializedWith(keys);
			
			keys.stream().forEach(key -> assertThat("7 is max", tree.max(), equalTo(7)));
		}
	}
	
	@Test
	public void successor() {
		List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		Map<Integer, Integer> successors = keys.stream().collect(Collectors.toMap(Function.identity(), n -> n + 1));
		successors.put(keys.get(keys.size() - 1), null); // last item has no successor
		
		for (int i = 1; i <= 5; i++) {
			Collections.shuffle(keys);
			givenATree();
			initializedWith(keys);
			keys.stream().forEach(key -> assertThat(String.format("Successor of %s is %s", key, successors.get(key)), tree.successor(key), equalTo(successors.get(key))));
		}
	}
	
	@Test
	public void predecessor() {
		List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
		Map<Integer, Integer> predecessor = keys.stream().collect(Collectors.toMap(Function.identity(), n -> n - 1));
		predecessor.put(keys.get(0), null); // first items has no predecessor
		
		for (int i = 1; i <= 5; i++) {
			Collections.shuffle(keys);
			givenATree();
			initializedWith(keys);
			keys.stream().forEach(key -> assertThat(String.format("Predecessor of %s is %s", key, predecessor.get(key)), tree.predecessor(key), equalTo(predecessor.get(key))));
		}
	}
	
	@Test
	public void delete() {
				
		for (int i = 1; i <= 5; i++) {
			List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
			List<Integer> sortedKeys = new ArrayList<>(keys);
			Collections.sort(sortedKeys);
			
			Collections.shuffle(keys);
			givenATree();
			initializedWith(keys);
			
			ListIterator<Integer> iterator = sortedKeys.listIterator();
			
			while(iterator.hasNext()) {
				tree.delete(iterator.next());
				iterator.remove();
				traversingReturns(BinarySearchTree::inorder, sortedKeys);
			}
			
			assertTrue("New tree is empty", tree.isEmpty());
			assertThat("New tree has size zero", tree.size(), equalTo(0));
		}
	}
	
	@Test
	public void deleteReplaceWithPredecessor() {
				
		for (int i = 1; i <= 5; i++) {
			List<Integer> keys = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
			List<Integer> sortedKeys = new ArrayList<>(keys);
			Collections.sort(sortedKeys);
			
			Collections.shuffle(keys);
			givenATree();
			initializedWith(keys);
			
			ListIterator<Integer> iterator = sortedKeys.listIterator();
			
			while(iterator.hasNext()) {
				tree.deleteReplaceWithPredecessor(iterator.next());
				iterator.remove();
				traversingReturns(BinarySearchTree::inorder, sortedKeys);
			}
			
			assertTrue("New tree is empty", tree.isEmpty());
			assertThat("New tree has size zero", tree.size(), equalTo(0));
		}
	}
}
