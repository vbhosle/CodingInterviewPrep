package clrs.dataStructures;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MultipleStacksUsingArrayTest {

    @Test
    public void randomPushPopTest() {
        final int ITERATIONS = 5;

        for (int i = 0; i < ITERATIONS; i++) {
            System.out.println("################# Iteration " + i);
            int numberOfStacks = ThreadLocalRandom.current().nextInt(5, 10);
            int arraySize = numberOfStacks*5;
            randomPushPopTestInstance(numberOfStacks, arraySize);
        }
    }

    private void randomPushPopTestInstance(int numberOfStacks, int arraySize) {
        System.out.println("Test instance: stacks - " + numberOfStacks + ", array size - " + arraySize);

        List<Deque<Integer>> standardStacks = createStandardStacks(numberOfStacks);

        List<Integer> randomStackNumbers = ThreadLocalRandom.current().ints(arraySize, 0, numberOfStacks).boxed().collect(Collectors.toCollection(ArrayList::new));
        MultipleStacksUsingArray testStack = new MultipleStacksUsingArray(numberOfStacks, arraySize);

        for (int i = 0; i < 5; i++) {
            for(int stackNumber: randomStackNumbers) {
                int item = ThreadLocalRandom.current().nextInt();
                System.out.println(String.format("Push %d into stack %d", item, stackNumber));
                standardStacks.get(stackNumber).push(item);
                testStack.push(stackNumber, item);
            }

            Collections.shuffle(randomStackNumbers);
            System.out.println("Pop and assert");
            System.out.println();
            for(int stackNumber: randomStackNumbers)
                assertThat("standard stack pop matches test stack pop", standardStacks.get(stackNumber).pop(), equalTo(testStack.pop(stackNumber)));
        }
    }

    private List<Deque<Integer>> createStandardStacks(int numberOfStacks) {
        List<Deque<Integer>> standardStacks = new ArrayList<>(numberOfStacks);
        for (int i = 0; i < numberOfStacks; i++) {
            standardStacks.add(new ArrayDeque<>());
        }

        return  standardStacks;
    }

}