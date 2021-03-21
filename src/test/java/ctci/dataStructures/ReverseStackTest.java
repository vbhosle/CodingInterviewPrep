package ctci.dataStructures;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReverseStackTest {

    @Test
    public void reverseUsingRecursionTest() {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }

        ReverseStack.reverseUsingRecursion(stack);
        for (int i = 1; i <= 10 ; i++) {
            assertThat(stack.pop(), equalTo(i));
        }
    }
}