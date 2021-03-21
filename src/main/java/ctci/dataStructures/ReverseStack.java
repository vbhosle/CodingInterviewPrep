package ctci.dataStructures;

import java.util.Deque;

/*
To reverse stack without extra space, represent it as linked list and reverse in O(n) time O(1) space
 */
public class ReverseStack {

    public static void reverseUsingRecursion(Deque<Integer> stack) {
        if(stack.isEmpty())
            return;
        int current = stack.pop();
        reverseUsingRecursion(stack);
        insertAtBottom(stack, current);
    }

    private static void insertAtBottom(Deque<Integer> stack, int value) {
        if(stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int current = stack.pop();
        insertAtBottom(stack, value);
        stack.push(current);
    }
}
