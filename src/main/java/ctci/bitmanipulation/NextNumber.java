package ctci.bitmanipulation;

public class NextNumber {
    public static int getNext(int number) {
        int c0 = 0;
        int c1 = 0;

        int n = number;
        while (((n & 1) == 0) && (n != 0)) {
            c0++;
            n = n >> 1;
        }

        while((n & 1) != 0) {
            c1++;
            n = n >> 1;
        }

        // what is c0 + c1 = 0 for especially + c1 = 0
        if((c0 + c1) == 31 || (c0 + c1) == 0) {
            return -1;
        }

        int position = c0 + c1;

        n = number;

        //flip right most non-trailing zero
        n |= (1 << position);

        // clear all bits to the right of c0 + c1
        n &= ~((1 << position) - 1);

        // Insert (c1 - 1) ones on the right
        n |= ((1 << (c1 - 1)) - 1);

        System.out.println(String.format("number = %s (%d) \n next = %s (%d)", Integer.toBinaryString(number), number, Integer.toBinaryString(n), n));
        return n;
    }

    public static int getPrevious(int number) {
        int c0 = 0;
        int c1 = 0;

        int n = number;
        while ((n & 1) != 0) {
            c1++;
            n = n >> 1;
        }

        while((n & 1) == 0 && (n != 0)) {
            c0++;
            n = n >> 1;
        }

        if((c0 + c1) == 31 || c0 == 0) {
            return -1;
        }

        int position = c0 + c1;

        n = number;

        //flip right most non-trailing one
        n &= ~(1 << position);

        // clear all bits to the right of c0 + c1
        n &= ~((1 << position) - 1);

        // Insert (c1 + 1) ones from left to right
        n |= ((1 << (c1 + 1)) - 1) << (position - (c1 + 1));

        System.out.println(String.format("number = %s (%d) \n previous = %s (%d)", Integer.toBinaryString(number), number, Integer.toBinaryString(n), n));
        return n;
    }

    public static void main(String[] args) {
        NextNumber.getNext(3);
        NextNumber.getNext(5);
        NextNumber.getNext(17);
        NextNumber.getNext(22);

        NextNumber.getPrevious(26);
        NextNumber.getPrevious(25);
        NextNumber.getPrevious(22);
        NextNumber.getPrevious(21);
        NextNumber.getPrevious(19);
        NextNumber.getPrevious(14);
        NextNumber.getPrevious(13);
        NextNumber.getPrevious(11);
        NextNumber.getPrevious(7);
        NextNumber.getPrevious(5);
        NextNumber.getPrevious(3);

        System.out.println(Integer.MAX_VALUE);
    }
}
