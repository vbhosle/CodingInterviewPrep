package ctci.dataStructures;

import java.util.ArrayDeque;
import java.util.Deque;

class SortStack {

    public static void sortIterative(Deque<Integer> s)
    {
        Deque<Integer> sortedStack = new ArrayDeque<>();

        while(!s.isEmpty()) {
            int curr = s.pop();

            while(!sortedStack.isEmpty() && curr < sortedStack.peek())
                s.push(sortedStack.pop());

            sortedStack.push(curr);
        }

        while(!sortedStack.isEmpty())
            s.push(sortedStack.pop());
    }

    public static void sortRecursive(Deque<Integer> stack)
    {
        if(stack.isEmpty())
            return;

        int current = stack.pop();
        sortRecursive(stack);
        insertInSortedDeque(stack, current);
    }

    public static void insertInSortedDeque(Deque<Integer> stack, int value) {
        if(stack.isEmpty() || value <= stack.peek()) {
            stack.push(value);
            return;
        }

        int current = stack.pop();
        insertInSortedDeque(stack, value);
        stack.push(current);
    }
}
