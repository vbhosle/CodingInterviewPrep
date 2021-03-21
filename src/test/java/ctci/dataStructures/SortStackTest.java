package ctci.dataStructures;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@RunWith(value = Parameterized.class)
public class SortStackTest {

    private static final int LIMIT = 20;
    private ArrayList<Integer> testNumbers;

    public SortStackTest(ArrayList<Integer> testNumbers) {
        this.testNumbers = testNumbers;
    }

    @Test
    public void sortRecursiveTest() {
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> testNumbersCopy = new ArrayList<>(testNumbers);
        testNumbersCopy.forEach(stack::push);

        Collections.sort(testNumbersCopy);

        SortStack.sortRecursive(stack);

        for (int i = 0; i < LIMIT; i++) {
            assertThat(stack.pop(), equalTo(testNumbersCopy.get(i)));
        }
    }

    @Test
    public void sortIterativeTest() {
        Deque<Integer> stack = new ArrayDeque<>();
        ArrayList<Integer> testNumbersCopy = new ArrayList<>(testNumbers);
        testNumbersCopy.forEach(stack::push);

        Collections.sort(testNumbersCopy);

        SortStack.sortIterative(stack);

        for (int i = 0; i < LIMIT; i++) {
            assertThat(stack.pop(), equalTo(testNumbersCopy.get(i)));
        }
    }

    @Parameterized.Parameters(name = "test {index} - {0}")
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                { ThreadLocalRandom.current().ints(LIMIT, 1, 10).boxed().collect(Collectors.toCollection(ArrayList::new)) }
                ,{ ThreadLocalRandom.current().ints(LIMIT, 1, 10).boxed().collect(Collectors.toCollection(ArrayList::new)) }
                ,{ ThreadLocalRandom.current().ints(LIMIT, 1, 10).boxed().collect(Collectors.toCollection(ArrayList::new)) }
        });
    }
}