package clrs.dataStructures;

import java.util.Arrays;

/*
Approach 1 - have fixed size stacks by dividing an array into equal size
Approach 2 - CTCI Start with fixed size stacks, when one stack is full and there is still space in array, shift elements of next stack to free up contiguous memory for current stack
Approach 3 (this class) - Maintain linked list of free indexes. [refer CLRS Allocating and freeing objects]. It take more memory than approach 2 (in terms of big O it's same O(n)) but is faster than it as all operations are O(1)
 */
public class MultipleStacksUsingArray {

    private int[] items;
    private int[] topIndexes;
    private int[] nextFreeIndex;
    private int freeHead;

    public MultipleStacksUsingArray(int numberOfStacks, int arraySize) {
        items = new int[arraySize];
        topIndexes = initTop(numberOfStacks);
        nextFreeIndex = initNextFreeIndex(arraySize);
        freeHead = 0;
    }

    private int[] initNextFreeIndex(int arraySize) {
        int[] freeIndexes = new int[arraySize];
        for(int i = 0; i < arraySize; i++)
            freeIndexes[i] = i + 1;

        freeIndexes[arraySize - 1] = -1;
        return freeIndexes;
    }

    private int[] initTop(int numberOfStacks) {
        int[] top = new int[numberOfStacks];
        Arrays.fill(top, -1);
        return top;
    }

    public void push(int stackNumber, int item) {
        if(freeHead == -1)
            throw new RuntimeException("No available slot left");
        int availableIndex = freeHead;
        freeHead = nextFreeIndex[availableIndex];
        nextFreeIndex[availableIndex] = topIndexes[stackNumber]; //store current stack top
        items[availableIndex] = item;
        topIndexes[stackNumber] = availableIndex;
    }

    public int pop(int stackNumber) {
        if(topIndexes[stackNumber] == -1)
            throw new RuntimeException(String.format("Stack %d is empty", stackNumber));
        int topIndex = topIndexes[stackNumber];
        topIndexes[stackNumber] = nextFreeIndex[topIndex];
        nextFreeIndex[topIndex] = freeHead;
        freeHead = topIndex;
        return items[topIndex];
    }
}
