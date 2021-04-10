package ctci.bitmanipulation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class NextNumberTest {
    private int number;
    private int next;
    private int previous;

    public NextNumberTest(int previous, int number, int next) {
        this.previous = previous;
        this.number = number;
        this.next = next;
    }

    @Test
    public void testNextAndPreviousNumber() {
        assertEquals("Next", NextNumber.getNext(number), next);
        assertEquals("Previous", NextNumber.getPrevious(number), previous);
    }


    @Parameterized.Parameters(name = "test {0} < {1} < {2}")
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {-1, 3, 5},
                {3, 5, 6},
                {5, 6, 9},
                {-1, 7, 11},
                {7, 11, 13},
                {11, 13, 14},
                {13, 14, 19},
                {-1, Integer.MAX_VALUE, -1},
                {2147483600, 2147483616, -1},
        });
    }
}