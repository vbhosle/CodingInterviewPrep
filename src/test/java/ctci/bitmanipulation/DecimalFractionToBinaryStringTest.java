package ctci.bitmanipulation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class DecimalFractionToBinaryStringTest {

    private double decimalFraction;
    private String binaryNumber;

    public DecimalFractionToBinaryStringTest(double decimalFraction, String binaryNumber) {
        this.decimalFraction = decimalFraction;
        this.binaryNumber = binaryNumber;
    }

    @Test
    public void testBinaryConversion() {
        assertEquals(DecimalFractionToBinaryString.toString(decimalFraction), binaryNumber);
    }


    @Parameterized.Parameters(name = "test {0} -> {1}")
    public static Collection<Object[]> data() {

        return Arrays.asList(new Object[][]{
                {1, "ERROR"},
                {1.01, "ERROR"},
                {1, "ERROR"},
                {0, "ERROR"},
                {-0.2, "ERROR"},
                {0.5, ".1"},
                {0.25, ".01"},
                {0.125, ".001"},
                {0.625, ".101"},
                {0.837, "ERROR"},
                {0.90062713623046875, ".11100110100011111"}
        });
    }

}